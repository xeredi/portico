package xeredi.integra.model.maestro.bo;

import java.util.List;

import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Subparametro.
 */
public interface Subparametro {

    /**
     * Insert.
     * 
     * @param sprmVO
     *            the sprm vo
     * @param tpspVO
     *            the tpsp vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final SubparametroVO sprmVO, final TipoSubparametroVO tpspVO) throws DuplicateInstanceException;

    /**
     * Duplicate.
     * 
     * @param sprmVO
     *            the sprm vo
     * @param tpsrVO
     *            the tpsr vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void duplicate(final SubparametroVO sprmVO, final TipoSubparametroVO tpsrVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param sprmVO
     *            the sprm vo
     * @param tpspVO
     *            the tpsp vo
     */
    void update(final SubparametroVO sprmVO, final TipoSubparametroVO tpspVO);

    /**
     * Delete.
     * 
     * @param spvrId
     *            the spvr id
     * @param tpspVO
     *            the tpsp vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long spvrId, final TipoSubparametroVO tpspVO) throws InstanceNotFoundException;

    /**
     * Select list.
     * 
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO, final int offset,
            final int limit);

    /**
     * Select list.
     * 
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the list
     */
    List<SubparametroVO> selectList(final SubparametroCriterioVO sprmCriterioVO);

    /**
     * Select object.
     * 
     * @param sprmCriterioVO
     *            the sprm criterio vo
     * @return the subparametro vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    SubparametroVO selectObject(final SubparametroCriterioVO sprmCriterioVO) throws InstanceNotFoundException;
}
