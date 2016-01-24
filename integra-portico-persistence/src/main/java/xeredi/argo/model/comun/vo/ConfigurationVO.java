package xeredi.argo.model.comun.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationVO.
 */
@Data
public final class ConfigurationVO {

    /** The key. */
    private ConfigurationKey key;

    /** The value type. */
    private ConfigurationValueType valueType;

    /** The default value. */
    private String defaultValue;

    /** The value. */
    private String value;
}
