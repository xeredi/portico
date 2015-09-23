package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroFilterAction.
 */
public final class TipoParametroFilterAction extends GridFilterAction<TipoParametroCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8019963453091790625L;

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
        return AccionPrefix.tppr;
    }
}
