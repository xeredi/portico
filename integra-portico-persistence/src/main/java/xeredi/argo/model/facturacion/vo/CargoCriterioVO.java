package xeredi.argo.model.facturacion.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.vo.BaseCriterioVO;
import xeredi.argo.model.comun.vo.Typeahead;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class CargoCriterioVO extends BaseCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The id. */
    private Long id;

    /** The ids. */
    private Set<Long> ids;

    /** The padre id. */
    private Long padreId;

    /** The padre ids. */
    private Set<Long> padreIds;

    /** The solo principales. */
    private boolean soloPrincipales;

    /** The solo dependientes. */
    private boolean soloDependientes;

    /** The codigo. */
    private String codigo;

    /** The codigo normalizado. */
    private String codigoNormalizado;

    /** The tpsr id. */
    private Long tpsrId;

    /** The srvc id. */
    private Long srvcId;

    /** The aspc id. */
    private Long aspcId;

    /** The vlrc id. */
    private Long vlrcId;
}
