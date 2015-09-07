package xeredi.integra.model.metamodelo.vo;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubservicioVO.
 */
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the tpsr id.
     *
     * @return the tpsr id
     */
    public Long getTpsrId() {
        return tpsrId;
    }

    /**
     * Sets the tpsr id.
     *
     * @param value
     *            the new tpsr id
     */
    public void setTpsrId(final Long value) {
        tpsrId = value;
    }

    /**
     * Gets the temporal.
     *
     * @return the temporal
     */
    public boolean isTemporal() {
        return temporal;
    }

    /**
     * Sets the temporal.
     *
     * @param value
     *            the new temporal
     */
    public void setTemporal(final boolean value) {
        temporal = value;
    }

    /**
     * Gets the facturable.
     *
     * @return the facturable
     */
    public boolean isFacturable() {
        return facturable;
    }

    /**
     * Sets the facturable.
     *
     * @param value
     *            the new facturable
     */
    public void setFacturable(final boolean value) {
        facturable = value;
    }

    /**
     * Gets the tpdt estado.
     *
     * @return the tpdt estado
     */
    public TipoDatoVO getTpdtEstado() {
        return tpdtEstado;
    }

    /**
     * Sets the tpdt estado.
     *
     * @param value
     *            the new tpdt estado
     */
    public void setTpdtEstado(final TipoDatoVO value) {
        tpdtEstado = value;
    }

    /**
     * Gets the exencionable.
     *
     * @return the exencionable
     */
    public boolean isExencionable() {
        return exencionable;
    }

    /**
     * Sets the exencionable.
     *
     * @param value
     *            the new exencionable
     */
    public void setExencionable(final boolean value) {
        exencionable = value;
    }

    /**
     * Gets the estados vlrc.
     *
     * @return the estados vlrc
     */
    public String getEstadosVlrc() {
        return estadosVlrc;
    }

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

    /**
     * Gets the estados vlrc set.
     *
     * @return the estados vlrc set
     */
    public Set<String> getEstadosVlrcSet() {
        return estadosVlrcSet;
    }

    /**
     * Gets the estado def.
     *
     * @return the estado def
     */
    public String getEstadoDef() {
        return estadoDef;
    }

    /**
     * Sets the estado def.
     *
     * @param value
     *            the new estado def
     */
    public void setEstadoDef(final String value) {
        estadoDef = value;
    }
}
