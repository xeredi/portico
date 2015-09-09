package xeredi.integra.http.controller.action.seguridad;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.seguridad.bo.AccionBO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionListAction.
 */
public final class AccionListAction extends GridListAction<AccionCriterioVO, AccionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1564064734569740718L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final AccionBO accnBO = new AccionBO();

        resultList = accnBO.selectList(model, getOffset(), limit);
    }
}
