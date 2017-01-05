package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleService;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleSaveAction.
 */
public final class ReglaIncompatibleSaveAction extends CrudSaveAction<ReglaIncompatibleVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3406256689953956051L;

	@Inject
	private ReglaIncompatibleService rginService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			rginService.insert(model);

			break;
		case edit:
			rginService.update(model);

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
		Preconditions.checkNotNull(model.getRgla1Id());

		if (accion == AccionCodigo.create) {
			FieldValidator.validateRequired(this, MessageI18nKey.rgin_rgla2, model.getRgla2());
		} else {
			Preconditions.checkNotNull(model.getId());
			Preconditions.checkNotNull(model.getVersion().getId());
			Preconditions.checkNotNull(model.getRgla2());
			Preconditions.checkNotNull(model.getRgla2().getId());
		}

		FieldValidator.validateVersion(this, accion, model);
	}
}
