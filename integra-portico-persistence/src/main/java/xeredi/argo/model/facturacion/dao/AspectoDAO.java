package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;
import xeredi.argo.model.facturacion.vo.FacturadorContextoVO;

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
