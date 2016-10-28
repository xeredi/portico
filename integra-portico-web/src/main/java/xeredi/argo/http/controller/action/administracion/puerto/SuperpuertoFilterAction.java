package xeredi.argo.http.controller.action.administracion.puerto;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoFilterAction.
 */
public final class SuperpuertoFilterAction extends GridFilterAction<SuperpuertoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6057301028031916940L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.sprt;
    }
}
