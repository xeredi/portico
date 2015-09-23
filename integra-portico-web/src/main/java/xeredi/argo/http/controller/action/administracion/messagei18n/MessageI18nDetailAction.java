package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.MessageBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nDetailAction.
 */
public final class MessageI18nDetailAction extends CrudDetailAction<MessageI18nKey> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 111777223068179652L;

    /** The i18n map. */
    private Map<String, MessageI18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final MessageBO bo = new MessageBO();

        i18nMap = bo.selectKeyMap(model);
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, MessageI18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.m18n;
    }
}
