package xeredi.argo.model.estadistica.vo;

import java.util.Calendar;
import java.util.Date;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;

import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoVO.
 */
@Data
public final class PeriodoProcesoVO {

    /** The id. */
    private Long id;

    /** The autp. */
    private SuperpuertoVO sprt;

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
    private Boolean cdmsGenerado;

    /** The arin. */
    private ArchivoInfoVO arin;

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public String getFilename() {
        if (sprt == null || anio == null || mes == null) {
            return null;
        }

        return sprt.getCodigo() + anio + StringUtils.leftPad(mes.toString(), 2, '0');
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    public String getEtiqueta() {
        if (sprt == null) {
            return null;
        }

        final StringBuffer buffer = new StringBuffer();

        if (sprt.getCodigo() != null) {
            buffer.append(sprt.getCodigo());
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
     * Sets the mes.
     *
     * @param value
     *            the new mes
     */
    public void setMes(final Integer value) {
        mes = value;

        recalcularDatos();
    }
}
