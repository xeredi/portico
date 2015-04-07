package xeredi.integra.model.servicio.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.servicio.vo.ServicioSecuenciaCriterioVO;
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
     * @param srsc
     *            the srsc
     */
    void insert(final @Nonnull ServicioSecuenciaVO srsc);

    /**
     * Update.
     *
     * @param srsc
     *            the srsc
     * @return the int
     */
    int update(final @Nonnull ServicioSecuenciaVO srsc);

    /**
     * Delete.
     *
     * @param srsc
     *            the srsc
     * @return the int
     */
    int delete(final @Nonnull ServicioSecuenciaVO srsc);

    /**
     * Incrementar secuencia.
     *
     * @param srvc
     *            the srvc
     * @return the int
     */
    int incrementarSecuencia(final @Nonnull ServicioVO srvc);

    /**
     * Obtener secuencia.
     *
     * @param srvc
     *            the srvc
     * @return the integer
     */
    Integer obtenerSecuencia(final @Nonnull ServicioVO srvc);

    /**
     * Count.
     *
     * @param srscCriterio
     *            the srsc criterio
     * @return the int
     */
    int count(final ServicioSecuenciaCriterioVO srscCriterio);

    /**
     * Select list.
     *
     * @param srscCriterio
     *            the srsc criterio
     * @return the list
     */
    List<ServicioSecuenciaVO> selectList(final ServicioSecuenciaCriterioVO srscCriterio);

    /**
     * Select list.
     *
     * @param srscCriterio
     *            the srsc criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ServicioSecuenciaVO> selectList(final ServicioSecuenciaCriterioVO srscCriterio, final RowBounds bounds);

    /**
     * Select object.
     *
     * @param srscCriterio
     *            the srsc criterio
     * @return the servicio secuencia vo
     */
    ServicioSecuenciaVO selectObject(final ServicioSecuenciaCriterioVO srscCriterio);

    /**
     * Exists.
     *
     * @param srsc
     *            the srsc
     * @return true, if successful
     */
    boolean exists(final ServicioSecuenciaVO srsc);
}
