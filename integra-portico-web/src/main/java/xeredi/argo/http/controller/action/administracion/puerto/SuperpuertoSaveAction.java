package xeredi.argo.http.controller.action.administracion.puerto;

import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Setter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.SuperpuertoService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoSaveAction.
 */
public final class SuperpuertoSaveAction extends CrudSaveAction<SuperpuertoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1633665993855067357L;

	/** The i18n map. */
	@Setter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private SuperpuertoService sprtService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			sprtService.insert(model, i18nMap);

			break;
		case edit:
			sprtService.update(model, i18nMap);

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
		if (accion == AccionCodigo.edit) {
			Preconditions.checkNotNull(model.getId());
		}

		FieldValidator.validateRequired(this, MessageI18nKey.sprt_codigo, model.getCodigo());

		FieldValidator.validateI18n(this, i18nMap);
	}
}
