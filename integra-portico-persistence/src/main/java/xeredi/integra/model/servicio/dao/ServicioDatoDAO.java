package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.servicio.vo.ServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioDatoDAO.
 */
public interface ServicioDatoDAO {

    /**
     * Select list.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the list
     */
    List<ItemDatoVO> selectList(final @Nonnull ServicioCriterioVO srvcCriterioVO);

    /**
     * Insert.
     *
     * @param itdtVO
     *            the itdt vo
     */
    void insert(final @Nonnull ItemDatoVO itdtVO);

    /**
     * Update.
     *
     * @param itdtVO
     *            the itdt vo
     * @return the int
     */
    int update(final @Nonnull ItemDatoVO itdtVO);

    /**
     * Delete.
     *
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the int
     */
    int delete(final @Nonnull ServicioCriterioVO srvcCriterioVO);
}
