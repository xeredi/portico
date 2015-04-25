package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaImpuestoDAO.
 */
public interface FacturaImpuestoDAO {
    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list
     */
    List<FacturaImpuestoVO> selectList(final FacturaCriterioVO fctrCriterioVO);
}
