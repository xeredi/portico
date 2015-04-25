package xeredi.integra.model.servicio.bo.escala;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.servicio.bo.AbstractServicioBO;
import xeredi.integra.model.servicio.dao.escala.EscalaDAO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EscalaBO.
 */
public final class EscalaBO extends AbstractServicioBO {
    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        Preconditions.checkNotNull(srvcVO.getId());

        final EscalaDAO esclDAO = session.getMapper(EscalaDAO.class);

        esclDAO.updateEstado(srvcVO.getId());
        esclDAO.updateEstancia(srvcVO.getId());
        esclDAO.updateExencion(srvcVO.getId());
        esclDAO.updateNavegacionEntrada(srvcVO.getId());
        esclDAO.updateNavegacionSalida(srvcVO.getId());
        esclDAO.updateTipoIva(srvcVO.getId());
        esclDAO.updateFechaInicioFin(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final Long srvcId) throws ModelException {
        // noop
    }

    /**
     * Obtener numero manifiesto aeat.
     *
     * @param srvcId
     *            the srvc id
     * @return the string
     */
    public String obtenerNumeroManifiestoAeat(final Long srvcId) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession();) {
            final EscalaDAO escaDAO = session.getMapper(EscalaDAO.class);

            return escaDAO.selectNumeroManifiestoAeat(srvcId);
        }
    }
}
