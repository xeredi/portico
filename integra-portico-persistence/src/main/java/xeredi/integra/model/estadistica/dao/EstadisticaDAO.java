package xeredi.integra.model.estadistica.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDAO.
 */
public interface EstadisticaDAO {

    /**
     * Count.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the int
     */
    int count(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    List<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO, final RowBounds bounds);

    /**
     * Select object.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the estadistica vo
     */
    EstadisticaVO selectObject(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Insert.
     *
     * @param estdVO
     *            the estd vo
     */
    void insert(final EstadisticaVO estdVO);

    /**
     * Delete.
     *
     * @param estdCriterio
     *            the estd criterio
     * @return the int
     */
    int deleteList(final EstadisticaCriterioVO estdCriterio);
}
