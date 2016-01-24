package xeredi.argo.model.servicio.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class SubservicioSubservicioVO.
 */
@Data
public final class SubservicioSubservicioVO {

    /** The ssrv padre id. */
    private final Long ssrvPadreId;

    /** The ssrv hijo id. */
    private final Long ssrvHijoId;

    /**
     * Instantiates a new subservicio subservicio vo.
     *
     * @param assrvPadreId
     *            the assrv padre id
     * @param assrvHijoId
     *            the assrv hijo id
     */
    public SubservicioSubservicioVO(final Long assrvPadreId, final Long assrvHijoId) {
        super();
        ssrvPadreId = assrvPadreId;
        ssrvHijoId = assrvHijoId;
    }
}
