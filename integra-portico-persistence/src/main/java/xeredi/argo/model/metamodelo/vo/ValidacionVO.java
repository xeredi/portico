package xeredi.argo.model.metamodelo.vo;

import java.util.Set;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new valicacion VO.
 */
@Data
@EqualsAndHashCode
public final class ValidacionVO {

    /** The min length. */
    private Integer minLength;

    /** The max length. */
    private Integer maxLength;

    /** The min value. */
    private Object minValue;

    /** The max value. */
    private Object maxValue;

    /** Expresión regular. */
    private Pattern regexp;

    /** The valid values. */
    private Set<Object> validValues;
}
