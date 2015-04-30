package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleListAction.
 */
public final class ValoracionDetalleListAction extends GridListAction<ValoracionDetalleCriterioVO, ValoracionDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5836376477924004332L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        Preconditions.checkNotNull(model.getVlrl());
        Preconditions.checkNotNull(model.getVlrl().getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        resultList = vlrcBO.selectVlrdList(model, idioma, getOffset(), limit);
    }
}
