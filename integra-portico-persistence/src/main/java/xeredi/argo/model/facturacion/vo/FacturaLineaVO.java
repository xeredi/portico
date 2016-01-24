package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaVO.
 */
@Data
public final class FacturaLineaVO {

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The fctr id. */
    private Long fctrId;

    /** The fcts id. */
    private FacturaServicioVO fcts;

    /** The rgla. */
    private ReglaVO rgla;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The ssrv. */
    private SubservicioVO ssrv;

    /** The fini. */
    private Date fini;

    /** The ffin. */
    private Date ffin;

    /** The importe base. */
    private Double importeBase;

    /** The importe. */
    private Double importe;

    /** The fctd count. */
    private Integer fctdCount;

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
