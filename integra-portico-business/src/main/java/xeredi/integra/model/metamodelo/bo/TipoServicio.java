package xeredi.integra.model.metamodelo.bo;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoServicio.
 */
public interface TipoServicio {

    /**
     * Select label values.
     * 
     * @return the list
     */
    List<LabelValueVO> selectLabelValues();

    /**
     * Select list.
     * 
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the list
     */
    List<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO);

    /**
     * Select list.
     * 
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterioVO, final int offset,
            final int limit);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo servicio vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    TipoServicioVO select(final Long id) throws InstanceNotFoundException;

    /**
     * Insert.
     * 
     * @param tpsrVO
     *            the tpsr vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final TipoServicioVO tpsrVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param tpsrVO
     *            the tpsr vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final TipoServicioVO tpsrVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param tpsrId
     *            the tpsr id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long tpsrId) throws InstanceNotFoundException;
}
