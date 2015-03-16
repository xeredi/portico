package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaAction.
 */
public final class FacturaLineaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3863722091539486183L;

    /** The fctl. */
    private FacturaLineaVO fctl;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctl-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(fctl);
        Preconditions.checkNotNull(fctl.getId());

        final FacturaBO fctrBO = new FacturaBO();

        fctl = fctrBO.selectFctl(fctl.getId());

        return SUCCESS;
    }

    /**
     * Gets the fctl.
     *
     * @return the fctl
     */
    public FacturaLineaVO getFctl() {
        return fctl;
    }

    /**
     * Sets the fctl.
     *
     * @param value
     *            the new fctl
     */
    public void setFctl(final FacturaLineaVO value) {
        fctl = value;
    }

}
