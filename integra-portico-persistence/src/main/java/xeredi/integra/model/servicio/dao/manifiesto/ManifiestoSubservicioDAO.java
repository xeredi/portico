package xeredi.integra.model.servicio.dao.manifiesto;

import javax.annotation.Nonnull;

import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;

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
    int updateBloquear(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Update completar.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateCompletar(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Update iniciar.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateIniciar(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Update anular.
     *
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the int
     */
    int updateAnular(final @Nonnull SubservicioCriterioVO ssrvCriterioVO);

}
