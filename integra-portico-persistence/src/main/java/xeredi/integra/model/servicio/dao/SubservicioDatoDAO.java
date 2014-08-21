package xeredi.integra.model.servicio.dao;

import java.util.List;

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
    List<ItemDatoVO> selectList(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Insert.
     *
     * @param itdtVO
     *            the itdt vo
     */
    void insert(final ItemDatoVO itdtVO);

    /**
     * Update.
     *
     * @param itdtVO
     *            the itdt vo
     * @return the int
     */
    int update(final ItemDatoVO itdtVO);

    /**
     * Delete.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int delete(final SubservicioCriterioVO ssrvCriterioVO);
}
