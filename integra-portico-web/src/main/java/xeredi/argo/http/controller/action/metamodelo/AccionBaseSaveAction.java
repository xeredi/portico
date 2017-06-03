package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.AccionBaseService;
import xeredi.argo.model.metamodelo.vo.AccionBaseVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionBaseSaveAction.
 */
public final class AccionBaseSaveAction extends CrudSaveAction<AccionBaseVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3847810790957415340L;

	@Inject
	private AccionBaseService acbsService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			acbsService.insert(model);

			break;
		case edit:
			acbsService.update(model);

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		if (accion == AccionCodigo.create) {
		} else {
			Preconditions.checkNotNull(model.getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.acbs_codigo, model.getCodigo());
		FieldValidator.validateRequired(this, MessageI18nKey.acbs_prefix, model.getPrefix());
	}
}
