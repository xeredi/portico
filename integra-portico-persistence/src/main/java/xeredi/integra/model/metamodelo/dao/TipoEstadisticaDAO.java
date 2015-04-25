package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoEstadisticaDAO.
 */
public interface TipoEstadisticaDAO {

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
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoEstadisticaVO> selectPaginatedList(final TipoEstadisticaCriterioVO tpesCriterioVO, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the tipo estadistica vo
     */
    TipoEstadisticaVO selectObject(final TipoEstadisticaCriterioVO entiCriterioVO);

    /**
     * Count.
     *
     * @param tpesCriterioVO
     *            the tpes criterio vo
     * @return the int
     */
    int count(final TipoEstadisticaCriterioVO tpesCriterioVO);

    /**
     * Insert.
     *
     * @param tpesVO
     *            the tpes vo
     */
    void insert(final TipoEstadisticaVO tpesVO);

    /**
     * Delete.
     *
     * @param tpesId
     *            the tpes id
     * @return the int
     */
    int delete(final Long tpesId);

}
