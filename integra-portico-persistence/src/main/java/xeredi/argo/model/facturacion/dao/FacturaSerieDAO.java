package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.facturacion.vo.FacturaSerieCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaSerieVO;

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
