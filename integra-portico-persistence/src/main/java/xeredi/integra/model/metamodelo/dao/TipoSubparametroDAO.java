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
     * @param tpspVO
     *            the tpsp vo
     */
    void insert(final TipoSubparametroVO tpspVO);

    /**
     * Update.
     *
     * @param tpspVO
     *            the tpsp vo
     * @return the int
     */
    int update(final TipoSubparametroVO tpspVO);

    /**
     * Delete.
     *
     * @param tpspId
     *            the tpsp id
     * @return the int
     */
    int delete(final Long tpspId);

    /**
     * Count.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the int
     */
    int count(final TipoSubparametroCriterioVO tpspCriterioVO);

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the list
     */
    List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO);

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoSubparametroVO> selectList(final TipoSubparametroCriterioVO tpspCriterioVO, final RowBounds bounds);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the tipo subparametro vo
     */
    TipoSubparametroVO select(final Long id);

}
