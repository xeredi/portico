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
     * @param tpesCriterio
     *            the tpes criterio
     * @return the list
     */
    List<TipoEstadisticaVO> selectList(final TipoEstadisticaCriterioVO tpesCriterio);

    /**
     * Select list.
     *
     * @param tpesCriterio
     *            the tpes criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoEstadisticaVO> selectPaginatedList(final TipoEstadisticaCriterioVO tpesCriterio, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the tipo estadistica vo
     */
    TipoEstadisticaVO selectObject(final TipoEstadisticaCriterioVO entiCriterio);

    /**
     * Count.
     *
     * @param tpesCriterio
     *            the tpes criterio
     * @return the int
     */
    int count(final TipoEstadisticaCriterioVO tpesCriterio);

    /**
     * Insert.
     *
     * @param tpes
     *            the tpes
     */
    void insert(final TipoEstadisticaVO tpes);

    /**
     * Delete.
     *
     * @param tpes
     *            the tpes
     * @return the int
     */
    int delete(final TipoEstadisticaVO tpes);

}
