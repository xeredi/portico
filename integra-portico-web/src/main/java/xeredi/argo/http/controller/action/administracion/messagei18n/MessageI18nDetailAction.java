package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import lombok.Data;
import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.bo.MessageI18nBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nDetailAction.
 */
@Data
public final class MessageI18nDetailAction extends CrudDetailAction<MessageI18nKey> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 111777223068179652L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.m18n;

    /** The i18n map. */
    @Getter
    private Map<String, MessageI18nVO> i18nMap;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        final MessageI18nBO bo = new MessageI18nBO();

        i18nMap = bo.selectKeyMap(model);
    }
}
