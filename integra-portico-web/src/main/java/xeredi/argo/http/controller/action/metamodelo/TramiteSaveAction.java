package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.TramiteService;
import xeredi.argo.model.metamodelo.vo.TramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteSaveAction.
 */
public final class TramiteSaveAction extends CrudSaveAction<TramiteVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6857018201060457551L;

	/** The i18n map. */
	@Setter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private TramiteService trmtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			trmtService.insert(model, i18nMap);

			break;
		case edit:
			trmtService.update(model, i18nMap);

			break;
		default:
			throw new Error("Invalid action: " + accion.name());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiId());

		switch (accion) {
		case create:
			FieldValidator.validateRequired(this, MessageI18nKey.trmt_estado_orig, model.getEstadoOrig());
			FieldValidator.validateRequired(this, MessageI18nKey.trmt_estado_dest, model.getEstadoDest());

			break;
		case edit:
			Preconditions.checkNotNull(model.getId());

			break;
		default:
			throw new Error("Invalid action: " + accion.name());
		}

		FieldValidator.validateI18n(this, i18nMap);
	}
}
