package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.ItemAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaAction.
 */
public final class FacturaLineaAction extends ItemAction implements ModelDriven<FacturaLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3863722091539486183L;

    /** The fctl. */
    private FacturaLineaVO model;

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("fctl-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();

        model = fctrBO.selectFctl(model.getId());

        return SUCCESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FacturaLineaVO getModel() {
        return model;
    }

    /**
     * Sets the fctl.
     *
     * @param value
     *            the new fctl
     */
    public void setModel(final FacturaLineaVO value) {
        model = value;
    }

}
