package xeredi.integra.model.estadistica.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstadisticaDatoDAO.
 */
public interface EstadisticaDatoDAO {

    /**
     * Insert.
     *
     * @param itdtVO
     *            the itdt vo
     */
    void insert(final @Nonnull ItemDatoVO itdtVO);

    /**
     * Select list.
     *
     * @param estdCriterioVO
     *            the estd criterio vo
     * @return the list
     */
    List<ItemDatoVO> selectList(final @Nonnull EstadisticaCriterioVO estdCriterioVO);

    /**
     * Delete.
     *
     * @param prprId
     *            the prpr id
     * @return the int
     */
    int delete(final @Nonnull Long prprId);
}
