package xeredi.integra.model.maestro.bo;

import java.util.List;

import xeredi.integra.model.comun.exception.OverlapException;
import xeredi.integra.model.maestro.vo.SubparametroCriterioVO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;
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
     * @throws OverlapException
     *             the overlap exception
     */
    void insert(final SubparametroVO sprmVO, final TipoSubparametroVO tpspVO) throws OverlapException;

    /**
     * Duplicate.
     *
     * @param sprmVO
     *            the sprm vo
     * @param tpsrVO
     *            the tpsr vo
     * @throws OverlapException
     *             the overlap exception
     */
    void duplicate(final SubparametroVO sprmVO, final TipoSubparametroVO tpsrVO) throws OverlapException;

    /**
     * Update.
     *
     * @param sprmVO
     *            the sprm vo
     * @param tpspVO
     *            the tpsp vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OverlapException
     *             the overlap exception
     */
    void update(final SubparametroVO sprmVO, final TipoSubparametroVO tpspVO) throws InstanceNotFoundException,
    OverlapException;

    /**
     * Delete.
     *
     * @param sprm
     *            the sprm
     * @param tpspVO
     *            the tpsp vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final SubparametroVO sprm, final TipoSubparametroVO tpspVO) throws InstanceNotFoundException;

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
