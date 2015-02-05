package xeredi.integra.model.comun.proxy;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.bo.MessageI18nControl;

// TODO: Auto-generated Javadoc
/**
 * The Class PorticoResourceBundle.
 */
public final class PorticoResourceBundle {

    /**
     * Gets the bundle.
     *
     * @param locale
     *            the locale
     * @return the bundle
     */
    public static ResourceBundle getBundle(final @Nonnull Locale locale) {
        return ResourceBundle.getBundle("portico", locale, new MessageI18nControl());
    }
}
