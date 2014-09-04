package xeredi.integra.http.controller.action.metamodelo;

import org.apache.commons.validator.GenericValidator;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.CodigoReferencia;
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CodigoReferenciaAction.
 */
public final class CodigoReferenciaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4021150215007821288L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The cdrf form. */
    private CodigoReferenciaVO cdrf;

    /**
     * Instantiates a new codigo referencia action.
     */
    public CodigoReferenciaAction() {
        super();

        cdrf = new CodigoReferenciaVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("cdrf-create")
    public String alta() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());

        accion = ACCION_EDICION.alta;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("cdrf-edit")
    public String modificar() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());
        Preconditions.checkNotNull(cdrf.getValor());

        accion = ACCION_EDICION.modificar;

        final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);
        final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

        cdrfCriterioVO.setTpdtId(cdrf.getTpdtId());
        cdrfCriterioVO.setValor(cdrf.getValor());

        cdrf = cdrfBO.selectObject(cdrfCriterioVO);

        if (cdrf == null) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("cdrf-save")
    public String guardar() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());

        // Validacion de datos
        if (accion == ACCION_EDICION.alta) {
            if (GenericValidator.isBlankOrNull(cdrf.getValor())) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("cdrf_valor") }));
            }
        } else {
            Preconditions.checkNotNull(cdrf.getValor());
        }

        if (cdrf.getOrden() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("cdrf_orden") }));
        }

        if (!hasErrors()) {
            final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);

            if (accion == ACCION_EDICION.alta) {
                try {
                    cdrfBO.insert(cdrf);
                } catch (final DuplicateInstanceException ex) {
                    addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("cdrf") }));
                }
            } else {
                try {
                    cdrfBO.update(cdrf);
                } catch (final InstanceNotFoundException ex) {
                    addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
                }
            }
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     */
    @Action("cdrf-delete")
    public String eliminar() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());
        Preconditions.checkNotNull(cdrf.getValor());

        final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);

        try {
            cdrfBO.delete(cdrf);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("cdrf-detail")
    public String detalle() {
        Preconditions.checkNotNull(cdrf);
        Preconditions.checkNotNull(cdrf.getTpdtId());
        Preconditions.checkNotNull(cdrf.getValor());

        accion = ACCION_EDICION.modificar;

        final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);
        final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

        cdrfCriterioVO.setTpdtId(cdrf.getTpdtId());
        cdrfCriterioVO.setValor(cdrf.getValor());

        cdrf = cdrfBO.selectObject(cdrfCriterioVO);

        if (cdrf == null) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("cdrf"), cdrf.getValor() }));
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
     * Gets the cdrf.
     *
     * @return the cdrf
     */
    public CodigoReferenciaVO getCdrf() {
        return cdrf;
    }

    /**
     * Sets the cdrf.
     *
     * @param value
     *            the new cdrf
     */
    public void setCdrf(final CodigoReferenciaVO value) {
        cdrf = value;
    }

}
