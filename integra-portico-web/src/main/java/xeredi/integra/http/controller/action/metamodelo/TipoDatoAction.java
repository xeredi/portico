package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.Entidad;
import xeredi.integra.model.bo.metamodelo.TipoDato;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.metamodelo.TipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoElemento;
import xeredi.integra.model.vo.metamodelo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAction.
 */
public final class TipoDatoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7405460701196255597L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tppr. */
    private TipoDatoVO tpdt;

    /**
     * Instantiates a new tipo dato action.
     */
    public TipoDatoAction() {
        super();

        tpdt = new TipoDatoVO();
    }

    // Acciones Web
    /**
     * Alta.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "tpdt-alta", results = { @Result(name = "success", location = "tpdt-edicion.jsp") })
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
    @Action(value = "tpdt-modificar", results = { @Result(name = "success", location = "tpdt-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDato.class);

        tpdt = tpdtBO.select(tpdt.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "tpdt-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "tpdt-detalle", "tpdt.id",
            "%{tpdt.id}" }), @Result(name = "input", location = "tpdt-edicion.jsp") })
    public String guardar() throws InstanceNotFoundException {
        // Validacion de datos
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "tpdt.nombre", tpdt.getNombre());
        }

        PropertyValidator.validateRequired(this, "tpdt.tpht", tpdt.getTpht());
        PropertyValidator.validateRequired(this, "tpdt.tipoElemento", tpdt.getTipoElemento());

        if (tpdt.getTipoElemento() != null && tpdt.getTipoElemento() == TipoElemento.PR) {
            PropertyValidator.validateRequired(this, "tpdt.tppr", tpdt.getEnti());
        }

        if (hasErrors()) {
            return INPUT;
        }

        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDato.class);

        if (accion == ACCION_EDICION.alta) {
            try {
                tpdtBO.insert(tpdt);
            } catch (final DuplicateInstanceException ex) {
                addFieldError("tpdt.nombre", getText("error.tpdt.duplicate"));
            }
        } else {
            tpdtBO.update(tpdt);
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
        @Action(value = "tpdt-detalle"),
        @Action(value = "tpdt-detalle-popup", results = { @Result(name = "success", location = "tpdt-detalle.jsp") }) })
    public String detalle() {
        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDato.class);

        tpdt = tpdtBO.select(tpdt.getId());

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the tphts.
     * 
     * @return the tphts
     */
    public TipoHtml[] getTphts() {
        return TipoHtml.values();
    }

    /**
     * Gets the tpprs.
     * 
     * @return the tpprs
     */
    public List<LabelValueVO> getEntis() {
        return BOFactory.getInjector().getInstance(Entidad.class).selectLabelValues();
    }

    /**
     * Gets the tipos elemento.
     * 
     * @return the tipos elemento
     */
    public TipoElemento[] getTiposElemento() {
        return TipoElemento.values();
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

    /**
     * Gets the tpdt.
     * 
     * @return the tpdt
     */
    public TipoDatoVO getTpdt() {
        return tpdt;
    }

    /**
     * Sets the tpdt.
     * 
     * @param value
     *            the new tpdt
     */
    public void setTpdt(final TipoDatoVO value) {
        tpdt = value;
    }

}
