package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionBO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrl;
    }
}
