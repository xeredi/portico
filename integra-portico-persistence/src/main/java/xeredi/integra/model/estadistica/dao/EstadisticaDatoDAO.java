package xeredi.integra.model.estadistica.dao;

import java.util.List;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDatoDAO.
 */
public interface EstadisticaDatoDAO {

    /**
     * Select list.
     *
     * @param estdCriterio
     *            the estd criterio
     * @return the list
     */
    List<ItemDatoVO> selectList(final EstadisticaCriterioVO estdCriterio);

    /**
     * Insert.
     *
     * @param itdt
     *            the itdt
     */
    void insert(final ItemDatoVO itdt);

    /**
     * Delete.
     *
     * @param estdCriterio
     *            the estd criterio
     * @return the int
     */
    int deleteList(final EstadisticaCriterioVO estdCriterio);
}
