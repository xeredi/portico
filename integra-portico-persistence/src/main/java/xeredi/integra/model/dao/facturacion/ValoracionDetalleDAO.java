package xeredi.integra.model.dao.facturacion;

import xeredi.integra.model.vo.facturacion.ValoracionDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDetalleDAO.
 */
public interface ValoracionDetalleDAO {

    /**
     * Insert.
     *
     * @param vlrdVO
     *            the vlrd vo
     */
    void insert(final ValoracionDetalleVO vlrdVO);

    /**
     * Delete.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @return the int
     */
    int delete(final ValoracionDetalleCriterioVO vlrdCriterioVO);

}
