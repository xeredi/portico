package xeredi.integra.model.bo.facturacion;

import java.util.Date;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface Facturador.
 */
public interface Facturador {

    /**
     * Facturar valoraciones.
     *
     * @param vlrcIds
     *            {@link Set} de valoraciones a facturar.
     * @param aspcId
     *            Identificador de Aspecto.
     * @param fasrId
     *            Identificador de serie de factura.
     * @param fechaFacturacion
     *            Fecha de Facturacion.
     * @param prbtId
     *            Identificador del proceso batch.
     */
    void facturarValoraciones(final Set<Long> vlrcIds, final Long aspcId, final Long fasrId,
            final Date fechaFacturacion, final Long prbtId);
}
