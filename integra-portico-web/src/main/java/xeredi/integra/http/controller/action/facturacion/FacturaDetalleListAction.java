package xeredi.integra.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleListAction.
 */
public final class FacturaDetalleListAction extends GridListAction<FacturaDetalleCriterioVO, FacturaDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 123237028893970950L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        Preconditions.checkNotNull(model.getFctl());
        Preconditions.checkNotNull(model.getFctl().getId());

        final FacturaBO fctrBO = new FacturaBO();

        resultList = fctrBO.selectFctdList(model.getFctl().getId(), getIdioma(), getOffset(), limit);
    }
}
