package xeredi.integra.model.comun.exception;

import xeredi.integra.model.comun.vo.MessageI18nKey;

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
    public DuplicateInstanceException(final MessageI18nKey aclassName, final Object aobjId) {
        super("Instancia Duplicada", aclassName, aobjId);
    }

    /**
     * Instantiates a new duplicate instance exception.
     *
     * @param aclassId
     *            the aclass id
     * @param aobjId
     *            the aobj id
     */
    public DuplicateInstanceException(final Long aclassId, final Object aobjId) {
        super("Instancia Duplicada", aclassId, aobjId);
    }
}
