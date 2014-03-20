package xeredi.integra.model.bo.proceso;

import xeredi.util.exception.ModelException;

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
    public OperacionNoPermitidaException(final String aclassName, final Object aobjId) {
        super("El estado del proceso no permite la ejecucion de esta operacion", aclassName, aobjId);
    }

}
