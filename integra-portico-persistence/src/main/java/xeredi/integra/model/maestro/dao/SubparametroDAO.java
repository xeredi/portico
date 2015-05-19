package xeredi.integra.model.maestro.dao;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.comun.dao.CrudVersionableDAO;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface SubparametroDAO.
 */
public interface SubparametroDAO extends CrudDAO<SubparametroVO, SubparametroCriterioVO>,
CrudVersionableDAO<SubparametroVO> {
    /**
     * Select id.
     *
     * @param sprmVO
     *            the sprm vo
     * @return the long
     */
    Long selectId(final SubparametroVO sprmVO);
}
