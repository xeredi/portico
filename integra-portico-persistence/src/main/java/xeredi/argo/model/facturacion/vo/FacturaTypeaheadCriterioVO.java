package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new factura typeahead criterio vo.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class FacturaTypeaheadCriterioVO extends BaseCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The serie. */
    private String serie;

    /** The anio. */
    private String anio;

    /** The numero. */
    private String numero;
}
