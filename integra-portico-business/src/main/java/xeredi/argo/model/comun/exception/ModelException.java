package xeredi.argo.model.comun.exception;

import java.util.Arrays;
import java.util.Iterator;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelException.
 */
public abstract class ModelException extends ApplicationException {

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
    public ModelException(@NonNull final String message, @NonNull final MessageI18nKey aclassName,
            final Object... aobjId) {
        super(message + " de la clase '" + aclassName + "' con identificador: " + aobjId[0]);

        className = aclassName.name();

        if (aobjId != null) {
            final StringBuilder builder = new StringBuilder();
            final Iterator<Object> iterator = Arrays.asList(aobjId).iterator();

            while (iterator.hasNext()) {
                builder.append(iterator.next());

                if (iterator.hasNext()) {
                    builder.append(", ");
                }
            }

            objId = builder;
        } else {
            objId = null;
        }
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
        super(message + " de la clase '" + "enti_" + aclassId + "' con identificador: " + aobjId);

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
