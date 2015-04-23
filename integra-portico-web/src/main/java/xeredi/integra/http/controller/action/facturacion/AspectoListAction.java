package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoListAction.
 */
public final class AspectoListAction extends GridListAction<AspectoCriterioVO, AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6610833697858691088L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final AspectoBO aspcBO = new AspectoBO();

        resultList = aspcBO.selectList(model, getOffset(), limit);
    }
}
