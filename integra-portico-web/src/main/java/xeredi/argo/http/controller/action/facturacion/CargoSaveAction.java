package xeredi.argo.http.controller.action.facturacion;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoSaveAction.
 */
public final class CargoSaveAction extends CrudSaveAction<CargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4637124394309482562L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private CargoService crgoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			crgoService.insert(model, i18nMap);

			break;
		case edit:
			crgoService.update(model, i18nMap);

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
		if (AccionCodigo.create == accion) {
			FieldValidator.validateRequired(this, MessageI18nKey.crgo_codigo, model.getCodigo());
			FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr());

			if (!hasErrors()) {
				FieldValidator.validateRequired(this, MessageI18nKey.tpsr, model.getTpsr().getId());
			}
		}

		FieldValidator.validateI18n(this, i18nMap);
		FieldValidator.validateRequired(this, MessageI18nKey.crgo_tipo, model.getVersion().getTipo());
		FieldValidator.validateRequired(this, MessageI18nKey.crgo_temporal, model.getVersion().getTemporal());
		FieldValidator.validateRequired(this, MessageI18nKey.crgo_principal, model.getVersion().getPrincipal());
	}
}
