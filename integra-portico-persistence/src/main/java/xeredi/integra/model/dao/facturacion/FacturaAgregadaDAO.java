package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.FacturaAgregadaVO;
import xeredi.integra.model.vo.facturacion.FacturadorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacturaAgregadaDAO.
 */
public interface FacturaAgregadaDAO {

    /**
     * Select list.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list< factura agregada v o>
     */
    List<FacturaAgregadaVO> selectList(final FacturadorContextoVO contextoVO);
}
