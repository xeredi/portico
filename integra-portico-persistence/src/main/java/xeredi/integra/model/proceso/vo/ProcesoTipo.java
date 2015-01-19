package xeredi.integra.model.proceso.vo;

// TODO: Auto-generated Javadoc
/**
 * The Enum ProcesoTipo.
 */
public enum ProcesoTipo {

    /** The est carga. */
    EST_CARGA(ProcesoModulo.E),
    /** The est creacion. */
    EST_CREACION(ProcesoModulo.E),
    /** The pes carga. */
    PES_CARGA(ProcesoModulo.S),
    /** The man carga. */
    MAN_CARGA(ProcesoModulo.S),
    /** The esc carga. */
    ESC_CARGA(ProcesoModulo.S),

    ;

    /** The modulo. */
    private final ProcesoModulo modulo;

    /**
     * Instantiates a new proceso tipo.
     *
     * @param amodulo
     *            the amodulo
     */
    private ProcesoTipo(final ProcesoModulo amodulo) {
        modulo = amodulo;
    }

    /**
     * Gets the modulo.
     *
     * @return the modulo
     */
    public ProcesoModulo getModulo() {
        return modulo;
    }

}
