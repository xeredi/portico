package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.facturacion.vo.ServicioCargoCriterioVO;

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
    void insertMarcarValorado(final ServicioCargoCriterioVO criterioVO);

    /**
     * Delete valoracion.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int deleteValoracion(final ServicioCargoCriterioVO criterioVO);
}