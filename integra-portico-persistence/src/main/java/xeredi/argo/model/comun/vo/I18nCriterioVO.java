package xeredi.argo.model.comun.vo;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class I18nCriterioVO extends BaseCriterioVO {
    /** The prefix. */
    private ClassPrefix prefix;

    /** The prefix set. */
    private Set<ClassPrefix> prefixSet;

    /** The external id. */
    private Long externalId;

    /** The language. */
    private String language;

    /** The default language. */
    private String defaultLanguage;
}
