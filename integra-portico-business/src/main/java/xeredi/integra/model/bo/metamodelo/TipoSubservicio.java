package xeredi.integra.model.bo.metamodelo;

import java.util.List;

import xeredi.integra.model.vo.metamodelo.TipoSubservicioCriterioVO;
import xeredi.integra.model.vo.metamodelo.TipoSubservicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubservicio.
 */
public interface TipoSubservicio {

    /**
     * Select label values.
     * 
     * @return the list
     */
    List<LabelValueVO> selectLabelValues();

    /**
     * Select list.
     * 
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @return the list
     */
    List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO);

    /**
     * Select list.
     * 
     * @param tpssCriterioVO
     *            the tpss criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterioVO, final int offset,
            final int limit);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo subservicio vo
     */
    TipoSubservicioVO select(final Long id);

    /**
     * Insert.
     * 
     * @param tpssVO
     *            the tpss vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final TipoSubservicioVO tpssVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param tpssVO
     *            the tpss vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final TipoSubservicioVO tpssVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param tpssId
     *            the tpss id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long tpssId) throws InstanceNotFoundException;
}
