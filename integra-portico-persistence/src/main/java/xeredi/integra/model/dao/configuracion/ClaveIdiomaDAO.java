package xeredi.integra.model.dao.configuracion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.integra.model.vo.configuracion.ClaveIdiomaCriterioVO;
import xeredi.integra.model.vo.configuracion.ClaveIdiomaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClaveIdiomaDAO.
 */
public interface ClaveIdiomaDAO {

    /**
     * Select all map.
     * 
     * @return the map
     */
    @MapKey("clave")
    Map<String, ClaveIdiomaVO> selectAllMap();

    /**
     * Select count.
     * 
     * @param cnciCriterioVO
     *            the cnci criterio vo
     * @return the integer
     */
    Integer selectCount(final ClaveIdiomaCriterioVO cnciCriterioVO);

    /**
     * Select list.
     * 
     * @param cnciCriterioVO
     *            the cnci criterio vo
     * @return the list
     */
    List<ClaveIdiomaVO> selectList(final ClaveIdiomaCriterioVO cnciCriterioVO);

    /**
     * Exists.
     * 
     * @param cnciVO
     *            the cnci vo
     * @return true, if successful
     */
    boolean exists(final ClaveIdiomaVO cnciVO);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the clave idioma vo
     */
    ClaveIdiomaVO select(final Long id);

    /**
     * Insert.
     * 
     * @param cnciVO
     *            the cnci vo
     */
    void insert(final ClaveIdiomaVO cnciVO);

    /**
     * Update.
     * 
     * @param cnciVO
     *            the cnci vo
     * @return the int
     */
    int update(final ClaveIdiomaVO cnciVO);

}
