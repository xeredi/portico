package xeredi.integra.http.controller.action.administracion.messagei18n;

import java.util.Map;

import xeredi.integra.http.controller.action.comun.CrudDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nDetailAction.
 */
public final class MessageI18nDetailAction extends CrudDetailAction<MessageI18nVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 111777223068179652L;

    /** The i18n map. */
    private Map<String, String> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        // TODO Auto-generated method stub
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, String> getI18nMap() {
        return i18nMap;
    }
}
