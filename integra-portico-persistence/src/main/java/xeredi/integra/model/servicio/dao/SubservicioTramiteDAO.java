package xeredi.integra.model.servicio.dao;

import java.util.List;

import xeredi.integra.model.servicio.vo.ServicioTramiteVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioTramiteVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubservicioTramiteDAO.
 */
public interface SubservicioTramiteDAO {
    /**
     * Insert.
     *
     * @param sstr
     *            the sstr
     */
    void insert(final SubservicioTramiteVO sstr);

    /**
     * Select object.
     *
     * @param criterio
     *            the criterio
     * @return the subservicio tramite vo
     */
    SubservicioTramiteVO selectObject(final SubservicioTramiteCriterioVO criterio);

    /**
     * Select list.
     *
     * @param criterio
     *            the criterio
     * @return the list
     */
    List<ServicioTramiteVO> selectList(final SubservicioTramiteCriterioVO criterio);

    /**
     * Delete list.
     *
     * @param criterio
     *            the criterio
     * @return the int
     */
    int deleteList(final SubservicioTramiteCriterioVO criterio);
}
