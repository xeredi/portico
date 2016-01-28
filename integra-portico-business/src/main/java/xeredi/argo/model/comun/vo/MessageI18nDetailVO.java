package xeredi.argo.model.comun.vo;

import java.util.Map;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new message i18n detail vo.
 */
@Data
public final class MessageI18nDetailVO {

    /** The key. */
    private MessageI18nKey key;

    /** The map. */
    private Map<String, String> map;
}
