package xeredi.argo.model.servicio.bo.pesca;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import lombok.NonNull;
import xeredi.argo.model.comun.exception.ModelException;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.servicio.bo.ServicioBO;
import xeredi.argo.model.servicio.dao.pesca.ManifiestoPescaDAO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoPescaBO.
 */
public final class ManifiestoPescaBO extends ServicioBO {

    /**
     * Instantiates a new manifiesto pesca BO.
     *
     * @param ausroId
     *            the ausro id
     */
    public ManifiestoPescaBO(@NonNull final Long ausroId) {
        super(Entidad.MANIFIESTO_PESCA.getId(), ausroId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final SqlSession session, final ServicioVO srvcVO,
            final List<SubservicioVO> ssrvList, final List<SubservicioSubservicioVO> ssssList) {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcVO.getId());
        mapeDAO.updateRecalcularPeso(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcVO.getId());
        mapeDAO.updateRecalcularPeso(srvcVO.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final ServicioVO srvcVO) throws ModelException {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcVO.getId());
        mapeDAO.updateRecalcularPeso(srvcVO.getId());
    }
}
