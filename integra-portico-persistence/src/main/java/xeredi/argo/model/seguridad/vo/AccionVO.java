package xeredi.argo.model.seguridad.vo;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class AccionVO.
 */
@Data
public final class AccionVO {

    /** The id. */
    private Long id;

    /** The prefix. */
    private AccionPrefix prefix;

    /** The codigo. */
    private AccionCodigo codigo;

    /** The core. */
    private Boolean core;

    /** The multiple. */
    private Boolean multiple;

    /** The grpo ids. */
    private Set<Long> grpoIds;

    /**
     * Instantiates a new accion vo.
     */
    public AccionVO() {
        super();

        grpoIds = new HashSet<>();
    }

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return prefix == null ? null : prefix.name() + '-' + codigo;
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return (prefix == null ? " - " : prefix.name()) + " - " + codigo;
    }
}
