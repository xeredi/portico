package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaVO.
 */
@Data
public final class ValoracionLineaVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.vlrl;

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The vlrc id. */
    private Long vlrcId;

    /** The fref. */
    private Date fref;

    /** The rgla. */
    private ReglaVO rgla;

    /** The importe base. */
    private Double importeBase;

    /** The importe. */
    private Double importe;

    /** The subtotal. */
    private Double subtotal;

    /** The vlrd count. */
    private Integer vlrdCount;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The ssrv. */
    private SubservicioVO ssrv;

    /** The srvc id. */
    private Long srvcId;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The cuant1. */
    private Double cuant1;

    /** The cuant2. */
    private Double cuant2;

    /** The cuant3. */
    private Double cuant3;

    /** The cuant4. */
    private Double cuant4;

    /** The cuant5. */
    private Double cuant5;

    /** The cuant6. */
    private Double cuant6;

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
