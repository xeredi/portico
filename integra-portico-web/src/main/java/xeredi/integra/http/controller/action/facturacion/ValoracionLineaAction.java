package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
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

    /** The vlrl padre. */
    private ValoracionLineaVO vlrlPadre;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("vlrl-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrl = vlrcBO.selectVlrl(vlrl.getId(), getIdioma());

        if (vlrl.getId() == vlrl.getPadreId()) {
            vlrlPadre = vlrl;
        } else {
            vlrlPadre = vlrcBO.selectVlrl(vlrl.getPadreId(), getIdioma());
        }

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrl-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getVlrcId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(vlrl.getId());

            final ValoracionBO vlrcBO = new ValoracionBO();

            vlrl = vlrcBO.selectVlrl(vlrl.getId(), getIdioma());
        }

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
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the vlrl padre.
     *
     * @return the vlrl padre
     */
    public ValoracionLineaVO getVlrlPadre() {
        return vlrlPadre;
    }

}
