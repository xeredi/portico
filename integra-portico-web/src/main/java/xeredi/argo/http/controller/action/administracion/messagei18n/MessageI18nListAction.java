package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.comun.bo.MessageI18nBO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nListAction.
 */
public final class MessageI18nListAction extends ListAction<MessageI18nKey> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 9186179634462884228L;

    /** The key map. */
    @Getter
    private Map<MessageI18nKey, Map<String, String>> keyMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() {
        final MessageI18nBO mesgBO = new MessageI18nBO();

        resultList = mesgBO.selectKeys();
        keyMap = new HashMap<MessageI18nKey, Map<String, String>>();

        for (final String language : getAvailableLanguages()) {
            final Map<MessageI18nKey, String> map = mesgBO.selectLocaleMap(new Locale(language));

            for (final MessageI18nKey key : map.keySet()) {
                if (!keyMap.containsKey(key)) {
                    keyMap.put(key, new HashMap<String, String>());
                }

                keyMap.get(key).put(language, map.get(key));
            }
        }
    }

    // @Action("m18n-reload")
    // public String reload() throws IOException {
    // final I18nJs i18nJs = new I18nJs();
    //
    // i18nJs.export();
    //
    // return SUCCESS;
    // }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.m18n;
    }
}
