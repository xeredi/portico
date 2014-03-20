package xeredi.integra.model.dao.servicio;

import xeredi.integra.model.vo.servicio.ServicioSecuenciaVO;
import xeredi.integra.model.vo.servicio.ServicioVO;

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
    void insert(final ServicioSecuenciaVO srscVO);

    /**
     * Update.
     *
     * @param srscVO
     *            the srsc vo
     * @return the int
     */
    int update(final ServicioSecuenciaVO srscVO);

    /**
     * Delete.
     *
     * @param srscVO
     *            the srsc vo
     * @return the int
     */
    int delete(final ServicioSecuenciaVO srscVO);

    /**
     * Incrementar secuencia.
     *
     * @param srvcVO
     *            the srvc vo
     * @return the int
     */
    int incrementarSecuencia(final ServicioVO srvcVO);

    /**
     * Obtener secuencia.
     *
     * @param srvcVO
     *            the srvc vo
     * @return the integer
     */
    Integer obtenerSecuencia(final ServicioVO srvcVO);

}
