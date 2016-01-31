package xeredi.argo.model.metamodelo.vo;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoDatoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoDatoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The tipo elemento. */
    private TipoElemento tipoElemento;

    /** The tpht id. */
    private TipoHtml tpht;

    /** The tppr id. */
    private Long entiId;

    /** The enti ref id. */
    private Long entiRefId;
}
