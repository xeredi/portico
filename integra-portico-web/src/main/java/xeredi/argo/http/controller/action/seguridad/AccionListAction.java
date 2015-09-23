package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.bo.AccionBO;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.argo.model.seguridad.vo.AccionVO;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.accn;
    }
}
