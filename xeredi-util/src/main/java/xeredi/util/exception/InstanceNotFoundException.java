package xeredi.util.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InstanceNotFoundException.
 */
public final class InstanceNotFoundException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3584819559951757661L;

    /**
     * Instantiates a new instance not found exception.
     * 
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public InstanceNotFoundException(final String aclassName, final Object aobjId) {
        super("Instancia no encontrada", aclassName, aobjId);
    }
}
