package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
    void insert(final @Nonnull TipoSubparametroVO tpspVO);

    /**
     * Update.
     *
     * @param tpspVO
     *            the tpsp vo
     * @return the int
     */
    int update(final @Nonnull TipoSubparametroVO tpspVO);

    /**
     * Delete.
     *
     * @param tpspId
     *            the tpsp id
     * @return the int
     */
    int delete(final @Nonnull Long tpspId);

    /**
     * Count.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the int
     */
    int count(final @Nonnull TipoSubparametroCriterioVO tpspCriterioVO);

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @return the list
     */
    List<TipoSubparametroVO> selectList(final @Nonnull TipoSubparametroCriterioVO tpspCriterioVO);

    /**
     * Select list.
     *
     * @param tpspCriterioVO
     *            the tpsp criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoSubparametroVO> selectPaginatedList(final @Nonnull TipoSubparametroCriterioVO tpspCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the tipo subparametro vo
     */
    TipoSubparametroVO selectObject(final @Nonnull TipoSubparametroCriterioVO entiCriterioVO);

}
