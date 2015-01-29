package xeredi.integra.model.servicio.io.manifiesto;

// TODO: Auto-generated Javadoc
/**
 * The Enum ManifiestoMensaje.
 */
public enum ManifiestoMensaje {

    /** The manifiesto alta. */
    MANIFIESTO_ALTA(47),
    /** The manifiesto baja. */
    MANIFIESTO_BAJA(1),
    /** The MANIFIEST o_ baj a_2. */
    MANIFIESTO_BAJA_2(13),
    /** The manifiesto modificacion. */
    MANIFIESTO_MODIFICACION(33),
    /** The bl modificacion. */
    BL_MODIFICACION(4),
    /** The bl baja. */
    BL_BAJA(40),
    /** The partida alta. */
    PARTIDA_ALTA(2),
    /** The partida baja. */
    PARTIDA_BAJA(3),
    /** The partida modificacion. */
    PARTIDA_MODIFICACION(36),

    ;

    /** The id. */
    private final int id;

    /**
     * Instantiates a new manifiesto mensaje.
     * 
     * @param aid
     *            the aid
     */
    private ManifiestoMensaje(final int aid) {
        id = aid;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Value of.
     * 
     * @param id
     *            the id
     * @return the manifiesto mensaje
     */
    public static ManifiestoMensaje valueOf(final int id) {
        for (final ManifiestoMensaje mensaje : ManifiestoMensaje.values()) {
            if (mensaje.getId() == id) {
                return mensaje;
            }
        }

        return null;
    }

}
