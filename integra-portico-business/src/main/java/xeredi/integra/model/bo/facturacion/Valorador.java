package xeredi.integra.model.bo.facturacion;

import java.util.Date;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface Valoracion.
 */
public interface Valorador {

    /**
     * Valorar servicio.
     *
     * @param srvcId
     *            the srvc id
     * @param crgoIds
     *            the crgo ids
     * @param fechaLiquidacion
     *            the fecha liquidacion
     * @param prbtId
     *            the prbt id
     */
    void valorarServicio(final Long srvcId, final Set<Long> crgoIds, final Date fechaLiquidacion, final Long prbtId);
}
