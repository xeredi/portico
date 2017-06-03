package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;
import java.util.Map;

import javax.inject.Inject;

import lombok.Setter;
import xeredi.argo.http.controller.action.item.ItemSaveAction;
import xeredi.argo.http.util.FieldValidator;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.service.EntidadProxyService;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.util.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroSaveAction.
 */
public final class ParametroSaveAction extends ItemSaveAction<ParametroVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8612808873765455744L;

	/** The p18n map. */
	@Setter
	private Map<String, I18nVO> i18nMap;

	@Inject
	private ParametroService prmtService;

	@Inject
	private EntidadProxyService entiProxy;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificValidate() throws ApplicationException {
		final TipoParametroDetailVO enti = entiProxy.selectTppr(model.getEntiId());

		if (enti.getEnti().getPuerto()) {
			FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto());

			if (!hasErrors()) {
				FieldValidator.validateRequired(this, MessageI18nKey.prto, model.getPrto().getId());
			}
		}

		FieldValidator.validateRequired(this, MessageI18nKey.prmt_parametro, model.getParametro());

		DateUtil.truncTime(model.getVersion().getFini(), Calendar.HOUR_OF_DAY);
		DateUtil.truncTime(model.getVersion().getFfin(), Calendar.HOUR_OF_DAY);

		FieldValidator.validateVersion(this, accion, model);

		if (!hasErrors()) {
			FieldValidator.validateRequired(this, MessageI18nKey.fini, model.getVersion().getFini());
		}

		if (enti.getEnti().getGis()) {
			FieldValidator.validateRequired(this, MessageI18nKey.prmt_lat, model.getVersion().getLat());
			FieldValidator.validateRequired(this, MessageI18nKey.prmt_lon, model.getVersion().getLon());
		}

		if (enti.getEnti().isI18n()) {
			FieldValidator.validateI18n(this, i18nMap);
		}

		FieldValidator.validateItem(this, enti, model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		final TipoParametroDetailVO enti = entiProxy.selectTppr(model.getEntiId());

		switch (accion) {
		case create:
			prmtService.insert(model, enti, i18nMap);

			break;
		case edit:
			prmtService.update(model, enti, i18nMap);

			break;
		case duplicate:
			prmtService.duplicate(model, enti, i18nMap);

			break;
		case duplicate_version:
			prmtService.duplicateVersion(model, enti, i18nMap);

			break;
		default:
			throw new Error("Accion no valida: " + accion);
		}
	}
}
