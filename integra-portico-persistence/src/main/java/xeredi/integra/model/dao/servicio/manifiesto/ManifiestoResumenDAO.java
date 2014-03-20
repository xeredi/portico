package xeredi.integra.model.dao.servicio.manifiesto;

import xeredi.integra.model.vo.servicio.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.vo.servicio.manifiesto.ResumenTotalesVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ManifiestoTotalDAO.
 */
public interface ManifiestoResumenDAO {

    /**
     * Select object.
     * 
     * @param criterioVO
     *            the criterio vo
     * @return the manifiesto total vo
     */
    ResumenTotalesVO selectObject(final ResumenTotalesCriterioVO criterioVO);
}
