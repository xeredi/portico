package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoFilterAction.
 */
public final class CargoFilterAction extends GridFilterAction<CargoCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4024940532231620563L;

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
