package xeredi.argo.model.facturacion.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.VersionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoVersionVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class CargoVersionVO extends VersionVO {
    /** The codigo normalizado. */
    private String codigoNormalizado;

    /** The principal. */
    private Boolean principal;

    /** The temporal. */
    private Boolean temporal;

    /** The tipo. */
    private CargoTipo tipo;

    /** The descripcion. */
    private String descripcion;
}
