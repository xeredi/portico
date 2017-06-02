package xeredi.argo.model.comun.exception;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.MessageI18nKey;

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
    public InstanceNotFoundException(final MessageI18nKey aclassName, final Object... aobjId) {
        super("Instancia no encontrada", aclassName, aobjId);
    }

    /**
     * Instantiates a new instance not found exception.
     *
     * @param aclassId
     *            the aclass id
     * @param aobjId
     *            the aobj id
     */
    public InstanceNotFoundException(final Long aclassId, final Object... aobjId) {
        super("Instancia no encontrada", aclassId, aobjId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public String getMessage(final @NonNull ResourceBundle bundle) {
        return MessageFormat.format(bundle.getString(MessageI18nKey.E00008.name()),
                new Object[] { bundle.getString(getClassName()), getObjId() });
    }

}
