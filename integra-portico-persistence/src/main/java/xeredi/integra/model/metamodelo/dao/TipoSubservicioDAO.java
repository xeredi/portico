package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoSubservicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubservicioDAO.
 */
public interface TipoSubservicioDAO {

    /**
     * Insert.
     *
     * @param tpss
     *            the tpss
     */
    void insert(final TipoSubservicioVO tpss);

    /**
     * Update.
     *
     * @param tpss
     *            the tpss
     * @return the int
     */
    int update(final TipoSubservicioVO tpss);

    /**
     * Delete.
     *
     * @param tpss
     *            the tpss
     * @return the int
     */
    int delete(final TipoSubservicioVO tpss);

    /**
     * Count.
     *
     * @param tpssCriterio
     *            the tpss criterio
     * @return the int
     */
    int count(final TipoSubservicioCriterioVO tpssCriterio);

    /**
     * Select list.
     *
     * @param tpssCriterio
     *            the tpss criterio
     * @return the list
     */
    List<TipoSubservicioVO> selectList(final TipoSubservicioCriterioVO tpssCriterio);

    /**
     * Select list.
     *
     * @param tpssCriterio
     *            the tpss criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoSubservicioVO> selectPaginatedList(final TipoSubservicioCriterioVO tpssCriterio, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the tipo subservicio vo
     */
    TipoSubservicioVO selectObject(final TipoSubservicioCriterioVO entiCriterio);
}
