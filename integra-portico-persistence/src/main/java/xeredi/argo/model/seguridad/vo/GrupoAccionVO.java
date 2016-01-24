package xeredi.argo.model.seguridad.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionVO.
 */
@Data
public final class GrupoAccionVO {

    /** The grpo id. */
    private Long grpoId;

    /** The accn id. */
    private Long accnId;

    /**
     * Instantiates a new grupo accion vo.
     */
    public GrupoAccionVO() {
        super();
    }

    /**
     * Instantiates a new grupo accion vo.
     *
     * @param agrpoId
     *            the agrpo id
     * @param aaccnId
     *            the aaccn id
     */
    public GrupoAccionVO(final Long agrpoId, final Long aaccnId) {
        super();
        grpoId = agrpoId;
        accnId = aaccnId;
    }
}
