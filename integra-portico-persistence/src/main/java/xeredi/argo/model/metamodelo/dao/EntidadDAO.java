package xeredi.argo.model.metamodelo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.argo.model.metamodelo.vo.EntidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadDAO.
 */
public interface EntidadDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<EntidadVO> selectList(final EntidadCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the entidad VO
	 */
	EntidadVO selectObject(final EntidadCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final EntidadVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final EntidadVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final EntidadVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final EntidadVO vo);

	/**
	 * Select map.
	 *
	 * @param entiCriterio
	 *            the enti criterio
	 * @return the map
	 */
	@MapKey(value = "id")
	Map<Long, EntidadVO> selectMap(final EntidadCriterioVO entiCriterio);
}
