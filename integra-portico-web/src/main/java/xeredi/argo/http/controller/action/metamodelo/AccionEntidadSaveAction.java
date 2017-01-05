package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.AccionEntidadService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.AccionEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEntidadSaveAction.
 */
public final class AccionEntidadSaveAction extends CrudSaveAction<AccionEntidadVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7228427972567184600L;

	@Inject
	private AccionEntidadService acenService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			acenService.insert(model);
			break;
		case edit:
			acenService.update(model);
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
		Preconditions.checkNotNull(model.getEntiId());

		if (accion != AccionCodigo.create) {
			Preconditions.checkNotNull(model.getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.aebs, model.getAebs());

		if (!hasErrors()) {
			FieldValidator.validateRequired(this, MessageI18nKey.aebs, model.getAebs().getId());
		}
	}
}
