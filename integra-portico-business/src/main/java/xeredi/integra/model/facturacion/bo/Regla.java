package xeredi.integra.model.facturacion.bo;

import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;
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
     * Select.
     *
     * @param rglaCriterioVO
     *            the rgla criterio vo
     * @return the regla vo
     */
    ReglaVO select(final ReglaCriterioVO rglaCriterioVO);
}
