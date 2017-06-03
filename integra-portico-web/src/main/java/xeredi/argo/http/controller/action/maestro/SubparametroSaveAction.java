package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.service.SubparametroService;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;
import xeredi.argo.model.util.DateUtil;

/**
 * The Class SubparametroSaveAction.
 */
public final class SubparametroSaveAction extends ItemSaveAction<SubparametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1118698219019756413L;

	@Inject
	private SubparametroService sprmService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		final TipoSubparametroDetailVO enti = entiProxy.selectTpsp(model.getEntiId());

		if (accion != AccionCodigo.edit) {
			FieldValidator.validateRequired(this, getText("enti_" + enti.getEnti().getTpprAsociado().getId()),
					model.getPrmtAsociado());
		}

		if (accion != AccionCodigo.create) {
			Preconditions.checkNotNull(model.getId());
			Preconditions.checkNotNull(model.getVersion());
			Preconditions.checkNotNull(model.getVersion().getId());
		}

		DateUtil.truncTime(model.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(model.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		FieldValidator.validateVersion(this, accion, model);

		FieldValidator.validateItem(this, enti, model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final TipoSubparametroDetailVO enti = entiProxy.selectTpsp(model.getEntiId());

		switch (accion) {
		case create:
			sprmService.insert(model, enti);

			break;
		case edit:
			sprmService.update(model, enti);

			break;
		case duplicate:
			sprmService.duplicate(model, enti);

			break;
		default:
			throw new Error("Accion no valida: " + accion);
		}
	}
}
