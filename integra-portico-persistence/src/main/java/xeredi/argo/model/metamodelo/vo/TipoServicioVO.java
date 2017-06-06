package xeredi.argo.model.metamodelo.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoServicioVO extends EntidadVO {
    /** The temporal. */
    private Boolean temporal;

    /** The facturable. */
    private Boolean facturable;

    /** The exencionable. */
    private Boolean exencionable;

    /** The tpdt estado. */
    private TipoDatoVO tpdtEstado;

    /** The estados vlrc. */
    private String estadosVlrc;

    /** The estado def. */
    private String estadoDef;

    /** The estados vlrc set. */
    private Set<String> estadosVlrcSet;

    /**
     * Sets the estados vlrc.
     *
     * @param value
     *            the new estados vlrc
     */
    public void setEstadosVlrc(final String value) {
        estadosVlrc = value;

        if (estadosVlrc != null) {
            estadosVlrcSet = new HashSet<>();

            final StringTokenizer tokenizer = new StringTokenizer(estadosVlrc, ",");

            while (tokenizer.hasMoreTokens()) {
                estadosVlrcSet.add(tokenizer.nextToken().trim());
            }
        }
    }
}
