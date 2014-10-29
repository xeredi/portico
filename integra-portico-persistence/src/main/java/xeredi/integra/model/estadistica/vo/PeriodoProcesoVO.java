package xeredi.integra.model.estadistica.vo;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.maestro.vo.ParametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoVO.
 */
public final class PeriodoProcesoVO {

    /** The id. */
    private Long id;

    /** The autp. */
    private ParametroVO autp;

    /** The anio. */
    private Integer anio;

    /** The mes. */
    private Integer mes;

    /** The trimestre. */
    private Integer trimestre;

    /** The falta. */
    private Date freferencia;

    /** The falta. */
    private Date falta;

    /** The cdms generado. */
    private boolean cdmsGenerado;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        if (autp == null) {
            return null;
        }

        final StringBuffer buffer = new StringBuffer();

        if (autp != null && autp.getParametro() != null) {
            buffer.append(autp.getParametro());
        }

        if (anio != null) {
            buffer.append("/").append(StringUtils.leftPad(String.valueOf(anio), 4, '0'));
        }

        if (mes != null) {
            buffer.append("/").append(StringUtils.leftPad(String.valueOf(mes), 2, '0'));
        }

        return buffer.length() == 0 ? null : buffer.toString();
    }

    /**
     * Recalcular datos.
     */
    protected void recalcularDatos() {
        if (anio != null && mes != null) {
            final Calendar calendar = Calendar.getInstance();

            calendar.setTimeInMillis(0);
            calendar.set(Calendar.YEAR, anio);
            calendar.set(Calendar.MONTH, mes - 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            freferencia = calendar.getTime();
            trimestre = (mes - 1) / 3 + 1;
        }
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
     * Gets the autp.
     *
     * @return the autp
     */
    public ParametroVO getAutp() {
        return autp;
    }

    /**
     * Sets the autp.
     *
     * @param value
     *            the new autp
     */
    public void setAutp(final ParametroVO value) {
        autp = value;
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

        recalcularDatos();
    }

    /**
     * Gets the mes.
     *
     * @return the mes
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * Sets the mes.
     *
     * @param value
     *            the new mes
     */
    public void setMes(final Integer value) {
        mes = value;

        recalcularDatos();
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
     * Gets the trimestre.
     *
     * @return the trimestre
     */
    public Integer getTrimestre() {
        return trimestre;
    }

    /**
     * Sets the trimestre.
     *
     * @param value
     *            the new trimestre
     */
    public void setTrimestre(final Integer value) {
        trimestre = value;
    }

    /**
     * Gets the freferencia.
     *
     * @return the freferencia
     */
    public Date getFreferencia() {
        return freferencia;
    }

    /**
     * Sets the freferencia.
     *
     * @param value
     *            the new freferencia
     */
    public void setFreferencia(final Date value) {
        freferencia = value;
    }

    /**
     * Checks if is cdms generado.
     *
     * @return true, if is cdms generado
     */
    public boolean isCdmsGenerado() {
        return cdmsGenerado;
    }

    /**
     * Sets the cdms generado.
     *
     * @param value
     *            the new cdms generado
     */
    public void setCdmsGenerado(final boolean value) {
        cdmsGenerado = value;
    }

}
