package xeredi.integra.model.maestro.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

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
    boolean intersects(final SubparametroVO sprmVO);

    /**
     * Insert.
     *
     * @param sprmVO
     *            the sprm vo
     */
    void insert(final SubparametroVO sprmVO);

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
     * Select list.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO, final RowBounds bounds);

    /**
     * Select object.
     *
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the subparametro vo
     */
    SubparametroVO selectObject(final SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select id.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the long
     */
    Long selectId(final SubparametroVO sprmVO);
}
