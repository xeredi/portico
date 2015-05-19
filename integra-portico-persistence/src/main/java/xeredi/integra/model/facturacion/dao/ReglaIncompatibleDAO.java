package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.dao.CrudVersionableDAO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;

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
