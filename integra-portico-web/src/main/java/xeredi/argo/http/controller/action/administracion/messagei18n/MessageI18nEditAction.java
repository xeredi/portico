package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.bo.MessageBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nEditAction.
 */
public final class MessageI18nEditAction extends CrudEditAction<MessageI18nKey> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4609134906730381113L;

    /** The i18n map. */
    private Map<String, MessageI18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        final MessageBO bo = new MessageBO();

        i18nMap = bo.selectKeyMap(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, MessageI18nVO> getI18nMap() {
        return i18nMap;
    }
}
