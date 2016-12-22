package xeredi.argo.model.comun.dao;

import java.util.List;

import lombok.NonNull;
import xeredi.argo.model.comun.vo.ConfigurationCriterioVO;
import xeredi.argo.model.comun.vo.ConfigurationVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigurationDAO.
 */
public interface ConfigurationDAO {

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the configuration VO
	 */
	ConfigurationVO selectObject(final @NonNull ConfigurationCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ConfigurationVO> selectList(final @NonNull ConfigurationCriterioVO criterio);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final @NonNull ConfigurationVO vo);
}
