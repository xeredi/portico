package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.facturacion.service.AspectoCargoService;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoDetailAction.
 */
public final class AspectoDetailAction extends CrudDetailAction<AspectoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1363256002707100032L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The ascr list. */
	@Getter
	private List<AspectoCargoVO> ascrList;

	@Inject
	private AspectoService aspcService;

	@Inject
	private AspectoCargoService ascrService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		Preconditions.checkNotNull(model.getId());

		model = aspcService.select(model.getId(), model.getFref(), getIdioma());
		i18nMap = i18nService.selectMap(model);

		final AspectoCargoCriterioVO ascrCriterio = new AspectoCargoCriterioVO();

		ascrCriterio.setAspcId(model.getId());
		ascrCriterio.setFechaVigencia(model.getFref());
		ascrCriterio.setIdioma(getIdioma());

		ascrList = ascrService.selectList(ascrCriterio);
	}
}
