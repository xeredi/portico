package xeredi.integra.model.configuracion.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import xeredi.integra.model.configuracion.vo.EntornoVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface EntornoDAO.
 */
public interface EntornoDAO {

    /**
     * Select all map.
     * 
     * @return the map
     */
    @MapKey("codigo")
    Map<String, EntornoVO> selectAllMap();

    /**
     * Select all list.
     * 
     * @return the list
     */
    List<EntornoVO> selectAllList();

    /**
     * Select codigos list.
     * 
     * @return the list
     */
    List<String> selectCodigosList();

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the entorno vo
     */
    EntornoVO select(final Long id);

    /**
     * Exists.
     * 
     * @param cnenVO
     *            the cnen vo
     * @return true, if successful
     */
    boolean exists(final EntornoVO cnenVO);

    /**
     * Insert.
     * 
     * @param cnenVO
     *            the cnen vo
     */
    void insert(final EntornoVO cnenVO);

    /**
     * Update.
     * 
     * @param cnenVO
     *            the cnen vo
     * @return the int
     */
    int update(final EntornoVO cnenVO);

    /**
     * Delete.
     * 
     * @param id
     *            the id
     * @return the int
     */
    int delete(final Long id);

}
