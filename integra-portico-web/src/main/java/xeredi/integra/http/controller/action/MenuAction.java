package xeredi.integra.http.controller.action;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuAction.
 */
public final class MenuAction extends ActionSupport {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5557087545067689065L;

    // Acciones Web
    /**
     * Listar.
     * 
     * @return the string
     */
    @Action(value = "menu")
    public static String menu() {
        return SUCCESS;
    }

}
