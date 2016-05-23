package xeredi.argo.model.maestro.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.Typeahead;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class SubparametroCriterioVO extends ItemCriterioVO implements Typeahead {

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /** The spvr id. */
    private Long versionId;

    /** The spvr ids. */
    private Set<Long> versionIds;

    /** The tpsp. */
    private TipoSubparametroCriterioVO tpsp;

    /** The prmt. */
    private ParametroCriterioVO prmt;

    /** The prmt asociado. */
    private ParametroCriterioVO prmtAsociado;
}
