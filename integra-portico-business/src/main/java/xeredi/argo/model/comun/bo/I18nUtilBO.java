package xeredi.argo.model.comun.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nCriterioVO;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.util.SqlMapperLocator;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nUtilBO.
 */
public final class I18nUtilBO {

	/**
	 * Instantiates a new i 18 n util BO.
	 */
	private I18nUtilBO() {
		super();
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
	static List<LabelValueVO> selectLabelValueList(@NonNull final Set<ClassPrefix> prefixSet,
			@NonNull final String language) {
		Preconditions.checkArgument(!prefixSet.isEmpty());

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
			final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

			i18nCriterioVO.setPrefixSet(prefixSet);
			i18nCriterioVO.setLanguage(language);

			return i18nDAO.selectLabelValueList(i18nCriterioVO);
		}
	}

	/**
	 * Select map.
	 *
	 * @param i18nable
	 *            the i 18 nable
	 * @return the map
	 */
	public static Map<String, I18nVO> selectMap(@NonNull final I18nable i18nable) {
		ClassPrefix prefix = null;
		Long externalId = null;

		if (i18nable instanceof Versionable<?>) {
			final Versionable<?> versionable = (Versionable<?>) i18nable;

			Preconditions.checkNotNull(versionable.getVersion());

			prefix = versionable.getVersion().getPrefix();
			externalId = versionable.getVersion().getId();
		} else {
			prefix = i18nable.getPrefix();
			externalId = i18nable.getId();
		}

		Preconditions.checkNotNull(prefix);
		Preconditions.checkNotNull(externalId);

		try (final SqlSession session = SqlMapperLocator.getSqlSessionFactory().openSession(ExecutorType.REUSE)) {
			final I18nDAO i18nDAO = session.getMapper(I18nDAO.class);
			final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

			i18nCriterioVO.setPrefix(prefix);
			i18nCriterioVO.setExternalId(externalId);

			final Map<String, I18nVO> i18nMap = new HashMap<>();

			for (final I18nVO i18nVO : i18nDAO.selectList(i18nCriterioVO)) {
				i18nMap.put(i18nVO.getLanguage(), i18nVO);
			}

			return i18nMap;
		}
	}

	/**
	 * Insert map.
	 *
	 * @param session
	 *            the session
	 * @param i18nable
	 *            the i 18 nable
	 * @param i18nMap
	 *            the i 18 n map
	 */
	public static void insertMap(@NonNull final SqlSession session, @NonNull final I18nable i18nable,
			@NonNull final Map<String, I18nVO> i18nMap) {
		ClassPrefix prefix = null;
		Long externalId = null;

		if (i18nable instanceof Versionable<?>) {
			final Versionable<?> versionable = (Versionable<?>) i18nable;

			Preconditions.checkNotNull(versionable.getVersion());

			prefix = versionable.getVersion().getPrefix();
			externalId = versionable.getVersion().getId();
		} else {
			prefix = i18nable.getPrefix();
			externalId = i18nable.getId();
		}

		Preconditions.checkNotNull(prefix);
		Preconditions.checkNotNull(externalId);

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
}
