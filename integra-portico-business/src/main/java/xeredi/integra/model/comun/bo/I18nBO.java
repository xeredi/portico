package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.I18nDAO;
import xeredi.integra.model.comun.vo.I18nCriterioVO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.mybatis.SqlMapperLocator;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nBO.
 */
public final class I18nBO {

    /**
     * Select i18n map.
     *
     * @param prefix
     *            the prefix
     * @param prvrId
     *            the prvr id
     * @return the map
     */
    public final Map<String, I18nVO> selectMap(final I18nPrefix prefix, final Long prvrId) {
        Preconditions.checkNotNull(prefix);
        Preconditions.checkNotNull(prvrId);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
            final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

            i18nCriterioVO.setPrefix(prefix);
            i18nCriterioVO.setExternalId(prvrId);

            final Map<String, I18nVO> i18nMap = new HashMap<>();

            for (final I18nVO i18nVO : i18nDAO.selectList(i18nCriterioVO)) {
                i18nMap.put(i18nVO.getLanguage(), i18nVO);
            }

            return i18nMap;
        }
    }

    /**
     * Select list.
     *
     * @param prefix
     *            the prefix
     * @param language
     *            the language
     * @return the list
     */
    public final List<I18nVO> selectList(final I18nPrefix prefix, final String language) {
        Preconditions.checkNotNull(prefix);
        Preconditions.checkNotNull(language);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
            final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

            i18nCriterioVO.setPrefix(prefix);
            i18nCriterioVO.setLanguage(language);

            return i18nDAO.selectList(i18nCriterioVO);
        }
    }

    /**
     * Select label value list.
     *
     * @param prefixSet
     *            the prefix set
     * @param language
     *            the language
     * @return the list
     */
    public final List<LabelValueVO> selectLabelValueList(final Set<I18nPrefix> prefixSet, final String language) {
        Preconditions.checkNotNull(prefixSet);
        Preconditions.checkNotNull(language);

        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
            final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

            i18nCriterioVO.setPrefixSet(prefixSet);
            i18nCriterioVO.setLanguage(language);

            return i18nDAO.selectLabelValueList(i18nCriterioVO);
        }
    }

}
