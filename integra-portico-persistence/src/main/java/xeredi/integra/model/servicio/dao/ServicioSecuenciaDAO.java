package xeredi.integra.model.servicio.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioSecuenciaVO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioSecuenciaDAO.
 */
public interface ServicioSecuenciaDAO extends CrudDAO<ServicioSecuenciaVO, ServicioSecuenciaCriterioVO> {
    /**
     * Incrementar secuencia.
     *
     * @param srvc
     *            the srvc
     * @return the int
     */
    int incrementarSecuencia(final ServicioVO srvc);

    /**
     * Obtener secuencia.
     *
     * @param srvc
     *            the srvc
     * @return the integer
     */
    Integer obtenerSecuencia(final ServicioVO srvc);
}
