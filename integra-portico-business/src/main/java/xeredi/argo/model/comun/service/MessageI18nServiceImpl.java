package xeredi.argo.model.comun.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import xeredi.argo.model.comun.dao.MessageDAO;
import xeredi.argo.model.comun.dao.MessageI18nDAO;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageCriterioVO;
import xeredi.argo.model.comun.vo.MessageI18nCriterioVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;
import xeredi.argo.model.comun.vo.MessageVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class MessageI18nServiceImpl implements MessageI18nService {

	@Inject
	private MessageDAO mesgDAO;

	@Inject
	private MessageI18nDAO m18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MessageI18nKey> selectKeys() {
		final MessageCriterioVO criterio = new MessageCriterioVO();
		final List<MessageI18nKey> list = new ArrayList<>();

		for (final MessageVO mesg : mesgDAO.selectList(criterio)) {
			list.add(mesg.getKey());
		}

		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<MessageI18nKey, String> selectLocaleMap(Locale locale) {
		final Map<MessageI18nKey, String> map = new HashMap<>();
		final MessageI18nCriterioVO criterio = new MessageI18nCriterioVO();

		if (locale == null || locale.getLanguage() == null || locale.getLanguage().isEmpty()) {
			criterio.setLanguage(ConfigurationProxy.getString(ConfigurationKey.language_default));
		} else {
			criterio.setLanguage(locale.getLanguage());
		}

		for (final MessageI18nVO m18n : m18nDAO.selectList(criterio)) {
			map.put(m18n.getKey(), m18n.getValue());
		}

		return map;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, MessageI18nVO> selectKeyMap(MessageI18nKey key) {
		final Map<String, MessageI18nVO> map = new HashMap<>();
		final MessageI18nCriterioVO criterio = new MessageI18nCriterioVO();

		criterio.setKey(key);

		for (final MessageI18nVO m18n : m18nDAO.selectList(criterio)) {
			map.put(m18n.getLanguage(), m18n);
		}

		return map;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateKeyMap(MessageI18nKey key, Map<String, MessageI18nVO> map) {
		final MessageI18nCriterioVO criterio = new MessageI18nCriterioVO();

		criterio.setKey(key);
		m18nDAO.deleteList(criterio);

		for (final String language : map.keySet()) {
			final MessageI18nVO m18n = map.get(language);

			m18n.setKey(key);
			m18n.setLanguage(language);

			m18nDAO.insert(m18n);
		}
	}

}