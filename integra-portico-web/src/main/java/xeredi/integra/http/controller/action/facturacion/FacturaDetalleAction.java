package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleAction.
 */
public final class FacturaDetalleAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8458951832194099421L;

    /** The fctd. */
    private FacturaDetalleVO fctd;

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("fctd-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(fctd);
        Preconditions.checkNotNull(fctd.getId());

        final FacturaBO fctdBO = new FacturaBO();

        fctd = fctdBO.selectFctd(fctd.getId());

        return SUCCESS;
    }

    /**
     * Gets the fctd.
     *
     * @return the fctd
     */
    public FacturaDetalleVO getFctd() {
        return fctd;
    }

    /**
     * Sets the fctd.
     *
     * @param value
     *            the new fctd
     */
    public void setFctd(final FacturaDetalleVO value) {
        fctd = value;
    }

}
