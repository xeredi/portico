package xeredi.argo.http.controller.action.facturacion;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.I18nService;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.service.AspectoService;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.AccionCodigo;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoEditAction.
 */
public final class AspectoEditAction extends CrudEditAction<AspectoVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6065040172880726006L;

	/** The i18n map. */
	@Getter
	private Map<String, I18nVO> i18nMap;

	/** The enti list. */
	@Getter
	private List<LabelValueVO> tpsrList;

	@Inject
	private AspectoService aspcService;

	@Inject
	private TipoServicioService tpsrService;

	@Inject
	private I18nService i18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		if (accion != AccionCodigo.create) {
			Preconditions.checkNotNull(model.getId());

			model = aspcService.select(model.getId(), model.getFref(), getIdioma());
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
	}
}
