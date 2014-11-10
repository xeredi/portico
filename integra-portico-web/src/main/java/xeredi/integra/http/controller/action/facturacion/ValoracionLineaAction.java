package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaAction.
 */
public final class ValoracionLineaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3876356981308567280L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("vlrl-detail")
    public String detalle() {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrl = vlrcBO.selectVlrl(vlrl.getId());

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     */
    @Action("vlrl-edit")
    public String edit() {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getId());

        accion = ACCION_EDICION.edit;

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrl = vlrcBO.selectVlrl(vlrl.getId());

        return SUCCESS;
    }

    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("vlrl-create")
    public String create() {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getVlrcId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaVO getVlrl() {
        return vlrl;
    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the vlrl
     */
    public void setVlrl(final ValoracionLineaVO value) {
        vlrl = value;
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
