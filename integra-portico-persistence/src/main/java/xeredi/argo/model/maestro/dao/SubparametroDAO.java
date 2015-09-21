package xeredi.argo.model.maestro.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.comun.dao.CrudVersionableDAO;
import xeredi.argo.model.maestro.vo.SubparametroCriterioVO;
import xeredi.argo.model.maestro.vo.SubparametroVO;

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
