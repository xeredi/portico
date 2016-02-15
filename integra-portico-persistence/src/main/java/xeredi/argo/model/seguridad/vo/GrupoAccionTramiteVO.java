package xeredi.argo.model.seguridad.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionTramiteVO.
 */
@Data
public final class GrupoAccionTramiteVO {

    /** The grpo id. */
    private Long grpoId;

    /** The acen id. */
    private Long actrId;

    /**
     * Instantiates a new grupo accion tramite vo.
     */
    public GrupoAccionTramiteVO() {
        super();
    }

    /**
     * Instantiates a new grupo accion tramite vo.
     *
     * @param agrpoId
     *            the agrpo id
     * @param aactrId
     *            the aactr id
     */
    public GrupoAccionTramiteVO(final Long agrpoId, final Long aactrId) {
        super();
        grpoId = agrpoId;
        actrId = aactrId;
    }
}
