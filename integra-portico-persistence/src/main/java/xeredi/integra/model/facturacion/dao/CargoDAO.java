package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.dao.CrudVersionableDAO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

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
