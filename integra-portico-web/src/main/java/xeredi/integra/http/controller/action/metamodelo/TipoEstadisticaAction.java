package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoEstadistica;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaAction.
 */
public final class TipoEstadisticaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3174617805403065108L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpes form. */
    private TipoEstadisticaVO tpes;

    /**
     * Instantiates a new tipo estadistica action.
     */
    public TipoEstadisticaAction() {
        super();

        tpes = new TipoEstadisticaVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "tpes-alta", results = { @Result(name = "success", location = "tpes-edicion.jsp") })
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
    @Action(value = "tpes-modificar", results = { @Result(name = "success", location = "tpes-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        if (tpes.getId() == null) {
            throw new Error("Identificador de tipo de estadistica no especificado");
        }

        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadistica.class);

        tpes = tpesBO.select(tpes.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action(value = "tpes-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "enti-detalle", "enti.id",
            "%{tpes.id}" }), @Result(name = "input", location = "tpes-edicion.jsp") })
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.modificar) {
            PropertyValidator.validateRequired(this, "tpes.id", tpes.getId());
        }

        PropertyValidator.validateRequired(this, "tpes.codigo", tpes.getCodigo());
        PropertyValidator.validateRequired(this, "tpes.nombre", tpes.getNombre());

        if (hasErrors()) {
            return INPUT;
        }

        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadistica.class);

        if (accion == ACCION_EDICION.alta) {
            tpes.setCodigo(tpes.getCodigo().toUpperCase());

            tpesBO.insert(tpes);
        } else {
            try {
                tpesBO.update(tpes);
            } catch (final InstanceNotFoundException ex) {
                throw new Error(ex);
            }
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
    @Action(value = "tpes-detalle")
    public String detalle() throws InstanceNotFoundException {
        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadistica.class);

        tpes = tpesBO.select(tpes.getId());

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
     * Gets the tpes.
     *
     * @return the tpes
     */
    public TipoEstadisticaVO getTpes() {
        return tpes;
    }

    /**
     * Sets the tpes.
     *
     * @param value
     *            the new tpes
     */
    public void setTpes(final TipoEstadisticaVO value) {
        tpes = value;
    }

}
