package xeredi.integra.model.comun.exception;

import xeredi.integra.model.comun.vo.MessageI18nKey;

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
    public InstanceNotFoundException(final MessageI18nKey aclassName, final Object aobjId) {
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
    public InstanceNotFoundException(final Long aclassId, final Object aobjId) {
        super("Instancia no encontrada", aclassId, aobjId);
    }
}
