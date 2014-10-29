package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.OverlapException;
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
import xeredi.integra.model.metamodelo.bo.EntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEntidad;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoAction.
 */
public final class AspectoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4939833753699919759L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The aspc. */
    private AspectoVO aspc;

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

    /** The ascr list. */
    private List<AspectoCargoVO> ascrList;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    private List<LabelValueVO> entiList;

    /**
     * Instantiates a new aspecto action.
     */
    public AspectoAction() {
        super();

        fechaVigencia = Calendar.getInstance().getTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("aspc-detail")
    public String detail() {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getId());

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setId(aspc.getId());
        aspcCriterioVO.setFechaVigencia(getFechaVigencia());
        aspcCriterioVO.setIdioma(getIdioma());

        aspc = aspcBO.select(aspcCriterioVO);

        if (aspc == null) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.aspc), String.valueOf(aspcCriterioVO.getId()));

            return SUCCESS;
        }

        final I18nBO i18nBO = new I18nBO();

        i18nMap = i18nBO.selectMap(I18nPrefix.aspv, aspc.getAspv().getId());

        final AspectoCargoBO ascrBO = new AspectoCargoBO();
        final AspectoCargoCriterioVO ascrCriterioVO = new AspectoCargoCriterioVO();

        ascrCriterioVO.setAspcId(aspc.getId());
        ascrCriterioVO.setFechaVigencia(fechaVigencia);

        ascrList = ascrBO.selectList(ascrCriterioVO);

        return SUCCESS;
    }

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("aspc-create")
    public String create() {
        accion = ACCION_EDICION.create;

        aspc = new AspectoVO();
        aspc.setAspv(new AspectoVersionVO());
        aspc.getAspv().setFini(Calendar.getInstance().getTime());

        final EntidadBO entiBO = new EntidadBO();
        final EntidadCriterioVO entiCriterioVO = new EntidadCriterioVO();

        entiCriterioVO.setTipo(TipoEntidad.T);
        entiCriterioVO.setIdioma(getIdioma());

        entiList = entiBO.selectLabelValues(entiCriterioVO);

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("aspc-edit")
    public String edit() {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        accion = ACCION_EDICION.edit;

        final AspectoBO aspcBO = new AspectoBO();
        final I18nBO i18nBO = new I18nBO();
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setAspvId(aspc.getAspv().getId());

        aspc = aspcBO.select(aspcCriterioVO);

        if (aspc == null) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.aspc), String.valueOf(aspcCriterioVO.getId()));

            return SUCCESS;
        }

        i18nMap = i18nBO.selectMap(I18nPrefix.aspv, aspc.getAspv().getId());

        return SUCCESS;
    }

    /**
     * Duplicar.
     *
     * @return the string
     */
    @Action("aspc-duplicate")
    public String duplicate() {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        accion = ACCION_EDICION.duplicate;

        final AspectoBO aspcBO = new AspectoBO();
        final I18nBO i18nBO = new I18nBO();
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setAspvId(aspc.getAspv().getId());

        aspc = aspcBO.select(aspcCriterioVO);
        i18nMap = i18nBO.selectMap(I18nPrefix.aspv, aspc.getAspv().getId());

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("aspc-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());

        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_codigo, aspc.getCodigo());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_tpsr, aspc.getTpsr());
        }

        if (ACCION_EDICION.create != accion) {
            Preconditions.checkNotNull(aspc.getId());
            Preconditions.checkNotNull(aspc.getAspv().getId());
        }

        FieldValidator.validateI18n(this, i18nMap);

        FieldValidator.validateRequired(this, MessageI18nKey.aspc_fini, aspc.getAspv().getFini());
        FieldValidator.validateRequired(this, MessageI18nKey.aspc_prioridad, aspc.getAspv().getPrioridad());

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo1())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo1())
                || aspc.getAspv().getCgrpInfo1() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo1, aspc.getAspv().getCetiqInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo1, aspc.getAspv().getCpathInfo1());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo1, aspc.getAspv().getCgrpInfo1());
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo2())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo2())
                || aspc.getAspv().getCgrpInfo2() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo2, aspc.getAspv().getCetiqInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo2, aspc.getAspv().getCpathInfo2());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo2, aspc.getAspv().getCgrpInfo2());
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo3())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo3())
                || aspc.getAspv().getCgrpInfo3() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo3, aspc.getAspv().getCetiqInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo3, aspc.getAspv().getCpathInfo3());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo3, aspc.getAspv().getCgrpInfo3());
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo4())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo4())
                || aspc.getAspv().getCgrpInfo4() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo4, aspc.getAspv().getCetiqInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo4, aspc.getAspv().getCpathInfo4());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo4, aspc.getAspv().getCgrpInfo4());
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo5())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo5())
                || aspc.getAspv().getCgrpInfo5() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo5, aspc.getAspv().getCetiqInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo5, aspc.getAspv().getCpathInfo5());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo5, aspc.getAspv().getCgrpInfo5());
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo6())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo6())
                || aspc.getAspv().getCgrpInfo6() != null) {
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cetiqInfo6, aspc.getAspv().getCetiqInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cpathInfo6, aspc.getAspv().getCpathInfo6());
            FieldValidator.validateRequired(this, MessageI18nKey.aspc_cgrpInfo6, aspc.getAspv().getCgrpInfo6());
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final AspectoBO aspcBO = new AspectoBO();

        switch (accion) {
        case create:
            try {
                aspcBO.insert(aspc, i18nMap);
            } catch (final OverlapException ex) {
                addActionError(MessageI18nKey.E00009, getText(MessageI18nKey.aspc));
            }

            break;
        case duplicate:
            try {
                aspcBO.duplicate(aspc, i18nMap);
            } catch (final DuplicateInstanceException ex) {
                addActionError(MessageI18nKey.E00005, getText(MessageI18nKey.aspc));
            }

            break;
        case edit:
            try {
                aspcBO.update(aspc, i18nMap);
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.aspc), aspc.getCodigo());
            } catch (final OverlapException ex) {
                addActionError(MessageI18nKey.E00009, getText(MessageI18nKey.aspc));
            }

            break;

        default:
            throw new Error("Accion no valida: " + accion);
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }

    /**
     * Sets the aspc.
     *
     * @param value
     *            the aspc
     */
    public void setAspc(final AspectoVO value) {
        aspc = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

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

    public List<LabelValueVO> getEntiList() {
        return entiList;
    }

}
