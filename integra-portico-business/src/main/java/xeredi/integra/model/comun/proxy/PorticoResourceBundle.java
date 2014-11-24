package xeredi.integra.model.comun.proxy;

import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.bo.MessageI18nControl;

import com.google.common.base.Preconditions;

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
    public static ResourceBundle getBundle(final Locale locale) {
        Preconditions.checkNotNull(locale);

        return ResourceBundle.getBundle("portico", locale, new MessageI18nControl());
    }
}
