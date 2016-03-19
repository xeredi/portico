package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.TypeaheadAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaTypeaheadCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaTypeaheadAction.
 */
public final class FacturaTypeaheadAction extends TypeaheadAction<FacturaTypeaheadCriterioVO, FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4164779349249014706L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        final FacturaBO fctrBO = new FacturaBO();

        resultList = fctrBO.selectTypeaheadList(model, limit);
    }
}
