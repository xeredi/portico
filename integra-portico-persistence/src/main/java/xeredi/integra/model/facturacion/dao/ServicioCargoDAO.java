package xeredi.integra.model.facturacion.dao;

import javax.annotation.Nonnull;

import xeredi.integra.model.facturacion.vo.ServicioCargoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioCargoDAO.
 */
public interface ServicioCargoDAO {

    /**
     * Insert marcar valorado.
     *
     * @param criterioVO
     *            the criterio vo
     */
    void insertMarcarValorado(final @Nonnull ServicioCargoCriterioVO criterioVO);

    /**
     * Delete valoracion.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int deleteValoracion(final @Nonnull ServicioCargoCriterioVO criterioVO);
}
