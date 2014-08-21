package xeredi.integra.model.configuracion.bo;

import java.util.Map;

import xeredi.integra.model.configuracion.vo.ClaveIdiomaCriterioVO;
import xeredi.integra.model.configuracion.vo.ClaveIdiomaVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface ClaveIdioma.
 */
public interface ClaveIdioma {

    /**
     * Insert.
     * 
     * @param cnciVO
     *            the cnci vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final ClaveIdiomaVO cnciVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param cnciVO
     *            the cnci vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final ClaveIdiomaVO cnciVO) throws InstanceNotFoundException;

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the clave idioma vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    ClaveIdiomaVO select(final Long id) throws InstanceNotFoundException;

    /**
     * Select list.
     * 
     * @param cnciCriterioVO
     *            the cnci criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ClaveIdiomaVO> selectList(final ClaveIdiomaCriterioVO cnciCriterioVO, final int offset,
            final int limit);

    /**
     * Select all map.
     * 
     * @return the map
     */
    Map<String, ClaveIdiomaVO> selectAllMap();

}
