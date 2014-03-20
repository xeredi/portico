package xeredi.integra.model.dao.configuracion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.integra.model.vo.configuracion.IdiomaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface IdiomaDAO.
 */
public interface IdiomaDAO {

    /**
     * Insert.
     * 
     * @param cnidVO
     *            the cnid vo
     */
    void insert(final IdiomaVO cnidVO);

    /**
     * Update.
     * 
     * @param cnidVO
     *            the cnid vo
     * @return the int
     */
    int update(final IdiomaVO cnidVO);

    /**
     * Delete.
     * 
     * @param id
     *            the id
     * @return the int
     */
    int delete(final Long id);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the idioma vo
     */
    IdiomaVO select(final Long id);

    /**
     * Exists.
     * 
     * @param cnidVO
     *            the cnid vo
     * @return true, if successful
     */
    boolean exists(final IdiomaVO cnidVO);

    /**
     * Select all map.
     * 
     * @return the map
     */
    @MapKey("codigo")
    Map<String, IdiomaVO> selectAllMap();

    /**
     * Select all list.
     * 
     * @return the list
     */
    List<IdiomaVO> selectAllList();

    /**
     * Select codigos list.
     * 
     * @return the list
     */
    List<String> selectCodigosList();
}
