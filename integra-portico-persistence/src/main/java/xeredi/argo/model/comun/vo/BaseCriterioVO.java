package xeredi.argo.model.comun.vo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import xeredi.argo.model.comun.vo.OrderByElement.OrderByType;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseCriterioVO.
 */
@Data
public abstract class BaseCriterioVO {

    /** The idioma. */
    private String idioma;

    /** The idioma defecto. */
    private String idiomaDefecto;

    /** The max limit. */
    private Integer maxLimit;

    /** The order by list. */
    private List<OrderByElement> orderByList = new ArrayList<>();

    /**
     * Adds the order by.
     *
     * @param columnName
     *            the column name
     * @param orderByType
     *            the order by type
     */
    public final void addOrderBy(final String columnName, final OrderByType orderByType) {
        orderByList.add(new OrderByElement(columnName, orderByType));
    }
}
