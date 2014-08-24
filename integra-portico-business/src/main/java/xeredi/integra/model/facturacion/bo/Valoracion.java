package xeredi.integra.model.facturacion.bo;

import java.util.List;
import java.util.Set;

import xeredi.integra.model.facturacion.vo.ValoracionCargoVO;
import xeredi.integra.model.facturacion.vo.ValoracionCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionDetalleVO;
import xeredi.integra.model.facturacion.vo.ValoracionImpuestoVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaCriterioVO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;
import xeredi.integra.model.facturacion.vo.ValoracionVO;
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
     * Select list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the paginated list
     */
    PaginatedList<ValoracionVO> selectList(final ValoracionCriterioVO vlrcCriterioVO, final int offset, final int limit);

    /**
     * Select imprimir.
     *
     * @param ids
     *            the ids
     * @return the list
     */
    List<ValoracionImpresionVO> selectImprimir(final Set<Long> ids);

    /**
     * Select impuestos list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionImpuestoVO> selectVlriList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select cargos list.
     *
     * @param vlrcCriterioVO
     *            the vlrc criterio vo
     * @return the list
     */
    List<ValoracionCargoVO> selectVlrgList(final ValoracionCriterioVO vlrcCriterioVO);

    /**
     * Select linea.
     *
     * @param vlrlId
     *            the vlrl id
     * @return the valoracion linea vo
     */
    ValoracionLineaVO selectVlrl(final Long vlrlId);

    /**
     * Exists linea dependencia.
     *
     * @param vlrlId
     *            the vlrl id
     * @return true, if successful
     */
    boolean existsVlrlHija(final Long vlrlId);

    /**
     * Insert linea.
     *
     * @param vlrl
     *            the vlrl
     * @param vlrd
     *            the vlrd
     */
    void insertVlrl(final ValoracionLineaVO vlrl, final ValoracionDetalleVO vlrd);

    /**
     * Delete linea.
     *
     * @param vlrlId
     *            the vlrl id
     */
    void deleteVlrl(final Long vlrlId);

    /**
     * Select lineas list.
     *
     * @param vlrlCriterioVO
     *            the vlrl criterio vo
     * @return the list
     */
    List<ValoracionLineaVO> selectVlrlList(final ValoracionLineaCriterioVO vlrlCriterioVO);

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
    PaginatedList<ValoracionLineaVO> selectVlrlList(final ValoracionLineaCriterioVO vlrlCriterioVO, final int offset,
            final int limit);

    /**
     * Select detalle.
     *
     * @param vlrdId
     *            the vlrd id
     * @return the valoracion detalle vo
     */
    ValoracionDetalleVO selectVlrd(final Long vlrdId);

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
    PaginatedList<ValoracionDetalleVO> selectVlrdList(final ValoracionDetalleCriterioVO vlrdCriterioVO,
            final int offset, final int limit);

}
