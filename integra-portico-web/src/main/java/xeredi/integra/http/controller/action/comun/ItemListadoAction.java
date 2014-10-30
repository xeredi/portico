package xeredi.integra.http.controller.action.comun;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.controller.action.PaginatedGrid;
import xeredi.integra.model.comun.vo.ItemCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemListadoAction.
 */
public abstract class ItemListadoAction extends BaseAction implements PaginatedGrid {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4401626614036721588L;

    /** The label values map. */
    protected Map<Long, List<LabelValueVO>> labelValuesMap;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    private int limit = ROWS_PER_PAGE_DEFAULT;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the limits.
     *
     * @return the limits
     */
    public final int[] getLimits() {
        return VALID_ROWS_PER_PAGE;
    }

    /**
     * Gets the label values map.
     *
     * @return the label values map
     */
    public final Map<Long, List<LabelValueVO>> getLabelValuesMap() {
        return labelValuesMap;
    }

    /**
     * Gets the item criterio.
     *
     * @return the item criterio
     */
    public abstract ItemCriterioVO getItemCriterio();

    /**
     * Gets the page.
     *
     * @return the page
     */
    public final int getPage() {
        return page;
    }

    /**
     * Sets the page.
     *
     * @param value
     *            the new page
     */
    public final void setPage(final int value) {
        page = value;
    }

    /**
     * Gets the limit.
     *
     * @return the limit
     */
    public final int getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the new limit
     */
    public final void setLimit(final int value) {
        limit = value;
    }

}
