package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.EntidadGrupoDato;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.metamodelo.EntidadGrupoDatoVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoAction.
 */
public final class EntidadGrupoDatoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3556845527608258423L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The entd form. */
    private EntidadGrupoDatoVO engd;

    /**
     * Instantiates a new entidad grupo dato action.
     */
    public EntidadGrupoDatoAction() {
        super();

        engd = new EntidadGrupoDatoVO();
    }

    // Acciones Web
    /**
     * Alta.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "engd-alta", results = { @Result(name = "success", location = "engd-edicion.jsp") })
    public String alta() throws InstanceNotFoundException {
        if (engd.getEntiId() == null) {
            throw new Error("No se ha seleccionado una entidad");
        }

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
    @Action(value = "engd-modificar", results = { @Result(name = "success", location = "engd-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDato.class);

        engd = engdBO.select(engd.getEntiId(), engd.getNumero());

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "engd-guardar", results = {
            @Result(name = "input", location = "engd-edicion.jsp"),
            @Result(name = "success", location = "enti-detalle", type = "redirect", params = { "enti.id",
            "%{engd.entiId}" }) })
    public String guardar() throws InstanceNotFoundException {
        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDato.class);

        PropertyValidator.validateRequired(this, "engd.entiId", engd.getEntiId());
        PropertyValidator.validateRequired(this, "engd.numero", engd.getNumero());
        PropertyValidator.validateRequired(this, "engd.etiqueta", engd.getEtiqueta());

        if (hasErrors()) {
            return INPUT;
        }

        if (accion == ACCION_EDICION.alta) {
            try {
                engdBO.insert(engd);
            } catch (final DuplicateInstanceException ex) {
                // FIXME Error
                throw new Error("No implementado");
            }
        } else {
            engdBO.update(engd);
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
    @Action(value = "engd-detalle")
    public String detalle() throws InstanceNotFoundException {
        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDato.class);

        engd = engdBO.select(engd.getEntiId(), engd.getNumero());

        return SUCCESS;
    }

    // get/set
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
     * Gets the engd.
     * 
     * @return the engd
     */
    public EntidadGrupoDatoVO getEngd() {
        return engd;
    }

    /**
     * Sets the engd.
     * 
     * @param value
     *            the new engd
     */
    public void setEngd(final EntidadGrupoDatoVO value) {
        engd = value;
    }

}
