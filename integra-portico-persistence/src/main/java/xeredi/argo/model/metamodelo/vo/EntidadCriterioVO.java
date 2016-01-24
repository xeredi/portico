package xeredi.argo.model.metamodelo.vo;

import java.util.Set;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadCriterioVO.
 */
@Data
public class EntidadCriterioVO extends BaseCriterioVO {

    /** The ids. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The tipo. */
    private TipoEntidad tipo;

    /** The codigos. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /** The enti padre id. */
    private Long entiPadreId;

    /** The enti hija id. */
    private Long entiHijaId;
}
