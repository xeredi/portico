package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.MessageI18nDAO;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.MessageI18nCriterioVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.comun.vo.MessageI18nVO;
import xeredi.util.mybatis.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageI18nBO.
 */
public final class MessageI18nBO {

    /**
     * Select language list.
     *
     * @return the list
     */
    public List<String> selectLanguageList() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

            return m18nDAO.selectLanguageList();
        }
    }

    /**
     * Select key value map.
     *
     * @param locale
     *            the locale
     * @param externalsOnly
     *            the externals only
     * @return the map
     */
    public Map<MessageI18nKey, String> selectKeyValueMap(final @Nonnull Locale locale, final boolean externalsOnly) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

            final Map<MessageI18nKey, String> map = new HashMap<>();
            final MessageI18nCriterioVO i18nCriterioVO = new MessageI18nCriterioVO();

            i18nCriterioVO.setExternalsOnly(externalsOnly);
            i18nCriterioVO.setLanguage(locale.getLanguage());

            if (locale == null || locale.getLanguage() == null || locale.getLanguage().isEmpty()) {
                i18nCriterioVO.setLanguage(ConfigurationProxy.getString(ConfigurationKey.language_default));
            }

            for (final MessageI18nVO i18nVO : m18nDAO.selectList(i18nCriterioVO)) {
                map.put(i18nVO.getKey(), i18nVO.getValue());
            }

            return map;
        }
    }

    /**
     * Report.
     *
     * @return the message i18n report vo
     */
    public MessageI18nReportVO report() {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

            final List<String> languageList = m18nDAO.selectLanguageList();

            final MessageI18nReportVO reportVO = new MessageI18nReportVO(languageList);
            final MessageI18nCriterioVO criterioVO = new MessageI18nCriterioVO();

            final List<MessageI18nVO> list = m18nDAO.selectList(criterioVO);

            for (final MessageI18nVO vo : list) {
                reportVO.getValuesMap().get(vo.getKey()).put(vo.getLanguage(), vo.getValue());
            }

            return reportVO;
        }
    }

    /**
     * Select list.
     *
     * @param key
     *            the key
     * @return the list
     */
    public List<MessageI18nVO> selectList(final @Nonnull MessageI18nKey key) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);
            final MessageI18nCriterioVO m18nCriterioVO = new MessageI18nCriterioVO();

            m18nCriterioVO.setKey(key);

            return m18nDAO.selectList(m18nCriterioVO);
        }
    }

}
