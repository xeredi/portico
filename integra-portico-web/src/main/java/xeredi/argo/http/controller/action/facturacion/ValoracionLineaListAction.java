package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ValoracionLineaBO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.argo.model.facturacion.vo.ValoracionLineaVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

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
        final ValoracionLineaBO vlrlBO = new ValoracionLineaBO();

        resultList = vlrlBO.selectList(model, getOffset(), limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.vlrl;
    }
}
