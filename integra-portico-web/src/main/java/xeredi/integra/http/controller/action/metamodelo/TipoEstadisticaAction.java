package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoEstadistica;
import xeredi.integra.model.metamodelo.bo.TipoEstadisticaBO;
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
    private TipoEstadisticaVO enti;

    /**
     * Instantiates a new tipo estadistica action.
     */
    public TipoEstadisticaAction() {
        super();

        enti = new TipoEstadisticaVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpes-create")
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
    @Action("tpes-edit")
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.edit;

        if (enti.getId() == null) {
            throw new Error("Identificador de tipo de estadistica no especificado");
        }

        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadisticaBO.class);

        enti = tpesBO.select(enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("tpes-save")
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.edit) {
            PropertyValidator.validateRequired(this, "tpes.id", enti.getId());
        }

        PropertyValidator.validateRequired(this, "tpes.codigo", enti.getCodigo());
        PropertyValidator.validateRequired(this, "tpes.nombre", enti.getNombre());

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadisticaBO.class);

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            tpesBO.insert(enti);
        } else {
            try {
                tpesBO.update(enti);
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
    @Action("tpes-detail")
    public String detalle() throws InstanceNotFoundException {
        final TipoEstadistica tpesBO = BOFactory.getInjector().getInstance(TipoEstadisticaBO.class);

        enti = tpesBO.select(enti.getId());

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
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoEstadisticaVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final TipoEstadisticaVO value) {
        enti = value;
    }

}
