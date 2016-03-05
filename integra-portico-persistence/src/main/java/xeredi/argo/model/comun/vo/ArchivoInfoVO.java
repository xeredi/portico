package xeredi.argo.model.comun.vo;

import java.util.Date;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoInfoVO.
 */
@Data
public final class ArchivoInfoVO {

    /** The id. */
    private Long id;

    /** The filename. */
    private String nombre;

    /** The filesize. */
    private Long tamanio;

    /** The sentido. */
    private ArchivoSentido sentido;

    /** The falta. */
    private Date falta;
}
