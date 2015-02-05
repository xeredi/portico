package xeredi.integra.model.metamodelo.dao;

import java.util.List;

import javax.annotation.Nonnull;

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
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the list
     */
    List<TipoServicioVO> selectList(final @Nonnull TipoServicioCriterioVO tpsrCriterioVO);

    /**
     * Select list.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<TipoServicioVO> selectPaginatedList(final @Nonnull TipoServicioCriterioVO tpsrCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select.
     *
     * @param entiCriterioVO
     *            the enti criterio vo
     * @return the tipo servicio vo
     */
    TipoServicioVO selectObject(final @Nonnull TipoServicioCriterioVO entiCriterioVO);

    /**
     * Count.
     *
     * @param tpsrCriterioVO
     *            the tpsr criterio vo
     * @return the int
     */
    int count(final @Nonnull TipoServicioCriterioVO tpsrCriterioVO);

    /**
     * Insert.
     *
     * @param tpsrVO
     *            the tpsr vo
     */
    void insert(final @Nonnull TipoServicioVO tpsrVO);

    /**
     * Update.
     *
     * @param tpsrVO
     *            the tpsr vo
     * @return the int
     */
    int update(final @Nonnull TipoServicioVO tpsrVO);

    /**
     * Delete.
     *
     * @param tpsrId
     *            the tpsr id
     * @return the int
     */
    int delete(final @Nonnull Long tpsrId);

}
