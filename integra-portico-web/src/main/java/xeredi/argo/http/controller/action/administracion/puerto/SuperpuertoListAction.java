package xeredi.argo.http.controller.action.administracion.puerto;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.sprt;
    }
}
