package xeredi.integra.model.facturacion.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaSerieCriterioVO.
 */
public final class FacturaSerieCriterioVO {

    /** The anio. */
    private Integer anio;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     *            the new anio
     */
    public void setAnio(final Integer value) {
        anio = value;
    }

}
