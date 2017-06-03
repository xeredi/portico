package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadEntidadService;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadRemoveAction.
 */
public final class EntidadEntidadRemoveAction extends CrudRemoveAction<EntidadEntidadVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 422958063619937693L;

	@Inject
	private EntidadEntidadService enenService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiPadreId());
		Preconditions.checkNotNull(model.getEntiHija());
		Preconditions.checkNotNull(model.getEntiHija().getId());

		enenService.delete(model);
	}
}
