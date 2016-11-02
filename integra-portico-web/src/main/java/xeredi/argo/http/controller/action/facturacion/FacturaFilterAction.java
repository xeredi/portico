package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaEstado;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaFilterAction.
 */
@Data
public final class FacturaFilterAction extends GridFilterAction<FacturaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -618324706779990531L;

    /** Estados de una factura. */
    private FacturaEstado[] fctrEstadoList;

    /** Tipos de servicio. */
    private List<LabelValueVO> tpsrList;

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
        tpsrList = TipoServicioProxy.selectLabelValues();
    }
}
