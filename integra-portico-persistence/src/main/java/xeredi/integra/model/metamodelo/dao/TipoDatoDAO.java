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
     * @param tpdt
     *            the tpdt
     */
    void insert(final TipoDatoVO tpdt);

    /**
     * Update.
     *
     * @param tpdt
     *            the tpdt
     * @return the int
     */
    int update(final TipoDatoVO tpdt);

    /**
     * Delete.
     *
     * @param tpdt
     *            the tpdt
     * @return the int
     */
    int delete(final TipoDatoVO tpdt);

    /**
     * Exists.
     *
     * @param tpdt
     *            the tpdt
     * @return true, if successful
     */
    boolean exists(final TipoDatoVO tpdt);

    /**
     * Select object.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the tipo dato vo
     */
    TipoDatoVO selectObject(final TipoDatoCriterioVO tpdtCriterio);

    /**
     * Count.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the int
     */
    int count(final TipoDatoCriterioVO tpdtCriterio);

    /**
     * Select list.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoDatoVO> selectPaginatedList(final TipoDatoCriterioVO tpdtCriterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the list
     */
    List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterio);

    /**
     * Select map.
     *
     * @param tpdtCriterio
     *            the tpdt criterio
     * @return the map
     */
    @MapKey("id")
    Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterio);
}
