package xeredi.integra.http.controller.action.comun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.vo.comun.ItemCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;
import xeredi.integra.model.vo.metamodelo.EntidadVO;
import xeredi.integra.model.vo.metamodelo.TipoHtml;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemListadoAction.
 */
public abstract class ItemListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4401626614036721588L;

    /** The Constant ROWS. */
    protected static final int ROWS = GlobalNames.ROWS_PER_PAGE_DEFAULT;

    /** The label values map. */
    protected Map<Long, List<LabelValueVO>> labelValuesMap;

    /** The page. */
    private int page = PaginatedList.FIRST_PAGE;

    /** The limit. */
    private Integer limit = GlobalNames.ROWS_PER_PAGE_DEFAULT;

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
        return GlobalNames.VALID_ROWS_PER_PAGE;
    }

    /**
     * Load label values map.
     */
    protected final void loadLabelValuesMap() {
        if (labelValuesMap == null) {
            labelValuesMap = new HashMap<>();

            // Carga de los labelValues (Si los hay)
            final Set<Long> tpprIds = new HashSet<>();

            for (final EntidadTipoDatoVO entdVO : getEnti().getEntdMap().values()) {
                if (entdVO.isFiltrable() && entdVO.getTpdt().getTpht() != TipoHtml.F
                        && entdVO.getTpdt().getEnti() != null && entdVO.getTpdt().getEnti().getId() != null) {
                    tpprIds.add(entdVO.getTpdt().getEnti().getId());
                }
            }

            if (!tpprIds.isEmpty()) {
                final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);

                labelValuesMap.putAll(prmtBO.selectLabelValues(tpprIds, getItemCriterio().getFechaVigencia(),
                        getItemCriterio().getIdioma()));
            }
        }
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
     * Gets the enti.
     *
     * @return the enti
     */
    public abstract EntidadVO getEnti();

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
    public final Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit.
     *
     * @param value
     *            the new limit
     */
    public final void setLimit(final Integer value) {
        limit = value;
    }

}
