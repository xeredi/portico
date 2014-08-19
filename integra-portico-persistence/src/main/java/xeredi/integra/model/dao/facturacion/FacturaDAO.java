package xeredi.integra.model.dao.facturacion;

import xeredi.integra.model.vo.facturacion.FacturaVO;

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
}
