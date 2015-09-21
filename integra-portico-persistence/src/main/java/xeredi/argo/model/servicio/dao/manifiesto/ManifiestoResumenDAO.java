package xeredi.argo.model.servicio.dao.manifiesto;

import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesCriterioVO;
import xeredi.argo.model.servicio.vo.manifiesto.ResumenTotalesVO;

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
