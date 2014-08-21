package xeredi.integra.model.servicio.dao.manifiesto;

import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;

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
