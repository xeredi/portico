package xeredi.integra.proceso.servicio.escala;

// TODO: Auto-generated Javadoc
/**
 * The Enum AperakKeyword.
 */
public enum AperakKeyword {

    /** The FTX b_ calificador. */
    FTXB_Calificador(4, 3, true),

    ;

    /** The offset. */
    private final int offset;

    /** The length. */
    private final int length;

    /** The required. */
    private final boolean required;

    /**
     * Instantiates a new aperak keyword.
     * 
     * @param aoffset
     *            the aoffset
     * @param alength
     *            the alength
     * @param arequired
     *            the arequired
     */
    private AperakKeyword(final int aoffset, final int alength, final boolean arequired) {
        offset = aoffset;
        length = alength;
        required = arequired;
    }

    /**
     * Gets the offset.
     * 
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Gets the length.
     * 
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Checks if is required.
     * 
     * @return true, if is required
     */
    public boolean isRequired() {
        return required;
    }

}
