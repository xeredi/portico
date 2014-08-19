package xeredi.integra.model.dao.facturacion;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.vo.facturacion.FacturaLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaLineaDAO.
 */
public interface FacturaLineaDAO {

    /**
     * Insert.
     *
     * @param fctl
     *            the fctl
     */
    void insert(final FacturaLineaVO fctl);

    /**
     * Count.
     *
     * @param fctlCriterioVO
     *            the fctl criterio vo
     * @return the int
     */
    int count(final FacturaLineaCriterioVO fctlCriterioVO);

    /**
     * Select list.
     *
     * @param fctlCriterioVO
     *            the fctl criterio vo
     * @param bounds
     *            the bounds
     * @return the list< factura linea v o>
     */
    List<FacturaLineaVO> selectList(final FacturaLineaCriterioVO fctlCriterioVO, RowBounds bounds);

    /**
     * Select list.
     *
     * @param fctlCriterioVO
     *            the fctl criterio vo
     * @return the list< factura linea v o>
     */
    List<FacturaLineaVO> selectList(final FacturaLineaCriterioVO fctlCriterioVO);
}
