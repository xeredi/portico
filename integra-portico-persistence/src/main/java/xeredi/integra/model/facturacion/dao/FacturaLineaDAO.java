package xeredi.integra.model.facturacion.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.FacturaLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaLineaVO;

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
     * @return the list
     */
    List<FacturaLineaVO> selectPaginatedList(final FacturaLineaCriterioVO fctlCriterioVO, RowBounds bounds);

    /**
     * Select list.
     *
     * @param fctlCriterioVO
     *            the fctl criterio vo
     * @return the list
     */
    List<FacturaLineaVO> selectList(final FacturaLineaCriterioVO fctlCriterioVO);

    /**
     * Select.
     *
     * @param fctlId
     *            the fctl id
     * @return the factura linea vo
     */
    FacturaLineaVO select(final Long fctlId);
}
