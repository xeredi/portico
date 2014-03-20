package xeredi.integra.model.bo.servicio.escala;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.bo.comun.IgBO;
import xeredi.integra.model.dao.servicio.ServicioDAO;
import xeredi.integra.model.dao.servicio.ServicioDatoDAO;
import xeredi.integra.model.dao.servicio.ServicioSecuenciaDAO;
import xeredi.integra.model.dao.servicio.SubservicioDAO;
import xeredi.integra.model.dao.servicio.SubservicioDatoDAO;
import xeredi.integra.model.dao.servicio.SubservicioSubservicioDAO;
import xeredi.integra.model.dao.servicio.escala.EscalaDAO;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.servicio.ServicioVO;
import xeredi.integra.model.vo.servicio.SubservicioSubservicioVO;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

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

        final IgBO igBO = new IgBO();

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);) {
            final ServicioSecuenciaDAO srscDAO = session.getMapper(ServicioSecuenciaDAO.class);
            final ServicioDAO srvcDAO = session.getMapper(ServicioDAO.class);
            final ServicioDatoDAO srdtDAO = session.getMapper(ServicioDatoDAO.class);
            final SubservicioDAO ssrvDAO = session.getMapper(SubservicioDAO.class);
            final SubservicioSubservicioDAO ssssDAO = session.getMapper(SubservicioSubservicioDAO.class);
            final SubservicioDatoDAO ssdtDAO = session.getMapper(SubservicioDatoDAO.class);

            final EscalaDAO esclDAO = session.getMapper(EscalaDAO.class);

            final List<SubservicioSubservicioVO> ssssList = new ArrayList<>();

            // valores por defecto
            for (final SubservicioVO atrqVO : atrqList) {
                if (atrqVO.getEstado() == null) {
                    atrqVO.setEstado("S");
                }
            }

            if (srvcDAO.exists(esclVO)) {
                throw new DuplicateInstanceException(ServicioVO.class.getName(), esclVO);
            }

            srscDAO.incrementarSecuencia(esclVO);

            final Integer secuencia = srscDAO.obtenerSecuencia(esclVO);

            if (secuencia == null) {
                throw new Error("No se encuentra secuencia para: " + esclVO);
            }

            esclVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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
                atrqVO.setId(igBO.nextVal(GlobalNames.SQ_INTEGRA));
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
            esclDAO.updateEstado(esclVO.getId());
            esclDAO.updateEstancia(esclVO.getId());
            esclDAO.updateExencion(esclVO.getId());
            esclDAO.updateNavegacionEntrada(esclVO.getId());
            esclDAO.updateNavegacionSalida(esclVO.getId());
            esclDAO.updateTipoIva(esclVO.getId());
            esclDAO.updateFechaInicioFin(esclVO.getId());

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
