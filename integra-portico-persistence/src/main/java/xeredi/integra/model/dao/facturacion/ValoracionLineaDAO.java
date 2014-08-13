package xeredi.integra.model.dao.facturacion;

import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionLineaDAO.
 */
public interface ValoracionLineaDAO {

    /**
     * Insert.
     *
     * @param vlrlVO
     *            the vlrl vo
     */
    void insert(final ValoracionLineaVO vlrlVO);

    /**
     * Delete.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the int
     */
    int delete(final ValoracionLineaCriterioVO vlrlCriterioVO);

}
