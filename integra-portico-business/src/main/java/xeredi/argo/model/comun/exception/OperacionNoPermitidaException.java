package xeredi.argo.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.argo.model.comun.proxy.PorticoResourceBundle;
import xeredi.argo.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class OperacionNoPermitidaException.
 */
public final class OperacionNoPermitidaException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1079106391938492752L;

    /** The operacion. */
    private final MessageI18nKey operacion;

    /**
     * Instantiates a new operacion no permitida exception.
     *
     * @param aclassName
     *            the aclass name
     * @param operacion
     *            the operacion
     * @param aobjId
     *            the aobj id
     */
    public OperacionNoPermitidaException(final MessageI18nKey aclassName, final MessageI18nKey operacion,
            final Object aobjId) {
        super("No se puede realizar la operacion " + operacion.name(), aclassName, aobjId);

        this.operacion = operacion;
    }

    /**
     * Instantiates a new operacion no permitida exception.
     *
     * @param aclassId
     *            the aclass id
     * @param operacion
     *            the operacion
     * @param aobjId
     *            the aobj id
     */
    public OperacionNoPermitidaException(final Long aclassId, final MessageI18nKey operacion, final Object aobjId) {
        super("No se puede realizar la operacion " + operacion.name(), aclassId, aobjId);

        this.operacion = operacion;
    }

    /**
     * Gets the operacion.
     *
     * @return the operacion
     */
    public MessageI18nKey getOperacion() {
        return operacion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(final Locale locale) {
        Preconditions.checkNotNull(locale);

        final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

        return MessageFormat.format(bundle.getString(MessageI18nKey.E00013.name()),
                new Object[] { bundle.getString(operacion.name()), bundle.getString(getClassName()), getObjId() });
    }

}
