package xeredi.integra.model.facturacion.bo;

import java.util.List;

import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Regla.
 */
public interface Regla {

    /**
     * Select list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ReglaVO> selectList(final ReglaCriterioVO rglaCriterioVO, final int offset, final int limit);

    /**
     * Select list.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the list
     */
    List<ReglaVO> selectList(final ReglaCriterioVO rglaCriterioVO);

    /**
     * Select.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the regla vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ReglaVO select(final ReglaCriterioVO rglaCriterioVO) throws InstanceNotFoundException;

    /**
     * Insert.
     *
     * @param rgla
     *            the rgla
     * @throws OverlapException
     *             the overlap exception
     */
    void insert(final ReglaVO rgla) throws OverlapException;

    /**
     * Update.
     *
     * @param rgla
     *            the rgla
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    void update(final ReglaVO rgla) throws InstanceNotFoundException, OverlapException;

    /**
     * Delete.
     *
     * @param rgla
     *            the rgla
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final ReglaVO rgla) throws InstanceNotFoundException;
}
