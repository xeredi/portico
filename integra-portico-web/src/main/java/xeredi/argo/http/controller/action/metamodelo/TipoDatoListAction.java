package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

/**
 * The Class TipoDatoListAction.
 */
public final class TipoDatoListAction extends GridListAction<TipoDatoCriterioVO, TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2898524538399018227L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final TipoDatoBO tpdtBO = new TipoDatoBO();

        resultList = tpdtBO.selectList(model, getOffset(), limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpdt;
    }
}
