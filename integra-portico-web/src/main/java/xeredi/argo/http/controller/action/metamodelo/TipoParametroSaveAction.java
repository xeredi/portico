package xeredi.argo.http.controller.action.metamodelo;

import javax.inject.Inject;

import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.TipoParametroService;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroSaveAction.
 */
public final class TipoParametroSaveAction extends EntidadSaveAction<TipoParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5259207976545583053L;

	/** The tppr service. */
	@Inject
	private TipoParametroService tpprService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, model.isI18n());
		FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, model.isTempExp());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			tpprService.insert(model, i18nMap);

			break;
		case edit:
			tpprService.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}
	}
}
