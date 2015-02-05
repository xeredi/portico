package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionCargoDAO.
 */
public interface ValoracionCargoDAO {

    /**
     * Insert generate.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     */
    void insertGenerate(final @Nonnull ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Delete.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the int
     */
    int delete(final @Nonnull ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionCargoVO> selectList(final @Nonnull ValoracionCriterioVO vlrcCriterioVO);
}
