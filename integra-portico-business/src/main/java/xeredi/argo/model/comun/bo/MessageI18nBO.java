package xeredi.argo.model.comun.bo;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.argo.model.comun.dao.MessageI18nDAO;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.MessageI18nCriterioVO;
import xeredi.argo.model.comun.vo.MessageI18nKey;
import xeredi.argo.model.comun.vo.MessageI18nVO;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageBO.
 */
public final class MessageI18nBO {

	/**
	 * Select locale map.
	 *
	 * @param locale
	 *            the locale
	 * @return the map
	 */
	public Map<MessageI18nKey, String> selectLocaleMap(final Locale locale) {
		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);
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
	}

}
