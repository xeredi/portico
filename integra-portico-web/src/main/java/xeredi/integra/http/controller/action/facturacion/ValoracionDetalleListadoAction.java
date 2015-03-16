package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionDetalleListadoAction.
 */
public final class ValoracionDetalleListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9004620291483639470L;

    /** The vlrd list. */
    private PaginatedList<ValoracionDetalleVO> vlrdList;

    /** The vlrl id. */
    private Long vlrlId;

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
    @Action("vlrd-list")
    public String listado() {
        Preconditions.checkNotNull(vlrlId);

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrdList = vlrcBO.selectVlrdList(vlrlId, getIdioma(), PaginatedList.getOffset(getPage(), getLimit()),
                getLimit());

        return SUCCESS;
    }

    // get / set

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
     *            the page
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
     *            the limit
     */
    public void setLimit(final int value) {
        limit = value;
    }

    /**
     * Gets the vlrl id.
     *
     * @return the vlrl id
     */
    public Long getVlrlId() {
        return vlrlId;
    }

    /**
     * Sets the vlrl id.
     *
     * @param value
     *            the new vlrl id
     */
    public void setVlrlId(final Long value) {
        vlrlId = value;
    }

    /**
     * Gets the vlrd list.
     *
     * @return the vlrd list
     */
    public PaginatedList<ValoracionDetalleVO> getVlrdList() {
        return vlrdList;
    }

}
