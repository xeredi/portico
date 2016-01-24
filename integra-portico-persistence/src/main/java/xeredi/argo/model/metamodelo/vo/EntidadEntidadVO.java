package xeredi.argo.model.metamodelo.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadVO.
 */
@Data
public final class EntidadEntidadVO {

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private EntidadVO entiHija;

    /** The orden. */
    private Integer orden;
}
