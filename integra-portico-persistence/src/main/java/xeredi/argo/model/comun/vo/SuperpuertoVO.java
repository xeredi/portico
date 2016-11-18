package xeredi.argo.model.comun.vo;

import java.io.Serializable;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class SuperpuertoVO.
 */
@Data
public final class SuperpuertoVO implements Identifiable, I18nable, Serializable {

    /** The prefix. */
    private final transient ClassPrefix prefix = ClassPrefix.sprt;

    /** The id. */
    private Long id;

    /** The codigo. */
    private String codigo;

    /** The nombre. */
    private String nombre;

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        final StringBuffer buffer = new StringBuffer();

        buffer.append(codigo);

        if (nombre != null) {
            buffer.append(" - ").append(nombre);
        }

        return buffer.toString();
    }
}
