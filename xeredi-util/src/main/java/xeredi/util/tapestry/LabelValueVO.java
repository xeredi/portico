package xeredi.util.tapestry;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.tapestry5.OptionModel;

// TODO: Auto-generated Javadoc
/**
 * The Class LabelValueVO.
 */
public class LabelValueVO implements OptionModel {

    /** The label. */
    private String label;

    /** The value. */
    private Object value;

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
     * Instantiates a new label value vo.
     */
    public LabelValueVO() {
        super();
    }

    /**
     * To string.
     * 
     * @return the string {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the label.
     * 
     * @return the label
     */
    @Override
    public final String getLabel() {
        return label;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    @Override
    public final Object getValue() {
        return value;
    }

    /**
     * Sets the label.
     * 
     * @param alabel
     *            the new label
     */
    public final void setLabel(final String alabel) {
        label = alabel;
    }

    /**
     * Sets the value.
     * 
     * @param avalue
     *            the new value
     */
    public final void setValue(final Object avalue) {
        value = avalue;
    }

    /**
     * Checks if is disabled.
     * 
     * @return true, if is disabled
     * @see org.apache.tapestry5.OptionModel#isDisabled()
     */
    @Override
    public final boolean isDisabled() {
        return false;
    }

    /**
     * Gets the attributes.
     * 
     * @return the attributes
     * @see org.apache.tapestry5.OptionModel#getAttributes()
     */
    @Override
    public final Map<String, String> getAttributes() {
        return null;
    }

}
