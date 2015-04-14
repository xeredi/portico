package xeredi.integra.model.servicio.bo;

import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioDetailVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultSubservicioBO.
 */
public final class DefaultSubservicioBO extends AbstractSubservicioBO {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void insertPostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO) {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final @Nonnull SqlSession session, final @Nonnull SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final @Nonnull SqlSession session, final @Nonnull Long srvcId,
            final @Nonnull Long ssrvId) throws InstanceNotFoundException {
        // noop
    }

}
