package xeredi.argo.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationVO.
 */
public final class ConfigurationVO {

    /** The key. */
    private ConfigurationKey key;

    /** The value type. */
    private ConfigurationValueType valueType;

    /** The default value. */
    private String defaultValue;

    /** The value. */
    private String value;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public ConfigurationKey getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param value
     *            the new key
     */
    public void setKey(final ConfigurationKey value) {
        key = value;
    }

    /**
     * Gets the value type.
     *
     * @return the value type
     */
    public ConfigurationValueType getValueType() {
        return valueType;
    }

    /**
     * Sets the value type.
     *
     * @param value
     *            the new value type
     */
    public void setValueType(final ConfigurationValueType value) {
        valueType = value;
    }

    /**
     * Gets the default value.
     *
     * @return the default value
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the default value.
     *
     * @param value
     *            the new default value
     */
    public void setDefaultValue(final String value) {
        defaultValue = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value
     *            the new value
     */
    public void setValue(final String value) {
        this.value = value;
    }

}
