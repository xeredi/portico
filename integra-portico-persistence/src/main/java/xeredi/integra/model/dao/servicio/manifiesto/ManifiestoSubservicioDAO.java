package xeredi.integra.model.dao.servicio.manifiesto;

import xeredi.integra.model.vo.servicio.SubservicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ManifiestoSubservicioDAO.
 */
public interface ManifiestoSubservicioDAO {

    /**
     * Update bloquear.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateBloquear(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Update completar.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateCompletar(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Update iniciar.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateIniciar(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Update anular.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateAnular(final SubservicioCriterioVO ssrvCriterioVO);

}
