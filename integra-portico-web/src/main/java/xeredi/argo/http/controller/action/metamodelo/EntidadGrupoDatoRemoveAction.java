package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.service.EntidadGrupoDatoService;
import xeredi.argo.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoRemoveAction.
 */
public final class EntidadGrupoDatoRemoveAction extends CrudRemoveAction<EntidadGrupoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8335697148874416415L;

	@Inject
	private EntidadGrupoDatoService engdService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		engdService.delete(model);
	}
}
