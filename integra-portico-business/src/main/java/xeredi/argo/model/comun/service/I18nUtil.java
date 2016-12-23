package xeredi.argo.model.comun.service;

import java.util.Map;

import com.google.common.base.Preconditions;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.I18nCriterioVO;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nUtil.
 */
public final class I18nUtil {
	/**
	 * Insert map.
	 *
	 * @param i18nDAO
	 *            the i 18 n DAO
	 * @param i18nable
	 *            the i 18 nable
	 * @param i18nMap
	 *            the i 18 n map
	 */
	public static void insertMap(@NonNull final I18nDAO i18nDAO, @NonNull final I18nable i18nable,
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
	 * @param i18nDAO
	 *            the i 18 n DAO
	 * @param i18nable
	 *            the i 18 nable
	 * @param i18nMap
	 *            the i 18 n map
	 */
	public static void updateMap(@NonNull final I18nDAO i18nDAO, @NonNull final I18nable i18nable,
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
	 * @param i18nDAO
	 *            the i 18 n DAO
	 * @param i18nable
	 *            the i 18 nable
	 * @return the int
	 */
	public static int deleteMap(@NonNull final I18nDAO i18nDAO, @NonNull final I18nable i18nable) {
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

		final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

		i18nCriterioVO.setExternalId(externalId);
		i18nCriterioVO.setPrefix(prefix);

		return i18nDAO.deleteList(i18nCriterioVO);
	}
}
