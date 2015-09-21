package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaDetalleVO;

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
