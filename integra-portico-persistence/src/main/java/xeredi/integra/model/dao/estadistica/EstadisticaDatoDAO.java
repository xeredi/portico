package xeredi.integra.model.dao.estadistica;

import java.util.List;

import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.estadistica.EstadisticaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDatoDAO.
 */
public interface EstadisticaDatoDAO {

    /**
     * Insert.
     *
     * @param itdtVO the itdt vo
     */
    void insert(final ItemDatoVO itdtVO);

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    List<ItemDatoVO> selectList(final EstadisticaCriterioVO estdCriterioVO);

    /**
     * Delete.
     *
     * @param prprId
     *            the prpr id
     * @return the int
     */
    int delete(final Long prprId);
}
