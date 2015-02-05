package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the list
     */
    List<TipoParametroVO> selectList(final @Nonnull TipoParametroCriterioVO tpprCriterioVO);

    /**
     * Select all.
     *
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoParametroVO> selectPaginatedList(final @Nonnull TipoParametroCriterioVO tpprCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the tipo parametro vo
     */
    TipoParametroVO selectObject(final @Nonnull TipoParametroCriterioVO entiCriterioVO);

    /**
     * Count.
     *
     * @param tpprCriterioVO
     *            the tppr criterio vo
     * @return the int
     */
    int count(final @Nonnull TipoParametroCriterioVO tpprCriterioVO);

    /**
     * Insert.
     *
     * @param tpprVO
     *            the tppr vo
     */
    void insert(final @Nonnull TipoParametroVO tpprVO);

    /**
     * Update.
     *
     * @param tpprVO
     *            the tppr vo
     * @return the int
     */
    int update(final @Nonnull TipoParametroVO tpprVO);

    /**
     * Delete.
     *
     * @param tpprId
     *            the tppr id
     * @return the int
     */
    int delete(final @Nonnull Long tpprId);

}
