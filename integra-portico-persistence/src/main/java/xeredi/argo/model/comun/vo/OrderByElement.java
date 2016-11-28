package xeredi.argo.model.comun.vo;

import lombok.Data;

/**
 * The Class OrderByElement.
 */
@Data
public final class OrderByElement {

    /**
     * The Enum OrderByType.
     */
    public enum OrderByType {
        /** The asc. */
        ASC,
        /** The desc. */
        DESC
    };

    /** The column name. */
    private final String columnName;

    /** The order by type. */
    private final OrderByType orderByType;
}
