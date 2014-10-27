package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.I18nValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
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

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

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
     */
    @Action("tppr-create")
    public String create() {
        accion = ACCION_EDICION.create;

        enti = new TipoParametroVO();

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tppr-edit")
    public String edit() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        final TipoParametroBO tpprBO = new TipoParametroBO();
        final EntidadBO entiBO = new EntidadBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpprBO.select(enti.getId(), getIdioma());

        if (enti != null) {
            i18nMap = i18nBO.selectMap(I18nPrefix.enti, enti.getId());

            EntidadCriterioVO entiCriterioVO = null;

            if (enti.getEntiPadresList() != null && !enti.getEntiPadresList().isEmpty()) {
                entiCriterioVO = new EntidadCriterioVO();
                entiCriterioVO.setEntiHijaId(enti.getId());
                entiCriterioVO.setIdioma(getIdioma());

                entiPadresList = entiBO.selectList(entiCriterioVO);
            }

            if (enti.getEntiHijasList() != null && !enti.getEntiHijasList().isEmpty()) {
                entiCriterioVO = new EntidadCriterioVO();
                entiCriterioVO.setEntiPadreId(enti.getId());
                entiCriterioVO.setIdioma(getIdioma());

                entiHijasList = entiBO.selectList(entiCriterioVO);
            }
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tppr-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enti);

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            if (enti.getCodigo() == null || enti.getCodigo().isEmpty()) {
                addActionError(getText(MessageI18nKey.E00001.name(),
                        new String[] { getText(MessageI18nKey.enti_codigo.name()) }));
            }
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        I18nValidator.validate(this, i18nMap);

        if (enti.getCmdAlta() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdAlta.name()) }));
        }
        if (enti.getCmdBaja() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdBaja.name()) }));
        }
        if (enti.getCmdEdicion() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdEdicion.name()) }));
        }
        if (enti.getCmdDuplicado() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_cmdDuplicado.name()) }));
        }
        if (enti.getI18n() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_i18n.name()) }));
        }
        if (enti.getTempExp() == null) {
            addActionError(getText(MessageI18nKey.E00001.name(),
                    new String[] { getText(MessageI18nKey.enti_tempExp.name()) }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoParametroBO tpprBO = new TipoParametroBO();

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            try {
                tpprBO.insert(enti, i18nMap);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(MessageI18nKey.E00005.name(),
                        new String[] { getText(MessageI18nKey.tppr.name()) }));
            }
        } else {
            try {
                tpprBO.update(enti, i18nMap);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(MessageI18nKey.E00008.name(), new String[] {
                    getText(MessageI18nKey.tppr.name()), String.valueOf(enti.getId()) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tppr-remove")
    public String remove() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoParametroBO tpprBO = new TipoParametroBO();

        try {
            tpprBO.delete(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(MessageI18nKey.E00008.name(), new String[] { getText(MessageI18nKey.tppr.name()),
                String.valueOf(enti.getId()) }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tppr-detail")
    public String detail() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoParametroBO tpprBO = new TipoParametroBO();
        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpprBO.select(enti.getId(), getIdioma());

        if (enti != null) {
            i18nMap = i18nBO.selectMap(I18nPrefix.enti, enti.getId());

            final TipoSubparametroCriterioVO entiCriterioVO = new TipoSubparametroCriterioVO();

            entiCriterioVO.setTpprId(enti.getId());
            entiCriterioVO.setIdioma(getIdioma());

            subentiList = tpspBO.selectList(entiCriterioVO);
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

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }

}
