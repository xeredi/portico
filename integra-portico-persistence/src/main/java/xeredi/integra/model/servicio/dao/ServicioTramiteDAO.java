package xeredi.integra.model.servicio.dao;

import java.util.List;

import xeredi.integra.model.servicio.vo.ServicioTramiteCriterioVO;
import xeredi.integra.model.servicio.vo.ServicioTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ServicioTramiteDAO.
 */
public interface ServicioTramiteDAO {

    /**
     * Insert.
     *
     * @param srtr
     *            the srtr
     */
    void insert(final ServicioTramiteVO srtr);

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the servicio tramite vo
     */
    ServicioTramiteVO selectObject(final ServicioTramiteCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<ServicioTramiteVO> selectList(final ServicioTramiteCriterioVO criterio);

    /**
     * Delete list.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int deleteList(final ServicioTramiteCriterioVO criterio);
}
