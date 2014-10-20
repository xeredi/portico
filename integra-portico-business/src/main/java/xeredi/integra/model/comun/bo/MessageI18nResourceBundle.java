package xeredi.integra.model.comun.bo;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Map;

import xeredi.integra.model.comun.vo.MessageI18nBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nResourceBundle.
 */
public final class MessageI18nResourceBundle extends ListResourceBundle {

    /** The bundle. */
    private final MessageI18nBundle bundle;

    /** The locale. */
    private final Locale locale;

    /**
     * Instantiates a new message i18n resource bundle.
     *
     * @param bundle
     *            the bundle
     * @param locale
     *            the locale
     */
    public MessageI18nResourceBundle(final MessageI18nBundle bundle, final Locale locale) {
        super();
        this.bundle = bundle;
        this.locale = locale;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object[][] getContents() {
        final MessageI18nBO i18nBO = new MessageI18nBO();

        final Map<String, String> map = i18nBO.selectKeyValueMap(bundle, locale);
        final Object[][] contents = new String[map.keySet().size()][2];

        int i = 0;
        for (final String key : map.keySet()) {
            contents[i][0] = key;
            contents[i][1] = map.get(key);

            i++;
        }

        return contents;
    }

}
