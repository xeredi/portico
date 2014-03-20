package xeredi.integra.model.dao.configuracion;

import java.util.List;

import xeredi.integra.model.vo.configuracion.ValorIdiomaCriterioVO;
import xeredi.integra.model.vo.configuracion.ValorIdiomaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValorIdiomaDAO.
 */
public interface ValorIdiomaDAO {

    /**
     * Select all list.
     * 
     * @return the list
     */
    List<ValorIdiomaVO> selectAllList();

    /**
     * Select list.
     * 
     * @param cnviCriterioVO
     *            the cnvi criterio vo
     * @return the list
     */
    List<ValorIdiomaVO> selectList(final ValorIdiomaCriterioVO cnviCriterioVO);

    /**
     * Delete.
     * 
     * @param cnviCriterioVO
     *            the cnvi criterio vo
     * @return the int
     */
    int delete(final ValorIdiomaCriterioVO cnviCriterioVO);

    /**
     * Insert.
     * 
     * @param cnviVO
     *            the cnvi vo
     */
    void insert(final ValorIdiomaVO cnviVO);

    /**
     * Update.
     * 
     * @param cnviVO
     *            the cnvi vo
     * @return the int
     */
    int update(final ValorIdiomaVO cnviVO);
}
