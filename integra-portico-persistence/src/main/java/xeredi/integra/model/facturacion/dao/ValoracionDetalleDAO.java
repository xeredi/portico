package xeredi.integra.model.facturacion.dao;

import java.util.List;

import javax.annotation.Nonnull;

import org.apache.ibatis.session.RowBounds;

import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValoracionDetalleDAO.
 */
public interface ValoracionDetalleDAO {

    /**
     * Insert.
     *
     * @param vlrdVO
     *            the vlrd vo
     */
    void insert(final @Nonnull ValoracionDetalleVO vlrdVO);

    /**
     * Update.
     *
     * @param vlrdVO
     *            the vlrd vo
     * @return the int
     */
    int update(final @Nonnull ValoracionDetalleVO vlrdVO);

    /**
     * Delete.
     *
     * @param vlrdVO
     *            the vlrd vo
     * @return the int
     */
    int delete(final @Nonnull ValoracionDetalleVO vlrdVO);

    /**
     * Delete.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @return the int
     */
    int deleteList(final @Nonnull ValoracionDetalleCriterioVO vlrdCriterioVO);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion detalle vo
     */
    ValoracionDetalleVO select(final @Nonnull Long id);

    /**
     * Count.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @return the int
     */
    int count(final @Nonnull ValoracionDetalleCriterioVO vlrdCriterioVO);

    /**
     * Select list.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ValoracionDetalleVO> selectPaginatedList(final @Nonnull ValoracionDetalleCriterioVO vlrdCriterioVO,
            final @Nonnull RowBounds bounds);

    /**
     * Select list.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @return the list
     */
    List<ValoracionDetalleVO> selectList(final @Nonnull ValoracionDetalleCriterioVO vlrdCriterioVO);
}
