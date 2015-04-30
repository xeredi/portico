package xeredi.integra.http.controller.action.proceso;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoCriterioVO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListAction.
 */
public final class ProcesoListAction extends GridListAction<ProcesoCriterioVO, ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4892003930947515760L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ProcesoBO prbtBO = new ProcesoBO();

        resultList = prbtBO.selectList(model, getOffset(), limit);
    }
}
