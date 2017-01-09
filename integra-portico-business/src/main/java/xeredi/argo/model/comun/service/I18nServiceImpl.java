package xeredi.argo.model.comun.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.guice.transactional.Transactional;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import lombok.NonNull;
import xeredi.argo.model.comun.dao.I18nDAO;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nCriterioVO;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.LabelValueVO;
import xeredi.argo.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class I18nServiceImpl.
 */
@Transactional(executorType = ExecutorType.REUSE)
public class I18nServiceImpl implements I18nService {

	/** The i 18 n DAO. */
	@Inject
	private I18nDAO i18nDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LabelValueVO> selectLabelValueList(@NonNull final Set<ClassPrefix> prefixSet,
			@NonNull final String language) {
		Preconditions.checkArgument(!prefixSet.isEmpty());

		final I18nCriterioVO i18nCriterioVO = new I18nCriterioVO();

		i18nCriterioVO.setPrefixSet(prefixSet);
		i18nCriterioVO.setLanguage(language);

		return i18nDAO.selectLabelValueList(i18nCriterioVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, I18nVO> selectMap(@NonNull final I18nable i18nable) {
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

		i18nCriterioVO.setPrefix(prefix);
		i18nCriterioVO.setExternalId(externalId);

		final Map<String, I18nVO> i18nMap = new HashMap<>();

		for (final I18nVO i18nVO : i18nDAO.selectList(i18nCriterioVO)) {
			i18nMap.put(i18nVO.getLanguage(), i18nVO);
		}

		return i18nMap;
	}
}
