package xeredi.argo.model.comun.report;

import xeredi.argo.model.metamodelo.vo.TipoElemento;

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
    public PdfCell(final String alabel, final String avalue, final int aspan, final TipoElemento atpel) {
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
    public int getWidth() {
        return span * PdfConstants.SPAN_SIZE;
    }

    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the span.
     *
     * @return the span
     */
    public int getSpan() {
        return span;
    }

    /**
     * Gets the tpel.
     *
     * @return the tpel
     */
    public TipoElemento getTpel() {
        return tpel;
    }
}
