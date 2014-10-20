package xeredi.integra.model.comun.proxy;

import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.bo.MessageI18nControl;
import xeredi.integra.model.comun.vo.MessageI18nBundlename;

// TODO: Auto-generated Javadoc
/**
 * The Class PorticoResourceBundle.
 */
public final class PorticoResourceBundle {

    /**
     * Gets the bundle.
     *
     * @param bundlename
     *            the bundlename
     * @param locale
     *            the locale
     * @return the bundle
     */
    public static ResourceBundle getBundle(final MessageI18nBundlename bundlename, final Locale locale) {
        return ResourceBundle.getBundle(bundlename.name(), locale, new MessageI18nControl());
    }
}
