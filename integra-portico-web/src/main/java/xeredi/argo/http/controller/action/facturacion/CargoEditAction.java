package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.vo.CargoTipo;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoEditAction.
 */
public final class CargoEditAction extends CrudEditAction<CargoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7135315858700353650L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The tpsr list. */
	@Getter
	private List<LabelValueVO> tpsrList;

	/** The tipos. */
	@Getter
	private CargoTipo[] tipos;

	@Inject
	private CargoService crgoService;

	@Inject
	private I18nService i18nService;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion != AccionCodigo.create) {
			model = crgoService.select(model.getId(), model.getFref(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			tpsrList = tpsrService.selectLabelValues(new TipoServicioCriterioVO());
		}

		tipos = CargoTipo.values();
	}
}
