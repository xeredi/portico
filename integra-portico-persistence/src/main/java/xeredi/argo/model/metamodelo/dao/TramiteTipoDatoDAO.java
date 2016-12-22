package xeredi.argo.model.metamodelo.dao;

import java.util.List;

import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoCriterioVO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TramiteTipoDatoDAO.
 */
public interface TramiteTipoDatoDAO {

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<TramiteTipoDatoVO> selectList(final TramiteTipoDatoCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the tramite tipo dato VO
	 */
	TramiteTipoDatoVO selectObject(final TramiteTipoDatoCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final TramiteTipoDatoVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final TramiteTipoDatoVO vo);

	/**
	 * Update.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int update(final TramiteTipoDatoVO vo);

	/**
	 * Delete.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int delete(final TramiteTipoDatoVO vo);
}
