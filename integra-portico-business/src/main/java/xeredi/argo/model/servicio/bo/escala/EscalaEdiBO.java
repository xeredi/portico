package xeredi.argo.model.servicio.bo.escala;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import xeredi.argo.model.comun.bo.IgUtilBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.servicio.dao.ServicioActorDAO;
import xeredi.argo.model.servicio.dao.ServicioDAO;
import xeredi.argo.model.servicio.dao.ServicioDatoDAO;
import xeredi.argo.model.servicio.dao.ServicioSecuenciaDAO;
import xeredi.argo.model.servicio.dao.SubservicioDAO;
import xeredi.argo.model.servicio.dao.SubservicioDatoDAO;
import xeredi.argo.model.servicio.dao.SubservicioSubservicioDAO;
import xeredi.argo.model.servicio.dao.escala.EscalaDAO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EscalaEdiBO.
 */
public final class EscalaEdiBO {

    /**
     * Alta escala.
     *
     * @param esclVO
     *            the escl vo
     * @param atrqList
     *            the atrq list
     * @param oprcMap
     *            the oprc map
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    public void altaEscala(final ServicioVO esclVO, final List<SubservicioVO> atrqList,
            final Map<Long, List<SubservicioVO>> oprcMap) throws DuplicateInstanceException {
        Preconditions.checkNotNull(esclVO);
        Preconditions.checkNotNull(atrqList);
        Preconditions.checkNotNull(oprcMap);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);
            final ServicioActorDAO sracDAO = session.getMapper(ServicioActorDAO.class);

            final EscalaDAO esclDAO = session.getMapper(EscalaDAO.class);

            final List<SubservicioSubservicioVO> ssssList = new ArrayList<>();

            // valores por defecto
            for (final SubservicioVO atrqVO : atrqList) {
                if (atrqVO.getEstado() == null) {
                    atrqVO.setEstado("S");
                }
            }

            if (srvcDAO.exists(esclVO)) {
                throw new DuplicateInstanceException(Entidad.ESCALA.getId(), esclVO);
            }

            srscDAO.incrementarSecuencia(esclVO);

            final Integer secuencia = srscDAO.obtenerSecuencia(esclVO);

            if (secuencia == null) {
                throw new Error("No se encuentra secuencia para: " + esclVO);
            }

            IgUtilBO.assignNextVal(esclVO);

            esclVO.setNumero(String.valueOf(secuencia));
            srvcDAO.insert(esclVO);

            // Escala
            for (final ItemDatoVO itdtVO : esclVO.getItdtMap().values()) {
                itdtVO.setItemId(esclVO.getId());
                srdtDAO.insert(itdtVO);
            }

            // Atraques y Operaciones
            int numeroAtraque = 1;

            for (final SubservicioVO atrqVO : atrqList) {
                IgUtilBO.assignNextVal(atrqVO);

                atrqVO.setSrvc(esclVO);
                atrqVO.setNumero(numeroAtraque++);
                ssrvDAO.insert(atrqVO);

                final Long numeroAtraqueEdi = atrqVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera();

                if (oprcMap.containsKey(numeroAtraqueEdi)) {
                    for (final SubservicioVO oprcVO : oprcMap.get(numeroAtraqueEdi)) {
                        oprcVO.setSrvc(esclVO);
                        ssrvDAO.insert(oprcVO);

                        final SubservicioSubservicioVO ssssVO = new SubservicioSubservicioVO(atrqVO.getId(),
                                oprcVO.getId());

                        ssssList.add(ssssVO);
                    }
                }
            }

            // Relaciones entre atraques y operaciones
            for (final SubservicioSubservicioVO ssssVO : ssssList) {
                ssssDAO.insert(ssssVO);
            }

            // Datos de Atraques
            for (final List<SubservicioVO> ssrvList : oprcMap.values()) {
                for (final SubservicioVO ssrvVO : ssrvList) {
                    for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                        itdtVO.setItemId(ssrvVO.getId());
                        ssdtDAO.insert(itdtVO);
                    }
                }
            }

            // Datos de Operaciones
            for (final SubservicioVO ssrvVO : atrqList) {
                for (final ItemDatoVO itdtVO : ssrvVO.getItdtMap().values()) {
                    itdtVO.setItemId(ssrvVO.getId());
                    ssdtDAO.insert(itdtVO);
                }
            }

            // Operaciones especificas de escala
            esclDAO.updateRecalcularEstado(esclVO.getId());
            esclDAO.updateEstancia(esclVO.getId());
            esclDAO.updateExencion(esclVO.getId());
            esclDAO.updateNavegacionEntrada(esclVO.getId());
            esclDAO.updateNavegacionSalida(esclVO.getId());
            esclDAO.updateTipoIva(esclVO.getId());
            esclDAO.updateRecalcularFechas(esclVO.getId());

            // Actores de la escala
            sracDAO.insert(esclVO.getId());

            session.commit();
        }
    }

    /**
     * Notificar practico.
     *
     * @param escaId
     *            the esca id
     * @param numeroManifiesto
     *            the numero manifiesto
     * @param fechaNotificacion
     *            the fecha notificacion
     */
    public void notificarPractico(final Long escaId, final String numeroManifiesto, final Date fechaNotificacion) {
        Preconditions.checkNotNull(escaId);
        Preconditions.checkNotNull(numeroManifiesto);
        Preconditions.checkNotNull(fechaNotificacion);

        throw new Error("No implementado");
    }
}
