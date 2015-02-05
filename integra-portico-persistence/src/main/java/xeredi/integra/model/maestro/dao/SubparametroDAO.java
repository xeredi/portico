package xeredi.integra.model.maestro.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroDAO.
 */
public interface SubparametroDAO {

    /**
     * Exists.
     *
     * @param sprmVO
     *            the sprm vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull SubparametroVO sprmVO);

    /**
     * Intersects.
     *
     * @param sprmVO
     *            the sprm vo
     * @return true, if successful
     */
    boolean existsOverlap(final @Nonnull SubparametroVO sprmVO);

    /**
     * Select id.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the long
     */
    Long selectId(final @Nonnull SubparametroVO sprmVO);

    /**
     * Insert.
     *
     * @param sprmVO
     *            the sprm vo
     */
    void insert(final @Nonnull SubparametroVO sprmVO);

    /**
     * Insert version.
     *
     * @param sprmVO
     *            the sprm vo
     */
    void insertVersion(final @Nonnull SubparametroVO sprmVO);

    /**
     * Update version.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the int
     */
    int updateVersion(final @Nonnull SubparametroVO sprmVO);

    /**
     * Delete version.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the int
     */
    int deleteVersion(final @Nonnull SubparametroVO sprmVO);

    /**
     * Count.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the int
     */
    int selectCount(final @Nonnull SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    List<SubparametroVO> selectList(final @Nonnull SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select paginated list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    List<SubparametroVO> selectPaginatedList(final @Nonnull SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select object.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the subparametro vo
     */
    SubparametroVO selectObject(final @Nonnull SubparametroCriterioVO sprmCriterioVO);
}
