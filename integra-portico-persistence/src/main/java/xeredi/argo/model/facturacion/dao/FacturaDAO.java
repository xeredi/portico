package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.facturacion.vo.FacturaCriterioVO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaDAO.
 */
public interface FacturaDAO extends CrudDAO<FacturaVO, FacturaCriterioVO> {
    /**
     * Update estado.
     *
     * @param fctr
     *            the fctr
     * @return the int
     */
    int updateEstado(final FacturaVO fctr);

    /**
     * Exists factura posterior.
     *
     * @param fctrId
     *            the fctr id
     * @return true, if successful
     */
    boolean existsFacturaPosterior(final Long fctrId);

    /**
     * Exists valoracion posterior.
     *
     * @param fctrId
     *            the fctr id
     * @return true, if successful
     */
    boolean existsValoracionPosterior(final Long fctrId);
}
