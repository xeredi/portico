package xeredi.argo.http.controller.action.seguridad;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRemoveAction.
 */
public final class UsuarioRemoveAction extends CrudRemoveAction<UsuarioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5018891561096266090L;

	/** The usro service. */
	@Inject
	private UsuarioService usroService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRemove() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		usroService.delete(model);
	}
}
