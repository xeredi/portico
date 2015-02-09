package xeredi.integra.model.proceso.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoVO.
 */
public final class ProcesoVO {

    /** The id. */
    private Long id;

    /** The modulo. */
    private ProcesoModulo modulo;

    /** The tipo. */
    private ProcesoTipo tipo;

    /** The estado. */
    private ProcesoEstado estado;

    /** The falta. */
    private Date falta;

    /** The finicio. */
    private Date finicio;

    /** The ffin. */
    private Date ffin;

    /** The errores cnt. */
    private Integer erroresCnt;

    /** The alertas cnt. */
    private Integer alertasCnt;

    /** The mensajes cnt. */
    private Integer mensajesCnt;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the duracion.
     *
     * @return the duracion
     */
    public Long getDuracion() {
        if (finicio != null && ffin != null) {
            return ffin.getTime() - finicio.getTime();
        }

        return null;
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
     * Gets the modulo.
     *
     * @return the modulo
     */
    public ProcesoModulo getModulo() {
        return modulo;
    }

    /**
     * Sets the modulo.
     *
     * @param value
     *            the new modulo
     */
    public void setModulo(final ProcesoModulo value) {
        modulo = value;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public ProcesoTipo getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param value
     *            the new tipo
     */
    public void setTipo(final ProcesoTipo value) {
        tipo = value;
    }

    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public ProcesoEstado getEstado() {
        return estado;
    }

    /**
     * Sets the estado.
     *
     * @param value
     *            the new estado
     */
    public void setEstado(final ProcesoEstado value) {
        estado = value;
    }

    /**
     * Gets the falta.
     *
     * @return the falta
     */
    public Date getFalta() {
        return falta;
    }

    /**
     * Sets the falta.
     *
     * @param value
     *            the new falta
     */
    public void setFalta(final Date value) {
        falta = value;
    }

    /**
     * Gets the finicio.
     *
     * @return the finicio
     */
    public Date getFinicio() {
        return finicio;
    }

    /**
     * Sets the finicio.
     *
     * @param value
     *            the new finicio
     */
    public void setFinicio(final Date value) {
        finicio = value;
    }

    /**
     * Gets the ffin.
     *
     * @return the ffin
     */
    public Date getFfin() {
        return ffin;
    }

    /**
     * Sets the ffin.
     *
     * @param value
     *            the new ffin
     */
    public void setFfin(final Date value) {
        ffin = value;
    }

    /**
     * Gets the errores cnt.
     *
     * @return the errores cnt
     */
    public Integer getErroresCnt() {
        return erroresCnt;
    }

    /**
     * Sets the errores cnt.
     *
     * @param value
     *            the new errores cnt
     */
    public void setErroresCnt(final Integer value) {
        erroresCnt = value;
    }

    /**
     * Gets the alertas cnt.
     *
     * @return the alertas cnt
     */
    public Integer getAlertasCnt() {
        return alertasCnt;
    }

    /**
     * Sets the alertas cnt.
     *
     * @param value
     *            the new alertas cnt
     */
    public void setAlertasCnt(final Integer value) {
        alertasCnt = value;
    }

    /**
     * Gets the mensajes cnt.
     *
     * @return the mensajes cnt
     */
    public Integer getMensajesCnt() {
        return mensajesCnt;
    }

    /**
     * Sets the mensajes cnt.
     *
     * @param value
     *            the new mensajes cnt
     */
    public void setMensajesCnt(final Integer value) {
        mensajesCnt = value;
    }

}
