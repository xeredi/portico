package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionVO.
 */
@Data
public final class ValoracionVO {

    /** The id. */
    private Long id;

    /** The srvc. */
    private ServicioVO srvc;

    /** The aspc. */
    private AspectoVO aspc;

    /** The pagador. */
    private ParametroVO pagador;

    /** The fref. */
    private Date fref;

    /** The falta. */
    private Date falta;

    /** The fliq. */
    private Date fliq;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The importe. */
    private Double importe;

    /** The iva. */
    private Double impuesto;

    /** The suj pasivo. */
    private Boolean sujPasivo;

    /** The cod exencion. */
    private String codExencion;

    /** The fctr. */
    private FacturaVO fctr;

    /** The info1. */
    private String info1;

    /** The info2. */
    private String info2;

    /** The info3. */
    private String info3;

    /** The info4. */
    private String info4;

    /** The info5. */
    private String info5;

    /** The info6. */
    private String info6;
}
