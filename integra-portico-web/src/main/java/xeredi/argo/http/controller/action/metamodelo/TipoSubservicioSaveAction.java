package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioSaveAction.
 */
public final class TipoSubservicioSaveAction extends EntidadSaveAction<TipoSubservicioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2564809133906860884L;

	@Inject
	private TipoSubservicioService tpssService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		Preconditions.checkNotNull(model.getTpsrId());

		FieldValidator.validateRequired(this, MessageI18nKey.enti_temporal, model.isTemporal());
		FieldValidator.validateRequired(this, MessageI18nKey.enti_facturable, model.isFacturable());
		FieldValidator.validateRequired(this, MessageI18nKey.enti_exencionable, model.isExencionable());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		switch (accion) {
		case create:
			tpssService.insert(model, i18nMap);

			break;
		case edit:
			tpssService.update(model, i18nMap);

			break;
		default:
			throw new Error("Accion no soportada: " + accion);
		}
	}
}
