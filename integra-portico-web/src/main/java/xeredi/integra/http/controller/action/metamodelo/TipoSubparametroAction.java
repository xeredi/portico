package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.TipoParametro;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.bo.TipoSubparametro;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
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
    private TipoSubparametroVO tpsp;

    /** The tpprs. */
    private List<LabelValueVO> tpprs;

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action(value = "tpsp-alta", results = { @Result(name = "success", location = "tpsp-edicion.jsp") })
    public String alta() {
        accion = ACCION_EDICION.alta;

        if (tpsp.getTpprId() == null) {
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
    @Action(value = "tpsp-modificar", results = { @Result(name = "success", location = "tpsp-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        if (tpsp.getId() == null) {
            throw new Error("Identificador de tipo de subparametro no especificado");
        }

        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        tpsp = tpspBO.select(tpsp.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action(value = "tpsp-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "enti-detalle", "enti.id",
                    "%{tpsp.tppr.id}" }), @Result(name = "input", location = "tpsp-edicion.jsp") })
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "tpsp.codigo", tpsp.getCodigo());
            PropertyValidator.validateRequired(this, "tpsp.nombre", tpsp.getNombre());
        } else {
            PropertyValidator.validateRequired(this, "tpsp.id", tpsp.getId());
        }

        if (hasErrors()) {
            return INPUT;
        }

        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        if (accion == ACCION_EDICION.alta) {
            tpsp.setCodigo(tpsp.getCodigo().toUpperCase());

            tpspBO.insert(tpsp);
        } else {
            try {
                tpspBO.update(tpsp);
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
    @Action(value = "tpsp-detalle")
    public String detalle() throws InstanceNotFoundException {
        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        tpsp = tpspBO.select(tpsp.getId());

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
     * Gets the tpsp.
     *
     * @return the tpsp
     */
    public TipoSubparametroVO getTpsp() {
        return tpsp;
    }

    /**
     * Sets the tpsp.
     *
     * @param value
     *            the new tpsp
     */
    public void setTpsp(final TipoSubparametroVO value) {
        tpsp = value;
    }

    /**
     * Gets the tpprs.
     *
     * @return the tpprs
     */
    public List<LabelValueVO> getTpprs() {
        if (tpprs == null) {
            final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametroBO.class);

            tpprs = tpprBO.selectLabelValues();
        }

        return tpprs;
    }

}
