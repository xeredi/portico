package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoSaveAction.
 */
public final class AspectoCargoSaveAction extends CrudSaveAction<AspectoCargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5838925962199897361L;

	@Inject
	private AspectoCargoService ascrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			ascrService.insert(model);

			break;
		case edit:
			ascrService.update(model);

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
		Preconditions.checkNotNull(model.getAspcId());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.crgo, model.getCrgo());

			if (!hasErrors()) {
				FieldValidator.validateRequired(this, MessageI18nKey.crgo, model.getCrgo().getId());
			}
		} else {
			Preconditions.checkNotNull(model.getId());
			Preconditions.checkNotNull(model.getVersion());
			Preconditions.checkNotNull(model.getVersion().getId());
		}

		FieldValidator.validateVersion(this, accion, model);
	}
}
