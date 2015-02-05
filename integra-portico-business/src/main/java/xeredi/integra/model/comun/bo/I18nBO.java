package xeredi.integra.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import xeredi.integra.model.comun.dao.I18nDAO;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
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
    public final static Map<String, I18nVO> selectMap(final @Nonnull I18nPrefix prefix, final @Nonnull Long prvrId) {
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
    public final static List<I18nVO> selectList(final @Nonnull I18nPrefix prefix, final @Nonnull String language) {
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
    public final List<LabelValueVO> selectLabelValueList(final @Nonnull Set<I18nPrefix> prefixSet,
            final @Nonnull String language) {
        try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
            final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
            final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

            i18nCriterioVO.setPrefixSet(prefixSet);
            i18nCriterioVO.setLanguage(language);

            return i18nDAO.selectLabelValueList(i18nCriterioVO);
        }
    }

    /**
     * Insert map.
     *
     * @param session
     *            the session
     * @param prefix
     *            the prefix
     * @param externalId
     *            the external id
     * @param i18nMap
     *            the i18n map
     */
    public final static void insertMap(final @Nonnull SqlSession session, final @Nonnull I18nPrefix prefix,
            final @Nonnull Long externalId, final @Nonnull Map<String, I18nVO> i18nMap) {
        Preconditions.checkNotNull(i18nMap.get(ConfigurationProxy.getString(ConfigurationKey.language_default)));

        final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);

        for (final I18nVO i18nVO : i18nMap.values()) {
            i18nVO.setPrefix(prefix);
            i18nVO.setExternalId(externalId);

            if (i18nVO.getText() != null || !i18nVO.getText().isEmpty()) {
                i18nDAO.insert(i18nVO);
            }
        }
    }

    /**
     * Duplicate map.
     *
     * @param session
     *            the session
     * @param prefix
     *            the prefix
     * @param externalId
     *            the external id
     * @param i18nMap
     *            the i18n map
     */
    public final static void duplicateMap(final @Nonnull SqlSession session, final @Nonnull I18nPrefix prefix,
            final @Nonnull Long externalId, final @Nonnull Map<String, I18nVO> i18nMap) {
        Preconditions.checkNotNull(i18nMap.get(ConfigurationProxy.getString(ConfigurationKey.language_default)));

        final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);

        for (final I18nVO i18nVO : i18nMap.values()) {
            i18nVO.setPrefix(prefix);
            i18nVO.setExternalId(externalId);

            if (i18nVO.getText() != null || !i18nVO.getText().isEmpty()) {
                i18nDAO.insert(i18nVO);
            }
        }
    }

    /**
     * Update map.
     *
     * @param session
     *            the session
     * @param prefix
     *            the prefix
     * @param externalId
     *            the external id
     * @param i18nMap
     *            the i18n map
     */
    public final static void updateMap(final @Nonnull SqlSession session, final @Nonnull I18nPrefix prefix,
            final @Nonnull Long externalId, final @Nonnull Map<String, I18nVO> i18nMap) {
        Preconditions.checkNotNull(i18nMap.get(ConfigurationProxy.getString(ConfigurationKey.language_default)));

        final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
        final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

        i18nCriterioVO.setExternalId(externalId);
        i18nCriterioVO.setPrefix(prefix);

        i18nDAO.deleteList(i18nCriterioVO);

        for (final I18nVO i18nVO : i18nMap.values()) {
            i18nVO.setPrefix(prefix);
            i18nVO.setExternalId(externalId);

            if (i18nVO.getText() != null && !i18nVO.getText().isEmpty()) {
                i18nDAO.insert(i18nVO);
            }
        }
    }

    /**
     * Delete map.
     *
     * @param session
     *            the session
     * @param prefix
     *            the prefix
     * @param externalId
     *            the external id
     * @return the int
     */
    public final static int deleteMap(final @Nonnull SqlSession session, final @Nonnull I18nPrefix prefix,
            final @Nonnull Long externalId) {
        final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
        final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

        i18nCriterioVO.setExternalId(externalId);
        i18nCriterioVO.setPrefix(prefix);

        return i18nDAO.deleteList(i18nCriterioVO);
    }

}
