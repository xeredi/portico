package xeredi.integra.model.bo.util.pdf;

import xeredi.integra.model.vo.metamodelo.TipoElemento;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfCell.
 */
public final class PdfCell {
	/** The label. */
	private final String label;

	/** The value. */
	private final String value;

	/** The span. */
	private final int span;

	/** The tpel. */
	private final TipoElemento tpel;

	/**
	 * Instantiates a new pdf cell.
	 * 
	 * @param alabel
	 *            the alabel
	 * @param avalue
	 *            the avalue
	 * @param aspan
	 *            the aspan
	 * @param atpel
	 *            the atpel
	 */
	public PdfCell(final String alabel, final String avalue, final int aspan,
			final TipoElemento atpel) {
		super();
		label = alabel;
		value = avalue;
		span = aspan;
		tpel = atpel;
	}

	/**
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public final int getWidth() {
		return span * PdfConstants.SPAN_SIZE;
	}

	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public final String getLabel() {
		return label;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * Gets the span.
	 * 
	 * @return the span
	 */
	public final int getSpan() {
		return span;
	}

	/**
	 * Gets the tpel.
	 * 
	 * @return the tpel
	 */
	public final TipoElemento getTpel() {
		return tpel;
	}

}
