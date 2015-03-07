package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleAction.
 */
public final class ValoracionDetalleAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8445459876553622926L;

    /** The vlrd. */
    private ValoracionDetalleVO vlrd;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("vlrd-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(vlrd);
        Preconditions.checkNotNull(vlrd.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        vlrd = vlrcBO.selectVlrd(vlrd.getId());
        vlrl = vlrcBO.selectVlrl(vlrd.getVlrlId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrd.
     *
     * @return the vlrd
     */
    public ValoracionDetalleVO getVlrd() {
        return vlrd;
    }

    /**
     * Sets the vlrd.
     *
     * @param value
     *            the vlrd
     */
    public void setVlrd(final ValoracionDetalleVO value) {
        vlrd = value;
    }

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaVO getVlrl() {
        return vlrl;
    }

}
