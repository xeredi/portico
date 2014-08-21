package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

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
