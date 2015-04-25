package xeredi.integra.model.facturacion.dao;

import java.util.List;

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
    void insert(final ValoracionDetalleVO vlrdVO);

    /**
     * Update.
     *
     * @param vlrdVO
     *            the vlrd vo
     * @return the int
     */
    int update(final ValoracionDetalleVO vlrdVO);

    /**
     * Delete.
     *
     * @param vlrdId
     *            the vlrd id
     * @return the int
     */
    int delete(final Long vlrdId);

    /**
     * Delete.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @return the int
     */
    int deleteList(final ValoracionDetalleCriterioVO vlrdCriterioVO);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion detalle vo
     */
    ValoracionDetalleVO select(final Long id);

    /**
     * Count.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @return the int
     */
    int count(final ValoracionDetalleCriterioVO vlrdCriterioVO);

    /**
     * Select list.
     *
     * @param vlrdCriterio
     *            the vlrd criterio
     * @param bounds
     *            the bounds
     * @return the list
     */
    List<ValoracionDetalleVO> selectList(final ValoracionDetalleCriterioVO vlrdCriterio, final RowBounds bounds);

    /**
     * Select list.
     *
     * @param vlrdCriterio
     *            the vlrd criterio
     * @return the list
     */
    List<ValoracionDetalleVO> selectList(final ValoracionDetalleCriterioVO vlrdCriterio);
}
