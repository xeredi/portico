package xeredi.integra.http.controller.action.administracion.puerto;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;

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

}
