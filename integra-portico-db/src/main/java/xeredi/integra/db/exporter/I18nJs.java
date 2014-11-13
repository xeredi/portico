package xeredi.integra.db.exporter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.bo.MessageI18nBO;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nJs.
 */
public class I18nJs {

    private static final Log LOG = LogFactory.getLog(I18nJs.class);

    /**
     * Export.
     */
    public void export() throws IOException {
        final String[] languages = ConfigurationProxy.getStringArray(ConfigurationKey.language_available);
        final String defaultLanguage = ConfigurationProxy.getString(ConfigurationKey.language_default);
        final String webappInstallPath = ConfigurationProxy.getString(ConfigurationKey.webapp_install_path);

        final I18nBO i18nBO = new I18nBO();
        final MessageI18nBO messageI18nBO = new MessageI18nBO();

        final Set<I18nPrefix> i18nPrefixSet = new HashSet<>();

        i18nPrefixSet.add(I18nPrefix.enti);
        i18nPrefixSet.add(I18nPrefix.engd);
        i18nPrefixSet.add(I18nPrefix.entd);
        i18nPrefixSet.add(I18nPrefix.enac);
        i18nPrefixSet.add(I18nPrefix.tpdt);
        i18nPrefixSet.add(I18nPrefix.cdrf);

        for (final String language : languages) {
            final List<LabelValueVO> labelValues = new ArrayList<>();

            labelValues.addAll(i18nBO.selectLabelValueList(i18nPrefixSet, language));

            final Map<MessageI18nKey, String> messageI18nMap = messageI18nBO.selectKeyValueMap(new Locale(language),
                    true);

            for (final MessageI18nKey key : messageI18nMap.keySet()) {
                labelValues.add(new LabelValueVO(key.name(), messageI18nMap.get(key)));
            }

            final Iterator<LabelValueVO> labelValueIterator = labelValues.iterator();
            final StringBuffer i18nParams = new StringBuffer();

            while (labelValueIterator.hasNext()) {
                final LabelValueVO labelValue = labelValueIterator.next();

                i18nParams.append(labelValue.getLabel() + ":'" + labelValue.getValue() + '\'');

                if (labelValueIterator.hasNext()) {
                    i18nParams.append(',');
                }
            }

            final String jsTemplate = "angular.module('i18n', [ 'pascalprecht.translate' ]).config(function($translateProvider) { $translateProvider.translations('"
                    + language
                    + "', {"
                    + i18nParams.toString()
                    + "}); $translateProvider.preferredLanguage('"
                    + defaultLanguage + "'); });";

            try (final PrintWriter printWriter = new PrintWriter(webappInstallPath + "/modules/i18n/i18n_messages_"
                    + language + ".js")) {
                printWriter.print(jsTemplate);

                System.out.println(jsTemplate);
            }
        }
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final I18nJs i18nJs = new I18nJs();

        try {
            i18nJs.export();
        } catch (final Throwable ex) {
            LOG.fatal(ex, ex);

            ex.printStackTrace(System.err);
        }
    }

}

// cdrf_ACC_PET_AMARRE_AB : 'AB',
// cdrf_ZONA_II : 'II'

