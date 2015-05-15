package xeredi.integra.http.controller.action.administracion.puerto;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoListAction.
 */
public final class SuperpuertoListAction extends GridListAction<SuperpuertoCriterioVO, SuperpuertoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 871252972692007990L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();

        resultList = sprtBO.selectList(model, getOffset(), limit);
    }
}
