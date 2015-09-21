package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.FacturaAgregadaVO;
import xeredi.argo.model.facturacion.vo.FacturadorContextoVO;

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
     * @return the list
     */
    List<FacturaAgregadaVO> selectList(final FacturadorContextoVO contextoVO);
}
