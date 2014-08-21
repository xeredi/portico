package xeredi.integra.model.dao.facturacion;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.facturacion.FacturaDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaDetalleDAO.
 */
public interface FacturaDetalleDAO {

    /**
     * Insert.
     *
     * @param fctd
     *            the fctd
     */
    void insert(final FacturaDetalleVO fctd);

    /**
     * Select.
     *
     * @param fctdId
     *            the fctd id
     * @return the factura detalle vo
     */
    FacturaDetalleVO select(final Long fctdId);

    /**
     * Count.
     *
     * @param fctdCriterioVO
     *            the fctd criterio vo
     * @return the int
     */
    int count(final FacturaDetalleCriterioVO fctdCriterioVO);

    /**
     * Select list.
     *
     * @param fctdCriterioVO
     *            the fctd criterio vo
     * @return the list< factura detalle v o>
     */
    List<FacturaDetalleVO> selectList(final FacturaDetalleCriterioVO fctdCriterioVO);

    /**
     * Select list.
     *
     * @param fctdCriterioVO
     *            the fctd criterio vo
     * @param bounds
     *            the bounds
     * @return the list< factura detalle v o>
     */
    List<FacturaDetalleVO> selectList(final FacturaDetalleCriterioVO fctdCriterioVO, final RowBounds bounds);
}
