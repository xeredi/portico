package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.bo.MessageI18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nSaveAction.
 */
@Data
public final class MessageI18nSaveAction extends CrudSaveAction<MessageI18nKey> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3331358676066653527L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.m18n;

    /** The i18n map. */
    private Map<String, MessageI18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave() throws ApplicationException {
        final MessageI18nBO bo = new MessageI18nBO();

        bo.updateKeyMap(model, i18nMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doValidate() throws ApplicationException {
        // FIXME Validate
    }
}
