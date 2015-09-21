package xeredi.argo.model.servicio.dao.manifiesto;

import xeredi.argo.model.servicio.vo.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BlDAO.
 */
public interface BlDAO {

    /**
     * Update recalcular estado.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int updateRecalcularEstado(final SubservicioCriterioVO criterioVO);

    /**
     * Update recalcular tipo iva.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the int
     */
    int updateRecalcularTipoIva(final SubservicioCriterioVO criterioVO);
}
