package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionBO;
import xeredi.integra.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroAction.
 */
public final class TipoSubparametroAction extends ItemAction implements ModelDriven<TipoSubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5302381394776687182L;

    /** The tpsp. */
    private TipoSubparametroVO model;

    /** The entd list. */
    private List<EntidadTipoDatoVO> entdList;

    /** The engd list. */
    private List<EntidadGrupoDatoVO> engdList;

    /** The enac list. */
    private List<EntidadAccionVO> enacList;

    /** The enag list. */
    private List<EntidadAccionGridVO> enagList;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The tppr list. */
    private List<LabelValueVO> tpprList;

    // Acciones Web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsp-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpprId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

            model = tpspBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());
        }

        loadLabelValues();

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsp-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getTpprId());

        // Validaciones
        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.enti_tpprAsociado, model.getTpprAsociado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdAlta, model.isCmdAlta());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdBaja, model.isCmdBaja());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdEdicion, model.isCmdEdicion());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdDuplicado, model.isCmdDuplicado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, model.isI18n());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, model.isTempExp());

        if (!hasErrors()) {
            final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

            switch (getAccion()) {
            case create:
                model.setCodigo(model.getCodigo().toUpperCase());
                tpspBO.insert(model, i18nMap);

                break;
            case edit:
                tpspBO.update(model, i18nMap);

                break;
            default:
                throw new Error("accion no soportada: " + getAccion());
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsp-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        tpspBO.delete(model.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsp-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        model = tpspBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();
        final EntidadTipoDatoCriterioVO entdCriterio = new EntidadTipoDatoCriterioVO();

        entdCriterio.setEntiId(model.getId());
        entdCriterio.setIdioma(getIdioma());

        entdList = entdBO.selectList(entdCriterio);

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();
        final EntidadGrupoDatoCriterioVO engdCriterio = new EntidadGrupoDatoCriterioVO();

        engdCriterio.setEntiId(model.getId());
        engdCriterio.setIdioma(getIdioma());

        engdList = engdBO.selectList(engdCriterio);

        final EntidadAccionBO enacBO = new EntidadAccionBO();
        final EntidadAccionCriterioVO enacCriterio = new EntidadAccionCriterioVO();

        enacCriterio.setEntiId(model.getId());
        enacCriterio.setIdioma(getIdioma());

        enacList = enacBO.selectList(enacCriterio);

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();
        final EntidadAccionGridCriterioVO enagCriterio = new EntidadAccionGridCriterioVO();

        enagCriterio.setEntiId(model.getId());
        enagCriterio.setIdioma(getIdioma());

        enagList = enagBO.selectList(enagCriterio);

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setTipo(TipoEntidad.P);
        entiCriterioVO.setIdioma(getIdioma());

        tpprList = entiBO.selectLabelValues(entiCriterioVO);
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public TipoSubparametroVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoSubparametroVO value) {
        model = value;
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

    /**
     * Gets the tppr list.
     *
     * @return the tppr list
     */
    public List<LabelValueVO> getTpprList() {
        return tpprList;
    }

    /**
     * Gets the entd list.
     *
     * @return the entd list
     */
    public List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

    /**
     * Gets the engd list.
     *
     * @return the engd list
     */
    public List<EntidadGrupoDatoVO> getEngdList() {
        return engdList;
    }

    /**
     * Gets the enac list.
     *
     * @return the enac list
     */
    public List<EntidadAccionVO> getEnacList() {
        return enacList;
    }

    /**
     * Gets the enag list.
     *
     * @return the enag list
     */
    public List<EntidadAccionGridVO> getEnagList() {
        return enagList;
    }

}
