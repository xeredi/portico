package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.ValoracionAgregadaVO;
import xeredi.integra.model.vo.facturacion.ValoradorContextoVO;

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

    /**
     * Delete temporal list.
     *
     * @param contextoVO
     *            the contexto vo
     * @return the int
     */
    int deleteTemporalList(final ValoradorContextoVO contextoVO);
}
