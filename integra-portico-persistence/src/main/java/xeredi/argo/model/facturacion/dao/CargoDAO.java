package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CargoDAO.
 */
public interface CargoDAO extends CrudDAO<CargoVO, CargoCriterioVO>, CrudVersionableDAO<CargoVO> {
    /**
     * Select id.
     *
     * @param crgo
     *            the crgo
     * @return the long
     */
    Long selectId(final CargoVO crgo);
}
