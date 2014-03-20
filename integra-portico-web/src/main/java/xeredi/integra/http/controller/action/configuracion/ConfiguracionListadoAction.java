package xeredi.integra.http.controller.action.configuracion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfiguracionListadoAction.
 */
public final class ConfiguracionListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6958876928850161861L;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Listado.
     * 
     * @return the string
     */
    @Action(value = "conf-listado")
    public String listado() {
        return SUCCESS;
    }

}
