package xeredi.integra.model.metamodelo.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoDatoDAO.
 */
public interface TipoDatoDAO {

    /**
     * Next sequence.
     *
     * @return the long
     */
    Long nextSequence();

    /**
     * Insert.
     *
     * @param tpdtVO
     *            the tpdt vo
     */
    void insert(final @Nonnull TipoDatoVO tpdtVO);

    /**
     * Update.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @return the int
     */
    int update(final @Nonnull TipoDatoVO tpdtVO);

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @return the int
     */
    int delete(final @Nonnull Long id);

    /**
     * Exists.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @return true, if successful
     */
    boolean exists(final @Nonnull TipoDatoVO tpdtVO);

    /**
     * Select object.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the tipo dato vo
     */
    TipoDatoVO selectObject(final @Nonnull TipoDatoCriterioVO tpdtCriterioVO);

    /**
     * Count.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the int
     */
    int count(final @Nonnull TipoDatoCriterioVO tpdtCriterioVO);

    /**
     * Select list.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoDatoVO> selectPaginatedList(final @Nonnull TipoDatoCriterioVO tpdtCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select list.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the list
     */
    List<TipoDatoVO> selectList(final @Nonnull TipoDatoCriterioVO tpdtCriterioVO);

    /**
     * Select map.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the map
     */
    @MapKey("id")
    Map<Long, TipoDatoVO> selectMap(final @Nonnull TipoDatoCriterioVO tpdtCriterioVO);
}
