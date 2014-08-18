package xeredi.integra.model.dao.facturacion;

import java.util.List;

import xeredi.integra.model.vo.facturacion.AspectoCriterioVO;
import xeredi.integra.model.vo.facturacion.AspectoVO;
import xeredi.integra.model.vo.facturacion.FacturadorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoDAO.
 */
public interface AspectoDAO {

    /**
     * Select list.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the list
     */
    List<AspectoVO> selectList(final AspectoCriterioVO criterioVO);

    /**
     * Select object.
     *
     * @param criterioVO
     *            the criterio vo
     * @return the aspecto vo
     */
    AspectoVO selectObject(final AspectoCriterioVO criterioVO);

    /**
     * Checks if is inaplicable.
     *
     * @param contextoVO
     *            the contexto vo
     * @return true, if checks if is inaplicable
     */
    boolean isInaplicable(final FacturadorContextoVO contextoVO);
}
