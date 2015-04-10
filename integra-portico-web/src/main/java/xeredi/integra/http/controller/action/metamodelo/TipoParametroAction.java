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
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroAction.
 */
public final class TipoParametroAction extends ItemAction implements ModelDriven<TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2717067151021279223L;

    /** The tppr. */
    private TipoParametroVO model;

    /** The tpsp list. */
    private List<TipoSubparametroVO> subentiList;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The tpdt nombre list. */
    private List<LabelValueVO> tpdtNombreList;

    // Acciones Web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tppr-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final TipoParametroBO tpprBO = new TipoParametroBO();

            model = tpprBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());
        } else {
            model = new TipoParametroVO();
        }

        {
            final TipoDatoBO tpdtBO = new TipoDatoBO();
            final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

            tpdtCriterio.setTipoElemento(TipoElemento.TX);
            tpdtCriterio.setIdioma(getIdioma());

            tpdtNombreList = tpdtBO.selectLabelValues(tpdtCriterio);
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tppr-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (model == null) {
            model = new TipoParametroVO();
        }

        // Validaciones
        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enti_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdAlta, model.isCmdAlta());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdBaja, model.isCmdBaja());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdEdicion, model.isCmdEdicion());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_cmdDuplicado, model.isCmdDuplicado());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_i18n, model.isI18n());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_tempExp, model.isTempExp());

        if (!hasErrors()) {
            final TipoParametroBO tpprBO = new TipoParametroBO();

            switch (getAccion()) {
            case create:
                model.setCodigo(model.getCodigo().toUpperCase());
                tpprBO.insert(model, i18nMap);

                break;
            case edit:
                tpprBO.update(model, i18nMap);

                break;
            default:
                throw new Error("Accion no soportada: " + getAccion());
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
    @Action("tppr-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoParametroBO tpprBO = new TipoParametroBO();

        tpprBO.delete(model.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tppr-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoParametroBO tpprBO = new TipoParametroBO();
        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        model = tpprBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());

        final TipoSubparametroCriterioVO entiCriterioVO = new TipoSubparametroCriterioVO();

        entiCriterioVO.setTpprId(model.getId());
        entiCriterioVO.setIdioma(getIdioma());

        subentiList = tpspBO.selectList(entiCriterioVO);

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the subenti list.
     *
     * @return the subenti list
     */
    public List<TipoSubparametroVO> getSubentiList() {
        return subentiList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TipoParametroVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoParametroVO value) {
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
     * Gets the tpdt nombre list.
     *
     * @return the tpdt nombre list
     */
    public List<LabelValueVO> getTpdtNombreList() {
        return tpdtNombreList;
    }

}
