package xeredi.integra.model.servicio.bo;

import java.util.List;
import java.util.Set;

import xeredi.integra.model.servicio.vo.SubservicioCriterioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Subservicio.
 */
public interface Subservicio {

    /**
     * Select list.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO, final int offset,
            final int limit);

    /**
     * Select list.
     * 
     * @param ssrvCriterioVO
     *            the ssrv criterio vo
     * @return the list
     */
    List<SubservicioVO> selectList(final SubservicioCriterioVO ssrvCriterioVO);

    /**
     * Select.
     * 
     * @param ssrvId
     *            the ssrv id
     * @param idioma
     *            the idioma
     * @return the subservicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    SubservicioVO select(final Long ssrvId, final String idioma) throws InstanceNotFoundException;

    /**
     * Insert.
     * 
     * @param ssrvVO
     *            the ssrv vo
     * @param ssrvPadreIds
     *            the ssrv padre ids
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final SubservicioVO ssrvVO, final Set<Long> ssrvPadreIds) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param ssrvVO
     *            the ssrv vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final SubservicioVO ssrvVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param ssrvId
     *            the ssrv id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long ssrvId) throws InstanceNotFoundException;
}