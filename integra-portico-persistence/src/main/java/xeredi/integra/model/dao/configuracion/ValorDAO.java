package xeredi.integra.model.dao.configuracion;

import java.util.List;

import xeredi.integra.model.vo.configuracion.ValorCriterioVO;
import xeredi.integra.model.vo.configuracion.ValorVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValorDAO.
 */
public interface ValorDAO {

    /**
     * Select all list.
     * 
     * @return the list
     */
    List<ValorVO> selectAllList();

    /**
     * Select list.
     * 
     * @param cnvlCriterioVO
     *            the cnvl criterio vo
     * @return the list
     */
    List<ValorVO> selectList(final ValorCriterioVO cnvlCriterioVO);

    /**
     * Delete.
     * 
     * @param cnvlCriterioVO
     *            the cnvl criterio vo
     * @return the int
     */
    int delete(final ValorCriterioVO cnvlCriterioVO);

    /**
     * Insert.
     * 
     * @param cnvlVO
     *            the cnvl vo
     */
    void insert(final ValorVO cnvlVO);
}
