package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaDetalleVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaDetalleListadoAction.
 */
public final class FacturaDetalleListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3171188863304092142L;

    /** The fctl id. */
    private Long fctlId;

    /** The fctd list. */
    private PaginatedList<FacturaDetalleVO> fctdList;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = ROWS_PER_PAGE_DEFAULT;

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

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the new page
     */
    public void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the new limit
     */
    public void setLimit(final int value) {
        limit = value;
    }

}
