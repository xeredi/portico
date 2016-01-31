package xeredi.argo.model.metamodelo.vo;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new campo dimension vo.
 */

/**
 * Instantiates a new campo dimension vo.
 */
@Data
public final class CampoDimensionVO {

    /** The id. */
    private Long id;

    /** The path. */
    private String path;

    /** The sql path. */
    private String sqlPath;

    /** The nombre. */
    private String nombre;

    /** The entd. */
    private EntidadTipoDatoVO entd;
}
