package xeredi.argo.model.comun.bo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.collect.Sets;

import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nJs.
 */
public class I18nJs {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(I18nJs.class);

    /**
     * Export.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void export() throws IOException {
        LOG.info("I18n export");

        final String[] languages = ConfigurationProxy.getStringArray(ConfigurationKey.language_available);
        final String defaultLanguage = ConfigurationProxy.getString(ConfigurationKey.language_default);
        final String webappInstallPath = ConfigurationProxy.getString(ConfigurationKey.webapp_install_path);

        final I18nBO i18nBO = new I18nBO();
        final MessageI18nBO mesgBO = new MessageI18nBO();

        final Set<I18nPrefix> i18nPrefixSet = Sets.newHashSet(I18nPrefix.enti, I18nPrefix.engd, I18nPrefix.entd,
                I18nPrefix.trmt, I18nPrefix.enac, I18nPrefix.enag, I18nPrefix.tpdt, I18nPrefix.cdrf);

        for (final String language : languages) {
            LOG.info("Language: " + language);

            final List<LabelValueVO> labelValues = new ArrayList<>();

            labelValues.addAll(i18nBO.selectLabelValueList(i18nPrefixSet, language));

            final Map<MessageI18nKey, String> m18nMap = mesgBO.selectLocaleMap(new Locale(language));

            for (final MessageI18nKey key : m18nMap.keySet()) {
                labelValues.add(new LabelValueVO(key.name(), m18nMap.get(key)));
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

            final String filename = webappInstallPath + "/modules/i18n/i18n_messages_" + language + ".js";

            LOG.info("Filename: " + filename);

            try (final PrintWriter printWriter = new PrintWriter(filename, "UTF-8")) {
                printWriter.print(jsTemplate);

                if (LOG.isDebugEnabled()) {
                    LOG.debug("jsTemplate: " + jsTemplate);
                }
            }
        }

        LOG.info("I18n export success");
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
