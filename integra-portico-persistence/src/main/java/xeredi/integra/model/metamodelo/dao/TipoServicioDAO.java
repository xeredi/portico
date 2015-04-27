package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoServicioCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoServicioDAO.
 */
public interface TipoServicioDAO {

    /**
     * Select list.
     *
     * @param tpsrCriterio
     *            the tpsr criterio
     * @return the list
     */
    List<TipoServicioVO> selectList(final TipoServicioCriterioVO tpsrCriterio);

    /**
     * Select list.
     *
     * @param tpsrCriterio
     *            the tpsr criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoServicioVO> selectPaginatedList(final TipoServicioCriterioVO tpsrCriterio, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the tipo servicio vo
     */
    TipoServicioVO selectObject(final TipoServicioCriterioVO entiCriterio);

    /**
     * Count.
     *
     * @param tpsrCriterio
     *            the tpsr criterio
     * @return the int
     */
    int count(final TipoServicioCriterioVO tpsrCriterio);

    /**
     * Insert.
     *
     * @param tpsr
     *            the tpsr
     */
    void insert(final TipoServicioVO tpsr);

    /**
     * Update.
     *
     * @param tpsr
     *            the tpsr
     * @return the int
     */
    int update(final TipoServicioVO tpsr);

    /**
     * Delete.
     *
     * @param tpsr
     *            the tpsr
     * @return the int
     */
    int delete(final TipoServicioVO tpsr);

}
