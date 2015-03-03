package xeredi.integra.model.metamodelo.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroTipoDatoVO.
 */
public final class EntidadTipoDatoVO {

    /** The id. */
    private Long id;

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
    private Boolean obligatorio;

    /** The gridable. */
    private Boolean gridable;

    /** The filtrable. */
    private Boolean filtrable;

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
     * Gets the span normalizado.
     *
     * @param span
     *            the span
     * @return the span normalizado
     */
    private Integer getSpanNormalizado(final Double span) {
        if (span == null) {
            return null;
        }

        if (span < 1) {
            return 1;
        }

        if (span > 12) {
            return 12;
        }

        return (int) Math.round(span);
    }

    /**
     * Gets the span xl.
     *
     * @return the span xl
     */
    public Integer getSpanXl() {
        return getSpanNormalizado(span / 1.61);
    }

    /**
     * Gets the span lg.
     *
     * @return the span lg
     */
    public Integer getSpanLg() {
        return getSpanNormalizado(span / 1.21);
    }

    /**
     * Gets the span sm.
     *
     * @return the span sm
     */
    public Integer getSpanSm() {
        return getSpanNormalizado(span * 1.29);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param value
     *            the new id
     */
    public void setId(final Long value) {
        id = value;
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

    /**
     * Gets the obligatorio.
     *
     * @return the obligatorio
     */
    public Boolean getObligatorio() {
        return obligatorio;
    }

    /**
     * Sets the obligatorio.
     *
     * @param value
     *            the new obligatorio
     */
    public void setObligatorio(final Boolean value) {
        obligatorio = value;
    }

    /**
     * Gets the gridable.
     *
     * @return the gridable
     */
    public Boolean getGridable() {
        return gridable;
    }

    /**
     * Sets the gridable.
     *
     * @param value
     *            the new gridable
     */
    public void setGridable(final Boolean value) {
        gridable = value;
    }

    /**
     * Gets the filtrable.
     *
     * @return the filtrable
     */
    public Boolean getFiltrable() {
        return filtrable;
    }

    /**
     * Sets the filtrable.
     *
     * @param value
     *            the new filtrable
     */
    public void setFiltrable(final Boolean value) {
        filtrable = value;
    }

}
