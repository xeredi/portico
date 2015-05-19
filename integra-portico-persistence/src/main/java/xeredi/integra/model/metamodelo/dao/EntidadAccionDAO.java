package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadAccionDAO.
 */
public interface EntidadAccionDAO extends CrudDAO<EntidadAccionVO, EntidadAccionCriterioVO> {
    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadAccionVO> selectAll();
}
