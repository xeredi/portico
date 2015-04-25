package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionImpuestoDAO.
 */
public interface ValoracionImpuestoDAO {
    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionImpuestoVO> selectList(final ValoracionCriterioVO vlrcCriterioVO);
}
