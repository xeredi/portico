package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.Entidad;
import xeredi.integra.model.bo.metamodelo.TipoDato;
import xeredi.integra.model.bo.metamodelo.TipoServicio;
import xeredi.integra.model.bo.metamodelo.TipoSubservicio;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.metamodelo.EntidadCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoServicioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAction.
 */
public final class TipoServicioAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5123740111042031938L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tpsr. */
    private TipoServicioVO tpsr;

    /** The tpss list. */
    private List<TipoSubservicioVO> tpssList;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The tpdt list. */
    private List<LabelValueVO> tpdtList;

    // Acciones Web
    /**
     * Alta.
     * 
     * @return the string
     */
    @Action(value = "tpsr-alta", results = { @Result(name = "success", location = "tpsr-edicion.jsp") })
    public String alta() {
        accion = ACCION_EDICION.alta;

        tpsr = new TipoServicioVO();

        return SUCCESS;
    }

    /**
     * Modificar.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "tpsr-modificar", results = { @Result(name = "success", location = "tpsr-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        if (tpsr.getId() == null) {
            throw new Error("Identificador de tipo de servicio no especificado");
        }

        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicio.class);

        tpsr = tpsrBO.select(tpsr.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action(value = "tpsr-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "enti-detalle", "enti.id",
            "%{tpsr.id}" }), @Result(name = "input", location = "tpsr-edicion.jsp") })
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "tpsr.codigo", tpsr.getCodigo());
            PropertyValidator.validateRequired(this, "tpsr.nombre", tpsr.getNombre());
        } else {
            PropertyValidator.validateRequired(this, "tpsr.id", tpsr.getId());
        }

        if (hasErrors()) {
            return INPUT;
        }

        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicio.class);

        if (accion == ACCION_EDICION.alta) {
            tpsr.setCodigo(tpsr.getCodigo().toUpperCase());

            tpsrBO.insert(tpsr);
        } else {
            try {
                tpsrBO.update(tpsr);
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
    @Action(value = "tpsr-detalle")
    public String detalle() throws InstanceNotFoundException {
        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicio.class);
        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicio.class);
        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        tpsr = tpsrBO.select(tpsr.getId());

        TipoSubservicioCriterioVO tpssCriterioVO = null;

        tpssCriterioVO = new TipoSubservicioCriterioVO();
        tpssCriterioVO.setTpsrId(tpsr.getId());
        tpssList = tpssBO.selectList(tpssCriterioVO);

        if (tpsr.getEntiHijasList() != null && !tpsr.getEntiHijasList().isEmpty()) {
            EntidadCriterioVO entiCriterioVO = null;

            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(tpsr.getId());

            entiHijasList = entiBO.selectList(entiCriterioVO);
        }

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the tpsr form.
     * 
     * @return the tpsr form
     */
    public TipoServicioVO getTpsr() {
        return tpsr;
    }

    /**
     * Sets the tpsr form.
     * 
     * @param value
     *            the new tpsr form
     */
    public void setTpsr(final TipoServicioVO value) {
        tpsr = value;
    }

    /**
     * Gets the tpss list.
     * 
     * @return the tpss list
     */
    public List<TipoSubservicioVO> getTpssList() {
        return tpssList;
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
     * @param accion
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION accion) {
        this.accion = accion;
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
