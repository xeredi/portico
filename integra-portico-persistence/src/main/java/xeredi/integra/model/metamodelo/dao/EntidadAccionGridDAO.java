package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadAccionGridDAO.
 */
public interface EntidadAccionGridDAO extends CrudDAO<EntidadAccionGridVO, EntidadAccionGridCriterioVO> {
    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadAccionGridVO> selectAll();
}
