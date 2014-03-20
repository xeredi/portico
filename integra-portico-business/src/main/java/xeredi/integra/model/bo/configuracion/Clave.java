package xeredi.integra.model.bo.configuracion;

import java.util.Map;

import xeredi.integra.model.vo.configuracion.ClaveCriterioVO;
import xeredi.integra.model.vo.configuracion.ClaveVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Clave.
 */
public interface Clave {

    /**
     * Insert.
     * 
     * @param cnclVO
     *            the cncl vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final ClaveVO cnclVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param cnclVO
     *            the cncl vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final ClaveVO cnclVO) throws InstanceNotFoundException;

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the clave vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ClaveVO select(final Long id) throws InstanceNotFoundException;

    /**
     * Select list.
     * 
     * @param cnclCriterioVO
     *            the cncl criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ClaveVO> selectList(final ClaveCriterioVO cnclCriterioVO, final int offset, final int limit);

    /**
     * Select all map.
     * 
     * @return the map
     */
    Map<String, ClaveVO> selectAllMap();

}
