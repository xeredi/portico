package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaLineaVO;

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

        resultList = fctrBO.selectFctlList(model.getFctr().getId(), getIdioma(), getOffset(), limit);
    }
}
