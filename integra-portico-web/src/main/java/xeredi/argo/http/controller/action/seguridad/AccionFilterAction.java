package xeredi.argo.http.controller.action.seguridad;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.seguridad.vo.AccionCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionFilterAction.
 */
public final class AccionFilterAction extends GridFilterAction<AccionCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1741238545886942803L;

    /** The prefix list. */
    private AccionPrefix[] prefixList;

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
        prefixList = AccionPrefix.values();
    }

    /**
     * Gets the prefix list.
     *
     * @return the prefix list
     */
    public AccionPrefix[] getPrefixList() {
        return prefixList;
    }
}
