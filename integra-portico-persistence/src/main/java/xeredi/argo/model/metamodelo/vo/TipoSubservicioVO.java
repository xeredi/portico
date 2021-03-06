package xeredi.argo.model.metamodelo.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioVO.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoSubservicioVO extends EntidadVO {
    /** The tpsr id. */
    private Long tpsrId;

    /** The temporal. */
    private boolean temporal;

    /** The facturable. */
    private boolean facturable;

    /** The exencionable. */
    private boolean exencionable;

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
