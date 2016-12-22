package xeredi.argo.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaDAO.
 */
public interface ReglaDAO {

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ReglaCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ReglaVO> selectList(final ReglaCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ReglaVO> selectList(final ReglaCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the regla VO
	 */
	ReglaVO selectObject(final ReglaCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final ReglaVO vo);

	/**
	 * Exists overlap.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean existsOverlap(final ReglaVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ReglaVO vo);

	/**
	 * Insert version.
	 *
	 * @param vo
	 *            the vo
	 */
	void insertVersion(final ReglaVO vo);

	/**
	 * Update version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int updateVersion(final ReglaVO vo);

	/**
	 * Delete version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteVersion(final ReglaVO vo);

	/**
	 * Select id.
	 *
	 * @param rgla
	 *            the rgla
	 * @return the long
	 */
	Long selectId(final ReglaVO rgla);
}
