package xeredi.argo.model.comun.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderByElement.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private @NonNull String columnName;

    /** The order by type. */
    private @NonNull OrderByType orderByType;
}
