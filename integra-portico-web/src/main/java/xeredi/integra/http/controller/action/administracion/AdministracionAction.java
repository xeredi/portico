package xeredi.integra.http.controller.action.administracion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.vo.MessageI18nBundlename;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministracionAction.
 */
public final class AdministracionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -272356575394609490L;

    /** The bundle list. */
    private MessageI18nBundlename[] bundleList;

    /**
     * Administracion.
     *
     * @return the string
     */
    @Action("main")
    public String administracion() {
        bundleList = MessageI18nBundlename.values();

        return SUCCESS;
    }

    /**
     * Gets the bundle list.
     *
     * @return the bundle list
     */
    public MessageI18nBundlename[] getBundleList() {
        return bundleList;
    }

}
