package xeredi.edifact.model;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleData.
 */
public final class SimpleData extends Data {

	/** The value. */
	private final String value;

	/**
	 * Instantiates a new simple data.
	 *
	 * @param avalue
	 *            the avalue
	 */
	public SimpleData(final String avalue) {
		this.value = avalue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toEdifact() {
		return value == null ? "" : value;
	}
}
