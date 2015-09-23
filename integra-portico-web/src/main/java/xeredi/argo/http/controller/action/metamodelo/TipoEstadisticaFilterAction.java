package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaFilterAction.
 */
public final class TipoEstadisticaFilterAction extends GridFilterAction<TipoEstadisticaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3827129512834686253L;

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
        return AccionPrefix.tpes;
    }

}
