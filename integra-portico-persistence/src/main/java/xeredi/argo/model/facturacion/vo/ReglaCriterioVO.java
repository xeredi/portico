package xeredi.argo.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ReglaCriterioVO extends BaseCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The incompatible id. */
    private Long incompatibleId;

    /** The tipo. */
    private ReglaTipo tipo;

    /** The crgo id. */
    private Long crgoId;

    /** The vlrc id. */
    private Long vlrcId;
}
