package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CargoDAO.
 */
public interface CargoDAO {
	/**
	 * Select id.
	 *
	 * @param crgo
	 *            the crgo
	 * @return the long
	 */
	Long selectId(final CargoVO crgo);

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final CargoCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<CargoVO> selectList(final CargoCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<CargoVO> selectList(final CargoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the cargo VO
	 */
	CargoVO selectObject(final CargoCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final CargoVO vo);

	/**
	 * Exists overlap.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean existsOverlap(final CargoVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final CargoVO vo);

	/**
	 * Insert version.
	 *
	 * @param vo
	 *            the vo
	 */
	void insertVersion(final CargoVO vo);

	/**
	 * Update version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int updateVersion(final CargoVO vo);

	/**
	 * Delete version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteVersion(final CargoVO vo);
}
