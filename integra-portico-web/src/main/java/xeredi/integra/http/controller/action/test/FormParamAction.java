package xeredi.integra.http.controller.action.test;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class FormParamAction.
 */
public final class FormParamAction extends ActionSupport {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6704410572801344847L;

    /** The form criterio. */
    private FormCriterioVO formCriterio;

    /**
     * Gets the form criterio.
     * 
     * @return the form criterio
     */
    public FormCriterioVO getFormCriterio() {
        return formCriterio;
    }

    /**
     * Sets the form criterio.
     * 
     * @param value
     *            the new form criterio
     */
    public void setFormCriterio(final FormCriterioVO value) {
        formCriterio = value;
    }

    // Acciones Web
    /**
     * Editar.
     * 
     * @return the string
     */
    @Action(value = "test-formparam-editar", results = { @Result(name = "success", location = "formparam.jsp") })
    public String editar() {
        return SUCCESS;
    }

    /**
     * Validar.
     * 
     * @return the string
     */
    @Action(value = "test-formparam-validar", results = {
            @Result(name = "success", location = "formparam.jsp"),
            @Result(name = "input", location = "formparam.jsp") })
    public String validar() {
        return SUCCESS;
    }
}
