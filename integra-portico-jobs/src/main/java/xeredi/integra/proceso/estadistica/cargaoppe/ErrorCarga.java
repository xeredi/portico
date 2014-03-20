package xeredi.integra.proceso.estadistica.cargaoppe;

import xeredi.integra.model.bo.estadistica.EstadisticaFileType;


// TODO: Auto-generated Javadoc
/**
 * The Class ErrorCarga.
 */
public final class ErrorCarga {

    /** The file type. */
    private final EstadisticaFileType fileType;

    /** The line. */
    private final int line;

    /** The mensaje. */
    private final String mensaje;

    /**
     * Instantiates a new error carga.
     * 
     * @param afileType
     *            the afile type
     * @param aline
     *            the aline
     * @param amensaje
     *            the amensaje
     */
    public ErrorCarga(final EstadisticaFileType afileType, final int aline, final String amensaje) {
        super();
        fileType = afileType;
        line = aline;
        mensaje = amensaje;
    }

    /**
     * Gets the file type.
     * 
     * @return the file type
     */
    public EstadisticaFileType getFileType() {
        return fileType;
    }

    /**
     * Gets the line.
     * 
     * @return the line
     */
    public int getLine() {
        return line;
    }

    /**
     * Gets the mensaje.
     * 
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

}
