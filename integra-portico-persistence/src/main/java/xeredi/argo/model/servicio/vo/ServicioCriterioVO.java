package xeredi.argo.model.servicio.vo;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioCriterioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class ServicioCriterioVO extends ItemCriterioVO {

    /** The subp id. */
    private PuertoCriterioVO prto;

    /** The anno. */
    private String anno;

    /** The numero. */
    private String numero;

    /** The estado. */
    private String estado;

    /** The fref min. */
    private Date frefMin;

    /** The fref max. */
    private Date frefMax;

    /** The fini min. */
    private Date finiMin;

    /** The fini max. */
    private Date finiMax;

    /** The ffin min. */
    private Date ffinMin;

    /** The ffin max. */
    private Date ffinMax;
}
