package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaIncompatibleDAO.
 */
public interface ReglaIncompatibleDAO extends CrudDAO<ReglaIncompatibleVO, ReglaIncompatibleCriterioVO>,
CrudVersionableDAO<ReglaIncompatibleVO> {

    /**
     * Select id.
     *
     * @param rgin
     *            the rgin
     * @return the long
     */
    Long selectId(final ReglaIncompatibleVO rgin);
}
