package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.dao.CrudVersionableDAO;
import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaDAO.
 */
public interface ReglaDAO extends CrudDAO<ReglaVO, ReglaCriterioVO>, CrudVersionableDAO<ReglaVO> {
    /**
     * Select id.
     *
     * @param rgla
     *            the rgla
     * @return the long
     */
    Long selectId(final ReglaVO rgla);
}
