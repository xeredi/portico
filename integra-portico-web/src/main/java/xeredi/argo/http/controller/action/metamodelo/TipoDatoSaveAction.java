package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.TipoDatoService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.metamodelo.vo.TipoElemento;

/**
 * The Class TipoDatoSaveAction.
 */
public final class TipoDatoSaveAction extends CrudSaveAction<TipoDatoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6497317985967093794L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The tpdt service. */
	@Inject
	private TipoDatoService tpdtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			tpdtService.insert(model, i18nMap);

			break;
		case edit:
			tpdtService.update(model, i18nMap);

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
			FieldValidator.validateRequired(this, MessageI18nKey.tpdt_codigo, model.getCodigo());
		} else {
			Preconditions.checkNotNull(model.getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.tpdt_tpht, model.getTpht());
		FieldValidator.validateRequired(this, MessageI18nKey.tpdt_tpel, model.getTipoElemento());

		if (FieldValidator.isInList(model.getTipoElemento(), TipoElemento.PR, TipoElemento.SR)) {
			FieldValidator.validateRequired(this, MessageI18nKey.enti, model.getEnti());
		}

		FieldValidator.validateI18n(this, i18nMap);
	}
}
