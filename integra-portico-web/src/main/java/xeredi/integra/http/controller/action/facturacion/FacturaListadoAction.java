package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.FacturaBO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaListadoAction.
 */
public final class FacturaListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -46147994205400361L;

    /** The fctr criterio. */
    private FacturaCriterioVO fctrCriterio;

    /** The fctr list. */
    private PaginatedList<FacturaVO> fctrList;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    // acciones web

    /**
     * List.
     *
     * @return the string
     */
    @Action("fctr-list")
    public String list() {
        final FacturaBO fctrBO = new FacturaBO();

        if (fctrCriterio == null) {
            fctrCriterio = new FacturaCriterioVO();
        }

        fctrList = fctrBO.selectList(fctrCriterio, PaginatedList.getOffset(page, ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the fctr criterio.
     *
     * @return the fctr criterio
     */
    public FacturaCriterioVO getFctrCriterio() {
        return fctrCriterio;
    }

    /**
     * Sets the fctr criterio.
     *
     * @param value
     *            the new fctr criterio
     */
    public void setFctrCriterio(final FacturaCriterioVO value) {
        fctrCriterio = value;
    }

    /**
     * Gets the fctr list.
     *
     * @return the fctr list
     */
    public PaginatedList<FacturaVO> getFctrList() {
        return fctrList;
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

}
