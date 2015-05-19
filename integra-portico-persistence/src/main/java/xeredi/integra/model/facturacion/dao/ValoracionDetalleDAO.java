package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDetalleDAO.
 */
public interface ValoracionDetalleDAO extends CrudDAO<ValoracionDetalleVO, ValoracionDetalleCriterioVO> {
    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion detalle vo
     */
    ValoracionDetalleVO select(final Long id);
}
