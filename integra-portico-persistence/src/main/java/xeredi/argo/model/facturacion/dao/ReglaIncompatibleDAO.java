package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaIncompatibleDAO.
 */
public interface ReglaIncompatibleDAO {

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the regla incompatible VO
	 */
	ReglaIncompatibleVO selectObject(final ReglaIncompatibleCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ReglaIncompatibleVO> selectList(final ReglaIncompatibleCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final ReglaIncompatibleVO vo);

	/**
	 * Exists overlap.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean existsOverlap(final ReglaIncompatibleVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ReglaIncompatibleVO vo);

	/**
	 * Insert version.
	 *
	 * @param vo
	 *            the vo
	 */
	void insertVersion(final ReglaIncompatibleVO vo);

	/**
	 * Update version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int updateVersion(final ReglaIncompatibleVO vo);

	/**
	 * Delete version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteVersion(final ReglaIncompatibleVO vo);

	/**
	 * Select id.
	 *
	 * @param rgin
	 *            the rgin
	 * @return the long
	 */
	Long selectId(final ReglaIncompatibleVO rgin);
}
