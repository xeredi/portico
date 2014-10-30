package xeredi.integra.model.comun.exception;

import xeredi.integra.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class OperacionNoPermitidaException.
 */
public final class OperacionNoPermitidaException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1079106391938492752L;

    /**
     * Instantiates a new operacion no permitida exception.
     *
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public OperacionNoPermitidaException(final MessageI18nKey aclassName, final Object aobjId) {
        super("El estado del objeto no permite la ejecucion de esta operacion", aclassName, aobjId);
    }

    /**
     * Instantiates a new operacion no permitida exception.
     *
     * @param aclassId
     *            the aclass id
     * @param aobjId
     *            the aobj id
     */
    public OperacionNoPermitidaException(final Long aclassId, final Object aobjId) {
        super("El estado del objeto no permite la ejecucion de esta operacion", aclassId, aobjId);
    }

}
