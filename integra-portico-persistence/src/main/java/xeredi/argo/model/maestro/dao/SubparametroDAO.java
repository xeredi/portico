package xeredi.argo.model.maestro.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroDAO.
 */
public interface SubparametroDAO {
	/**
	 * Select id.
	 *
	 * @param sprmVO
	 *            the sprm vo
	 * @return the long
	 */
	Long selectId(final SubparametroVO sprmVO);

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final SubparametroCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final SubparametroVO vo);

	/**
	 * Exists overlap.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean existsOverlap(final SubparametroVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final SubparametroVO vo);

	/**
	 * Insert version.
	 *
	 * @param vo
	 *            the vo
	 */
	void insertVersion(final SubparametroVO vo);

	/**
	 * Update version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int updateVersion(final SubparametroVO vo);

	/**
	 * Delete version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteVersion(final SubparametroVO vo);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the subparametro VO
	 */
	SubparametroVO selectObject(final SubparametroCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<SubparametroVO> selectList(final SubparametroCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<SubparametroVO> selectList(final SubparametroCriterioVO criterio, final RowBounds bounds);
}
