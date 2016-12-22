package xeredi.argo.model.comun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PuertoDAO.
 */
public interface PuertoDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final PuertoCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<PuertoVO> selectList(final PuertoCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<PuertoVO> selectList(final PuertoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the puerto VO
	 */
	PuertoVO selectObject(final PuertoCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final PuertoVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final PuertoVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final PuertoVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final PuertoVO vo);
}
