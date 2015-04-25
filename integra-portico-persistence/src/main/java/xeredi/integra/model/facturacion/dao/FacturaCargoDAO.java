package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.FacturaCargoVO;
import xeredi.integra.model.facturacion.vo.FacturaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaCargoDAO.
 */
public interface FacturaCargoDAO {
    /**
     * Select list.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @return the list
     */
    List<FacturaCargoVO> selectList(final FacturaCriterioVO fctrCriterioVO);
}
