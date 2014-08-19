package xeredi.integra.model.dao.facturacion;

import xeredi.integra.model.vo.facturacion.ServicioCargoCriterioVO;

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