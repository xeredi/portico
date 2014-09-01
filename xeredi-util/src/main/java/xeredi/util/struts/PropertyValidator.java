package xeredi.util.struts;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyValidator.
 */
public final class PropertyValidator {

    /** The Constant ERROR_REQUIRED. */
    public static final String ERROR_REQUIRED = "error.required";

    /** The Constant ERROR_LONG. */
    public static final String ERROR_LONG = "error.format.long";

    /** The Constant ERROR_INTEGER. */
    public static final String ERROR_INTEGER = "error.format.integer";

    /** The Constant ERROR_DOUBLE. */
    public static final String ERROR_DOUBLE = "error.format.double";

    /** The Constant ERROR_DATE. */
    public static final String ERROR_DATE = "error.format.date";

    /**
     * Instantiates a new property validator.
     */
    private PropertyValidator() {
        super();
    }

    /**
     * Validate required.
     * 
     * @param support
     *            the support
     * @param propertyName
     *            the property name
     * @param propertyValue
     *            the property value
     */
    public static final void validateRequired(final ActionSupport support, final String propertyName,
            final Object propertyValue) {
        if (propertyValue == null || propertyValue instanceof String && "".equals(propertyValue)) {
            support.addFieldError(propertyName,
                    support.getText(ERROR_REQUIRED, new String[] { support.getText(propertyName) }));
        }
    }

    /**
     * Validate long.
     * 
     * @param support
     *            the support
     * @param propertyName
     *            the property name
     * @param propertyValue
     *            the property value
     * @return the long
     */
    public static final Long validateLong(final ActionSupport support, final String propertyName,
            final String propertyValue) {
        Long value = null;

        if (propertyValue != null && !propertyValue.isEmpty()) {
            try {
                value = Long.parseLong(propertyValue);
            } catch (final NumberFormatException ex) {
                support.addFieldError(propertyName,
                        support.getText(ERROR_LONG, new String[] { support.getText(propertyName) }));
            }
        }

        return value;
    }

    /**
     * Validate integer.
     * 
     * @param support
     *            the support
     * @param propertyName
     *            the property name
     * @param propertyValue
     *            the property value
     * @return the integer
     */
    public static final Integer validateInteger(final ActionSupport support, final String propertyName,
            final String propertyValue) {
        Integer value = null;

        if (propertyValue != null && !propertyValue.isEmpty()) {
            try {
                value = Integer.parseInt(propertyValue);
            } catch (final NumberFormatException ex) {
                support.addFieldError(propertyName,
                        support.getText(ERROR_INTEGER, new String[] { support.getText(propertyName) }));
            }
        }

        return value;
    }

    /**
     * Validate double.
     * 
     * @param support
     *            the support
     * @param propertyName
     *            the property name
     * @param propertyValue
     *            the property value
     * @return the double
     */
    public static final Double validateDouble(final ActionSupport support, final String propertyName,
            final String propertyValue) {
        Double value = null;

        if (propertyValue != null && !propertyValue.isEmpty()) {
            try {
                value = Double.parseDouble(propertyValue);
            } catch (final NumberFormatException ex) {
                support.addFieldError(propertyName,
                        support.getText(ERROR_DOUBLE, new String[] { support.getText(propertyName) }));
            }
        }

        return value;
    }

    /**
     * Validate date.
     * 
     * @param support
     *            the support
     * @param propertyName
     *            the property name
     * @param propertyValue
     *            the property value
     * @param dateFormat
     *            the date format
     * @return the date
     */
    public static final Date validateDate(final ActionSupport support, final String propertyName,
            final String propertyValue, final DateFormat dateFormat) {
        Date value = null;

        if (propertyValue != null && !propertyValue.isEmpty()) {
            try {
                value = dateFormat.parse(propertyValue);
            } catch (final ParseException ex) {
                support.addFieldError(propertyName,
                        support.getText(ERROR_DATE, new String[] { support.getText(propertyName) }));
            }
        }

        return value;
    }

    /**
     * Validate boolean.
     * 
     * @param support
     *            the support
     * @param propertyName
     *            the property name
     * @param propertyValue
     *            the property value
     * @return the boolean
     */
    public static final Boolean validateBoolean(final ActionSupport support, final String propertyName,
            final String propertyValue) {
        Boolean value = null;

        if (propertyValue != null && !propertyValue.isEmpty()) {
            value = "on".equals(propertyValue);
        }

        return value;
    }

}
