package xeredi.integra.model.estadistica.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    void insert(final @Nonnull EstadisticaVO estdVO);

    /**
     * Count.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the int
     */
    int selectCount(final @Nonnull EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    List<EstadisticaVO> selectList(final @Nonnull EstadisticaCriterioVO estdCriterioVO);

    /**
     * Select object.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the estadistica vo
     */
    EstadisticaVO selectObject(final @Nonnull EstadisticaCriterioVO estdCriterioVO);

    /**
     * Delete.
     *
     * @param prprId
     *            the prpr id
     * @return the int
     */
    int delete(final @Nonnull Long prprId);
}
