package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.bo.AspectoCargoBO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.AspectoVersionVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoAction.
 */
public final class AspectoAction extends ItemAction implements ModelDriven<AspectoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4939833753699919759L;

    /** The aspc. */
    private AspectoVO model;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The ascr list. */
    private List<AspectoCargoVO> ascrList;

    /** The enti list. */
    private List<LabelValueVO> tpsrList;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("aspc-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        if (getFechaVigencia() == null) {
            setFechaVigencia(Calendar.getInstance().getTime());
        }

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

        aspcCriterio.setId(model.getId());
        aspcCriterio.setFechaVigencia(getFechaVigencia());
        aspcCriterio.setIdioma(getIdioma());

        model = aspcBO.selectObject(aspcCriterio);
        i18nMap = I18nBO.selectMap(I18nPrefix.aspv, model.getAspv().getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterioVO = new AspectoCargoCriterioVO();

        ascrCriterioVO.setAspcId(model.getId());
        ascrCriterioVO.setFechaVigencia(getFechaVigencia());

        ascrList = ascrBO.selectList(ascrCriterioVO);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("aspc-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());

        if (getAccion() == ACCION_EDICION.create) {
            model = new AspectoVO();
            model.setAspv(new AspectoVersionVO());
            model.getAspv().setFini(Calendar.getInstance().getTime());

            tpsrList = TipoServicioProxy.selectLabelValues();
        } else {
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(getFechaVigencia());

            final AspectoBO aspcBO = new AspectoBO();
            final AspectoCriterioVO aspcCriterio = new AspectoCriterioVO();

            aspcCriterio.setId(model.getId());
            aspcCriterio.setFechaVigencia(getFechaVigencia());
            aspcCriterio.setIdioma(getIdioma());

            model = aspcBO.selectObject(aspcCriterio);
            i18nMap = I18nBO.selectMap(I18nPrefix.aspv, model.getAspv().getId());
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
    @Action("aspc-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(getAccion());
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getAspv());

        if (ACCION_EDICION.create == getAccion()) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_codigo, model.getCodigo());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_tpsr, model.getTpsr());
        }

        if (ACCION_EDICION.create != getAccion()) {
            Preconditions.checkNotNull(model.getId());
            Preconditions.checkNotNull(model.getAspv().getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.aspc_fini, model.getAspv().getFini());
        FieldValidator.validatePeriod(this, model.getAspv().getFini(), model.getAspv().getFfin());
        FieldValidator.validateRequired(this, MessageI18nKey.aspc_prioridad, model.getAspv().getPrioridad());

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo1())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo1())
                || model.getAspv().getCgrpInfo1() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo1, model.getAspv().getCetiqInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo1, model.getAspv().getCpathInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo1, model.getAspv().getCgrpInfo1());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo2())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo2())
                || model.getAspv().getCgrpInfo2() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo2, model.getAspv().getCetiqInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo2, model.getAspv().getCpathInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo2, model.getAspv().getCgrpInfo2());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo3())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo3())
                || model.getAspv().getCgrpInfo3() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo3, model.getAspv().getCetiqInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo3, model.getAspv().getCpathInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo3, model.getAspv().getCgrpInfo3());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo4())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo4())
                || model.getAspv().getCgrpInfo4() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo4, model.getAspv().getCetiqInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo4, model.getAspv().getCpathInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo4, model.getAspv().getCgrpInfo4());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo5())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo5())
                || model.getAspv().getCgrpInfo5() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo5, model.getAspv().getCetiqInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo5, model.getAspv().getCpathInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo5, model.getAspv().getCgrpInfo5());
        }

        if (!GenericValidator.isBlankOrNull(model.getAspv().getCetiqInfo6())
                || !GenericValidator.isBlankOrNull(model.getAspv().getCpathInfo6())
                || model.getAspv().getCgrpInfo6() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo6, model.getAspv().getCetiqInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo6, model.getAspv().getCpathInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo6, model.getAspv().getCgrpInfo6());
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final AspectoBO aspcBO = new AspectoBO();

        switch (getAccion()) {
        case create:
            aspcBO.insert(model, i18nMap);

            break;
        case duplicate:
            aspcBO.duplicate(model, i18nMap);

            break;
        case edit:
            aspcBO.update(model, i18nMap);

            break;

        default:
            throw new Error("Accion no valida: " + getAccion());
        }

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public AspectoVO getModel() {
        return model;
    }

    /**
     * Sets the aspc.
     *
     * @param value
     *            the aspc
     */
    public void setModel(final AspectoVO value) {
        model = value;
    }

    /**
     * Gets the ascr list.
     *
     * @return the ascr list
     */
    public List<AspectoCargoVO> getAscrList() {
        return ascrList;
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
     * Gets the enti list.
     *
     * @return the enti list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }

}
