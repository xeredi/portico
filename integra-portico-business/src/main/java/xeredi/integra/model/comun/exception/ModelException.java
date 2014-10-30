package xeredi.integra.model.comun.exception;

import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

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
    public ModelException(final String message, final MessageI18nKey aclassName, final Object aobjId) {
        super(message + " de la clase '" + aclassName + " con identificador :" + aobjId);

        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(aclassName);

        className = aclassName.name();
        objId = aobjId;
    }

    /**
     * Instantiates a new model exception.
     *
     * @param message
     *            the message
     * @param aclassId
     *            the aclass id
     * @param aobjId
     *            the aobj id
     */
    public ModelException(final String message, final Long aclassId, final Object aobjId) {
        super(message + " de la clase '" + "enti_" + aclassId + " con identificador :" + aobjId);

        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(aclassId);

        className = "enti_" + aclassId;
        objId = aobjId;
    }

    /**
     * Gets the class name.
     *
     * @return the class name
     */
    public final String getClassName() {
        return className;
    }

    /**
     * Gets the obj id.
     *
     * @return the obj id
     */
    public final Object getObjId() {
        return objId;
    }
}
