package xeredi.integra.model.dao.facturacion;

import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDAO.
 */
public interface ValoracionDAO {

    /**
     * Insert.
     *
     * @param vlrcVO
     *            the vlrc vo
     */
    void insert(final ValoracionVO vlrcVO);

    /**
     * Insert generate cargos.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     */
    void insertGenerateCargos(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Update recalcular.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the int
     */
    int updateRecalcular(final ValoracionCriterioVO vlrcCriterioVO);
}
