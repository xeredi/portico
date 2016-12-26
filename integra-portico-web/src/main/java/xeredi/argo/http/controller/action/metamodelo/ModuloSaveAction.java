package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.ModuloService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.ModuloVO;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new modulo save action.
 */
public final class ModuloSaveAction extends CrudSaveAction<ModuloVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8050794442778503887L;

	/** The i18n map. */
	@Setter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private ModuloService mdloService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			mdloService.insert(model, i18nMap);

			break;
		case edit:
			mdloService.update(model, i18nMap);

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

		FieldValidator.validateRequired(this, MessageI18nKey.mdlo_codigo, model.getCodigo());

		FieldValidator.validateI18n(this, i18nMap);
	}
}
