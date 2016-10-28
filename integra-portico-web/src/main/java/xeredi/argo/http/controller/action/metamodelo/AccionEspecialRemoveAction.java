package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialRemoveAction.
 */
public final class AccionEspecialRemoveAction extends CrudRemoveAction<AccionEspecialVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3638404948238880930L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		final AccionEspecialBO acesBO = new AccionEspecialBO();

		acesBO.delete(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccionPrefix getAccnPrefix() {
		return AccionPrefix.aces;
	}

}
