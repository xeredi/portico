package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoDetailAction.
 */
public final class CargoDetailAction extends CrudDetailAction<CargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 731400411604425450L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The rgla list. */
	@Getter
	private List<ReglaVO> rglaList;

	@Inject
	private CargoService crgoService;

	@Inject
	private I18nService i18nService;

	@Inject
	private ReglaService rglaService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		model = crgoService.select(model.getId(), model.getFref(), getIdioma());
		i18nMap = i18nService.selectMap(model);

		final ReglaCriterioVO rglaCriterio = new ReglaCriterioVO();

		rglaCriterio.setCrgoId(model.getId());
		rglaCriterio.setFechaVigencia(model.getFref());
		rglaCriterio.setIdioma(getIdioma());

		rglaList = rglaService.selectList(rglaCriterio);
	}
}
