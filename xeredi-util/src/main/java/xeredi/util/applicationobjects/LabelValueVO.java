package xeredi.util.applicationobjects;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class LabelValueVO.
 */
public final class LabelValueVO {

    /** The label. */
    private String label;

    /** The value. */
    private Object value;

    /**
     * Instantiates a new label value vo.
     */
    public LabelValueVO() {
        super();
    }

    /**
     * Instantiates a new label value vo.
     * 
     * @param alabel
     *            the alabel
     * @param avalue
     *            the avalue
     */
    public LabelValueVO(final String alabel, final Object avalue) {
        super();
        label = alabel;
        value = avalue;
    }

    /**
     * To string.
     * 
     * @return the string {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the label.
     * 
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets the label.
     * 
     * @param alabel
     *            the new label
     */
    public void setLabel(final String alabel) {
        label = alabel;
    }

    /**
     * Sets the value.
     * 
     * @param avalue
     *            the new value
     */
    public void setValue(final Object avalue) {
        value = avalue;
    }

}
