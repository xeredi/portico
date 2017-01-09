package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.TipoSubparametroService;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroSaveAction.
 */
public final class TipoSubparametroSaveAction extends EntidadSaveAction<TipoSubparametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3409997803363715915L;

	@Inject
	private TipoSubparametroService tpspService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpprId());

		FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, model.isI18n());
		FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, model.isTempExp());

		FieldValidator.validateRequired(this, MessageI18nKey.enti_tpprAsociado, model.getTpprAsociado());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			tpspService.insert(model, i18nMap);

			break;
		case edit:
			tpspService.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}
	}
}
