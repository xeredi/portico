package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCriterioVO.
 */
@Data
public final class AspectoCriterioVO extends BaseCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The aspv id. */
    private Long aspvId;

    /** The srvc id. */
    private Long srvcId;

    /** The codigo. */
    private String codigo;

    /** The tpsr id. */
    private Long tpsrId;

    /** The vlrc id. */
    private Long vlrcId;
}
