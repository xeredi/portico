package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(final Locale locale) {
        Preconditions.checkNotNull(locale);

        final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

        return MessageFormat.format(bundle.getString(MessageI18nKey.E00008.name()),
                new Object[] { bundle.getString(getClassName()), getObjId() });
    }

}
