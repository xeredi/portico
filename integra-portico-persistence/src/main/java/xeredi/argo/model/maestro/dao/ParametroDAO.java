package xeredi.argo.model.maestro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDAO.
 */
public interface ParametroDAO {

	/**
	 * Select id.
	 *
	 * @param prmt
	 *            the prmt
	 * @return the long
	 */
	Long selectId(final ParametroVO prmt);

	/**
	 * Select map.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the map
	 */
	@MapKey("parametro")
	Map<String, ParametroVO> selectMapByCodigo(final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select map.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio vo
	 * @return the map
	 */
	@MapKey("id")
	Map<Long, ParametroVO> selectMap(final ParametroCriterioVO prmtCriterioVO);

	/**
	 * Select typeahead list.
	 *
	 * @param prmtCriterioVO
	 *            the prmt criterio VO
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ParametroVO> selectTypeaheadList(final ParametroCriterioVO prmtCriterioVO, final RowBounds bounds);

	/**
	 * Count.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the int
	 */
	int count(final ParametroCriterioVO criterio);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @param bounds
	 *            the bounds
	 * @return the list
	 */
	List<ParametroVO> selectList(final ParametroCriterioVO criterio, final RowBounds bounds);

	/**
	 * Select list.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the list
	 */
	List<ParametroVO> selectList(final ParametroCriterioVO criterio);

	/**
	 * Select object.
	 *
	 * @param criterio
	 *            the criterio
	 * @return the parametro VO
	 */
	ParametroVO selectObject(final ParametroCriterioVO criterio);

	/**
	 * Exists.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean exists(final ParametroVO vo);

	/**
	 * Exists overlap.
	 *
	 * @param vo
	 *            the vo
	 * @return true, if successful
	 */
	boolean existsOverlap(final ParametroVO vo);

	/**
	 * Insert.
	 *
	 * @param vo
	 *            the vo
	 */
	void insert(final ParametroVO vo);

	/**
	 * Insert version.
	 *
	 * @param vo
	 *            the vo
	 */
	void insertVersion(final ParametroVO vo);

	/**
	 * Update version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int updateVersion(final ParametroVO vo);

	/**
	 * Delete version.
	 *
	 * @param vo
	 *            the vo
	 * @return the int
	 */
	int deleteVersion(final ParametroVO vo);
}
