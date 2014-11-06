package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;

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

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Actions({ @Action("vlrd-detail") })
    public String detalle() {
        Preconditions.checkNotNull(vlrd);
        Preconditions.checkNotNull(vlrd.getId());

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrd = vlrcBO.selectVlrd(vlrd.getId());

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

}
