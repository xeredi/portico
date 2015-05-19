package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import xeredi.integra.model.comun.dao.CrudDAO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntidadGrupoDatoDAO.
 */
public interface EntidadGrupoDatoDAO extends CrudDAO<EntidadGrupoDatoVO, EntidadGrupoDatoCriterioVO> {
    /**
     * Select all.
     *
     * @return the list
     */
    List<EntidadGrupoDatoVO> selectAll();
}
