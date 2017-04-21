package xeredi.edifact.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleSegment.
 */
public final class SimpleSegment extends Segment {

	/** The name. */
	private final SegmentType type;

	/** The data list. */
	private final List<Data> dataList = new ArrayList<>();

	/**
	 * Instantiates a new simple segment.
	 *
	 * @param atype
	 *            the atype
	 * @param datas
	 *            the datas
	 */
	public SimpleSegment(final SegmentType atype, final Data... datas) {
		this.type = atype;

		if (datas != null) {
			dataList.addAll(Arrays.asList(datas));
		}
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public final SegmentType getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toEdifact() {
		final StringBuilder builder = new StringBuilder();

		builder.append(getType().name());

		for (final Data data : dataList) {
			builder.append('+');

			if (data != null) {
				builder.append(data.toEdifact());
			}
		}

		builder.append("\'\n");

		return builder.toString();
	}
}
