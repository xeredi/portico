package xeredi.argo.model.servicio.vo;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioCriterioVO.
 */
@Data
public final class SubservicioCriterioVO extends ItemCriterioVO {

    /** The padre id. */
    private Long padreId;

    /** The padre ids. */
    private Set<Long> padreIds;

    /** The hijo id. */
    private Long hijoId;

    /** The hijo ids. */
    private Set<Long> hijoIds;

    /** The numero. */
    private Integer numero;

    /** The estado. */
    private String estado;

    /** The fini min. */
    private Date finiMin;

    /** The fini max. */
    private Date finiMax;

    /** The ffin min. */
    private Date ffinMin;

    /** The ffin max. */
    private Date ffinMax;

    /** The srvc. */
    private ServicioCriterioVO srvc;
}
