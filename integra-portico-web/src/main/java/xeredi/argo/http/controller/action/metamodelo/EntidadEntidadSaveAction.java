package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.EntidadEntidadService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadSaveAction.
 */
public final class EntidadEntidadSaveAction extends CrudSaveAction<EntidadEntidadVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3600184227172584616L;

	@Inject
	private EntidadEntidadService enenService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			enenService.insert(model);

			break;
		case edit:
			enenService.update(model);

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
		Preconditions.checkNotNull(model.getEntiPadreId());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.enen_entiHija, model.getEntiHija());

			if (!hasErrors()) {
				FieldValidator.validateRequired(this, MessageI18nKey.enen_entiHija, model.getEntiHija().getId());
			}
		} else {
			Preconditions.checkNotNull(model.getEntiHija());
			Preconditions.checkNotNull(model.getEntiHija().getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.enen_orden, model.getOrden());
	}
}
