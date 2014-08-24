package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.facturacion.vo.FacturaSerieVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaSerieDAO.
 */
public interface FacturaSerieDAO {

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the factura serie vo
     */
    FacturaSerieVO select(final Long id);

    /**
     * Update incrementar.
     *
     * @param id
     *            the id
     * @return the int
     */
    int updateIncrementar(final Long id);
}