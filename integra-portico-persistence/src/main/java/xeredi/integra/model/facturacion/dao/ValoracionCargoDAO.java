package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionCargoDAO.
 */
public interface ValoracionCargoDAO {
    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionCargoVO> selectList(final ValoracionCriterioVO vlrcCriterioVO);
}
