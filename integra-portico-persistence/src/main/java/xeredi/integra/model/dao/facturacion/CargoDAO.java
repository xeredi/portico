package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.CargoCriterioVO;
import xeredi.integra.model.vo.facturacion.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CargoDAO.
 */
public interface CargoDAO {

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the cargo vo
     */
    CargoVO selectObject(final CargoCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<CargoVO> selectList(final CargoCriterioVO criterioVO);
}
