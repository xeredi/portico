package xeredi.integra.model.bo.metamodelo;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoEstadistica.
 */
public interface TipoEstadistica {

    /**
     * Select label values.
     * 
     * @return the list
     */
    List<LabelValueVO> selectLabelValues();

    /**
     * Select list.
     * 
     * @param tpesCriterioVO
     *            the tpes criterio vo
     * @return the list
     */
    List<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterioVO);

    /**
     * Select list.
     * 
     * @param tpesCriterioVO
     *            the tpes criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterioVO, final int offset,
            final int limit);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo estadistica vo
     */
    TipoEstadisticaVO select(final Long id);

    /**
     * Insert.
     * 
     * @param tpesVO
     *            the tpes vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final TipoEstadisticaVO tpesVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param tpesVO
     *            the tpes vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final TipoEstadisticaVO tpesVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param tpesId
     *            the tpes id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long tpesId) throws InstanceNotFoundException;
}
