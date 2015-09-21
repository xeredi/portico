package xeredi.argo.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class PuertoVO.
 */
public final class PuertoVO {

    /** The id. */
    private Long id;

    /** The sprt. */
    private SuperpuertoVO sprt;

    /** The codigo. */
    private String codigo;

    /** The codigo corto. */
    private String codigoCorto;

    /** The codigo edi. */
    private String codigoEdi;

    /** The rec aduanero. */
    private String recAduanero;

    /** The unlocode. */
    private String unlocode;

    /** The nombre. */
    private String nombre;

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
        final StringBuffer buffer = new StringBuffer();

        buffer.append(codigo);

        if (nombre != null) {
            buffer.append(" - ").append(nombre);
        }

        return buffer.toString();
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
     * Gets the sprt.
     *
     * @return the sprt
     */
    public SuperpuertoVO getSprt() {
        return sprt;
    }

    /**
     * Sets the sprt.
     *
     * @param value
     *            the new sprt
     */
    public void setSprt(final SuperpuertoVO value) {
        sprt = value;
    }

    /**
     * Gets the codigo.
     *
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the codigo.
     *
     * @param value
     *            the new codigo
     */
    public void setCodigo(final String value) {
        codigo = value;
    }

    /**
     * Gets the codigo corto.
     *
     * @return the codigo corto
     */
    public String getCodigoCorto() {
        return codigoCorto;
    }

    /**
     * Sets the codigo corto.
     *
     * @param value
     *            the new codigo corto
     */
    public void setCodigoCorto(final String value) {
        codigoCorto = value;
    }

    /**
     * Gets the codigo edi.
     *
     * @return the codigo edi
     */
    public String getCodigoEdi() {
        return codigoEdi;
    }

    /**
     * Sets the codigo edi.
     *
     * @param value
     *            the new codigo edi
     */
    public void setCodigoEdi(final String value) {
        codigoEdi = value;
    }

    /**
     * Gets the rec aduanero.
     *
     * @return the rec aduanero
     */
    public String getRecAduanero() {
        return recAduanero;
    }

    /**
     * Sets the rec aduanero.
     *
     * @param value
     *            the new rec aduanero
     */
    public void setRecAduanero(final String value) {
        recAduanero = value;
    }

    /**
     * Gets the nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the nombre.
     *
     * @param value
     *            the new nombre
     */
    public void setNombre(final String value) {
        nombre = value;
    }

    /**
     * Gets the unlocode.
     *
     * @return the unlocode
     */
    public String getUnlocode() {
        return unlocode;
    }

    /**
     * Sets the unlocode.
     *
     * @param value
     *            the new unlocode
     */
    public void setUnlocode(final String value) {
        unlocode = value;
    }

}
