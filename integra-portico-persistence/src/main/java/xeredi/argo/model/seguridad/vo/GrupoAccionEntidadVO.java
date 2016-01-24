package xeredi.argo.model.seguridad.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class GrupoAccionEntidadVO.
 */
@Data
public final class GrupoAccionEntidadVO {

    /** The grpo id. */
    private Long grpoId;

    /** The acen id. */
    private Long acenId;

    /**
     * Instantiates a new grupo accion entidad vo.
     */
    public GrupoAccionEntidadVO() {
        super();
    }

    /**
     * Instantiates a new grupo accion entidad vo.
     *
     * @param agrpoId
     *            the agrpo id
     * @param aacenId
     *            the aacen id
     */
    public GrupoAccionEntidadVO(final Long agrpoId, final Long aacenId) {
        super();
        grpoId = agrpoId;
        acenId = aacenId;
    }
}
