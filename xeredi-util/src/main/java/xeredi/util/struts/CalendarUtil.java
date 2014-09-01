package xeredi.util.struts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarUtil.
 */
public final class CalendarUtil {

    /** The Constant DAYS_OF_MONTH. */
    private static final List<Integer> DAYS_OF_MONTH = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 });

    /** The Constant MONTHS. */
    private static final List<Integer> MONTHS = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });

    /** The Constant MIN_AGE. */
    private static final int MIN_AGE = 18;

    /**
     * Instantiates a new calendar util.
     */
    private CalendarUtil() {
        super();
    }

    /**
     * Gets the days of month.
     * 
     * @return the days of month
     */
    public static List<Integer> getDaysOfMonth() {
        return DAYS_OF_MONTH;
    }

    /**
     * Gets the months.
     * 
     * @return the months
     */
    public static List<Integer> getMonths() {
        return MONTHS;
    }

    /**
     * Gets the ages.
     * 
     * @return the ages
     */
    public static List<Integer> getAges() {
        final int lastYear = Calendar.getInstance().get(Calendar.YEAR) - MIN_AGE;

        return getYears(lastYear - 80, lastYear);
    }

    /**
     * Gets the years.
     * 
     * @param fromYear
     *            the from year
     * @param toYear
     *            the to year
     * @return the years
     */
    public static List<Integer> getYears(final int fromYear, final int toYear) {
        final List<Integer> list = new ArrayList<>(toYear - fromYear);
        for (int i = toYear; i >= fromYear; i--) {
            list.add(i);
        }

        return list;
    }
}
