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
     * Generacion de los impuestos de una valoracion a partir de sus lineas.
     *
     * @param vlrcCriterioVO
     *            Criterio de busqueda de valoraciones.
     * @return the list
     */
    List<ValoracionImpuestoVO> selectGenerateList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Insert.
     *
     * @param vlriVO
     *            the vlri vo
     */
    void insert(final ValoracionImpuestoVO vlriVO);

    /**
     * Delete.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the int
     */
    int delete(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionImpuestoVO> selectList(final ValoracionCriterioVO vlrcCriterioVO);
}
