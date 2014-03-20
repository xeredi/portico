package xeredi.integra.model.dao.servicio;

import java.util.List;

import xeredi.integra.model.vo.comun.ItemDatoVO;
import xeredi.integra.model.vo.servicio.ServicioCriterioVO;

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
    List<ItemDatoVO> selectList(final ServicioCriterioVO srvcCriterioVO);

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
     * @param srvcCriterioVO
     *            the srvc criterio vo
     * @return the int
     */
    int delete(final ServicioCriterioVO srvcCriterioVO);
}
