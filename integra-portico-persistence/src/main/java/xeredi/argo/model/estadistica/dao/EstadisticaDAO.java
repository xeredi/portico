package xeredi.argo.model.estadistica.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.argo.model.estadistica.vo.EstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDAO.
 */
public interface EstadisticaDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final EstadisticaCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<EstadisticaVO> selectList(final EstadisticaCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<EstadisticaVO> selectList(final EstadisticaCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the estadistica VO
	 */
	EstadisticaVO selectObject(final EstadisticaCriterioVO criterio);

	void insert(final EstadisticaVO vo);

	int deleteList(final EstadisticaCriterioVO criterio);
}
