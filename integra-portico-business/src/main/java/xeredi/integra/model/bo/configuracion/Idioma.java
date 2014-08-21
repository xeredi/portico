package xeredi.integra.model.bo.configuracion;

import java.util.List;
import java.util.Map;

import xeredi.integra.model.configuracion.vo.IdiomaVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Idioma.
 */
public interface Idioma {

    /**
     * Select all.
     * 
     * @return the list
     */
    List<IdiomaVO> selectAll();

    /**
     * Select all map.
     * 
     * @return the map
     */
    Map<String, IdiomaVO> selectAllMap();

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
     * @return the idioma vo
     */
    IdiomaVO select(final Long id);

    /**
     * Insert.
     * 
     * @param cnidVO
     *            the cnid vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final IdiomaVO cnidVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param cnidVO
     *            the cnid vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final IdiomaVO cnidVO) throws InstanceNotFoundException;

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
