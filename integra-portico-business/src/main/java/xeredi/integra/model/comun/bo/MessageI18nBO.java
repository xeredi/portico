package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.MessageI18nDAO;
import xeredi.integra.model.comun.vo.MessageI18nBundle;
import xeredi.integra.model.comun.vo.MessageI18nCriterioVO;
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
     * Select key list.
     *
     * @param bundle
     *            the bundle
     * @return the list
     */
    public List<String> selectKeyList(final MessageI18nBundle bundle) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

        try {
            return m18nDAO.selectKeyList(bundle);
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
    public Map<String, String> selectKeyValueMap(final MessageI18nBundle bundle, final Locale locale) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

        try {
            final Map<String, String> map = new HashMap<>();
            final MessageI18nCriterioVO i18nCriterioVO = new MessageI18nCriterioVO();

            i18nCriterioVO.setBundle(bundle);
            i18nCriterioVO.setLanguage(locale.getLanguage());

            for (final MessageI18nVO i18nVO : m18nDAO.selectList(i18nCriterioVO)) {
                map.put(i18nVO.getLanguage(), i18nVO.getValue());
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
    public MessageI18nReportVO report(final MessageI18nBundle bundle) {
        final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.BATCH);

        final MessageI18nDAO m18nDAO = session.getMapper(MessageI18nDAO.class);

        try {
            final List<String> keyList = m18nDAO.selectKeyList(bundle);
            final List<String> languageList = m18nDAO.selectLanguageList();

            final MessageI18nReportVO reportVO = new MessageI18nReportVO(keyList, languageList);
            final MessageI18nCriterioVO criterioVO = new MessageI18nCriterioVO();

            criterioVO.setBundle(bundle);

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
