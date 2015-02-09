package xeredi.integra.model.comun.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ArchivoVO.
 */
public final class ArchivoVO {

    /** The info. */
    private ArchivoInfoVO arin;

    /** The stream. */
    private byte[] archivo;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Gets the arin.
     *
     * @return the arin
     */
    public ArchivoInfoVO getArin() {
        return arin;
    }

    /**
     * Sets the arin.
     *
     * @param value
     *            the new arin
     */
    public void setArin(final ArchivoInfoVO value) {
        arin = value;
    }

    /**
     * Gets the archivo.
     *
     * @return the archivo
     */
    public byte[] getArchivo() {
        return archivo;
    }

    /**
     * Sets the archivo.
     *
     * @param value
     *            the new archivo
     */
    public void setArchivo(final byte[] value) {
        archivo = value;
    }

}
