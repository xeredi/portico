package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

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
    private TipoSubservicioVO enti;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The enti padres list. */
    private List<EntidadVO> entiPadresList;

    // Acciones web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("tpss-create")
    public String create() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getTpsrId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("tpss-edit")
    public String edit() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        accion = ACCION_EDICION.edit;

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpssBO.select(enti.getId(), getIdioma());
        i18nMap = i18nBO.selectMap(I18nPrefix.enti, enti.getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("tpss-save")
    public String save() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getTpsrId());

        // Validaciones
        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, enti.getCodigo());
        } else {
            Preconditions.checkNotNull(enti.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdAlta, enti.getCmdAlta());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdBaja, enti.getCmdBaja());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdEdicion, enti.getCmdEdicion());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdDuplicado, enti.getCmdDuplicado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_temporal, enti.getTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_facturable, enti.getFacturable());

        if (hasErrors()) {
            return SUCCESS;
        }

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        if (accion == ACCION_EDICION.create) {
            enti.setCodigo(enti.getCodigo().toUpperCase());

            try {
                tpssBO.insert(enti, i18nMap);
            } catch (final DuplicateInstanceException ex) {
                addActionError(MessageI18nKey.E00005, getText(MessageI18nKey.tpss));
            }
        } else {
            try {
                tpssBO.update(enti, i18nMap);
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.tpss), String.valueOf(enti.getId()));
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     */
    @Action("tpss-remove")
    public String remove() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();

        try {
            tpssBO.delete(enti.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.tpss), String.valueOf(enti.getId()));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("tpss-detail")
    public String detail() {
        Preconditions.checkNotNull(enti);
        Preconditions.checkNotNull(enti.getId());

        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final EntidadBO entiBO = new EntidadBO();
        final I18nBO i18nBO = new I18nBO();

        enti = tpssBO.select(enti.getId(), getIdioma());
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
    public TipoSubservicioVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     *
     * @param value
     *            the new enti
     */
    public void setEnti(final TipoSubservicioVO value) {
        enti = value;
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
