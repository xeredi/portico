package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.ValoracionAgregadaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionAgregadaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionAgregadaDAO.
 */
public interface ValoracionAgregadaDAO {

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<ValoracionAgregadaVO> selectList(final ValoracionAgregadaCriterioVO criterioVO);

    /**
     * Delete temporal list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int deleteTemporalList(final ValoracionAgregadaCriterioVO criterioVO);
}
