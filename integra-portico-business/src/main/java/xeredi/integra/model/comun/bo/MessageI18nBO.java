package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.MessageI18nDAO;
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
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

        try {
            return m18nDAO.selectLanguageList();
        } finally {
            session.close();
        }
    }

    /**
     * Select key value map.
     *
     * @param bundle
     *            the bundle
     * @param locale
     *            the locale
     * @return the map
     */
    public Map<MessageI18nKey, String> selectKeyValueMap(final Locale locale, final boolean externalsOnly) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

        try {
            final Map<MessageI18nKey, String> map = new HashMap<>();
            final MessageI18nCriterioVO i18nCriterioVO = new MessageI18nCriterioVO();

            i18nCriterioVO.setExternalsOnly(externalsOnly);
            i18nCriterioVO.setLanguage(locale.getLanguage());

            for (final MessageI18nVO i18nVO : m18nDAO.selectList(i18nCriterioVO)) {
                map.put(i18nVO.getKey(), i18nVO.getValue());
            }

            return map;
        } finally {
            session.close();
        }
    }

    /**
     * Report.
     *
     * @param bundle
     *            the bundle
     * @return the message i18n report vo
     */
    public MessageI18nReportVO report() {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

        try {
            final List<String> languageList = m18nDAO.selectLanguageList();

            final MessageI18nReportVO reportVO = new MessageI18nReportVO(languageList);
            final MessageI18nCriterioVO criterioVO = new MessageI18nCriterioVO();

            final List<MessageI18nVO> list = m18nDAO.selectList(criterioVO);

            for (final MessageI18nVO vo : list) {
                reportVO.getValuesMap().get(vo.getKey()).put(vo.getLanguage(), vo.getValue());
            }

            return reportVO;
        } finally {
            session.close();
        }
    }

}
