package xeredi.argo.http.controller.action.seguridad;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.UsuarioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioSaveAction.
 */
public final class UsuarioSaveAction extends CrudSaveAction<UsuarioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4486221964172526427L;

	/** The usro service. */
	@Inject
	private UsuarioService usroService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			usroService.insert(model);

			break;
		case edit:
			usroService.update(model);

			break;

		default:
			throw new Error("Accion no valida: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		if (accion != AccionCodigo.create) {
			Preconditions.checkNotNull(model.getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.usro_login, model.getLogin());
		FieldValidator.validateRequired(this, MessageI18nKey.usro_contrasenia, model.getContrasenia());
		FieldValidator.validateRequired(this, MessageI18nKey.usro_email, model.getEmail());
		FieldValidator.validateRequired(this, MessageI18nKey.usro_nombre, model.getNombre());
	}
}
