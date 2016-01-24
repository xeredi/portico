package xeredi.argo.model.comun.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoCriterioVO.
 */
@Data
public final class ArchivoCriterioVO extends BaseCriterioVO {

    /** The id. */
    private Long id;

    /** The srvc id. */
    private Long srvcId;

    /** The prbt id. */
    private Long prbtId;

    /** The sentido. */
    private ArchivoSentido sentido;
}
