package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.bo.MessageBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nSaveAction.
 */
public final class MessageI18nSaveAction extends CrudSaveAction<MessageI18nKey> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3331358676066653527L;

    /** The i18n map. */
    private Map<String, MessageI18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final MessageBO bo = new MessageBO();

        bo.updateKeyMap(model, i18nMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        // FIXME Validate
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, MessageI18nVO> value) {
        i18nMap = value;
    }
}
