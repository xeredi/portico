package xeredi.argo.model.comun.vo;

import lombok.Data;
import lombok.NonNull;

// TODO: Auto-generated Javadoc
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
    private final @NonNull String columnName;

    /** The order by type. */
    private final @NonNull OrderByType orderByType;
}
