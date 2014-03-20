package xeredi.integra.proceso.servicio.manifiesto;

// TODO: Auto-generated Javadoc
/**
 * The Enum ManifiestoSegmento.
 */
public enum ManifiestoSegmento {

    /** The unb. */
    UNB,
    /** The ifc. */
    IFC,
    /** The nad. */
    NAD,
    /** The cni. */
    CNI,
    /** The gid. */
    GID,
    /** The ftx. */
    FTX,
    /** The pci. */
    PCI,
    /** The gor. */
    GOR,
    /** The doc. */
    DOC,
    /** The sgp. */
    SGP,
    /** The dgs. */
    DGS,
    /** The eqd. */
    EQD,
    /** The sel. */
    SEL;

    /**
     * Segmento valido.
     * 
     * @param segmento
     *            the segmento
     * @param mensaje
     *            the mensaje
     * @return true, if successful
     */
    public static boolean segmentoValido(final ManifiestoSegmento segmento, final ManifiestoMensaje mensaje) {
        switch (mensaje) {
        case MANIFIESTO_ALTA:
        case PARTIDA_ALTA:
        case PARTIDA_MODIFICACION:
            switch (segmento) {
            case IFC:
            case NAD:
            case CNI:
            case GID:
            case FTX:
            case PCI:
            case GOR:
            case DOC:
            case SGP:
            case DGS:
            case EQD:
            case SEL:
                return true;

            default:
                return false;
            }
        case MANIFIESTO_BAJA:
        case MANIFIESTO_BAJA_2:
            switch (segmento) {
            case IFC:
                return true;

            default:
                return false;
            }
        case MANIFIESTO_MODIFICACION:
            switch (segmento) {
            case IFC:
            case NAD:
            case CNI:
                return true;

            default:
                return false;
            }
        case BL_MODIFICACION:
            switch (segmento) {
            case IFC:
            case NAD:
            case CNI:
            case EQD:
            case SEL:
                return true;

            default:
                return false;
            }
        case BL_BAJA:
            switch (segmento) {
            case IFC:
            case NAD:
            case CNI:
            case GID:
            case FTX:
            case PCI:
            case GOR:
            case SGP:
            case DGS:
            case EQD:
                return true;

            default:
                return false;
            }
        case PARTIDA_BAJA:
            switch (segmento) {
            case IFC:
            case NAD:
            case CNI:
            case GID:
            case EQD:
                return true;

            default:
                return false;
            }
        default:
            throw new Error("Mensaje + '" + mensaje + "' no valido");
        }
    }

    /**
     * Segmento valido.
     * 
     * @param segmento
     *            the segmento
     * @param segmentoSiguiente
     *            the segmento siguiente
     * @return true, if successful
     */
    public static boolean segmentoValido(final ManifiestoSegmento segmento, final ManifiestoSegmento segmentoSiguiente) {
        switch (segmento) {
        case IFC:
        case NAD:
            switch (segmentoSiguiente) {
            case NAD:
            case CNI:
                return true;
            default:
                return false;
            }
        case CNI:
            switch (segmentoSiguiente) {
            case CNI:
            case GID:
            case EQD:
                return true;
            default:
                return false;
            }
        case GID:
        case FTX:
            switch (segmentoSiguiente) {
            case FTX:
            case PCI:
            case SGP:
            case DGS:
            case GID:
            case EQD:
            case CNI:
            case GOR:
                return true;
            default:
                return false;
            }
        case PCI:
            switch (segmentoSiguiente) {
            case PCI:
            case SGP:
            case DGS:
            case GID:
            case EQD:
            case CNI:
            case GOR:
                return true;
            default:
                return false;
            }
        case GOR:
        case DOC:
            switch (segmentoSiguiente) {
            case SGP:
            case DGS:
            case GID:
            case EQD:
            case CNI:
            case GOR:
            case DOC:
                return true;
            default:
                return false;
            }
        case SGP:
            switch (segmentoSiguiente) {
            case SGP:
            case DGS:
            case GID:
            case EQD:
            case CNI:
                return true;
            default:
                return false;
            }
        case DGS:
            switch (segmentoSiguiente) {
            case DGS:
            case GID:
            case EQD:
            case CNI:
                return true;
            default:
                return false;
            }
        case EQD:
        case SEL:
            switch (segmentoSiguiente) {
            case EQD:
            case SEL:
            case CNI:
                return true;
            default:
                return false;
            }
        default:
            return false;
        }
    }
}
