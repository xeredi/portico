package xeredi.integra.model.servicio.bo.pesca;

import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.bo.AbstractSubservicioBO;
import xeredi.integra.model.servicio.dao.pesca.ManifiestoPescaDAO;
import xeredi.integra.model.servicio.dao.pesca.PartidaPescaDAO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaPescaBO.
 */
public final class PartidaPescaBO extends AbstractSubservicioBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcularImporte(ssrvVO.getId());
        papeDAO.updateRecalcularPrecio(ssrvVO.getId());
        mapeDAO.updateRecalcularImporte(ssrvVO.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO) {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcularImporte(ssrvVO.getId());
        papeDAO.updateRecalcularPrecio(ssrvVO.getId());
        mapeDAO.updateRecalcularImporte(ssrvVO.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        final PartidaPescaDAO papeDAO = session.getMapper(PartidaPescaDAO.class);
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        papeDAO.updateRecalcularImporte(ssrvVO.getId());
        papeDAO.updateRecalcularPrecio(ssrvVO.getId());
        mapeDAO.updateRecalcularImporte(ssrvVO.getSrvc().getId());
        mapeDAO.updateRecalcularPeso(ssrvVO.getSrvc().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final @Nonnull SqlSession session, final @Nonnull Long srvcId,
            final @Nonnull Long ssrvId) throws InstanceNotFoundException {
        final ManifiestoPescaDAO mapeDAO = session.getMapper(ManifiestoPescaDAO.class);

        mapeDAO.updateRecalcularImporte(srvcId);
        mapeDAO.updateRecalcularPeso(srvcId);
    }
}
