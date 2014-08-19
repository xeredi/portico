package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.FacturaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaImpuestoDAO.
 */
public interface FacturaImpuestoDAO {

    /**
     * Select generate list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list
     */
    List<FacturaImpuestoVO> selectGenerateList(final FacturaCriterioVO fctrCriterioVO);

    /**
     * Insert.
     *
     * @param fcti
     *            the fcti
     */
    void insert(final FacturaImpuestoVO fcti);

    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list< factura impuesto v o>
     */
    List<FacturaImpuestoVO> selectList(final FacturaCriterioVO fctrCriterioVO);
}
