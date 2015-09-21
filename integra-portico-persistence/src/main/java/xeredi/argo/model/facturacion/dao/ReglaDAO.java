package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.facturacion.vo.ReglaCriterioVO;
import xeredi.argo.model.facturacion.vo.ReglaVO;

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
