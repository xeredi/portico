package xeredi.integra.http.util;

import java.util.Map;

import org.apache.commons.validator.GenericValidator;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nValidator.
 */
public final class I18nValidator {

    /**
     * Validate.
     *
     * @param action
     *            the action
     * @param i18nMap
     *            the i18n map
     */
    public static void validate(final BaseAction action, final Map<String, I18nVO> i18nMap) {
        final String language_default = ConfigurationProxy.getString(ConfigurationKey.language_default);
        final String[] language_available = ConfigurationProxy.getStringArray(ConfigurationKey.language_available);

        if (i18nMap != null) {
            for (final String language : i18nMap.keySet()) {
                final I18nVO i18nVO = i18nMap.get(language);

                Preconditions.checkNotNull(i18nVO.getPrefix());

                i18nVO.setLanguage(language);
            }
        }

        if (i18nMap == null || i18nMap.isEmpty() || !i18nMap.containsKey(language_default)
                || GenericValidator.isBlankOrNull(i18nMap.get(language_default).getText())) {
            action.addActionError(action.getText(MessageI18nKey.E00002.name(), new String[] { language_default }));
        }

    }
}
