package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.ReglaCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaDAO.
 */
public interface ReglaDAO {

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the regla vo
     */
    ReglaVO selectObject(final ReglaCriterioVO criterioVO);

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<ReglaVO> selectList(final ReglaCriterioVO criterioVO);

}
