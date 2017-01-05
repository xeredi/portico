package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.service.ReglaIncompatibleService;
import xeredi.argo.model.facturacion.service.ReglaService;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaDetailAction.
 */
public final class ReglaDetailAction extends CrudDetailAction<ReglaVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -830320171753668738L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The rgin list. */
	@Getter
	private List<ReglaIncompatibleVO> rginList;

	@Inject
	private ReglaService rglaService;

	@Inject
	private I18nService i18nService;

	@Inject
	private ReglaIncompatibleService rginService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = rglaService.select(model.getId(), model.getFref(), getIdioma());
		i18nMap = i18nService.selectMap(model);

		final ReglaIncompatibleCriterioVO rginCriterioVO = new ReglaIncompatibleCriterioVO();

		rginCriterioVO.setRgla1Id(model.getId());
		rginCriterioVO.setFechaVigencia(model.getFref());

		rginList = rginService.selectList(rginCriterioVO);
	}
}
