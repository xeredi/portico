package xeredi.argo.http.controller.action.metamodelo;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.bo.AccionEspecialBO;
import xeredi.argo.model.metamodelo.vo.AccionEspecialVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionEspecialSaveAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class AccionEspecialSaveAction extends CrudSaveAction<AccionEspecialVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6614369736767022920L;

	/** The i18n map. */
	private Map<String, I18nVO> i18nMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final AccionEspecialBO acesBO = new AccionEspecialBO();

		switch (accion) {
		case create:
			acesBO.insert(model, i18nMap);

			break;
		case edit:
			acesBO.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no contemplada: " + accion);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getEntiId());

		FieldValidator.validateI18n(this, i18nMap);

		FieldValidator.validateRequired(this, MessageI18nKey.aces_orden, model.getOrden());
		FieldValidator.validateRequired(this, MessageI18nKey.aces_path, model.getPath());
	}
}
