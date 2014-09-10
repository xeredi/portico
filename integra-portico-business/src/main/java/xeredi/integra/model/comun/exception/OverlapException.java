package xeredi.integra.model.comun.exception;

import xeredi.util.exception.ModelException;

/**
 * The Class OverlapException.
 */
public final class OverlapException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2765874878516074151L;

    /**
     * Instantiates a new overlap exception.
     *
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public OverlapException(final String aclassName, final Object aobjId) {
        super("Overlap", aclassName, aobjId);
    }

}
