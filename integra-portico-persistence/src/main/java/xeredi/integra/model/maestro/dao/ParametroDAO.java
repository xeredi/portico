package xeredi.integra.model.maestro.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroTypeaheadCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;

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
    boolean exists(final @Nonnull ParametroVO prmt);

    /**
     * Exists overlap.
     *
     * @param prmt
     *            the prmt
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull ParametroVO prmt);

    /**
     * Select id.
     *
     * @param prmt
     *            the prmt
     * @return the long
     */
    Long selectId(final @Nonnull ParametroVO prmt);

    /**
     * Insert.
     *
     * @param prmt
     *            the prmt
     */
    void insert(final @Nonnull ParametroVO prmt);

    /**
     * Insert version.
     *
     * @param prmt
     *            the prmt
     */
    void insertVersion(final @Nonnull ParametroVO prmt);

    /**
     * Update version.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int updateVersion(final @Nonnull ParametroVO prmt);

    /**
     * Delete version.
     *
     * @param prmt
     *            the prmt
     * @return the int
     */
    int deleteVersion(final @Nonnull ParametroVO prmt);

    /**
     * Select object.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the parametro vo
     */
    ParametroVO selectObject(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the list
     */
    List<ParametroVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select list.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ParametroVO> selectList(final @Nonnull ParametroCriterioVO prmtCriterioVO, final RowBounds bounds);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    @MapKey("parametro")
    Map<String, ParametroVO> selectMapByCodigo(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select map.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the map
     */
    @MapKey("id")
    Map<Long, ParametroVO> selectMap(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Count.
     *
     * @param prmtCriterioVO
     *            the prmt criterio vo
     * @return the int
     */
    int count(final @Nonnull ParametroCriterioVO prmtCriterioVO);

    /**
     * Select lupa list.
     *
     * @param criterio
     *            the criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ParametroVO> selectLupaList(final @Nonnull ParametroTypeaheadCriterioVO criterio,
            final @Nonnull RowBounds bounds);

}
