package xeredi.integra.proceso.servicio.escala;

// TODO: Auto-generated Javadoc
/**
 * The Enum BermanMensaje.
 */
public enum EscalaMensaje {

    /** The alta solicitud escala. */
    BERMAN_ALTA_SOLICITUD_ESCALA(47),
    /** The alta atraque fondeo. */
    BERMAN_ALTA_ATRAQUE_FONDEO(13),
    /** The modificacion cabecera. */
    BERMAN_MODIFICACION_CABECERA(33),
    /** The modificacion eta. */
    BERMAN_MODIFICACION_ETA(54),
    /** The cancelacion solicitud escala. */
    BERMAN_CANCELACION_SOLICITUD_ESCALA(1),
    /** The borrado atraque fondeo. */
    BERMAN_BORRADO_ATRAQUE_FONDEO(40),
    /** The reemplazo atraque fondeo. */
    BERMAN_REEMPLAZO_ATRAQUE_FONDEO(21),
    /** The aperak autorizacion. */
    APERAK_AUTORIZACION(51),
    /** The aperak denegacion. */
    APERAK_DENEGACION(27),

    ;

    /** The id. */
    private final int id;

    /**
     * Instantiates a new berman mensaje.
     * 
     * @param aid
     *            the aid
     */
    private EscalaMensaje(final int aid) {
        id = aid;
    }

    /**
     * Value of.
     * 
     * @param id
     *            the id
     * @return the berman mensaje
     */
    public static EscalaMensaje valueOf(final int id) {
        for (final EscalaMensaje mensaje : EscalaMensaje.values()) {
            if (mensaje.getId() == id) {
                return mensaje;
            }
        }

        return null;
    }

    /**
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

}
