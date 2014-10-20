package xeredi.integra.http.util;

import java.util.Locale;
import java.util.ResourceBundle;

import xeredi.integra.model.comun.proxy.PorticoResourceBundle;
import xeredi.integra.model.comun.vo.MessageI18nBundlename;

import com.opensymphony.xwork2.LocaleProvider;
import com.opensymphony.xwork2.TextProviderSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nTextProvider.
 */
public final class MessageI18nTextProvider extends TextProviderSupport {

    /**
     * Instantiates a new message i18n text provider.
     */
    public MessageI18nTextProvider() {
        super();

        setBundle(PorticoResourceBundle.getBundle(MessageI18nBundlename.app, Locale.getDefault()));
    }

    /**
     * Instantiates a new message i18n text provider.
     *
     * @param clazz
     *            the clazz
     * @param provider
     *            the provider
     */
    public MessageI18nTextProvider(final Class clazz, final LocaleProvider provider) {
        super(clazz, provider);

        setBundle(PorticoResourceBundle.getBundle(MessageI18nBundlename.app, provider.getLocale()));
    }

    /**
     * Instantiates a new message i18n text provider.
     *
     * @param bundle
     *            the bundle
     * @param provider
     *            the provider
     */
    public MessageI18nTextProvider(final ResourceBundle bundle, final LocaleProvider provider) {
        super(PorticoResourceBundle.getBundle(MessageI18nBundlename.app, provider.getLocale()), provider);
    }

}
