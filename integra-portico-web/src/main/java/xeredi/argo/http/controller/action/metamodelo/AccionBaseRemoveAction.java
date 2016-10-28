package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionBaseBO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseRemoveAction.
 */
public final class AccionBaseRemoveAction extends CrudRemoveAction<AccionBaseVO> {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4615648744428447373L;

	/**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final AccionBaseBO acbsBO = new AccionBaseBO();

        acbsBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.acbs;
    }
}
