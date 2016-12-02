package xeredi.argo.model.comun.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import lombok.NonNull;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;

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
     * @param alocale
     *            the locale
     */
    public MessageI18nResourceBundle(@NonNull final Locale alocale) {
        super();

        this.locale = alocale;
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

        final Set<ClassPrefix> prefixSet = Sets.newHashSet(ClassPrefix.tpdt, ClassPrefix.cdrf, ClassPrefix.enti,
                ClassPrefix.entd, ClassPrefix.engd);

        final List<LabelValueVO> list = I18nUtilBO.selectLabelValueList(prefixSet,
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
