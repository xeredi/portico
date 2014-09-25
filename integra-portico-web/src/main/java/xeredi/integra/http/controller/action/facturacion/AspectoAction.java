package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.AspectoVersionVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
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

    /** The fecha vigencia. */
    private Date fechaVigencia;

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
        Preconditions.checkArgument(aspc.getId() != null && fechaVigencia != null || aspc.getAspv() != null
                && aspc.getAspv().getId() != null);

        final AspectoBO aspcBO = new AspectoBO();
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setId(aspc.getId());
        aspcCriterioVO.setFechaVigencia(getFechaVigencia());

        if (aspc.getAspv() != null) {
            aspcCriterioVO.setAspvId(aspc.getAspv().getId());
        }

        aspc = aspcBO.select(aspcCriterioVO);

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
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setAspvId(aspc.getAspv().getId());

        aspc = aspcBO.select(aspcCriterioVO);

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
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        aspcCriterioVO.setAspvId(aspc.getAspv().getId());

        aspc = aspcBO.select(aspcCriterioVO);

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
            if (GenericValidator.isBlankOrNull(aspc.getCodigo())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_codigo") }));
            }

            if (aspc.getTpsr() == null || aspc.getTpsr().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_tpsr") }));
            }
        }

        if (ACCION_EDICION.create != accion) {
            Preconditions.checkNotNull(aspc.getId());
            Preconditions.checkNotNull(aspc.getAspv().getId());
        }

        if (GenericValidator.isBlankOrNull(aspc.getAspv().getDescripcion())) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_descripcion") }));
        }

        if (aspc.getAspv().getFini() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_fini") }));
        }
        if (aspc.getAspv().getPrioridad() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_prioridad") }));
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo1())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo1())
                || aspc.getAspv().getCgrpInfo1() != null) {
            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo1())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cetiqInfo1") }));
            }

            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo1())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cpathInfo1") }));
            }

            if (aspc.getAspv().getCgrpInfo1() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cgrpInfo1") }));
            }
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo2())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo2())
                || aspc.getAspv().getCgrpInfo2() != null) {
            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo2())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cetiqInfo2") }));
            }

            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo2())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cpathInfo2") }));
            }

            if (aspc.getAspv().getCgrpInfo2() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cgrpInfo2") }));
            }
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo3())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo3())
                || aspc.getAspv().getCgrpInfo3() != null) {
            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo3())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cetiqInfo3") }));
            }

            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo3())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cpathInfo3") }));
            }

            if (aspc.getAspv().getCgrpInfo3() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cgrpInfo3") }));
            }
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo4())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo4())
                || aspc.getAspv().getCgrpInfo4() != null) {
            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo4())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cetiqInfo4") }));
            }

            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo4())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cpathInfo4") }));
            }

            if (aspc.getAspv().getCgrpInfo4() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cgrpInfo4") }));
            }
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo5())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo5())
                || aspc.getAspv().getCgrpInfo5() != null) {
            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo5())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cetiqInfo5") }));
            }

            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo5())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cpathInfo5") }));
            }

            if (aspc.getAspv().getCgrpInfo5() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cgrpInfo5") }));
            }
        }

        if (!GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo6())
                || !GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo6())
                || aspc.getAspv().getCgrpInfo6() != null) {
            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCetiqInfo6())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cetiqInfo6") }));
            }

            if (GenericValidator.isBlankOrNull(aspc.getAspv().getCpathInfo6())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cpathInfo6") }));
            }

            if (aspc.getAspv().getCgrpInfo6() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("aspc_cgrpInfo6") }));
            }
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final AspectoBO aspcBO = new AspectoBO();

        switch (accion) {
        case create:
            try {
                aspcBO.insert(aspc);
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("aspc") }));
            }

            break;
        case duplicate:
            try {
                aspcBO.duplicate(aspc);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("aspc") }));
            }

            break;
        case edit:
            try {
                aspcBO.update(aspc);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("aspc"), aspc.getCodigo() }));
            } catch (final OverlapException ex) {
                addActionError(getText(ErrorCode.E00009.name(), new String[] { getText("aspc") }));
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

}
