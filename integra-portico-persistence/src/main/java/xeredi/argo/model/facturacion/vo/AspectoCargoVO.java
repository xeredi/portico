package xeredi.argo.model.facturacion.vo;

import java.util.Date;

import lombok.Data;
import xeredi.argo.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoCargoVO.
 */
@Data
public final class AspectoCargoVO implements Versionable<AspectoCargoVersionVO> {

    /** The id. */
    private Long id;

    /** The aspc id. */
    private Long aspcId;

    /** The crgo. */
    private CargoVO crgo;

    /** The ascv. */
    private AspectoCargoVersionVO version;

    /** The fref. */
    private Date fref;

    /**
     * Instantiates a new aspecto cargo vo.
     */
    public AspectoCargoVO() {
        super();

        version = new AspectoCargoVersionVO();
    }
}
