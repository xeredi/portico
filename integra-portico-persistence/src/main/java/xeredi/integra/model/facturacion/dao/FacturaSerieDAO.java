package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaSerieDAO.
 */
public interface FacturaSerieDAO extends CrudDAO<FacturaSerieVO, FacturaSerieCriterioVO> {
    /**
     * Update incrementar.
     *
     * @param id
     *            the id
     * @return the int
     */
    int updateIncrementar(final Long id);
}
