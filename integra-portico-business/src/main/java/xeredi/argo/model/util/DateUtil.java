package xeredi.argo.model.util;

import java.util.Calendar;
import java.util.Date;

import lombok.NonNull;

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
	 * @param field
	 *            the field
	 */
	public static void truncTime(final @NonNull Date date, final int field) {
		if (date != null) {
			final Calendar calendar = Calendar.getInstance();

			calendar.setTime(date);

			switch (field) {
			case Calendar.HOUR_OF_DAY:
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);

				break;
			case Calendar.MINUTE:
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);

				break;
			case Calendar.SECOND:
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);

				break;
			case Calendar.MILLISECOND:
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);

				break;

			default:
				throw new Error("Tipo de hora no soportado: " + field);
			}

			date.setTime(calendar.getTime().getTime());
		}
	}
}
