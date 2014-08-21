package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.TipoDato;
import xeredi.integra.model.metamodelo.bo.TipoSubservicio;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioAction.
 */
public final class TipoSubservicioAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1943908334114266376L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpss form. */
    private TipoSubservicioVO tpss;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The enti padres list. */
    private List<EntidadVO> entiPadresList;

    /** The tpdt list. */
    private List<LabelValueVO> tpdtList;

    // Acciones web
    /**
     * Alta.
     * 
     * @return the string
     */
    @Action(value = "tpss-alta", results = { @Result(name = "success", location = "tpss-edicion.jsp") })
    public String alta() {
        accion = ACCION_EDICION.alta;

        if (tpss == null || tpss.getTpsr() == null || tpss.getTpsr().getId() == null) {
            throw new Error("Especifique un tipo de servicio para poder crear un tipo de subservicio");
        }

        tpss = new TipoSubservicioVO();

        return SUCCESS;
    }

    /**
     * Modificar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "tpss-modificar", results = { @Result(name = "success", location = "tpss-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        if (tpss.getId() == null) {
            throw new Error("Identificador de tipo de subservicio no especificado");
        }

        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicio.class);

        tpss = tpssBO.select(tpss.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action(value = "tpss-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "enti-detalle", "enti.id",
            "%{tpss.id}" }), @Result(name = "input", location = "tpss-edicion.jsp") })
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "tpss.codigo", tpss.getCodigo());
            PropertyValidator.validateRequired(this, "tpss.nombre", tpss.getNombre());
        } else {
            PropertyValidator.validateRequired(this, "tpss.id", tpss.getId());
        }

        PropertyValidator.validateRequired(this, "tpss.tpsr.id", tpss.getTpsr().getId());

        if (hasErrors()) {
            return INPUT;
        }

        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicio.class);

        if (accion == ACCION_EDICION.alta) {
            tpss.setCodigo(tpss.getCodigo().toUpperCase());

            tpssBO.insert(tpss);
        } else {
            try {
                tpssBO.update(tpss);
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
     */
    @Action("tpss-detalle")
    public String detalle() {
        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicio.class);
        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        tpss = tpssBO.select(tpss.getId());

        EntidadCriterioVO entiCriterioVO = null;

        if (tpss.getEntiPadresList() != null && !tpss.getEntiPadresList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiHijaId(tpss.getId());

            entiPadresList = entiBO.selectList(entiCriterioVO);
        }

        if (tpss.getEntiHijasList() != null && !tpss.getEntiHijasList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(tpss.getId());

            entiHijasList = entiBO.selectList(entiCriterioVO);
        }

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
     * @param accion
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION accion) {
        this.accion = accion;
    }

    /**
     * Gets the tpss.
     * 
     * @return the tpss
     */
    public TipoSubservicioVO getTpss() {
        return tpss;
    }

    /**
     * Sets the tpss.
     * 
     * @param value
     *            the new tpss
     */
    public void setTpss(final TipoSubservicioVO value) {
        tpss = value;
    }

    /**
     * Gets the enti hijas list.
     * 
     * @return the enti hijas list
     */
    public List<EntidadVO> getEntiHijasList() {
        return entiHijasList;
    }

    /**
     * Gets the enti padres list.
     * 
     * @return the enti padres list
     */
    public List<EntidadVO> getEntiPadresList() {
        return entiPadresList;
    }

    /**
     * Gets the tpdt list.
     * 
     * @return the tpdt list
     */
    public List<LabelValueVO> getTpdtList() {
        if (tpdtList == null || tpdtList.isEmpty()) {
            final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDato.class);

            tpdtList = tpdtBO.selectLabelValues();
        }

        return tpdtList;
    }

}
