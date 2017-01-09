package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.MessageI18nService;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nDetailAction.
 */
public final class MessageI18nDetailAction extends CrudDetailAction<MessageI18nKey> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 111777223068179652L;

	/** The i18n map. */
	@Getter
	private Map<String, MessageI18nVO> i18nMap;

	@Inject
	private MessageI18nService m18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doDetail() throws ApplicationException {
		i18nMap = m18nService.selectKeyMap(model);
	}
}
