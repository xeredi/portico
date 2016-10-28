package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaSerieBO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieListAction.
 */
public final class FacturaSerieListAction extends GridListAction<FacturaSerieCriterioVO, FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8695014228430229258L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        resultList = fcsrBO.selectList(model, getOffset(), limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.fcsr;
    }
}
