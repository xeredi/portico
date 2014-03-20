package xeredi.integra.http.controller.action.configuracion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.configuracion.Clave;
import xeredi.integra.model.bo.configuracion.Entorno;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.configuracion.ClaveVO;
import xeredi.integra.model.vo.configuracion.EntornoVO;
import xeredi.integra.model.vo.configuracion.TipoValor;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class ClaveAction.
 */
public final class ClaveAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -608261107465108451L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cncl. */
    private ClaveVO cncl;

    /** The cnens. */
    private List<EntornoVO> cnens;

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
    @Action(value = "cncl-alta", results = { @Result(name = "success", location = "cncl-edicion.jsp") })
    public String alta() throws InstanceNotFoundException {
        accion = ACCION_EDICION.alta;

        final Entorno cnenBO = BOFactory.getInjector().getInstance(Entorno.class);

        cnens = cnenBO.selectAll();

        return SUCCESS;
    }

    /**
     * Modificar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cncl-modificar", results = { @Result(name = "success", location = "cncl-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final Clave cnclBO = BOFactory.getInjector().getInstance(Clave.class);

        cncl = cnclBO.select(cncl.getId());

        final Entorno cnenBO = BOFactory.getInjector().getInstance(Entorno.class);

        cnens = cnenBO.selectAll();

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "cncl-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "cncl-detalle", "cncl.id",
            "%{cncl.id}" }), @Result(name = "input", location = "cncl-edicion.jsp") })
    public String guardar() throws InstanceNotFoundException {
        // Validacion de datos
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "cncl.clave", cncl.getClave());
        }

        PropertyValidator.validateRequired(this, "cncl.tipoValor", cncl.getTipoValor());
        PropertyValidator.validateRequired(this, "cncl.valorDefecto", cncl.getValorDefecto());

        if (hasErrors()) {
            return INPUT;
        }

        final Clave cnclBO = BOFactory.getInjector().getInstance(Clave.class);

        if (accion == ACCION_EDICION.alta) {
            try {
                cnclBO.insert(cncl);
            } catch (final DuplicateInstanceException ex) {
                addFieldError("cncl.codigo", getText("error.cncl.duplicate"));
            }
        } else {
            cnclBO.update(cncl);
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
        @Action(value = "cncl-detalle"),
        @Action(value = "cncl-detalle-popup", results = { @Result(name = "success", location = "cncl-detalle.jsp") }) })
    public String detalle() throws InstanceNotFoundException {
        final Clave cnclBO = BOFactory.getInjector().getInstance(Clave.class);

        cncl = cnclBO.select(cncl.getId());

        final Entorno cnenBO = BOFactory.getInjector().getInstance(Entorno.class);

        cnens = cnenBO.selectAll();

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the cncl.
     * 
     * @return the cncl
     */
    public ClaveVO getCncl() {
        return cncl;
    }

    /**
     * Sets the cncl.
     * 
     * @param value
     *            the new cncl
     */
    public void setCncl(final ClaveVO value) {
        cncl = value;
    }

    /**
     * Gets the cnens.
     * 
     * @return the cnens
     */
    public List<EntornoVO> getCnens() {
        return cnens;
    }

    /**
     * Gets the tipos valor.
     * 
     * @return the tipos valor
     */
    public TipoValor[] getTiposValor() {
        return TipoValor.values();
    }

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
}
