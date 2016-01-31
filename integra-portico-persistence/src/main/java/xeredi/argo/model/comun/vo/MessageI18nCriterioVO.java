package xeredi.argo.model.comun.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class MessageI18nCriterioVO extends BaseCriterioVO {
    /** The key. */
    private MessageI18nKey key;

    /** The language. */
    private String language;
}
