package xeredi.integra.model.servicio.dao;

import javax.annotation.Nonnull;

import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioSecuenciaDAO.
 */
public interface ServicioSecuenciaDAO {

    /**
     * Insert.
     *
     * @param srscVO
     *            the srsc vo
     */
    void insert(final @Nonnull ServicioSecuenciaVO srscVO);

    /**
     * Update.
     *
     * @param srscVO
     *            the srsc vo
     * @return the int
     */
    int update(final @Nonnull ServicioSecuenciaVO srscVO);

    /**
     * Delete.
     *
     * @param srscVO
     *            the srsc vo
     * @return the int
     */
    int delete(final @Nonnull ServicioSecuenciaVO srscVO);

    /**
     * Incrementar secuencia.
     *
     * @param srvcVO
     *            the srvc vo
     * @return the int
     */
    int incrementarSecuencia(final @Nonnull ServicioVO srvcVO);

    /**
     * Obtener secuencia.
     *
     * @param srvcVO
     *            the srvc vo
     * @return the integer
     */
    Integer obtenerSecuencia(final @Nonnull ServicioVO srvcVO);

}
