package xeredi.integra.model.facturacion.bo;

import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;
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
}
