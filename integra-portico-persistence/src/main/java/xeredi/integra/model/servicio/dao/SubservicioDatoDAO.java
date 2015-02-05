package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioDatoDAO.
 */
public interface SubservicioDatoDAO {

    /**
     * Select list.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<ItemDatoVO> selectList(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

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
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int delete(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);
}
