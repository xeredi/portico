package xeredi.integra.model.bo.facturacion;

import java.util.List;
import java.util.Set;

import xeredi.integra.model.vo.facturacion.ValoracionCargoVO;
import xeredi.integra.model.vo.facturacion.ValoracionCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionDetalleVO;
import xeredi.integra.model.vo.facturacion.ValoracionImpuestoVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaCriterioVO;
import xeredi.integra.model.vo.facturacion.ValoracionLineaVO;
import xeredi.integra.model.vo.facturacion.ValoracionVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * The Interface Valoracion.
 */
public interface Valoracion {

    /**
     * Delete.
     *
     * @param id
     *            the id
     */
    void delete(final Long id);

    /**
     * Delete.
     *
     * @param ids
     *            the ids
     */
    void delete(final Set<Long> ids);

    /**
     * Select.
     *
     * @param id
     *            the id
     * @return the valoracion vo
     */
    ValoracionVO select(final Long id);

    /**
     * Select impuestos list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionImpuestoVO> selectImpuestosList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select cargos list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionCargoVO> selectCargosList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select linea.
     *
     * @param vlrlId
     *            the vlrl id
     * @return the valoracion linea vo
     */
    ValoracionLineaVO selectLinea(final Long vlrlId);

    /**
     * Exists linea dependencia.
     *
     * @param vlrlId
     *            the vlrl id
     * @return true, if successful
     */
    boolean existsLineaDependencia(final Long vlrlId);

    /**
     * Delete linea.
     *
     * @param vlrlId
     *            the vlrl id
     */
    void deleteLinea(final Long vlrlId);

    /**
     * Select lineas list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the list
     */
    List<ValoracionLineaVO> selectLineasList(final ValoracionLineaCriterioVO vlrlCriterioVO);

    /**
     * Select lineas list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ValoracionLineaVO> selectLineasList(final ValoracionLineaCriterioVO vlrlCriterioVO, final int offset,
            final int limit);

    /**
     * Select detalle.
     *
     * @param vlrdId
     *            the vlrd id
     * @return the valoracion detalle vo
     */
    ValoracionDetalleVO selectDetalle(final Long vlrdId);

    /**
     * Select detalles list.
     *
     * @param vlrdCriterioVO
     *            the vlrd criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ValoracionDetalleVO> selectDetallesList(final ValoracionDetalleCriterioVO vlrdCriterioVO,
            final int offset, final int limit);

}
