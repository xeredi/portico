package xeredi.argo.http.controller.action.maestro;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.item.ItemEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.service.ParametroService;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroEditAction.
 */
public final class ParametroEditAction extends ItemEditAction<ParametroVO, TipoParametroDetailVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8716069938226934369L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The prto list. */
	@Getter
	private List<PuertoVO> prtoList;

	@Inject
	private ParametroService prmtService;

	@Inject
	private I18nService i18nService;

	@Inject
	private PuertoService prtoService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSpecificEdit() throws ApplicationException {
		enti = TipoParametroProxy.select(model.getEntiId());

		if (accion == AccionCodigo.create) {
			i18nMap = new HashMap<String, I18nVO>();
		} else {
			model = prmtService.select(model.getId(), getIdioma(), model.getFref());

			if (accion == AccionCodigo.duplicate_version) {
				if (model.getVersion().getFfin() != null) {
					model.getVersion().setFini(model.getVersion().getFfin());
					model.getVersion().setFfin(null);
				} else {
					final Calendar ffin = Calendar.getInstance();

					ffin.set(Calendar.HOUR_OF_DAY, 0);
					ffin.set(Calendar.MINUTE, 0);
					ffin.set(Calendar.SECOND, 0);
					ffin.set(Calendar.MILLISECOND, 0);

					model.getVersion().setFini(ffin.getTime());
				}
			}

			if (enti.getEnti().isI18n()) {
				i18nMap = i18nService.selectMap(model);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadSpecificDependencies() throws ApplicationException {
		if (enti.getEnti().getPuerto()) {
			final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

			prtoCriterio.setSprtId(getSprtId());
			prtoCriterio.setIdioma(getIdioma());

			prtoList = prtoService.selectList(prtoCriterio);
		}
	}
}
