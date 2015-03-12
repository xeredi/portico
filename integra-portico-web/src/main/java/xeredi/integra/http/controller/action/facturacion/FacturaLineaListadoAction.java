package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaListadoAction.
 */
public final class FacturaLineaListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 374470052137978720L;

    /** The fctl list. */
    private PaginatedList<FacturaLineaVO> fctlList;

    /** The fctr id. */
    private Long fctrId;

    /** The page. */
    private int page = 1;

    /** The limit. */
    private int limit = ROWS_PER_PAGE_DEFAULT;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("fctl-list")
    public String list() {
        Preconditions.checkNotNull(fctrId);

        final FacturaBO fctrBO = new FacturaBO();

        fctlList = fctrBO.selectFctlList(fctrId, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the fctr id.
     *
     * @return the fctr id
     */
    public Long getFctrId() {
        return fctrId;
    }

    /**
     * Sets the fctr id.
     *
     * @param value
     *            the new fctr id
     */
    public void setFctrId(final Long value) {
        fctrId = value;
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

    /**
     * Gets the fctl list.
     *
     * @return the fctl list
     */
    public PaginatedList<FacturaLineaVO> getFctlList() {
        return fctlList;
    }

}
