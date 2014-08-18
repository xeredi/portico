package xeredi.integra.model.vo.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieVO.
 */
public final class FacturaSerieVO {

    /** The id. */
    private Long id;

    /** The serie. */
    private String serie;

    /** The anio. */
    private Integer anio;

    /** The numero ultimo. */
    private Integer numeroUltimo;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     *            the id
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the serie.
     *
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Sets the serie.
     *
     * @param value
     *            the serie
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Gets the anio.
     *
     * @return the anio
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * Sets the anio.
     *
     * @param value
     *            the anio
     */
    public void setAnio(Integer value) {
        this.anio = value;
    }

    /**
     * Gets the numero ultimo.
     *
     * @return the numero ultimo
     */
    public Integer getNumeroUltimo() {
        return numeroUltimo;
    }

    /**
     * Sets the numero ultimo.
     *
     * @param value
     *            the numero ultimo
     */
    public void setNumeroUltimo(Integer value) {
        this.numeroUltimo = value;
    }

}
