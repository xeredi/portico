package xeredi.integra.http.controller.action.metamodelo;

import java.util.ArrayList;
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
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.bo.EntidadTipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadTipoDatoAction.
 */
public final class EntidadTipoDatoAction extends ItemAction implements ModelDriven<EntidadTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -9005055738040850443L;

    /** The entd form. */
    private EntidadTipoDatoVO model;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The engd list. */
    private final List<LabelValueVO> engdList = new ArrayList<>();

    /** The tpdt list. */
    private final List<LabelValueVO> tpdtList = new ArrayList<>();

    // Acciones Web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("entd-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getTpdt());
            Preconditions.checkNotNull(model.getTpdt().getId());

            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            model = entdBO.select(model.getEntiId(), model.getTpdt().getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.entd, model.getId());
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
    @Action("entd-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (getAccion() == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.entd_tpdt, model.getTpdt());
        } else {
            Preconditions.checkNotNull(model.getTpdt());
            Preconditions.checkNotNull(model.getTpdt().getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.entd_grupo, model.getGrupo());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_fila, model.getFila());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_orden, model.getOrden());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_span, model.getSpan());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_spanLg, model.getSpanLg());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_obligatorio, model.getObligatorio());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_gridable, model.getGridable());
        FieldValidator.validateRequired(this, MessageI18nKey.entd_filtrable, model.getFiltrable());

        if (!hasErrors()) {
            final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

            switch (getAccion()) {
            case create:
                entdBO.insert(model, i18nMap);

                break;
            case edit:
                entdBO.update(model, i18nMap);

                break;
            default:
                throw new Error("Accion no contemplada: " + getAccion());
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
    @Action("entd-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        entdBO.delete(model);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("entd-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getTpdt());
        Preconditions.checkNotNull(model.getTpdt().getId());

        final EntidadTipoDatoBO entdBO = new EntidadTipoDatoBO();

        model = entdBO.select(model.getEntiId(), model.getTpdt().getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.entd, model.getId());

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        engdList.addAll(engdBO.selectLabelValues(model.getEntiId(), getIdioma()));

        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final TipoDatoCriterioVO tpdtCriterioVO = new TipoDatoCriterioVO();

        tpdtCriterioVO.setIdioma(getIdioma());

        tpdtList.addAll(tpdtBO.selectLabelValues(tpdtCriterioVO));
    }

    // get/set

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
     * Gets the engd list.
     *
     * @return the engd list
     */
    public List<LabelValueVO> getEngdList() {
        return engdList;
    }

    /**
     * Gets the tpdt list.
     *
     * @return the tpdt list
     */
    public List<LabelValueVO> getTpdtList() {
        return tpdtList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntidadTipoDatoVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final EntidadTipoDatoVO value) {
        model = value;
    }

}
