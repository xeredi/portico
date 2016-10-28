package xeredi.argo.http.controller.action.administracion.puerto;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoListAction.
 */
public final class PuertoListAction extends GridListAction<PuertoCriterioVO, PuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1750952015496111173L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final PuertoBO prtoBO = new PuertoBO();

        resultList = prtoBO.selectList(model, getOffset(), limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prto;
    }
}
