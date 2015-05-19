package xeredi.integra.model.facturacion.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.dao.CrudVersionableDAO;
import xeredi.integra.model.facturacion.vo.AspectoCargoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoCargoVO;

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
