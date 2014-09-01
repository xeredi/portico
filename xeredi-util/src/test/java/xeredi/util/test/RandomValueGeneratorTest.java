package xeredi.util.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomValueGeneratorTest.
 */
public final class RandomValueGeneratorTest {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(RandomValueGeneratorTest.class);

    public enum EnumTest {
        uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez;
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        final int numTests = 10000000;
        final Date maxDate = new Date();
        final Date minDate = new Date();
        final List<Integer> list = Arrays.asList(new Integer[] { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
                10000, 11000, 12000, 13000, 14000, 15000 });

        minDate.setTime(maxDate.getTime() - 1000000000);

        final char[] testChars = "abcdefghi".toCharArray();
        final EnumTest[] enumConstants = EnumTest.values();

        for (int i = 0; i < numTests; i++) {
            RandomValueGenerator.getBoolean();
            RandomValueGenerator.getBoolean(0.1f);
            RandomValueGenerator.getDate(minDate, maxDate);
            RandomValueGenerator.getDate(minDate, maxDate, 0.1f);
            // RandomValueGenerator.getEnumObject(EnumTest.class);
            // RandomValueGenerator.getEnumObject(EnumTest.class, 0.1f);
            RandomValueGenerator.getEnumObject(enumConstants, 0.1f);
            RandomValueGenerator.getInteger(1000, 10000);
            RandomValueGenerator.getInteger(1000, 10000, 0.1f);
            RandomValueGenerator.getObject(list);
            RandomValueGenerator.getObject(list, false, 0.1f);
            RandomValueGenerator.getString(4, 30, testChars, 0.1f);
            RandomValueGenerator.getString(4, 30, 0.1f);
        }

        LOG.info("Enum Value: " + RandomValueGenerator.getEnumObject(EnumTest.class));
        LOG.info("Enum value: " + RandomValueGenerator.getEnumObject(EnumTest.class, 0.1f));
    }
}
