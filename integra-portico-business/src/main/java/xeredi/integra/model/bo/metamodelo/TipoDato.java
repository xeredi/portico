package xeredi.integra.model.bo.metamodelo;

import java.util.List;
import java.util.Map;

import xeredi.integra.model.metamodelo.vo.TipoDatoCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.util.applicationobjects.LabelValueVO;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoDato.
 */
public interface TipoDato {

    /**
     * Select.
     * 
     * @param id
     *            the id
     * @return the tipo dato vo
     */
    TipoDatoVO select(final Long id);

    /**
     * Insert.
     * 
     * @param tpdtVO
     *            the tpdt vo
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    void insert(final TipoDatoVO tpdtVO) throws DuplicateInstanceException;

    /**
     * Update.
     * 
     * @param tpdtVO
     *            the tpdt vo
     */
    void update(final TipoDatoVO tpdtVO);

    /**
     * Select list.
     * 
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the list
     */
    List<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO);

    /**
     * Select list.
     * 
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<TipoDatoVO> selectList(final TipoDatoCriterioVO tpdtCriterioVO, final int offset, final int limit);

    /**
     * Select label values.
     * 
     * @return the list
     */
    List<LabelValueVO> selectLabelValues();

    /**
     * Select map.
     * 
     * @param tpdtCriterioVO
     *            the tpdt criterio vo
     * @return the map
     */
    Map<Long, TipoDatoVO> selectMap(final TipoDatoCriterioVO tpdtCriterioVO);
}
