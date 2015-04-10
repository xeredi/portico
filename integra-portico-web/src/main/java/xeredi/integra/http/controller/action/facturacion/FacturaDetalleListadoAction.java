package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.PaginableAction;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleListadoAction.
 */
public final class FacturaDetalleListadoAction extends PaginableAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3171188863304092142L;

    /** The fctl id. */
    private Long fctlId;

    /** The fctd list. */
    private PaginatedList<FacturaDetalleVO> fctdList;

    /**
     * List.
     *
     * @return the string
     */
    @Action("fctd-list")
    public String list() {
        Preconditions.checkNotNull(fctlId);

        final FacturaBO fctrBO = new FacturaBO();

        fctdList = fctrBO.selectFctdList(fctlId, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * Gets the fctl id.
     *
     * @return the fctl id
     */
    public Long getFctlId() {
        return fctlId;
    }

    /**
     * Sets the fctl id.
     *
     * @param value
     *            the new fctl id
     */
    public void setFctlId(final Long value) {
        fctlId = value;
    }

    /**
     * Gets the fctd list.
     *
     * @return the fctd list
     */
    public PaginatedList<FacturaDetalleVO> getFctdList() {
        return fctdList;
    }
}
