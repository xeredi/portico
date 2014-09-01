package xeredi.util.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class DuplicateInstanceException.
 */
public final class DuplicateInstanceException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1650516445646836708L;

    /**
     * Instantiates a new duplicate instance exception.
     * 
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public DuplicateInstanceException(final String aclassName, final Object aobjId) {
        super("Instancia Duplicada", aclassName, aobjId);
    }
}
