package xeredi.integra.model.maestro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParametroDAO.
 */
public interface ParametroDAO {

    /**
     * Exists.
     *
     * @param prmt
     *            the prmt
     * @return true, if successful
     */
    boolean exists(final ParametroVO prmt);

    /**
     * Exists overlap.
     *
     * @param prmt
     *            the prmt
     * @return true, if successful
     */
    boolean existsOverlap(final ParametroVO prmt);

    /**
     * Select id.
     *
     * @param prmt
     *            the prmt
     * @return the long
     */
    Long selectId(final ParametroVO prmt);

    /**
     * Insert.
     *
     * @param prmt
     *            the prmt
     */
    void insert(final ParametroVO prmt);

    /**
     * Insert version.
     *
     * @param prmt
     *            the prmt
     */
    void insertVersion(final ParametroVO prmt);

    /**
     * Update version.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int updateVersion(final ParametroVO prmt);

    /**
     * Delete version.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int deleteVersion(final ParametroVO prmt);

    /**
     * Select object.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the parametro vo
     */
    ParametroVO selectObject(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ParametroVO> selectList(final ParametroCriterioVO prmtCriterioVO, final RowBounds bounds);

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
     * Count.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the int
     */
    int count(final ParametroCriterioVO prmtCriterioVO);

    /**
     * Select typeahead sprm list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ParametroVO> selectSprmList(final SubparametroCriterioVO criterio, final RowBounds bounds);
}
