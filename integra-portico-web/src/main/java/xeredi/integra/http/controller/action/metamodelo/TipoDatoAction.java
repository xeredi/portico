package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoDato;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
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
    @Action("tpdt-create")
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
    @Action("tpdt-edit")
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDatoBO.class);

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
    @Action("tpdt-save")
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
            return SUCCESS;
        }

        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDatoBO.class);

        if (accion == ACCION_EDICION.alta) {
            try {
                tpdtBO.insert(tpdt);
            } catch (final DuplicateInstanceException ex) {
                addFieldError("tpdt.nombre", getText("error.tpdt.duplicate"));
            }
        } else {
            tpdtBO.update(tpdt);
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Actions({ @Action("tpdt-detail") })
    public String detalle() {
        final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDatoBO.class);

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
