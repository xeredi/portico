package xeredi.integra.http.controller.action.usuario;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.vo.servicio.usuario.UsuarioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioAction.
 */
@ParentPackage("json-default")
public final class UsuarioAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7832880559310609306L;

    /** The usro. */
    private UsuarioVO usro;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Acceso.
     * 
     * @return the string
     */
    @Action(value = "usro-acceso", results = { @Result(name = "success", type = "json") })
    public String acceso() {
        Preconditions.checkNotNull(usro);

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the usro.
     * 
     * @return the usro
     */
    public UsuarioVO getUsro() {
        return usro;
    }

    /**
     * Sets the usro.
     * 
     * @param value
     *            the new usro
     */
    public void setUsro(final UsuarioVO value) {
        usro = value;
    }

}
