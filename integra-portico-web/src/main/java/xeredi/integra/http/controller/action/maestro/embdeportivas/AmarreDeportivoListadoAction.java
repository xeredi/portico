package xeredi.integra.http.controller.action.maestro.embdeportivas;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.maestro.bo.embdeportivas.AmarreDeportivoBO;

// TODO: Auto-generated Javadoc
/**
 * The Class EmbDepAutListadoAction.
 */
public final class AmarreDeportivoListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1922904918711479468L;

    /**
     * Recalcular estado.
     *
     * @return the string
     */
    @Action("amad-recalc-estado")
    public String recalcularEstado() {
        final AmarreDeportivoBO amadBO = new AmarreDeportivoBO();

        amadBO.updateRecalcularEstado();

        return SUCCESS;
    }
}
