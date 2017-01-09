package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoFilterAction.
 */
public final class AspectoFilterAction extends GridFilterAction<AspectoCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7354700770368605863L;

	/** The tpsr list. */
	@Getter
	private List<LabelValueVO> tpsrList;

	@Inject
	private TipoServicioService tpsrService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doPrepareFilter() throws ApplicationException {
		// noop
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		tpsrList = tpsrService.selectLabelValues(new TipoServicioCriterioVO());
	}
}
