package xeredi.edifact.composer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class GroupSegment.
 */
public final class GroupSegment extends Segment {

	/** The segment list. */
	private final List<Segment> segmentList = new ArrayList<>();

	/**
	 * Instantiates a new group segment.
	 *
	 * @param segments
	 *            the segments
	 */
	public GroupSegment(final Segment... segments) {
		if (segments != null) {
			segmentList.addAll(Arrays.asList(segments));
		}
	}

	/**
	 * Adds the segment.
	 *
	 * @param segment
	 *            the segment
	 */
	public void addSegment(final Segment segment) {
		segmentList.add(segment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toEdifact() {
		final StringBuilder builder = new StringBuilder();

		for (final Segment segment : segmentList) {
			builder.append(segment.toEdifact());
		}

		return builder.toString();
	}
}
