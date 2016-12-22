package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import xeredi.argo.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.argo.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodigoReferenciaDAO.
 */
public interface CodigoReferenciaDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<CodigoReferenciaVO> selectList(final CodigoReferenciaCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the codigo referencia VO
	 */
	CodigoReferenciaVO selectObject(final CodigoReferenciaCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final CodigoReferenciaVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final CodigoReferenciaVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final CodigoReferenciaVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final CodigoReferenciaVO vo);

	/**
	 * Delete list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int deleteList(final CodigoReferenciaCriterioVO criterio);
}
