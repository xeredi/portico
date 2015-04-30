package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.comun.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridRemoveAction.
 */
public final class EntidadAccionGridRemoveAction extends CrudRemoveAction<EntidadAccionGridVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7363930156589738654L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

        enagBO.delete(model);
    }
}
