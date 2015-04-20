package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;

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
}
