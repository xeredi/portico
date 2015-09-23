package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.fctr;
    }
}
