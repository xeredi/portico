package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class DuplicateInstanceException.
 */
public final class DuplicateInstanceException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1650516445646836708L;

    /**
     * Instantiates a new duplicate instance exception.
     *
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public DuplicateInstanceException(final MessageI18nKey aclassName, final Object aobjId) {
        super("Instancia Duplicada", aclassName, aobjId);

    }

    /**
     * Instantiates a new duplicate instance exception.
     *
     * @param aclassId
     *            the aclass id
     * @param aobjId
     *            the aobj id
     */
    public DuplicateInstanceException(final Long aclassId, final Object aobjId) {
        super("Instancia Duplicada", aclassId, aobjId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(final Locale locale) {
        Preconditions.checkNotNull(locale);

        final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

        return MessageFormat.format(bundle.getString(MessageI18nKey.E00005.name()),
                new Object[] { bundle.getString(getClassName()), getObjId() });
    }

}
