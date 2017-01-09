package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.MessageI18nService;
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
	@Getter
	private Map<String, MessageI18nVO> i18nMap;

	@Inject
	private MessageI18nService m18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doEdit() throws ApplicationException {
		i18nMap = m18nService.selectKeyMap(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doLoadDependencies() throws ApplicationException {
		// noop
	}
}
