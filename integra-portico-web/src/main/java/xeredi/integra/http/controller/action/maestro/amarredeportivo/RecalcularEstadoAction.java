package xeredi.integra.http.controller.action.maestro.amarredeportivo;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.embdeportivas.AmarreDeportivoBO;

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
