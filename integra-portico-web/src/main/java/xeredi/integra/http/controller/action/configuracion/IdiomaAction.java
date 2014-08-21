package xeredi.integra.http.controller.action.configuracion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.configuracion.bo.Idioma;
import xeredi.integra.model.configuracion.vo.IdiomaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class IdiomaAction.
 */
public final class IdiomaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8597194195195082133L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cnid. */
    private IdiomaVO cnid;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web

    /**
     * Alta.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnid-alta", results = { @Result(name = "success", location = "cnid-edicion.jsp") })
    public String alta() throws InstanceNotFoundException {
        accion = ACCION_EDICION.alta;

        return SUCCESS;
    }

    /**
     * Modificar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnid-modificar", results = { @Result(name = "success", location = "cnid-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);

        cnid = cnidBO.select(cnid.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnid-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "cnid-detalle", "cnid.id",
            "%{cnid.id}" }), @Result(name = "input", location = "cnid-edicion.jsp") })
    public String guardar() throws InstanceNotFoundException {
        // Validacion de datos
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "cnid.codigo", cnid.getCodigo());
        }

        PropertyValidator.validateRequired(this, "cnid.descripcion", cnid.getDescripcion());

        if (hasErrors()) {
            return INPUT;
        }

        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);

        if (accion == ACCION_EDICION.alta) {
            try {
                cnidBO.insert(cnid);
            } catch (final DuplicateInstanceException ex) {
                addFieldError("cnid.codigo", getText("error.cnid.duplicate"));
            }
        } else {
            cnidBO.update(cnid);
        }

        if (hasErrors()) {
            return INPUT;
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     * 
     * @return the string
     */
    @Actions({
        @Action(value = "cnid-detalle"),
        @Action(value = "cnid-detalle-popup", results = { @Result(name = "success", location = "cnid-detalle.jsp") }) })
    public String detalle() {
        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);

        cnid = cnidBO.select(cnid.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the accion.
     * 
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     * 
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the cnid.
     * 
     * @return the cnid
     */
    public IdiomaVO getCnid() {
        return cnid;
    }

    /**
     * Sets the cnid.
     * 
     * @param value
     *            the new cnid
     */
    public void setCnid(final IdiomaVO value) {
        cnid = value;
    }

}
