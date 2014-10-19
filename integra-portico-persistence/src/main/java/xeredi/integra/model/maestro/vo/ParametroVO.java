package xeredi.integra.model.maestro.vo;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.ItemVO;

// TODO: Auto-generated Javadoc
/**
 * Datos de un parametro.
 */
public final class ParametroVO extends ItemVO {

    /** Descripcion del parametro. */
    private String parametro;

    /** The prvr. */
    private ParametroVersionVO prvr;

    /** Datos de i18n del parametro. */
    private I18nVO i18n;

    /**
     * Instantiates a new parametro vo.
     */
    public ParametroVO() {
        super();

        prvr = new ParametroVersionVO();
        i18n = new I18nVO();
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

        if (i18n != null && i18n.getText() != null) {
            buffer.append(" - ").append(i18n.getText());
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

        return buffer.length() == 0 ? null : buffer.toString()/* StringEscapeUtils.escapeHtml4(buffer.toString()) */;
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
     * Gets the i18n.
     *
     * @return the i18n
     */
    public I18nVO getI18n() {
        return i18n;
    }

    /**
     * Sets the i18n.
     *
     * @param value
     *            the new i18n
     */
    public void setI18n(final I18nVO value) {
        i18n = value;
    }

    /**
     * Gets the prvr.
     *
     * @return the prvr
     */
    public ParametroVersionVO getPrvr() {
        return prvr;
    }

    /**
     * Sets the prvr.
     *
     * @param value
     *            the new prvr
     */
    public void setPrvr(final ParametroVersionVO value) {
        prvr = value;
    }

}
