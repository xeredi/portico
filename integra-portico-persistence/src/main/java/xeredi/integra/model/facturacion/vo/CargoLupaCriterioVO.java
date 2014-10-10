package xeredi.integra.model.facturacion.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoLupaCriterioVO.
 */
public final class CargoLupaCriterioVO {

    /** The tpsr id. */
    private Long tpsrId;

    /** The texto busqueda. */
    private String textoBusqueda;

    /** The fecha vigencia. */
    private Date fechaVigencia;

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
     * Gets the texto busqueda.
     *
     * @return the texto busqueda
     */
    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    /**
     * Sets the texto busqueda.
     *
     * @param value
     *            the new texto busqueda
     */
    public void setTextoBusqueda(final String value) {
        textoBusqueda = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

}
