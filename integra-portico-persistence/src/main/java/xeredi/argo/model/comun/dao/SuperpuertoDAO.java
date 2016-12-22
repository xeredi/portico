package xeredi.argo.model.comun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SuperpuertoDAO.
 */
public interface SuperpuertoDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final SuperpuertoCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<SuperpuertoVO> selectList(final SuperpuertoCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<SuperpuertoVO> selectList(final SuperpuertoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the superpuerto VO
	 */
	SuperpuertoVO selectObject(final SuperpuertoCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final SuperpuertoVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final SuperpuertoVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final SuperpuertoVO vo);
}
