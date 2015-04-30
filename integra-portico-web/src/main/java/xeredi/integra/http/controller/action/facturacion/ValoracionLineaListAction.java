package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaListAction.
 */
public final class ValoracionLineaListAction extends GridListAction<ValoracionLineaCriterioVO, ValoracionLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1895265213593160732L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrc());
        Preconditions.checkNotNull(model.getVlrc().getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        resultList = vlrcBO.selectVlrlList(model, getOffset(), limit);
    }
}
