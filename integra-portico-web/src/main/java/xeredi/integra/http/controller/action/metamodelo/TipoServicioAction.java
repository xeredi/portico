package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoDato;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoServicio;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicio;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
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
    private TipoServicioVO enti;

    /** The tpss list. */
    private List<TipoSubservicioVO> subentiList;

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
    @Action("tpsr-alta")
    public String alta() {
        accion = ACCION_EDICION.alta;

        enti = new TipoServicioVO();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tpsr-modificar")
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        if (enti.getId() == null) {
            throw new Error("Identificador de tipo de servicio no especificado");
        }

        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicioBO.class);

        enti = tpsrBO.select(enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("tpsr-guardar")
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "tpsr.codigo", enti.getCodigo());
            PropertyValidator.validateRequired(this, "tpsr.nombre", enti.getNombre());
        } else {
            PropertyValidator.validateRequired(this, "tpsr.id", enti.getId());
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicioBO.class);

        if (accion == ACCION_EDICION.alta) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            tpsrBO.insert(enti);
        } else {
            try {
                tpsrBO.update(enti);
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
    @Action("tpsr-detalle")
    public String detalle() throws InstanceNotFoundException {
        final TipoServicio tpsrBO = BOFactory.getInjector().getInstance(TipoServicioBO.class);
        final TipoSubservicio tpssBO = BOFactory.getInjector().getInstance(TipoSubservicioBO.class);
        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);

        enti = tpsrBO.select(enti.getId());

        TipoSubservicioCriterioVO tpssCriterioVO = null;

        tpssCriterioVO = new TipoSubservicioCriterioVO();
        tpssCriterioVO.setTpsrId(enti.getId());
        subentiList = tpssBO.selectList(tpssCriterioVO);

        if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
            EntidadCriterioVO entiCriterioVO = null;

            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(enti.getId());

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
    public TipoServicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the tpsr form.
     *
     * @param value
     *            the new tpsr form
     */
    public void setEnti(final TipoServicioVO value) {
        enti = value;
    }

    /**
     * Gets the tpss list.
     *
     * @return the tpss list
     */
    public List<TipoSubservicioVO> getSubentiList() {
        return subentiList;
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
            final TipoDato tpdtBO = BOFactory.getInjector().getInstance(TipoDatoBO.class);

            tpdtList = tpdtBO.selectLabelValues();
        }

        return tpdtList;
    }

}
