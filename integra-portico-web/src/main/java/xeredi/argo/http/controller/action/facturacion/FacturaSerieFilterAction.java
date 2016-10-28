package xeredi.argo.http.controller.action.facturacion;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieFilterAction.
 */
@Data
public final class FacturaSerieFilterAction extends GridFilterAction<FacturaSerieCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 453805992132153117L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.fcsr;

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
        // noop
    }
}
