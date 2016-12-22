package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import xeredi.argo.model.metamodelo.vo.CampoAgregacionCriterioVO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CampoAgregacionDAO.
 */
public interface CampoAgregacionDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<CampoAgregacionVO> selectList(final CampoAgregacionCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the campo agregacion VO
	 */
	CampoAgregacionVO selectObject(final CampoAgregacionCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final CampoAgregacionVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final CampoAgregacionVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final CampoAgregacionVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final CampoAgregacionVO vo);
}
