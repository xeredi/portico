package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.ReglaCriterioVO;
import xeredi.integra.model.vo.facturacion.ReglaVO;

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
