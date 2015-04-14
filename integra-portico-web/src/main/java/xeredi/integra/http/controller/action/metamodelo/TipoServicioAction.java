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
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.bo.TipoServicioBO;
import xeredi.integra.model.metamodelo.bo.TipoSubservicioBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadTipoDatoVO;
import xeredi.integra.model.metamodelo.vo.EntidadVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoElemento;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioAction.
 */
public final class TipoServicioAction extends ItemAction implements ModelDriven<TipoServicioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5123740111042031938L;

    /** The tpsr. */
    private TipoServicioVO model;

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

    /** The tpss list. */
    private List<TipoSubservicioVO> subentiList;

    /** The enti hijas list. */
    private List<EntidadVO> entiHijasList;

    /** The tpdt estado list. */
    private List<LabelValueVO> tpdtEstadoList;

    // Acciones Web
    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsr-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final TipoServicioBO tpsrBO = new TipoServicioBO();

            model = tpsrBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());
        } else {
            model = new TipoServicioVO();
        }

        {
            final TipoDatoBO tpdtBO = new TipoDatoBO();
            final TipoDatoCriterioVO tpdtCriterio = new TipoDatoCriterioVO();

            tpdtCriterio.setTipoElemento(TipoElemento.CR);
            tpdtCriterio.setIdioma(getIdioma());

            tpdtEstadoList = tpdtBO.selectLabelValues(tpdtCriterio);
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
    @Action("tpsr-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (model == null) {
            model = new TipoServicioVO();
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
        FieldValidator.validateRequired(this, MessageI18nKey.enti_temporal, model.isTemporal());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_exencionable, model.isExencionable());
        FieldValidator.validateRequired(this, MessageI18nKey.enti_facturable, model.isFacturable());

        if (!hasErrors()) {
            final TipoServicioBO tpsrBO = new TipoServicioBO();

            switch (getAccion()) {
            case create:
                model.setCodigo(model.getCodigo().toUpperCase());
                tpsrBO.insert(model, i18nMap);

                break;
            case edit:
                tpsrBO.update(model, i18nMap);

                break;
            default:
                throw new Error(getAccion() + " noimplementado");
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
    @Action("tpsr-remove")
    public String remove() throws ApplicationException {
        final TipoServicioBO tpsrBO = new TipoServicioBO();

        tpsrBO.delete(model.getId());

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("tpsr-detail")
    public String detail() throws ApplicationException {
        final TipoServicioBO tpsrBO = new TipoServicioBO();
        final TipoSubservicioBO tpssBO = new TipoSubservicioBO();
        final EntidadBO entiBO = new EntidadBO();

        model = tpsrBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enti, model.getId());

        {
            TipoSubservicioCriterioVO tpssCriterioVO = null;

            tpssCriterioVO = new TipoSubservicioCriterioVO();
            tpssCriterioVO.setTpsrId(model.getId());
            tpssCriterioVO.setIdioma(getIdioma());

            subentiList = tpssBO.selectList(tpssCriterioVO);
        }

        if (subentiList != null && !subentiList.isEmpty()) {
            final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

            entiCriterioVO.setEntiPadreId(model.getId());
            entiCriterioVO.setIdioma(getIdioma());

            entiHijasList = entiBO.selectList(entiCriterioVO);
        }

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

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public TipoServicioVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public void setModel(final TipoServicioVO value) {
        model = value;
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
     * Gets the enti hijas list.
     *
     * @return the enti hijas list
     */
    public List<EntidadVO> getEntiHijasList() {
        return entiHijasList;
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
     * Gets the tpdt estado list.
     *
     * @return the tpdt estado list
     */
    public List<LabelValueVO> getTpdtEstadoList() {
        return tpdtEstadoList;
    }

    public List<EntidadTipoDatoVO> getEntdList() {
        return entdList;
    }

    public List<EntidadGrupoDatoVO> getEngdList() {
        return engdList;
    }

    public List<EntidadAccionVO> getEnacList() {
        return enacList;
    }

    public List<EntidadAccionGridVO> getEnagList() {
        return enagList;
    }

}
