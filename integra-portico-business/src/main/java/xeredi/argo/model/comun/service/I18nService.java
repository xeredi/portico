package xeredi.argo.model.comun.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.I18nVO;
import xeredi.argo.model.comun.vo.I18nable;
import xeredi.argo.model.comun.vo.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface I18nService.
 */
public interface I18nService {
	/**
	 * Select label value list.
	 *
	 * @param prefixSet
	 *            the prefix set
	 * @param language
	 *            the language
	 * @return the list
	 */
	List<LabelValueVO> selectLabelValueList(@NonNull final Set<ClassPrefix> prefixSet, @NonNull final String language);

	/**
	 * Select map.
	 *
	 * @param i18nable
	 *            the i 18 nable
	 * @return the map
	 */
	Map<String, I18nVO> selectMap(@NonNull final I18nable i18nable);
}
