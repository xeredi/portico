package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.metamodelo.vo.TipoSubparametroCriterioVO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TipoSubparametroDAO.
 */
public interface TipoSubparametroDAO {

    /**
     * Insert.
     *
     * @param tpsp
     *            the tpsp
     */
    void insert(final TipoSubparametroVO tpsp);

    /**
     * Update.
     *
     * @param tpsp
     *            the tpsp
     * @return the int
     */
    int update(final TipoSubparametroVO tpsp);

    /**
     * Delete.
     *
     * @param tpsp
     *            the tpsp
     * @return the int
     */
    int delete(final TipoSubparametroVO tpsp);

    /**
     * Count.
     *
     * @param tpspCriterio
     *            the tpsp criterio
     * @return the int
     */
    int count(final TipoSubparametroCriterioVO tpspCriterio);

    /**
     * Select list.
     *
     * @param tpspCriterio
     *            the tpsp criterio
     * @return the list
     */
    List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterio);

    /**
     * Select list.
     *
     * @param tpspCriterio
     *            the tpsp criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoSubparametroVO> selectPaginatedList(final TipoSubparametroCriterioVO tpspCriterio, final RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterio
     *            the enti criterio
     * @return the tipo subparametro vo
     */
    TipoSubparametroVO selectObject(final TipoSubparametroCriterioVO entiCriterio);

}
