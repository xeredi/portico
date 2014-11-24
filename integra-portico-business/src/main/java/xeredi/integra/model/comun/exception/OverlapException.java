package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class OverlapException.
 */
public final class OverlapException extends ModelException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2765874878516074151L;

    /**
     * Instantiates a new overlap exception.
     *
     * @param aclassName
     *            the aclass name
     * @param aobjId
     *            the aobj id
     */
    public OverlapException(final MessageI18nKey aclassName, final Object aobjId) {
        super("Overlap", aclassName, aobjId);
    }

    /**
     * Instantiates a new overlap exception.
     *
     * @param aclassId
     *            the aclass id
     * @param aobjId
     *            the aobj id
     */
    public OverlapException(final Long aclassId, final Object aobjId) {
        super("Overlap", aclassId, aobjId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(final Locale locale) {
        Preconditions.checkNotNull(locale);

        final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

        return MessageFormat.format(bundle.getString(MessageI18nKey.E00009.name()),
                new Object[] { bundle.getString(getClassName()), getObjId() });
    }

}
