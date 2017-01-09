package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaEstado;
import xeredi.argo.model.metamodelo.service.TipoServicioService;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaFilterAction.
 */
public final class FacturaFilterAction extends GridFilterAction<FacturaCriterioVO> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -618324706779990531L;

	/** Estados de una factura. */
	@Getter
	private FacturaEstado[] fctrEstadoList;

	/** Tipos de servicio. */
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
		fctrEstadoList = FacturaEstado.values();
		tpsrList = tpsrService.selectLabelValues(new TipoServicioCriterioVO());
	}
}
