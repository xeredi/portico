package xeredi.argo.model.util;

import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 */
public final class DateUtil {

    /**
     * Instantiates a new date util.
     */
    private DateUtil() {
        super();
    }

    /**
     * Reset time.
     *
     * @param date
     *            the date
     * @return the date
     */
    public static Date resetTime(final Date date) {
        if (date != null) {
            final Calendar calendar = Calendar.getInstance();

            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            return calendar.getTime();
        }

        return null;
    }

}
