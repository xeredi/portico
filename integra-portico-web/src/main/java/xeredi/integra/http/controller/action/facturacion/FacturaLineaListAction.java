package xeredi.integra.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaListAction.
 */
public final class FacturaLineaListAction extends GridListAction<FacturaLineaCriterioVO, FacturaLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 408627782002711638L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        Preconditions.checkNotNull(model.getFctr());
        Preconditions.checkNotNull(model.getFctr().getId());

        final FacturaBO fctrBO = new FacturaBO();

        resultList = fctrBO.selectFctlList(model.getFctr().getId(), getOffset(), limit);
    }
}
