package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.comun.vo.Identifiable;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionTemporalVO.
 */
@Data
public final class ValoracionTemporalVO implements Identifiable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.vlrt;

    /** The id. */
    private Long id;

    /** The padre id. */
    private Long padreId;

    /** The prbt. */
    private Long prbtId;

    /** The srvc. */
    private Long srvcId;

    /** The ssrv. */
    private SubservicioVO ssrv;

    /** The crgo. */
    private CargoVO crgo;

    /** The rgla. */
    private ReglaVO rgla;

    /** The impuesto. */
    private ParametroVO impuesto;

    /** The pagador. */
    private ParametroVO pagador;

    /** The orden. */
    private Integer orden;

    /** The valor base. */
    private Double valorBase;

    /** The importe base. */
    private Double importeBase;

    /** The importe. */
    private Double importe;

    /** The importe inc. */
    private Double importeInc;

    /** The suj pasivo. */
    private Boolean sujPasivo;

    /** The cod exencion. */
    private String codExencion;

    /** The freferencia. */
    private Date freferencia;

    /** The fliquidacion. */
    private Date fliquidacion;

    /** The finicio. */
    private Date finicio;

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
