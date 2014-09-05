package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.Entidad;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoParametro;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.bo.TipoSubparametro;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

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
    private TipoParametroVO enti;

    /** The tpsp list. */
    private List<TipoSubparametroVO> subentiList;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The enti padres list. */
    private List<EntidadVO> entiPadresList;

    /**
     * Instantiates a new tipo parametro action.
     */
    public TipoParametroAction() {
        super();

        enti = new TipoParametroVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("tppr-create")
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
    @Action("tppr-edit")
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.edit;

        if (enti.getId() == null) {
            throw new Error("Identificador de tipo de parametro no especificado");
        }

        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametroBO.class);
        final Entidad entiBO = BOFactory.getInjector().getInstance(EntidadBO.class);

        enti = tpprBO.select(enti.getId());

        EntidadCriterioVO entiCriterioVO = null;

        if (enti.getEntiPadresList() != null && !enti.getEntiPadresList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiHijaId(enti.getId());

            entiPadresList = entiBO.selectList(entiCriterioVO);
        }

        if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
            entiCriterioVO = new EntidadCriterioVO();
            entiCriterioVO.setEntiPadreId(enti.getId());

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
    @Action("tppr-save")
    public String guardar() throws DuplicateInstanceException {
        Preconditions.checkNotNull(enti);

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            if (enti.getCodigo() == null || enti.getCodigo().isEmpty()) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { "enti_codigo" }));
            }
            if (enti.getNombre() == null || enti.getNombre().isEmpty()) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { "enti_nombre" }));
            }
        } else {
            if (enti.getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { "enti_id" }));
            }
        }

        // if (enti.isCmdAlta() == null || enti.getCodigo().isEmpty()) {
        // addActionError(getText(ErrorCode.E00001.name(), new String[] { "enti_codigo" }));
        // }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametroBO.class);

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            tpprBO.insert(enti);
        } else {
            try {
                tpprBO.update(enti);
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
    @Action("tppr-detail")
    public String detalle() throws InstanceNotFoundException {
        final TipoParametro tpprBO = BOFactory.getInjector().getInstance(TipoParametroBO.class);
        final TipoSubparametro tpspBO = BOFactory.getInjector().getInstance(TipoSubparametroBO.class);

        enti = tpprBO.select(enti.getId());

        final TipoSubparametroCriterioVO tpspCriterioVO = new TipoSubparametroCriterioVO();

        tpspCriterioVO.setTpprId(enti.getId());

        subentiList = tpspBO.selectList(tpspCriterioVO);

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
     * Gets the subenti list.
     *
     * @return the subenti list
     */
    public List<TipoSubparametroVO> getSubentiList() {
        return subentiList;
    }

    /**
     * Gets the enti.
     *
     * @return the enti
     */
    public TipoParametroVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the enti
     */
    public void setEnti(final TipoParametroVO value) {
        enti = value;
    }

}
