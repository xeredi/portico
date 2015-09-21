package xeredi.argo.model.facturacion.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.argo.model.facturacion.vo.AspectoCargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AspectoCargoDAO.
 */
public interface AspectoCargoDAO extends CrudDAO<AspectoCargoVO, AspectoCargoCriterioVO>,
CrudVersionableDAO<AspectoCargoVO> {

    /**
     * Select id.
     *
     * @param vo
     *            the vo
     * @return the long
     */
    Long selectId(final AspectoCargoVO vo);
}
