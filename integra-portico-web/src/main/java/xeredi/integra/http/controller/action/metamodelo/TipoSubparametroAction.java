package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoSubparametro;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroAction.
 */
public final class TipoSubparametroAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5302381394776687182L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpsp. */
    private TipoSubparametroVO enti;

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpsp-create")
    public String alta() {
        accion = ACCION_EDICION.create;

        if (enti.getTpprId() == null) {
            throw new Error("No se ha especificado un tipo de parametro");
        }

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpsp-edit")
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.edit;

        if (enti.getId() == null) {
            throw new Error("Identificador de tipo de subparametro no especificado");
        }

        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        enti = tpspBO.select(enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("tpsp-save")
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.create) {
            PropertyValidator.validateRequired(this, "tpsp.codigo", enti.getCodigo());
            PropertyValidator.validateRequired(this, "tpsp.nombre", enti.getNombre());
        } else {
            PropertyValidator.validateRequired(this, "tpsp.id", enti.getId());
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            tpspBO.insert(enti);
        } else {
            try {
                tpspBO.update(enti);
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
    @Action("tpsp-detail")
    public String detalle() throws InstanceNotFoundException {
        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        enti = tpspBO.select(enti.getId());

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
    public TipoSubparametroVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final TipoSubparametroVO value) {
        enti = value;
    }

}
