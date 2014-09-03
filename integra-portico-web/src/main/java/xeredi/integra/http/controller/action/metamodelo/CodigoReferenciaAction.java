package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.metamodelo.bo.CodigoReferencia;
import xeredi.integra.model.metamodelo.bo.CodigoReferenciaBO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdrf-create")
    public String alta() throws InstanceNotFoundException {
        accion = ACCION_EDICION.alta;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdrf-edit")
    public String modificar() throws InstanceNotFoundException {
        accion = ACCION_EDICION.modificar;

        final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);
        final CodigoReferenciaCriterioVO cdrfCriterioVO = new CodigoReferenciaCriterioVO();

        cdrfCriterioVO.setTpdtId(cdrf.getTpdtId());
        cdrfCriterioVO.setValor(cdrf.getValor());

        cdrf = cdrfBO.selectObject(cdrfCriterioVO);

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdrf-save")
    public String guardar() throws InstanceNotFoundException {
        final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);

        if (cdrf.getTpdtId() == null) {
            throw new Error("No se ha especificado un tipo de dato");
        }

        PropertyValidator.validateRequired(this, "cdrf.valor", cdrf.getValor());
        PropertyValidator.validateRequired(this, "cdrf.orden", cdrf.getOrden());

        if (!hasErrors()) {
            if (accion == ACCION_EDICION.alta) {
                try {
                    cdrfBO.insert(cdrf);
                } catch (final DuplicateInstanceException ex) {
                    addFieldError("cdrf.valor", "errors.duplicado");
                }
            }
        }

        if (hasErrors()) {
            return INPUT;
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("cdrf-delete")
    public String eliminar() throws InstanceNotFoundException {
        final CodigoReferencia cdrfBO = BOFactory.getInjector().getInstance(CodigoReferenciaBO.class);

        if (cdrf.getTpdtId() == null) {
            throw new Error("No se ha especificado un tipo de dato");
        }

        PropertyValidator.validateRequired(this, "cdrf.valor", cdrf.getValor());

        if (hasErrors()) {
            throw new Error("Error recogiendo los datos del codigo de referencia: " + cdrf);
        }

        cdrfBO.delete(cdrf);

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
