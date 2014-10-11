package xeredi.integra.model.metamodelo.dao;

import java.util.List;
import java.util.Map;

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
    void insert(final TipoDatoVO tpdtVO);

    /**
     * Update.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @return the int
     */
    int update(final TipoDatoVO tpdtVO);

    /**
     * Delete.
     *
     * @param id
     *            the id
     * @return the int
     */
    int delete(final Long id);

    /**
     * Exists.
     *
     * @param tpdtVO
     *            the tpdt vo
     * @return true, if successful
     */
    boolean exists(final TipoDatoVO tpdtVO);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo dato vo
     */
    TipoDatoVO select(final Long id);

    /**
     * Count.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the int
     */
    int count(final TipoDatoCriterioVO tpdtCriterioVO);

    /**
     * Select list.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the list
     */
    List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO);

    /**
     * Select map.
     *
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the map
     */
    @MapKey("id")
    Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterioVO);
}
