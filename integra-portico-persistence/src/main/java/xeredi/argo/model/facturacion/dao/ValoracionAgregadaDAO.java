package xeredi.argo.model.facturacion.dao;

import java.util.List;

import xeredi.argo.model.facturacion.vo.ValoracionAgregadaVO;
import xeredi.argo.model.facturacion.vo.ValoradorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionAgregadaDAO.
 */
public interface ValoracionAgregadaDAO {

    /**
     * Select list.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the list
     */
    List<ValoracionAgregadaVO> selectList(final ValoradorContextoVO contextoVO);
}
