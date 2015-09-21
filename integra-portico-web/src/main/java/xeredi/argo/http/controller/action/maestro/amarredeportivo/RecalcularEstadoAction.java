package xeredi.argo.http.controller.action.maestro.amarredeportivo;

import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.embdeportivas.AmarreDeportivoBO;

// TODO: Auto-generated Javadoc
/**
 * The Class EmbDepAutListadoAction.
 */
public final class RecalcularEstadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1922904918711479468L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() throws ApplicationException {
        final AmarreDeportivoBO amadBO = new AmarreDeportivoBO();

        amadBO.updateRecalcularEstado();
    }
}
