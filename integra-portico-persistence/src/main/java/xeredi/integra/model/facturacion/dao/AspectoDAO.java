package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.dao.CrudVersionableDAO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;
import xeredi.integra.model.facturacion.vo.FacturadorContextoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoDAO.
 */
public interface AspectoDAO extends CrudDAO<AspectoVO, AspectoCriterioVO>, CrudVersionableDAO<AspectoVO> {
    /**
     * Checks if is inaplicable.
     *
     * @param contextoVO
     *            the contexto vo
     * @return true, if checks if is inaplicable
     */
    boolean isInaplicable(final FacturadorContextoVO contextoVO);

    /**
     * Select id.
     *
     * @param aspc
     *            the aspc
     * @return the long
     */
    Long selectId(final AspectoVO aspc);
}
