package xeredi.argo.model.maestro.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.lang3.StringEscapeUtils;

import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.Versionable;
import xeredi.argo.model.item.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * Datos de un parametro.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ParametroVO extends ItemVO implements Versionable<ParametroVersionVO> {

    /** Descripcion del parametro. */
    private String parametro;

    /** The prto. */
    private PuertoVO prto;

    /** The prvr. */
    private ParametroVersionVO version = new ParametroVersionVO();

    /** The texto. */
    private String texto;

    /**
     * Gets the etiqueta string buffer.
     *
     * @return the etiqueta string buffer
     */
    private StringBuffer getEtiquetaStringBuffer() {
        final StringBuffer buffer = new StringBuffer();

        if (parametro != null) {
            buffer.append(parametro);
        }

        if (texto != null) {
            buffer.append(" - ").append(texto);
        }

        return buffer;
    }

    /**
     * Gets the etiqueta.
     *
     * @return the etiqueta
     */
    @Override
    public String getEtiqueta() {
        final StringBuffer buffer = getEtiquetaStringBuffer();

        return buffer.length() == 0 ? null : buffer.toString()/*
         * StringEscapeUtils.escapeHtml4(buffer.toString(
         * ))
         */;
    }

    /**
     * Gets the etiqueta csv.
     *
     * @return the etiqueta csv
     */
    public String obtenerEtiquetaCSV() {
        final StringBuffer buffer = getEtiquetaStringBuffer();

        return buffer.length() == 0 ? null : StringEscapeUtils.escapeCsv(buffer.toString());
    }

    /**
     * Sets the descripcion.
     *
     * @param value
     *            the new descripcion
     */
    public void setParametro(final String value) {
        if (value != null) {
            parametro = value.trim().toUpperCase();
        }
    }
}
