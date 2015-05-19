package xeredi.integra.model.seguridad.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.seguridad.vo.AccionCriterioVO;
import xeredi.integra.model.seguridad.vo.AccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccionDAO.
 */
public interface AccionDAO extends CrudDAO<AccionVO, AccionCriterioVO> {
    /**
     * Exists.
     *
     * @param accnCriterio
     *            the accn criterio
     * @return true, if successful
     */
    boolean exists(final AccionCriterioVO accnCriterio);
}
