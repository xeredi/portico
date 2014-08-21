package xeredi.integra.model.bo.metamodelo;

import java.util.List;

import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametro.
 */
public interface TipoParametro {

    /**
     * Select label values.
     * 
     * @return the list
     */
    List<LabelValueVO> selectLabelValues();

    /**
     * Select list.
     * 
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the list
     */
    List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO);

    /**
     * Select list.
     * 
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterioVO, final int offset,
            final int limit);

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo parametro vo
     */
    TipoParametroVO select(final Long id);

    /**
     * Insert.
     * 
     * @param tpprVO
     *            the tppr vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final TipoParametroVO tpprVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param tpprVO
     *            the tppr vo
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void update(final TipoParametroVO tpprVO) throws InstanceNotFoundException;

    /**
     * Delete.
     * 
     * @param tpprId
     *            the tppr id
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    void delete(final Long tpprId) throws InstanceNotFoundException;
}
