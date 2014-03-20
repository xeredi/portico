package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.Entidad;
import xeredi.integra.model.bo.metamodelo.TipoParametro;
import xeredi.integra.model.bo.metamodelo.TipoSubparametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.integra.model.vo.metamodelo.EntidadCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubparametroVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroAction.
 */
public final class TipoParametroAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2717067151021279223L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tppr. */
    private TipoParametroVO tppr;

    /** The tpsp list. */
    private List<TipoSubparametroVO> tpspList;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The enti padres list. */
    private List<EntidadVO> entiPadresList;

    /**
     * Instantiates a new tipo parametro action.
     */
    public TipoParametroAction() {
        super();

        tppr = new TipoParametroVO();
    }

    // Acciones Web
    /**
     * Alta.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "tppr-alta", results = { @Result(name = "success", location = "tppr-edicion.jsp") })
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
    @Action(value = "tppr-modificar", results = { @Result(name = "success", location = "tppr-edicion.jsp") })
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        if (tppr.getId() == null) {
            throw new Error("Identificador de tipo de parametro no especificado");
        }

        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametro.class);
        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        tppr = tpprBO.select(tppr.getId());

        EntidadCriterioVO entiCriterioVO = null;

        if (tppr.getEntiPadresList() != null && !tppr.getEntiPadresList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiHijaId(tppr.getId());

            entiPadresList = entiBO.selectList(entiCriterioVO);
        }

        if (tppr.getEntiHijasList() != null && !tppr.getEntiHijasList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(tppr.getId());

            entiHijasList = entiBO.selectList(entiCriterioVO);
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     * 
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action(value = "tppr-guardar", results = {
            @Result(name = "success", type = "redirectAction", params = { "actionName", "enti-detalle", "enti.id",
            "%{tppr.id}" }), @Result(name = "input", location = "tppr-edicion.jsp") })
    public String guardar() throws DuplicateInstanceException {
        // Validaciones
        if (accion == ACCION_EDICION.alta) {
            PropertyValidator.validateRequired(this, "tppr.codigo", tppr.getCodigo());
            PropertyValidator.validateRequired(this, "tppr.nombre", tppr.getNombre());
        } else {
            PropertyValidator.validateRequired(this, "tppr.id", tppr.getId());
        }

        if (hasErrors()) {
            return INPUT;
        }

        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametro.class);

        if (accion == ACCION_EDICION.alta) {
            tppr.setCodigo(tppr.getCodigo().toUpperCase());

            tpprBO.insert(tppr);
        } else {
            try {
                tpprBO.update(tppr);
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
    @Action(value = "tppr-detalle")
    public String detalle() throws InstanceNotFoundException {
        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametro.class);
        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametro.class);

        tppr = tpprBO.select(tppr.getId());

        final TipoSubparametroCriterioVO tpspCriterioVO = new TipoSubparametroCriterioVO();

        tpspCriterioVO.setTpprId(tppr.getId());

        tpspList = tpspBO.selectList(tpspCriterioVO);

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
     * Gets the tppr.
     * 
     * @return the tppr
     */
    public TipoParametroVO getTppr() {
        return tppr;
    }

    /**
     * Sets the tppr.
     * 
     * @param value
     *            the new tppr
     */
    public void setTppr(final TipoParametroVO value) {
        tppr = value;
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
     * Gets the tpsp list.
     * 
     * @return the tpsp list
     */
    public List<TipoSubparametroVO> getTpspList() {
        return tpspList;
    }

}
