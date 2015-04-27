package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoParametroDAO.
 */
public interface TipoParametroDAO {

    /**
     * Select all.
     *
     * @param tpprCriterio
     *            the tppr criterio
     * @return the list
     */
    List<TipoParametroVO> selectList(final TipoParametroCriterioVO tpprCriterio);

    /**
     * Select all.
     *
     * @param tpprCriterio
     *            the tppr criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoParametroVO> selectPaginatedList(final TipoParametroCriterioVO tpprCriterio, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the tipo parametro vo
     */
    TipoParametroVO selectObject(final TipoParametroCriterioVO entiCriterio);

    /**
     * Count.
     *
     * @param tpprCriterio
     *            the tppr criterio
     * @return the int
     */
    int count(final TipoParametroCriterioVO tpprCriterio);

    /**
     * Insert.
     *
     * @param tppr
     *            the tppr
     */
    void insert(final TipoParametroVO tppr);

    /**
     * Update.
     *
     * @param tppr
     *            the tppr
     * @return the int
     */
    int update(final TipoParametroVO tppr);

    /**
     * Delete.
     *
     * @param tppr
     *            the tppr
     * @return the int
     */
    int delete(final TipoParametroVO tppr);

}
