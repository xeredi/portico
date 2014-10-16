package xeredi.integra.model.maestro.dao;

import java.util.List;

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
    boolean exists(final SubparametroVO sprmVO);

    /**
     * Intersects.
     *
     * @param sprmVO
     *            the sprm vo
     * @return true, if successful
     */
    boolean existsOverlap(final SubparametroVO sprmVO);

    /**
     * Select id.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the long
     */
    Long selectId(final SubparametroVO sprmVO);

    /**
     * Insert.
     *
     * @param sprmVO
     *            the sprm vo
     */
    void insert(final SubparametroVO sprmVO);

    /**
     * Insert version.
     *
     * @param sprmVO
     *            the sprm vo
     */
    void insertVersion(final SubparametroVO sprmVO);

    /**
     * Update version.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the int
     */
    int updateVersion(final SubparametroVO sprmVO);

    /**
     * Delete version.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the int
     */
    int deleteVersion(final SubparametroVO sprmVO);

    /**
     * Count.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the int
     */
    int selectCount(final SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select paginated list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    List<SubparametroVO> selectPaginatedList(final SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select object.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the subparametro vo
     */
    SubparametroVO selectObject(final SubparametroCriterioVO sprmCriterioVO);
}
