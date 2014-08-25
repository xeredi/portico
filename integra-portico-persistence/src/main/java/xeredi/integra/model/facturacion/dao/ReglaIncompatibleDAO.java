package xeredi.integra.model.facturacion.dao;

import java.util.List;

import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReglaIncompatibleDAO.
 */
public interface ReglaIncompatibleDAO {

    /**
     * Select list.
     *
     * @param rginCriterioVO
     *            the rgin criterio vo
     * @return the list
     */
    List<ReglaIncompatibleVO> selectList(final ReglaIncompatibleCriterioVO rginCriterioVO);
}
