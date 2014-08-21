package xeredi.integra.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaDAO.
 */
public interface FacturaDAO {

    /**
     * Insert.
     *
     * @param fctr
     *            the fctr
     */
    void insert(final FacturaVO fctr);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the factura vo
     */
    FacturaVO select(final Long id);

    /**
     * Count.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the int
     */
    int count(final FacturaCriterioVO fctrCriterioVO);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @param bounds
     *            the bounds
     * @return the list< factura v o>
     */
    List<FacturaVO> selectList(final FacturaCriterioVO fctrCriterioVO, final RowBounds bounds);
}
