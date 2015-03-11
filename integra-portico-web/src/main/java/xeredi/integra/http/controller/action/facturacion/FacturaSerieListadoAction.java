package xeredi.integra.http.controller.action.facturacion;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.FacturaSerieBO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieListadoAction.
 */
public final class FacturaSerieListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1189138882681211082L;

    /** The srvcs. */
    private PaginatedList<FacturaSerieVO> fcsrList;

    /** The srvc criterio form. */
    private FacturaSerieCriterioVO fcsrCriterio;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    // acciones web

    /**
     * List.
     *
     * @return the string
     */
    @Action("fcsr-list")
    public String list() {
        final FacturaSerieBO fcsrBO = new FacturaSerieBO();

        if (fcsrCriterio == null) {
            fcsrCriterio = new FacturaSerieCriterioVO();
        }

        fcsrList = fcsrBO.selectList(fcsrCriterio, PaginatedList.getOffset(page, ROWS_PER_PAGE_DEFAULT),
                ROWS_PER_PAGE_DEFAULT);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the fcsr criterio.
     *
     * @return the fcsr criterio
     */
    public FacturaSerieCriterioVO getFcsrCriterio() {
        return fcsrCriterio;
    }

    /**
     * Sets the fcsr criterio.
     *
     * @param value
     *            the new fcsr criterio
     */
    public void setFcsrCriterio(final FacturaSerieCriterioVO value) {
        fcsrCriterio = value;
    }

    /**
     * Gets the fcsr list.
     *
     * @return the fcsr list
     */
    public PaginatedList<FacturaSerieVO> getFcsrList() {
        return fcsrList;
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
