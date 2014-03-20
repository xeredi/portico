package xeredi.integra.model.vo.metamodelo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroTipoDatoVO.
 */
public final class EntidadTipoDatoVO {

    /** The tppr id. */
    private Long entiId;

    /** The tpdt. */
    private TipoDatoVO tpdt;

    /** The grupo. */
    private Integer grupo;

    /** The fila. */
    private Integer fila;

    /** The orden. */
    private Integer orden;

    /** The span. */
    private Integer span;

    /** The obligatorio. */
    private boolean obligatorio;

    /** The gridable. */
    private boolean gridable;

    /** The filtrable. */
    private boolean filtrable;

    /** The valor defecto. */
    private String valorDefecto;

    /** The etiqueta. */
    private String etiqueta;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the span lg.
     * 
     * @return the span lg
     */
    public Integer getSpanLg() {
        // return span > 2 && span < 12 ? span * 3 / 4 : span;
        return span;
    }

    /**
     * Gets the tpdt.
     * 
     * @return the tpdt
     */
    public TipoDatoVO getTpdt() {
        return tpdt;
    }

    /**
     * Sets the tpdt.
     * 
     * @param value
     *            the new tpdt
     */
    public void setTpdt(final TipoDatoVO value) {
        tpdt = value;
    }

    /**
     * Gets the orden.
     * 
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * Sets the orden.
     * 
     * @param value
     *            the new orden
     */
    public void setOrden(final Integer value) {
        orden = value;
    }

    /**
     * Gets the etiqueta.
     * 
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Sets the etiqueta.
     * 
     * @param value
     *            the new etiqueta
     */
    public void setEtiqueta(final String value) {
        etiqueta = value;
    }

    /**
     * Checks if is obligatorio.
     * 
     * @return true, if is obligatorio
     */
    public boolean isObligatorio() {
        return obligatorio;
    }

    /**
     * Sets the obligatorio.
     * 
     * @param value
     *            the new obligatorio
     */
    public void setObligatorio(final boolean value) {
        obligatorio = value;
    }

    /**
     * Checks if is gridable.
     * 
     * @return true, if is gridable
     */
    public boolean isGridable() {
        return gridable;
    }

    /**
     * Sets the gridable.
     * 
     * @param value
     *            the new gridable
     */
    public void setGridable(final boolean value) {
        gridable = value;
    }

    /**
     * Checks if is filtrable.
     * 
     * @return true, if is filtrable
     */
    public boolean isFiltrable() {
        return filtrable;
    }

    /**
     * Sets the filtrable.
     * 
     * @param value
     *            the new filtrable
     */
    public void setFiltrable(final boolean value) {
        filtrable = value;
    }

    /**
     * Gets the enti id.
     * 
     * @return the enti id
     */
    public Long getEntiId() {
        return entiId;
    }

    /**
     * Sets the enti id.
     * 
     * @param value
     *            the new enti id
     */
    public void setEntiId(final Long value) {
        entiId = value;
    }

    /**
     * Gets the fila.
     * 
     * @return the fila
     */
    public Integer getFila() {
        return fila;
    }

    /**
     * Sets the fila.
     * 
     * @param value
     *            the new fila
     */
    public void setFila(final Integer value) {
        fila = value;
    }

    /**
     * Gets the span.
     * 
     * @return the span
     */
    public Integer getSpan() {
        return span;
    }

    /**
     * Sets the span.
     * 
     * @param value
     *            the new span
     */
    public void setSpan(final Integer value) {
        span = value;
    }

    /**
     * Gets the valor defecto.
     * 
     * @return the valor defecto
     */
    public String getValorDefecto() {
        return valorDefecto;
    }

    /**
     * Sets the valor defecto.
     * 
     * @param value
     *            the new valor defecto
     */
    public void setValorDefecto(final String value) {
        valorDefecto = value;
    }

    /**
     * Gets the grupo.
     * 
     * @return the grupo
     */
    public Integer getGrupo() {
        return grupo;
    }

    /**
     * Sets the grupo.
     * 
     * @param value
     *            the new grupo
     */
    public void setGrupo(final Integer value) {
        grupo = value;
    }

}
