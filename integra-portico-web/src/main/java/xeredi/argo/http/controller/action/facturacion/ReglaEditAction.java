package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.service.CargoService;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.facturacion.vo.ReglaTipo;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.service.TipoSubservicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaEditAction.
 */
public final class ReglaEditAction extends CrudEditAction<ReglaVO> {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7473288340314527092L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The enti facturable list. */
	@Getter
	private List<LabelValueVO> entiFacturableList;

	/** The tipos. */
	@Getter
	private ReglaTipo[] tipos;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private CargoService crgoService;

	@Inject
	private ReglaService rglaService;

	@Inject
	private I18nService i18nService;

	@Inject
	private TipoSubservicioService tpssService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			Preconditions.checkNotNull(model.getCrgo());
			Preconditions.checkNotNull(model.getCrgo().getId());

			final CargoVO crgo = crgoService.select(model.getCrgo().getId(), model.getFref(), getIdioma());

			model.setCrgo(crgo);
			model.getVersion().setFini(Calendar.getInstance().getTime());
		} else {
			Preconditions.checkNotNull(model.getId());

			model = rglaService.select(model.getId(), model.getFref(), getIdioma());
			i18nMap = i18nService.selectMap(model);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		if (accion == AccionCodigo.create) {
			tipos = ReglaTipo.values();

			final CargoVO crgo = crgoService.select(model.getCrgo().getId(), model.getFref(), getIdioma());
			final TipoServicioCriterioVO tpsrCriterioVO = new TipoServicioCriterioVO();

			tpsrCriterioVO.setId(crgo.getTpsr().getId());
			tpsrCriterioVO.setFacturable(Boolean.TRUE);
			tpsrCriterioVO.setIdioma(getIdioma());

			entiFacturableList = tpsrService.selectLabelValues(tpsrCriterioVO);

			final TipoSubservicioCriterioVO tpssCriterioVO = new TipoSubservicioCriterioVO();

			tpssCriterioVO.setTpsrId(crgo.getTpsr().getId());
			tpssCriterioVO.setFacturable(Boolean.TRUE);
			tpssCriterioVO.setIdioma(getIdioma());

			entiFacturableList.addAll(tpssService.selectLabelValues(tpssCriterioVO));
		}
	}
}
