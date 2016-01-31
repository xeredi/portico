package xeredi.argo.model.comun.vo;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class PuertoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The sprt id. */
    private Long sprtId;

    /** The codigo. */
    private String codigo;

    /** The codigo corto. */
    private String codigoCorto;

    /** The codigo edi. */
    private String codigoEdi;

    /** The rec aduanero. */
    private String recAduanero;

    /** The unlocode. */
    private String unlocode;
}
