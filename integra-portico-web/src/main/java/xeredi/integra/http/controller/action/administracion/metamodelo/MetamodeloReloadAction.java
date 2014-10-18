package xeredi.integra.http.controller.action.administracion.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.MetamodeloProxy;

// TODO: Auto-generated Javadoc
/**
 * The Class MetamodeloReloadAction.
 */
public final class MetamodeloReloadAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8578635089114047405L;

    /**
     * Prepare.
     *
     * @return the string
     */
    @Action("reload-prepare")
    public String prepare() {
        return SUCCESS;
    }

    /**
     * Reload.
     *
     * @return the string
     */
    @Action("reload")
    public String reload() {
        try {
            MetamodeloProxy.reload();
        } catch (final Throwable ex) {
            addActionError(ex.getMessage());
        }

        return SUCCESS;
    }

}
