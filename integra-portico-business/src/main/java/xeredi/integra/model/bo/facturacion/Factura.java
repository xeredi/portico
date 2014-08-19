package xeredi.integra.model.bo.facturacion;

import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Interface Factura.
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
}
