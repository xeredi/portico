package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaListAction.
 */
public final class FacturaListAction extends GridListAction<FacturaCriterioVO, FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6828936466180806396L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final FacturaBO fctrBO = new FacturaBO();

        resultList = fctrBO.selectList(model, getOffset(), limit);
    }
}
