package xeredi.integra.model.bo.facturacion;

import java.util.List;
import java.util.Set;

import xeredi.integra.model.vo.facturacion.FacturaCargoVO;
import xeredi.integra.model.vo.facturacion.FacturaCriterioVO;
import xeredi.integra.model.vo.facturacion.FacturaDetalleVO;
import xeredi.integra.model.vo.facturacion.FacturaImpuestoVO;
import xeredi.integra.model.vo.facturacion.FacturaLineaVO;
import xeredi.integra.model.vo.facturacion.FacturaServicioVO;
import xeredi.integra.model.vo.facturacion.FacturaVO;
import xeredi.util.pagination.PaginatedList;

// TODO: Auto-generated Javadoc
/**
 * Funciones de Negocio de Gestión de facturas.
 */
public interface Factura {

    /**
     * Imprimir.
     *
     * @param fctrIds
     *            the fctr ids
     * @return the list
     */
    List<FacturaImpresionVO> selectImprimir(final Set<Long> fctrIds);

    /**
     * Select.
     *
     * @param fctrCriterioVO
     *            the fctr criterio vo
     * @param offset
     *            the offset
     * @param limit
     *            the size
     * @return the list
     */
    PaginatedList<FacturaVO> selectList(final FacturaCriterioVO fctrCriterioVO, final int offset, final int limit);

    /**
     * Select.
     *
     * @param fctrId
     *            the fctr id
     * @return the factura vo
     */
    FacturaVO select(final Long fctrId);

    /**
     * Busqueda de los servicios asociados a una factura.
     *
     * @param fctrId
     *            Identificador de una factura.
     * @return the list
     */
    List<FacturaServicioVO> selectFctsList(final Long fctrId);

    /**
     * Busqueda de los impuestos asociados a una factura.
     *
     * @param fctrId
     *            Identificador de una factura.
     * @return the list
     */
    List<FacturaImpuestoVO> selectFctiList(final Long fctrId);

    /**
     * Busqueda de los cargos asociados a una factura.
     *
     * @param fctrId
     *            Identificador de una factura.
     * @return the list
     */
    List<FacturaCargoVO> selectFctgList(final Long fctrId);

    /**
     * Busqueda de la lineas de factura asociadas a una factura.
     *
     * @param fctrId
     *            Identificador de una factura.
     * @param offset
     *            the offset
     * @param limit
     *            the limit
     * @return the list
     */
    PaginatedList<FacturaLineaVO> selectFctlList(final Long fctrId, final int offset, final int limit);

    /**
     * Busqueda de una linea de factura a partir de su identificador.
     *
     * @param fctlId
     *            Identificador de linea de factura.
     * @return the factura linea vo
     */
    FacturaLineaVO selectFctl(final Long fctlId);

    /**
     * Busqueda de detalles de factura asociados a una linea de factura.
     *
     * @param fctlId
     *            Identificador de linea de factura.
     * @param offset
     *            Posicion a partir de la que se empieza a devolver resultados.
     * @param limit
     *            Numero maximo de resultados.
     * @return the paginated list
     */
    PaginatedList<FacturaDetalleVO> selectFctdList(final Long fctlId, final int offset, final int limit);

    /**
     * Busqueda de un detalle de factura a partir de su identificador.
     *
     * @param fctdId
     *            Identificador de detalle de factura.
     * @return the factura detalle vo
     */
    FacturaDetalleVO selectFctd(final Long fctdId);

}
