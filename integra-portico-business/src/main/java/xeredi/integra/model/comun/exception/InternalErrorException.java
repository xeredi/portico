package xeredi.integra.model.comun.exception;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nKey;

// TODO: Auto-generated Javadoc
/**
 * The Class InternalErrorException.
 */
public final class InternalErrorException extends ApplicationException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9021423003651092646L;

    /** The throwable. */
    private final Throwable throwable;

    /**
     * Instantiates a new internal error exception.
     *
     * @param athrowable
     *            the athrowable
     */
    public InternalErrorException(final Throwable athrowable) {
        super(athrowable.getMessage());

        throwable = athrowable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(final Locale locale) {
        final ResourceBundle bundle = PorticoResourceBundle.getBundle(locale);

        return MessageFormat.format(bundle.getString(MessageI18nKey.E00000.name()),
                new Object[] { throwable.getCause() });
    }

}
