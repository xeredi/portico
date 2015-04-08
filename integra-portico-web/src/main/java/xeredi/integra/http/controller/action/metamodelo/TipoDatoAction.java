package xeredi.integra.http.controller.action.metamodelo;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.metamodelo.vo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoAction.
 */
public final class TipoDatoAction extends BaseAction implements ModelDriven<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7405460701196255597L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The tppr. */
    private TipoDatoVO model;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The cdrf list. */
    private List<CodigoReferenciaVO> cdrfList;

    /** The tppr list. */
    private List<LabelValueVO> tpprList;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

    // Acciones Web
    /**
     * Editar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpdt-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final TipoDatoBO tpdtBO = new TipoDatoBO();

            model = tpdtBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.tpdt, model.getId());
        } else {
            model = new TipoDatoVO();
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
    @Action("tpdt-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);

        if (model == null) {
            model = new TipoDatoVO();
        }

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.tpdt_codigo, model.getCodigo());
        } else {
            Preconditions.checkNotNull(model.getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.tpdt_tpht, model.getTpht());
        FieldValidator.validateRequired(this, MessageI18nKey.tpdt_tpel, model.getTipoElemento());

        if (FieldValidator.isInList(model.getTipoElemento(), TipoElemento.PR, TipoElemento.SR)) {
            FieldValidator.validateRequired(this, MessageI18nKey.tpdt_enti, model.getEnti());
        }

        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final TipoDatoBO tpdtBO = new TipoDatoBO();

            switch (accion) {
            case create:
                tpdtBO.insert(model, i18nMap);

                break;
            case edit:
                tpdtBO.update(model, i18nMap);

                break;
            default:
                throw new Error("Accion no soportada: " + accion);
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
    @Action("tpdt-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdtBO.delete(model);

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpdt-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();
        final CodigoReferenciaBO cdrfBO = new CodigoReferenciaBO();

        model = tpdtBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.tpdt, model.getId());
        cdrfList = cdrfBO.selectList(model.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Load label values.
     */
    private void loadLabelValues() {
        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setIdioma(getIdioma());

        {
            entiCriterioVO.setTipo(TipoEntidad.P);
            tpprList = entiBO.selectLabelValues(entiCriterioVO);
        }

        {
            entiCriterioVO.setTipo(TipoEntidad.T);
            tpsrList = entiBO.selectLabelValues(entiCriterioVO);
        }
    }

    // get / set

    /**
     * Gets the tppr list.
     *
     * @return the tppr list
     */
    public List<LabelValueVO> getTpprList() {
        return tpprList;
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

    /**
     * Gets the tphts.
     *
     * @return the tphts
     */
    public TipoHtml[] getTphtList() {
        return TipoHtml.values();
    }

    /**
     * Gets the tipos elemento.
     *
     * @return the tipos elemento
     */
    public TipoElemento[] getTpelList() {
        return TipoElemento.values();
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
     * {@inheritDoc}
     */
    @Override
    public TipoDatoVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoDatoVO value) {
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
     * Gets the cdrf list.
     *
     * @return the cdrf list
     */
    public List<CodigoReferenciaVO> getCdrfList() {
        return cdrfList;
    }

}
