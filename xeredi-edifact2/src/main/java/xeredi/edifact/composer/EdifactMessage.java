package xeredi.edifact.composer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Message.
 */
public final class EdifactMessage {

	/** The type. */
	private final MessageType type;

	/** The version. */
	private final String version;

	/** The segment list. */
	private final List<Segment> segmentList = new ArrayList<>();

	/**
	 * Instantiates a new message.
	 *
	 * @param atype
	 *            the atype
	 * @param aversion
	 *            the aversion
	 * @param segments
	 *            the segments
	 */
	public EdifactMessage(final MessageType atype, final String aversion, final Segment... segments) {
		this.type = atype;
		this.version = aversion;

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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Gets the segment list.
	 *
	 * @return the segment list
	 */
	public List<Segment> getSegmentList() {
		return segmentList;
	}

	/**
	 * To edifact.
	 *
	 * @return the string
	 */
	public String toEdifact() {
		final StringBuilder builder = new StringBuilder();

		for (final Segment segment : segmentList) {
			builder.append(segment.toEdifact());
		}

		return builder.toString();
	}

}
