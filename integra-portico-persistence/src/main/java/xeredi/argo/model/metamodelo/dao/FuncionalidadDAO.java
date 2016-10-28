package xeredi.argo.model.metamodelo.dao;

import xeredi.argo.model.comun.dao.CrudDAO;
import xeredi.argo.model.metamodelo.vo.FuncionalidadCriterioVO;
import xeredi.argo.model.metamodelo.vo.FuncionalidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface FuncionalidadDAO.
 */
public interface FuncionalidadDAO extends CrudDAO<FuncionalidadVO, FuncionalidadCriterioVO> {
    /**
     * Next sequence.
     *
     * @return the long
     */
    Long nextSequence();

}
