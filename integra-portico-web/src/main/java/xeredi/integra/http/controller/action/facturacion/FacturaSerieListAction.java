package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

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
}
