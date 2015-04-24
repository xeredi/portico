package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleAction.
 */
public final class FacturaDetalleAction extends ItemAction implements ModelDriven<FacturaDetalleVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8458951832194099421L;

    /** The fctd. */
    private FacturaDetalleVO model;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctd-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctdBO = new FacturaBO();

        model = fctdBO.selectFctd(model.getId());

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaDetalleVO getModel() {
        return model;
    }

    /**
     * Sets the fctd.
     *
     * @param value
     *            the new fctd
     */
    public void setModel(final FacturaDetalleVO value) {
        model = value;
    }

}
