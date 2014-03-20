package xeredi.integra.model.dao.metamodelo;

import java.util.List;

import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoCriterioVO;
import xeredi.integra.model.vo.metamodelo.EntidadTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametroTipoDatoDAO.
 */
public interface EntidadTipoDatoDAO {

	/**
	 * Exists.
	 *
	 * @param entdVO
	 *            the entd vo
	 * @return true, if successful
	 */
	boolean exists(final EntidadTipoDatoVO entdVO);

	/**
	 * Insert.
	 *
	 * @param entdVO
	 *            the entd vo
	 */
	void insert(final EntidadTipoDatoVO entdVO);

	/**
	 * Update.
	 *
	 * @param entdVO
	 *            the entd vo
	 * @return the int
	 */
	int update(final EntidadTipoDatoVO entdVO);

	/**
	 * Delete.
	 *
	 * @param entdCriterioVO
	 *            the entd criterio vo
	 * @return the int
	 */
	int deleteCriterio(final EntidadTipoDatoCriterioVO entdCriterioVO);

	/**
	 * Select all.
	 *
	 * @return the list
	 */
	List<EntidadTipoDatoVO> selectAll();

	/**
	 * Select criterio.
	 *
	 * @param entdCriterioVO
	 *            the entd criterio vo
	 * @return the list
	 */
	List<EntidadTipoDatoVO> selectList(
			final EntidadTipoDatoCriterioVO entdCriterioVO);

	/**
	 * Select object.
	 *
	 * @param entdCriterioVO
	 *            the entd criterio vo
	 * @return the entidad tipo dato vo
	 */
	EntidadTipoDatoVO selectObject(
			final EntidadTipoDatoCriterioVO entdCriterioVO);
}
