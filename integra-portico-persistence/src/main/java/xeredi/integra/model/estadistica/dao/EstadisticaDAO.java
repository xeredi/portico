package xeredi.integra.model.estadistica.dao;

import java.util.List;

import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDAO.
 */
public interface EstadisticaDAO {

    /**
     * Insert.
     *
     * @param estdVO
     *            the estd vo
     */
    void insert(final EstadisticaVO estdVO);

    /**
     * Count.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the int
     */
    int selectCount(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    List<EstadisticaVO> selectList(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select paginated list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    List<EstadisticaVO> selectPaginatedList(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select object.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the estadistica vo
     */
    EstadisticaVO selectObject(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Delete.
     *
     * @param prprId
     *            the prpr id
     * @return the int
     */
    int delete(final Long prprId);
}
