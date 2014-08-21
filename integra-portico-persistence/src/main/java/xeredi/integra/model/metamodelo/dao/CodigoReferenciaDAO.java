package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.CodigoReferenciaCriterioVO;
import xeredi.integra.model.metamodelo.vo.CodigoReferenciaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CodigoReferenciaDAO.
 */
public interface CodigoReferenciaDAO {

	/**
	 * Select criterio.
	 *
	 * @param cdrfCriterioVO
	 *            the cdrf criterio vo
	 * @return the list
	 */
	List<CodigoReferenciaVO> selectList(
			final CodigoReferenciaCriterioVO cdrfCriterioVO);

	/**
	 * Select object.
	 *
	 * @param cdrfCriterioVO
	 *            the cdrf criterio vo
	 * @return the codigo referencia vo
	 */
	CodigoReferenciaVO selectObject(
			final CodigoReferenciaCriterioVO cdrfCriterioVO);

	/**
	 * Exists.
	 *
	 * @param cdrfVO
	 *            the cdrf vo
	 * @return true, if successful
	 */
	boolean exists(final CodigoReferenciaVO cdrfVO);

	/**
	 * Insert.
	 *
	 * @param cdrfVO
	 *            the cdrf vo
	 */
	void insert(final CodigoReferenciaVO cdrfVO);

	/**
	 * Update.
	 *
	 * @param cdrfVO
	 *            the cdrf vo
	 * @return the int
	 */
	int update(final CodigoReferenciaVO cdrfVO);

	/**
	 * Delete.
	 *
	 * @param cdrfVO
	 *            the cdrf vo
	 * @return the int
	 */
	int delete(final CodigoReferenciaVO cdrfVO);
}
