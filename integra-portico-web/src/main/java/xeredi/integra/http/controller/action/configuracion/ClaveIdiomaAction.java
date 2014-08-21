package xeredi.integra.http.controller.action.configuracion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.configuracion.bo.ClaveIdioma;
import xeredi.integra.model.configuracion.bo.Idioma;
import xeredi.integra.model.configuracion.vo.ClaveIdiomaVO;
import xeredi.integra.model.configuracion.vo.IdiomaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveIdiomaAction.
 */
public final class ClaveIdiomaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6471189153743839443L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cnci. */
    private ClaveIdiomaVO cnci;

    /** cnids. */
    private List<IdiomaVO> cnids;

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
    @Action(value = "cnci-alta", results = { @Result(name = "success", location = "cnci-edicion.jsp") })
    public String alta() throws InstanceNotFoundException {
        accion = ACCION_EDICION.alta;

        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);

        cnids = cnidBO.selectAll();

        return SUCCESS;
    }

    /**
     * Modificar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnci-modificar", results = { @Result(name = "success", location = "cnci-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final ClaveIdioma cnciBO = BOFactory.getInjector().getInstance(ClaveIdioma.class);
        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);

        cnci = cnciBO.select(cnci.getId());
        cnids = cnidBO.selectAll();

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cnci-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "cnci-detalle", "cnci.id",
            "%{cnci.id}" }), @Result(name = "input", location = "cnci-edicion.jsp") })
    public String guardar() throws InstanceNotFoundException {
        // Validacion de datos
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "cnci.clave", cnci.getClave());
        }

        PropertyValidator.validateRequired(this, "cnci.valorDefecto", cnci.getValorDefecto());

        if (hasErrors()) {
            return INPUT;
        }

        final ClaveIdioma cnciBO = BOFactory.getInjector().getInstance(ClaveIdioma.class);

        if (accion == ACCION_EDICION.alta) {
            try {
                cnciBO.insert(cnci);
            } catch (final DuplicateInstanceException ex) {
                addFieldError("cnci.clave", getText("error.cnci.duplicate"));
            }
        } else {
            cnciBO.update(cnci);
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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Actions({
        @Action(value = "cnci-detalle"),
        @Action(value = "cnci-detalle-popup", results = { @Result(name = "success", location = "cnci-detalle.jsp") }) })
    public String detalle() throws InstanceNotFoundException {
        final ClaveIdioma cnciBO = BOFactory.getInjector().getInstance(ClaveIdioma.class);

        cnci = cnciBO.select(cnci.getId());

        final Idioma cnidBO = BOFactory.getInjector().getInstance(Idioma.class);

        cnids = cnidBO.selectAll();

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
     * Gets the cnci.
     * 
     * @return the cnci
     */
    public ClaveIdiomaVO getCnci() {
        return cnci;
    }

    /**
     * Sets the cnci.
     * 
     * @param value
     *            the new cnci
     */
    public void setCnci(final ClaveIdiomaVO value) {
        cnci = value;
    }

    /**
     * Gets the cnids.
     * 
     * @return the cnids
     */
    public List<IdiomaVO> getCnids() {
        return cnids;
    }

}
