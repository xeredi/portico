package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoDAO.
 */
public interface AspectoDAO extends CrudDAO<AspectoVO, AspectoCriterioVO>, CrudVersionableDAO<AspectoVO> {
    /**
     * Select id.
     *
     * @param aspc
     *            the aspc
     * @return the long
     */
    Long selectId(final AspectoVO aspc);
}
