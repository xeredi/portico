package xeredi.argo.model.servicio.bo.escala;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.dao.escala.EscalaDAO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class EscalaBO.
 */
public final class EscalaBO extends ServicioBO {

    /**
     * Instantiates a new escala BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public EscalaBO(final @NonNull Long ausroId) {
        super(Entidad.ESCALA.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        Preconditions.checkNotNull(srvcVO.getId());

        final EscalaDAO esclDAO = session.getMapper(EscalaDAO.class);

        esclDAO.updateRecalcularEstado(srvcVO.getId());
        esclDAO.updateEstancia(srvcVO.getId());
        esclDAO.updateExencion(srvcVO.getId());
        esclDAO.updateNavegacionEntrada(srvcVO.getId());
        esclDAO.updateNavegacionSalida(srvcVO.getId());
        esclDAO.updateTipoIva(srvcVO.getId());
        esclDAO.updateRecalcularFechas(srvcVO.getId());
    }

    /**
     * Obtener numero manifiesto aeat.
     *
     * @param srvcId
     *            the srvc id
     * @return the string
     */
    public final String obtenerNumeroManifiestoAeat(final Long srvcId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);

            return escaDAO.selectNumeroManifiestoAeat(srvcId);
        }
    }
}
