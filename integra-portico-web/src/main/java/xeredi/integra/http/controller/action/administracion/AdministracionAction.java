package xeredi.integra.http.controller.action.administracion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministracionAction.
 */
public final class AdministracionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -272356575394609490L;

    /**
     * Administracion.
     *
     * @return the string
     */
    @Action("main")
    public String administracion() {
        return SUCCESS;
    }

}
