package xeredi.util.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomValueGenerator.
 */
public final class RandomValueGenerator {

    /** The Constant RANDOM. */
    private static final Random RANDOM = new Random();

    /** The Constant LOWER_ALPHABETIC_CHARS. */
    public static final char[] LOWER_ALPHABETIC_CHARS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /** The Constant UPPER_ALPHABETIC_CHARS. */
    public static final char[] UPPER_ALPHABETIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /** The Constant VALIDCHARS. */
    public static final char[] VALIDCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ          "
            .toCharArray();

    /** The Constant NUMERICCHARS. */
    private static final char[] NUMERICCHARS = "0123456789".toCharArray();

    /**
     * Instantiates a new random value generator.
     */
    private RandomValueGenerator() {
        super();
    }

    /**
     * Gets the date.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the date
     */
    public static Date getDate(final Date minValue, final Date maxValue) {
        return getDate(minValue, maxValue, 0);
    }

    /**
     * Gets the date gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the date gaussian
     */
    public static Date getDateGaussian(final Date minValue, final Date maxValue) {
        return getDateGaussian(minValue, maxValue, 0);
    }

    /**
     * Gets the date.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the date
     */
    public static Date getDate(final Date minValue, final Date maxValue, final float nullProb) {
        Date value = null;

        if (!generateNull(nullProb)) {
            final long valueLong = RANDOM.nextLong() % (maxValue.getTime() - minValue.getTime()) + minValue.getTime();
            value = new Date(valueLong);
        }

        return value;
    }

    /**
     * Gets the date gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the date gaussian
     */
    public static Date getDateGaussian(final Date minValue, final Date maxValue, final float nullProb) {
        Date value = null;

        if (!generateNull(nullProb)) {
            long valueLong;
            do {
                valueLong = (long) (Math.abs(RANDOM.nextGaussian()) * (maxValue.getTime() - minValue.getTime()) + minValue
                        .getTime());
            } while (valueLong < minValue.getTime() || valueLong > maxValue.getTime());

            value = new Date(valueLong);
        }

        return value;
    }

    /**
     * Gets the integer.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the integer
     */
    public static Integer getInteger(final Integer minValue, final Integer maxValue) {
        return getInteger(minValue, maxValue, 0);
    }

    /**
     * Gets the integer gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the integer gaussian
     */
    public static Integer getIntegerGaussian(final Integer minValue, final Integer maxValue) {
        return getIntegerGaussian(minValue, maxValue, 0);
    }

    /**
     * Gets the integer.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the integer
     */
    public static Integer getInteger(final Integer minValue, final Integer maxValue, final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        return RANDOM.nextInt(maxValue.intValue() - minValue.intValue()) + minValue.intValue();
    }

    /**
     * Gets the integer gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the integer gaussian
     */
    public static Integer getIntegerGaussian(final Integer minValue, final Integer maxValue, final float nullProb) {
        Integer value = null;

        if (!generateNull(nullProb)) {
            if (minValue.equals(maxValue)) {
                value = minValue;
            } else {
                do {
                    final double random = Math.abs(RANDOM.nextGaussian());
                    final double valueDouble = Math.floor(random * (maxValue.intValue() - minValue.intValue())
                            + minValue.intValue());

                    value = (int) valueDouble;
                } while (value < minValue || value > maxValue);
            }
        }

        return value;
    }

    /**
     * Gets the long.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the long
     */
    public static Long getLong(final Long minValue, final Long maxValue) {
        return getLong(minValue, maxValue, 0);
    }

    /**
     * Gets the long gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the long gaussian
     */
    public static Long getLongGaussian(final Long minValue, final Long maxValue) {
        return getLongGaussian(minValue, maxValue, 0);
    }

    /**
     * Gets the long.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the long
     */
    public static Long getLong(final Long minValue, final Long maxValue, final float nullProb) {
        Long value = null;

        if (!generateNull(nullProb)) {
            if (minValue.equals(maxValue)) {
                value = minValue;
            } else {
                value = Math.abs(RANDOM.nextLong() % (maxValue.intValue() - minValue.intValue())) + minValue.intValue();
            }
        }

        return value;
    }

    /**
     * Gets the long gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the long gaussian
     */
    public static Long getLongGaussian(final Long minValue, final Long maxValue, final float nullProb) {
        Long value = null;

        if (!generateNull(nullProb)) {
            if (minValue.equals(maxValue)) {
                value = minValue;
            } else {
                do {
                    final double random = Math.abs(RANDOM.nextGaussian());
                    final double valueDouble = Math.floor(random * (maxValue.intValue() - minValue.intValue())
                            + minValue.intValue());

                    value = (long) valueDouble;
                } while (value < minValue || value > maxValue);
            }
        }

        return value;
    }

    /**
     * Gets the double.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the double
     */
    public static Double getDouble(final Double minValue, final Double maxValue) {
        return getDouble(minValue, maxValue, 0);
    }

    /**
     * Gets the double gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @return the double gaussian
     */
    public static Double getDoubleGaussian(final Double minValue, final Double maxValue) {
        return getDoubleGaussian(minValue, maxValue, 0);
    }

    /**
     * Gets the double.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the double
     */
    public static Double getDouble(final Double minValue, final Double maxValue, final float nullProb) {
        Double value = null;

        if (!generateNull(nullProb)) {
            value = RANDOM.nextDouble() * (maxValue.doubleValue() - minValue.doubleValue()) + minValue.doubleValue();
        }

        return value;
    }

    /**
     * Gets the double gaussian.
     *
     * @param minValue
     *            the min value
     * @param maxValue
     *            the max value
     * @param nullProb
     *            the null prob
     * @return the double gaussian
     */
    public static Double getDoubleGaussian(final Double minValue, final Double maxValue, final float nullProb) {
        Double value = null;

        if (!generateNull(nullProb)) {
            do {
                value = Math.abs(RANDOM.nextGaussian()) * (maxValue.doubleValue() - minValue.doubleValue())
                        + minValue.doubleValue();
            } while (value < minValue || value > maxValue);
        }

        return value;
    }

    /**
     * Gets the string.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param nullProb
     *            the null prob
     * @return the string
     */
    public static String getString(final int minLength, final int maxLength, final float nullProb) {
        return getString(minLength, maxLength, VALIDCHARS, nullProb);
    }

    /**
     * Gets the string gaussian.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param nullProb
     *            the null prob
     * @return the string gaussian
     */
    public static String getStringGaussian(final int minLength, final int maxLength, final float nullProb) {
        return getStringGaussian(minLength, maxLength, VALIDCHARS, nullProb);
    }

    /**
     * Gets the numeric string.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param nullProb
     *            the null prob
     * @return the numeric string
     */
    public static String getNumericString(final int minLength, final int maxLength, final float nullProb) {
        return getString(minLength, maxLength, NUMERICCHARS, nullProb);
    }

    /**
     * Gets the numeric string gaussian.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param nullProb
     *            the null prob
     * @return the numeric string gaussian
     */
    public static String getNumericStringGaussian(final int minLength, final int maxLength, final float nullProb) {
        return getStringGaussian(minLength, maxLength, NUMERICCHARS, nullProb);
    }

    /**
     * Gets the string.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param validChars
     *            the valid chars
     * @param nullProb
     *            the null prob
     * @return the string
     */
    public static String getString(final int minLength, final int maxLength, final char[] validChars,
            final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        int valueInt = minLength;

        if (minLength != maxLength) {
            valueInt = RANDOM.nextInt(maxLength - minLength) + minLength;
        }

        final StringBuffer buffer = new StringBuffer(valueInt);

        for (int i = 0; i < valueInt; i++) {
            buffer.append(validChars[RANDOM.nextInt(validChars.length)]);
        }

        return buffer.toString();
    }

    /**
     * Gets the string gaussian.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param validChars
     *            the valid chars
     * @param nullProb
     *            the null prob
     * @return the string gaussian
     */
    public static String getStringGaussian(final int minLength, final int maxLength, final char[] validChars,
            final float nullProb) {
        String value = null;

        if (!generateNull(nullProb)) {
            int valueInt = minLength;
            if (minLength != maxLength) {
                valueInt = getIntegerGaussian(minLength, maxLength);
            }

            final StringBuffer buffer = new StringBuffer(valueInt);

            for (int i = 0; i < valueInt; i++) {
                buffer.append(validChars[RANDOM.nextInt(validChars.length)]);
            }

            value = buffer.toString();
        }

        return value;
    }

    /**
     * Gets the email.
     *
     * @param minLength
     *            the min length
     * @param maxLength
     *            the max length
     * @param nullProb
     *            the null prob
     * @return the email
     */
    public static String getEmail(final int minLength, final int maxLength, final float nullProb) {
        String value = null;

        if (!generateNull(nullProb)) {
            int valueInt = minLength;
            if (minLength != maxLength) {
                valueInt = RANDOM.nextInt(maxLength - minLength) + minLength;
            }

            final StringBuffer buffer = new StringBuffer(valueInt);
            final int tokenSize = (valueInt - 5) / 2;

            buffer.append(getString(tokenSize, tokenSize, LOWER_ALPHABETIC_CHARS, 0)).append('@')
                    .append(getString(tokenSize, tokenSize, LOWER_ALPHABETIC_CHARS, 0)).append('.')
                    .append(getString(3, 3, LOWER_ALPHABETIC_CHARS, 0));

            value = buffer.toString();
        }

        return value;
    }

    /**
     * Gets the boolean.
     *
     * @return the boolean
     */
    public static Boolean getBoolean() {
        return getBoolean(0);
    }

    /**
     * Gets the boolean.
     *
     * @param nullProb
     *            the null prob
     * @return the boolean
     */
    public static Boolean getBoolean(final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        return RANDOM.nextBoolean();
    }

    /**
     * Gets the object.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @return the object
     */
    public static <T> T getObject(final List<T> validValues) {
        return getObject(validValues, false, 0);
    }

    /**
     * Gets the object gaussian.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @return the object gaussian
     */
    public static <T> T getObjectGaussian(final List<T> validValues) {
        return getObjectGaussian(validValues, false, 0);
    }

    /**
     * Gets the object.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @param remove
     *            the remove
     * @param nullProb
     *            the null prob
     * @return the object
     */
    public static <T> T getObject(final List<T> validValues, final boolean remove, final float nullProb) {
        if (generateNull(nullProb) || validValues == null || validValues.isEmpty()) {
            return null;
        }

        final T object = validValues.get(RANDOM.nextInt(validValues.size()));

        if (remove) {
            validValues.remove(object);
        }

        return object;
    }

    /**
     * Gets the object gaussian.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @param remove
     *            the remove
     * @param nullProb
     *            the null prob
     * @return the object gaussian
     */
    public static <T> T getObjectGaussian(final List<T> validValues, final boolean remove, final float nullProb) {
        T value = null;

        if (!generateNull(nullProb)) {
            final int pos = getIntegerGaussian(0, validValues.size() - 1);
            value = validValues.get(pos);

            if (remove) {
                validValues.remove(pos);
            }
        }

        return value;
    }

    /**
     * Gets the object.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @param remove
     *            the remove
     * @param nullProb
     *            the null prob
     * @return the object
     */
    public static <T> T getObject(final Set<T> validValues, final boolean remove, final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        final T[] values = (T[]) validValues.toArray();
        final T object = values[RANDOM.nextInt(validValues.size())];

        if (remove) {
            validValues.remove(object);
        }

        return object;
    }

    /**
     * Gets the object gaussian.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @param remove
     *            the remove
     * @param nullProb
     *            the null prob
     * @return the object gaussian
     */
    public static <T> T getObjectGaussian(final Set<T> validValues, final boolean remove, final float nullProb) {
        T object = null;
        T[] values = null;

        if (!generateNull(nullProb)) {
            final int pos = getIntegerGaussian(0, validValues.size() - 1);
            values = validValues.toArray(values);

            object = values[pos];

            if (remove) {
                validValues.remove(object);
            }
        }

        return object;
    }

    /**
     * Gets the object.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @param remove
     *            the remove
     * @param nullProb
     *            the null prob
     * @return the object
     */
    public static <T> T getObject(final Map<T, T> validValues, final boolean remove, final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        final T[] values = (T[]) validValues.keySet().toArray();
        final T object = values[RANDOM.nextInt(validValues.size())];

        if (remove) {
            validValues.remove(object);
        }

        return object;
    }

    /**
     * Gets the object gaussian.
     *
     * @param <T>
     *            the generic type
     * @param validValues
     *            the valid values
     * @param remove
     *            the remove
     * @param nullProb
     *            the null prob
     * @return the object gaussian
     */
    public static <T> T getObjectGaussian(final Map<T, T> validValues, final boolean remove, final float nullProb) {
        T object = null;
        T[] values = null;

        if (!generateNull(nullProb)) {
            final int pos = getIntegerGaussian(0, validValues.size() - 1);
            values = validValues.keySet().toArray(values);

            object = values[pos];

            if (remove) {
                validValues.remove(object);
            }
        }

        return object;
    }

    /**
     * Gets the enum object.
     *
     * @param <I>
     *            the generic type
     * @param enumType
     *            the enum type
     * @return the enum object
     */
    public static <I extends Enum<I>> I getEnumObject(final Class<I> enumType) {
        return getEnumObject(enumType, 0);
    }

    /**
     * Gets the enum object gaussian.
     *
     * @param <I>
     *            the generic type
     * @param enumType
     *            the enum type
     * @return the enum object gaussian
     */
    public static <I extends Enum<I>> I getEnumObjectGaussian(final Class<I> enumType) {
        return getEnumObjectGaussian(enumType, 0);
    }

    /**
     * Gets the enum object.
     *
     * @param <T>
     *            the generic type
     * @param enumType
     *            the enum type
     * @param nullProb
     *            the null prob
     * @return the enum object
     */
    public static <T extends Enum<T>> T getEnumObject(final Class<T> enumType, final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        return enumType.getEnumConstants()[RANDOM.nextInt(enumType.getEnumConstants().length)];
    }

    public static <T extends Enum<T>> T getEnumObject(final T[] enumConstants, final float nullProb) {
        if (generateNull(nullProb)) {
            return null;
        }

        return enumConstants[RANDOM.nextInt(enumConstants.length)];
    }

    /**
     * Gets the enum object gaussian.
     *
     * @param <T>
     *            the generic type
     * @param enumType
     *            the enum type
     * @param nullProb
     *            the null prob
     * @return the enum object gaussian
     */
    public static <T extends Enum<T>> T getEnumObjectGaussian(final Class<T> enumType, final float nullProb) {
        T object = null;

        if (!generateNull(nullProb)) {
            final int pos = getIntegerGaussian(0, enumType.getEnumConstants().length - 1);

            object = enumType.getEnumConstants()[pos];
        }

        return object;
    }

    /**
     * Generate null.
     *
     * @param nullProb
     *            the null prob
     * @return true, if successful
     */
    private static boolean generateNull(final float nullProb) {
        return nullProb > 0 ? RANDOM.nextFloat() < nullProb : false;
    }
}
