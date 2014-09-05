package xeredi.integra.http.controller.action.configuracion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.configuracion.bo.Entorno;
import xeredi.integra.model.configuracion.bo.EntornoBO;
import xeredi.integra.model.configuracion.vo.EntornoVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntornoAction.
 */
@ParentPackage("json-default")
public final class EntornoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3487674473861828481L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cnen. */
    private EntornoVO cnen;

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
    @Action(value = "cnen-alta", results = { @Result(name = "success", location = "cnen-edicion.jsp") })
    public String alta() throws InstanceNotFoundException {
        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnen-modificar", results = { @Result(name = "success", location = "cnen-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.edit;

        final Entorno cnenBO = BOFactory.getInjector().getInstance(EntornoBO.class);

        cnen = cnenBO.select(cnen.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnen-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "cnen-detalle", "cnen.id",
            "%{cnen.id}" }), @Result(name = "input", location = "cnen-edicion.jsp") })
    public String guardar() throws InstanceNotFoundException {
        // Validacion de datos
        if (accion == ACCION_EDICION.create) {
            PropertyValidator.validateRequired(this, "cnen.codigo", cnen.getCodigo());
        }

        PropertyValidator.validateRequired(this, "cnen.nombre", cnen.getNombre());

        if (hasErrors()) {
            return INPUT;
        }

        final Entorno cnenBO = BOFactory.getInjector().getInstance(EntornoBO.class);

        if (accion == ACCION_EDICION.create) {
            try {
                cnenBO.insert(cnen);
            } catch (final DuplicateInstanceException ex) {
                addFieldError("cnen.codigo", getText("error.cnen.duplicate"));
            }
        } else {
            cnenBO.update(cnen);
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
        @Action(value = "cnen-detalle"),
        @Action(value = "cnen-detalle-json", results = { @Result(name = "success", type = "json") }),
        @Action(value = "cnen-detalle-popup", results = { @Result(name = "success", location = "cnen-detalle.jsp") }) })
    public String detalle() {
        final Entorno cnenBO = BOFactory.getInjector().getInstance(EntornoBO.class);

        cnen = cnenBO.select(cnen.getId());

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
     * Gets the cnen.
     *
     * @return the cnen
     */
    public EntornoVO getCnen() {
        return cnen;
    }

    /**
     * Sets the cnen.
     *
     * @param value
     *            the new cnen
     */
    public void setCnen(final EntornoVO value) {
        cnen = value;
    }
}
