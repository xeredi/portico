package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadTipoDatoService;
import xeredi.argo.model.metamodelo.vo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoRemoveAction.
 */
public final class EntidadTipoDatoRemoveAction extends CrudRemoveAction<EntidadTipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7790171477752471387L;

	@Inject
	private EntidadTipoDatoService entdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		entdService.delete(model);
	}
}
