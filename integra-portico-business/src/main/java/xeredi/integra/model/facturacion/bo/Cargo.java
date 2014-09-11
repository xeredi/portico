package xeredi.integra.model.facturacion.bo;

import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Cargo.
 */
public interface Cargo {

    /**
     * Select list.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<CargoVO> selectList(final CargoCriterioVO crgoCriterioVO, final int offset, final int limit);

    /**
     * Select object.
     *
     * @param crgoCriterioVO
     *            the crgo criterio vo
     * @return the cargo vo
     */
    CargoVO select(final CargoCriterioVO crgoCriterioVO);

    /**
     * Insert.
     *
     * @param crgo
     *            the crgo
     * @throws OverlapException
     *             the overlap exception
     */
    void insert(final CargoVO crgo) throws OverlapException;

    /**
     * Update.
     *
     * @param crgo
     *            the crgo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    void update(final CargoVO crgo) throws InstanceNotFoundException, OverlapException;

    /**
     * Delete.
     *
     * @param crgo
     *            the crgo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final CargoVO crgo) throws InstanceNotFoundException;
}
