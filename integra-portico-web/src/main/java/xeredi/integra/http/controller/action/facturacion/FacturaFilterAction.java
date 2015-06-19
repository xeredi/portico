package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.GridFilterAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaFilterAction.
 */
public final class FacturaFilterAction extends GridFilterAction<FacturaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -618324706779990531L;

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
