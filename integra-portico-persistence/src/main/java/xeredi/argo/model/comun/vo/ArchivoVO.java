package xeredi.argo.model.comun.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoVO.
 */
@Data
public final class ArchivoVO {

    /** The info. */
    private ArchivoInfoVO arin = new ArchivoInfoVO();

    /** The stream. */
    private byte[] archivo;
}
