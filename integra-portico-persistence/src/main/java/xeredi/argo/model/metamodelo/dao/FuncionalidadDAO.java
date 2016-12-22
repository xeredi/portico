package xeredi.argo.model.metamodelo.dao;

import xeredi.argo.model.metamodelo.vo.FuncionalidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.FuncionalidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FuncionalidadDAO.
 */
public interface FuncionalidadDAO {
	/**
	 * Next sequence.
	 *
	 * @return the long
	 */
	Long nextSequence();

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final FuncionalidadCriterioVO criterio);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final FuncionalidadVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final FuncionalidadVO vo);

}
