package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ModelException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieAction.
 */
public final class FacturaSerieAction extends BaseAction implements ModelDriven<FacturaSerieVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2617347238199516008L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The fcsr. */
    private FacturaSerieVO model;

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        model = fcsrBO.select(model.getId());

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
            Preconditions.checkNotNull(model);
            Preconditions.checkNotNull(model.getId());

            final FacturaSerieBO fcsrBO = new FacturaSerieBO();

            model = fcsrBO.select(model.getId());
        } else {
            model = new FacturaSerieVO();
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

        if (model == null) {
            model = new FacturaSerieVO();
        }

        if (ACCION_EDICION.edit == accion) {
            Preconditions.checkNotNull(model.getId());
        }

        if (ACCION_EDICION.create == accion) {
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_serie, model.getSerie());
            FieldValidator.validateRequired(this, MessageI18nKey.fcsr_anio, model.getAnio());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.fcsr_numeroUltimo, model.getNumeroUltimo());

        if (!hasErrors()) {
            final FacturaSerieBO fcsrBO = new FacturaSerieBO();

            switch (accion) {
            case create:
                fcsrBO.insert(model);

                break;
            case edit:
                fcsrBO.update(model);

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
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        fcsrBO.delete(model.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaSerieVO getModel() {
        return model;
    }

    /**
     * Sets the fcsr.
     *
     * @param value
     *            the new fcsr
     */
    public void setModel(final FacturaSerieVO value) {
        model = value;
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
