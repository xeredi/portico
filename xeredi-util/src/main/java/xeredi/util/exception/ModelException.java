package xeredi.util.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelException.
 */
public abstract class ModelException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4946073733597057632L;

    /** The class name. */
    private final transient String className;

    /** The obj id. */
    private final transient Object objId;

    /**
     * Instantiates a new model exception.
     * 
     * @param message
     *            the message
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public ModelException(final String message, final String aclassName, final Object aobjId) {
        super(message + " de la clase '" + aclassName + " con identificador :" + aobjId);

        this.className = aclassName;
        this.objId = aobjId;
    }

    /**
     * Gets the class name.
     * 
     * @return the class name
     */
    public final String getClassName() {
        return this.className;
    }

    /**
     * Gets the obj id.
     * 
     * @return the obj id
     */
    public final Object getObjId() {
        return this.objId;
    }
}
