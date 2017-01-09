package xeredi.argo.http.controller.action.administracion.messagei18n;

import java.util.Map;

import com.google.inject.Inject;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.CrudSaveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.MessageI18nService;
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
	@Getter
	private Map<String, MessageI18nVO> i18nMap;

	@Inject
	private MessageI18nService m18nService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave() throws ApplicationException {
		m18nService.updateKeyMap(model, i18nMap);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doValidate() throws ApplicationException {
		// FIXME Validate
	}
}
