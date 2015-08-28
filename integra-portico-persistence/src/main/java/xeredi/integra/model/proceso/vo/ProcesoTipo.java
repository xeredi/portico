package xeredi.integra.model.proceso.vo;

// TODO: Auto-generated Javadoc
/**
 * The Enum ProcesoTipo.
 */
public enum ProcesoTipo {

    /** The valorador. */
    VALORADOR(ProcesoModulo.F, ItemTipo.vlrc),

    /** The facturador. */
    FACTURADOR(ProcesoModulo.F, ItemTipo.fctr),

    /** The est carga. */
    EST_CARGA(ProcesoModulo.E, ItemTipo.pepr),

    /** The est creacion. */
    EST_CREACION(ProcesoModulo.E, ItemTipo.pepr),

    /** The pes creacion. */
    SBUP_CREACION(ProcesoModulo.S, ItemTipo.srvc),

    /** The pes carga. */
    PES_CARGA(ProcesoModulo.S, ItemTipo.srvc),

    /** The man carga. */
    MAN_CARGA(ProcesoModulo.S, ItemTipo.srvc),

    /** The esc carga. */
    ESC_CARGA(ProcesoModulo.S, ItemTipo.srvc),;

    /** The modulo. */
    private final ProcesoModulo modulo;

    /** The item salida. */
    private final ItemTipo itemTipoSalida;

    /**
     * Instantiates a new proceso tipo.
     *
     * @param amodulo
     *            the amodulo
     * @param aitemTipoSalida
     *            the aitem tipo salida
     */
    private ProcesoTipo(final ProcesoModulo amodulo, final ItemTipo aitemTipoSalida) {
        modulo = amodulo;
        itemTipoSalida = aitemTipoSalida;
    }

    /**
     * Gets the modulo.
     *
     * @return the modulo
     */
    public ProcesoModulo getModulo() {
        return modulo;
    }

    /**
     * Gets the item salida.
     *
     * @return the item salida
     */
    public ItemTipo getItemTipoSalida() {
        return itemTipoSalida;
    }

}
