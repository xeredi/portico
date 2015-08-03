package xeredi.integra.model.servicio.bo;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.item.vo.ItemTramiteVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioDetailVO;
import xeredi.integra.model.metamodelo.vo.TramiteDetailVO;
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
    protected void insertPostOperations(final SqlSession session, final SubservicioVO ssrvVO,
            final TipoSubservicioDetailVO tpssDetail, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void duplicatePostOperations(final SqlSession session, final SubservicioVO ssrvVO) {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void updatePostOperations(final SqlSession session, final SubservicioVO ssrvVO)
            throws InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void deletePostOperations(final SqlSession session, final SubservicioVO ssrv)
            throws InstanceNotFoundException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void statechangePostOperations(final SqlSession session, final SubservicioVO ssrv,
            final ItemTramiteVO ittr, final TramiteDetailVO trmtDetail) throws ModelException {
        // noop
    }
}
