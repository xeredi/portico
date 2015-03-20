package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieAction.
 */
public final class FacturaSerieAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2617347238199516008L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The fcsr. */
    private FacturaSerieVO fcsr;

    // acciones web

    /**
     * Detail.
     *
     * @return the string
     * @throws ModelException
     *             the model exception
     */
    @Action("fcsr-detail")
    public String detail() throws ModelException {
        Preconditions.checkNotNull(fcsr);
        Preconditions.checkNotNull(fcsr.getId());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        fcsr = fcsrBO.select(fcsr.getId());

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ModelException
     *             the model exception
     */
    @Action("fcsr-edit")
    public String edit() throws ModelException {
        Preconditions.checkNotNull(accion);

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(fcsr);
            Preconditions.checkNotNull(fcsr.getId());

            final FacturaSerieBO fcsrBO = new FacturaSerieBO();

            fcsr = fcsrBO.select(fcsr.getId());
        } else {
            fcsr = new FacturaSerieVO();
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ModelException
     *             the model exception
     */
    @Action("fcsr-save")
    public String save() throws ModelException {
        Preconditions.checkNotNull(accion);

        if (fcsr == null) {
            fcsr = new FacturaSerieVO();
        }

        if (ACCION_EDICION.edit == accion) {
            Preconditions.checkNotNull(fcsr.getId());
        }

        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_serie, fcsr.getSerie());
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_anio, fcsr.getAnio());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.fcsr_numeroUltimo, fcsr.getNumeroUltimo());

        if (!hasErrors()) {
            final FacturaSerieBO fcsrBO = new FacturaSerieBO();

            switch (accion) {
            case create:
                fcsrBO.insert(fcsr);

                break;
            case edit:
                fcsrBO.update(fcsr);

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
     * @throws ModelException
     *             the model exception
     */
    @Action("fcsr-remove")
    public String remove() throws ModelException {
        Preconditions.checkNotNull(fcsr);
        Preconditions.checkNotNull(fcsr.getId());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        fcsrBO.delete(fcsr.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the fcsr.
     *
     * @return the fcsr
     */
    public FacturaSerieVO getFcsr() {
        return fcsr;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the new fcsr
     */
    public void setFcsr(final FacturaSerieVO value) {
        fcsr = value;
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
