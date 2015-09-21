package xeredi.argo.model.comun.bo;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nControl.
 */
public final class MessageI18nControl extends Control {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(MessageI18nControl.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceBundle newBundle(final String baseName, final Locale locale, final String format,
            final ClassLoader loader, final boolean reload) throws IllegalAccessException, InstantiationException,
            IOException {
        LOG.info("Loading messages from database for bundle '" + baseName + "' and locale '" + locale + "'");

        return new MessageI18nResourceBundle(locale);
    }

}
