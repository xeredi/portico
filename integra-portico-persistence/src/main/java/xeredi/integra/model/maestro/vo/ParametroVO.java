package xeredi.integra.model.maestro.vo;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.ItemVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.comun.vo.Versionable;

// TODO: Auto-generated Javadoc
/**
 * Datos de un parametro.
 */
public final class ParametroVO extends ItemVO implements Versionable<ParametroVersionVO> {

    /** Descripcion del parametro. */
    private String parametro;

    /** The prto. */
    private PuertoVO prto;

    /** The prvr. */
    private ParametroVersionVO version;

    /** The texto. */
    private String texto;

    /**
     * Instantiates a new parametro vo.
     */
    public ParametroVO() {
        super();

        version = new ParametroVersionVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

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
     * Gets the texto.
     *
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Sets the texto.
     *
     * @param value
     *            the new texto
     */
    public void setTexto(final String value) {
        texto = value;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getParametro() {
        return parametro;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametroVersionVO getVersion() {
        return version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVersion(final ParametroVersionVO value) {
        version = value;
    }

    /**
     * Gets the prto.
     *
     * @return the prto
     */
    public PuertoVO getPrto() {
        return prto;
    }

    /**
     * Sets the prto.
     *
     * @param value
     *            the new prto
     */
    public void setPrto(final PuertoVO value) {
        prto = value;
    }
}
