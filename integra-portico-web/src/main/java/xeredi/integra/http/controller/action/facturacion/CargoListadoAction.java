package xeredi.integra.http.controller.action.facturacion;

import java.util.Calendar;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoListadoAction.
 */
public final class CargoListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6194164339064073309L;

    /** The aspc list. */
    private PaginatedList<CargoVO> crgoList;

    /** The aspc criterio. */
    private CargoCriterioVO crgoCriterio;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    private int limit = ROWS_PER_PAGE_DEFAULT;

    // acciones web

    /**
     * Listado.
     *
     * @return the string
     */
    @Action("crgo-list")
    public String listado() {
        if (crgoCriterio == null) {
            crgoCriterio = new CargoCriterioVO();
        }

        crgoCriterio.setIdioma(getIdioma());

        final CargoBO crgoBO = new CargoBO();

        crgoList = crgoBO.selectList(crgoCriterio, PaginatedList.getOffset(getPage(), getLimit()), getLimit());

        return SUCCESS;
    }

    /**
     * Filtro.
     *
     * @return the string
     */
    @Action("crgo-filter")
    public String filtro() {
        crgoCriterio.setFechaVigencia(Calendar.getInstance().getTime());

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
     * Gets the crgo criterio.
     *
     * @return the crgo criterio
     */
    public CargoCriterioVO getCrgoCriterio() {
        return crgoCriterio;
    }

    /**
     * Sets the crgo criterio.
     *
     * @param value
     *            the new crgo criterio
     */
    public void setCrgoCriterio(final CargoCriterioVO value) {
        crgoCriterio = value;
    }

    /**
     * Gets the crgo list.
     *
     * @return the crgo list
     */
    public PaginatedList<CargoVO> getCrgoList() {
        return crgoList;
    }

}
