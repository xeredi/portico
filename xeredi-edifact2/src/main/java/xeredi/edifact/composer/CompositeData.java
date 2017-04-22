package xeredi.edifact.composer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class CompositeData.
 */
public final class CompositeData extends Data {

	/** The data list. */
	private final List<String> dataList = new ArrayList<>();

	/**
	 * Instantiates a new composite data.
	 *
	 * @param datas
	 *            the datas
	 */
	public CompositeData(final String... datas) {
		if (datas != null) {
			dataList.addAll(Arrays.asList(datas));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toEdifact() {
		final StringBuilder builder = new StringBuilder();
		final Iterator<String> iterator = dataList.iterator();

		while (iterator.hasNext()) {
			final String value = iterator.next();

			builder.append(value == null ? "" : value);

			if (iterator.hasNext()) {
				builder.append(':');
			}
		}

		return builder.toString();
	}

}
