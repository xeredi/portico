package xeredi.argo.model.comun.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class MessageCriterioVO extends BaseCriterioVO {

    /** The key. */
    private MessageI18nKey key;

    /** The internal. */
    private Boolean internal;
}
