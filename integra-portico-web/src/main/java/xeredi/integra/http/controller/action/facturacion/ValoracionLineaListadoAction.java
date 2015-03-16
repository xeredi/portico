package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.util.pagination.PaginatedList;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaListadoAction.
 */
public final class ValoracionLineaListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4531375285740204285L;

    /** The vlrl list. */
    private PaginatedList<ValoracionLineaVO> vlrlList;

    /** The vlrl criterio. */
    private Long vlrcId;

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
    @Action("vlrl-list")
    public String listado() {
        Preconditions.checkNotNull(vlrcId);

        final ValoracionBO vlrcBO = new ValoracionBO();

        if (hasErrors()) {
            return INPUT;
        }

        vlrlList = vlrcBO.selectVlrlList(vlrcId, getIdioma(), PaginatedList.getOffset(getPage(), getLimit()),
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
     * Gets the vlrc id.
     *
     * @return the vlrc id
     */
    public Long getVlrcId() {
        return vlrcId;
    }

    /**
     * Sets the vlrc id.
     *
     * @param value
     *            the new vlrc id
     */
    public void setVlrcId(final Long value) {
        vlrcId = value;
    }

    /**
     * Gets the vlrl list.
     *
     * @return the vlrl list
     */
    public PaginatedList<ValoracionLineaVO> getVlrlList() {
        return vlrlList;
    }

}
