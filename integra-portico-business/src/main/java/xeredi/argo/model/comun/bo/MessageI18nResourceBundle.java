package xeredi.argo.model.comun.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.util.applicationobjects.LabelValueVO;

import com.google.common.collect.Sets;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nResourceBundle.
 */
public final class MessageI18nResourceBundle extends ListResourceBundle {

    /** The locale. */
    private final Locale locale;

    /**
     * Instantiates a new message i18n resource bundle.
     *
     * @param locale
     *            the locale
     */
    public MessageI18nResourceBundle(final Locale locale) {
        super();

        this.locale = locale;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object[][] getContents() {
        final List<Object[]> contentList = new ArrayList<>();

        final String defaultLanguage = ConfigurationProxy.getString(ConfigurationKey.language_default);
        final MessageI18nBO mesgBO = new MessageI18nBO();

        final Map<MessageI18nKey, String> map = mesgBO.selectLocaleMap(locale);

        for (final MessageI18nKey key : map.keySet()) {
            contentList.add(new Object[] { key.name(), map.get(key) });
        }

        final I18nBO i18nBO = new I18nBO();
        final Set<I18nPrefix> prefixSet = Sets.newHashSet(I18nPrefix.tpdt, I18nPrefix.cdrf, I18nPrefix.enti,
                I18nPrefix.entd, I18nPrefix.enac, I18nPrefix.engd);

        final List<LabelValueVO> list = i18nBO.selectLabelValueList(prefixSet,
                locale.getLanguage().isEmpty() ? defaultLanguage : locale.getLanguage());

        for (final LabelValueVO vo : list) {
            contentList.add(new Object[] { vo.getLabel(), vo.getValue() });
        }

        final Object[][] contents = new Object[contentList.size()][2];

        for (int i = 0; i < contentList.size(); i++) {
            contents[i] = contentList.get(i);
        }

        return contents;
    }

}
