package xeredi.integra.model.bo.configuracion;

import java.util.List;
import java.util.Map;

import xeredi.integra.model.vo.configuracion.EntornoVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Entorno.
 */
public interface Entorno {

    /**
     * Select all.
     * 
     * @return the list
     */
    List<EntornoVO> selectAll();

    /**
     * Select all map.
     * 
     * @return the map
     */
    Map<String, EntornoVO> selectAllMap();

    /**
     * Select codigos.
     * 
     * @return the list
     */
    List<String> selectCodigos();

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the entorno vo
     */
    EntornoVO select(final Long id);

    /**
     * Insert.
     * 
     * @param cnenVO
     *            the cnen vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final EntornoVO cnenVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param cnenVO
     *            the cnen vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final EntornoVO cnenVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param id
     *            the id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long id) throws InstanceNotFoundException;
}
