package xeredi.argo.proceso.servicio.escala;

// TODO: Auto-generated Javadoc
/**
 * The Enum BermanSegmento.
 */
public enum BermanSegmento {

    /** The unb. */
    UNB,
    /** The bgm. */
    BGM,

    /** The ftx. */
    FTX,
    /** The rff. */
    RFF,

    /** The qty. */
    QTY,
    /** The nad. */
    NAD,
    /** The tdt. */
    TDT,
    /** The R f1. */
    RF1,
    /** The dtm. */
    DTM,
    /** The mea. */
    MEA,
    /** The F t1. */
    FT1,
    /** The loc. */
    LOC,
    /** The D t1. */
    DT1,
    /** The doc. */
    DOC,
    /** The tsr. */
    TSR,
    /** The L o1. */
    LO1,
    /** The M e1. */
    ME1,
    /** The D t2. */
    DT2,
    /** The poc. */
    POC,
    /** The F t2. */
    FT2,
    /** The han. */
    HAN,
    /** The N a2. */
    NA2,
    /** The gds. */
    GDS,
    /** The F t3. */
    FT3,
    /** The M e2. */
    ME2,
    /** The eqn. */
    EQN;

    /** The Constant SEC. */
    private static final String SEC = "SEC";

    /**
     * Segmento valido.
     * 
     * @param segmento
     *            the segmento
     * @param mensaje
     *            the mensaje
     * @return true, if successful
     */
    public static boolean segmentoValido(final BermanSegmento segmento, final EscalaMensaje mensaje) {
        switch (mensaje) {
        case BERMAN_ALTA_SOLICITUD_ESCALA:
            switch (segmento) {
            case FTX:
            case QTY:
            case NAD:
            case TDT:
            case RF1:
            case DTM:
            case MEA:
            case FT1:
            case LOC:
            case DT1:
            case DOC:
            case TSR:
            case LO1:
            case ME1:
            case DT2:
            case POC:
            case FT2:
            case HAN:
            case NA2:
            case GDS:
            case FT3:
            case ME2:
            case EQN:
                return true;

            default:
                return false;
            }
        case BERMAN_ALTA_ATRAQUE_FONDEO:
            switch (segmento) {
            case RFF:
            case QTY:
            case NAD:
            case TDT:
            case RF1:
            case DTM:
            case MEA:
            case FT1:
            case LOC:
            case DT1:
            case DOC:
            case TSR:
            case LO1:
            case ME1:
            case DT2:
            case POC:
            case FT2:
            case HAN:
            case NA2:
            case GDS:
            case FT3:
            case ME2:
            case EQN:
                return true;

            default:
                return false;
            }
        case BERMAN_MODIFICACION_CABECERA:
        case BERMAN_MODIFICACION_ETA:
        case BERMAN_BORRADO_ATRAQUE_FONDEO:
        case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
            switch (segmento) {
            case FTX:
            case RFF:
            case QTY:
            case NAD:
            case TDT:
            case RF1:
            case DTM:
            case MEA:
            case FT1:
            case LOC:
            case DT1:
            case DOC:
            case TSR:
            case LO1:
            case ME1:
            case DT2:
            case POC:
            case FT2:
            case HAN:
            case NA2:
            case GDS:
            case FT3:
            case ME2:
            case EQN:
                return true;

            default:
                return false;
            }
        case BERMAN_CANCELACION_SOLICITUD_ESCALA:
            switch (segmento) {
            case FTX:
            case RFF:
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
     * @param mensaje
     *            the mensaje
     * @param segmento
     *            the segmento
     * @param segmentoSiguiente
     *            the segmento siguiente
     * @param tipoTsr
     *            the tipo tsr
     * @return true, if successful
     */
    public static boolean segmentoValido(final EscalaMensaje mensaje, final BermanSegmento segmento,
            final BermanSegmento segmentoSiguiente, final String tipoTsr) {
        switch (segmento) {
        case FTX:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_ALTA_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case FTX:
                case QTY:
                case NAD:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
            case BERMAN_MODIFICACION_ETA:
            case BERMAN_CANCELACION_SOLICITUD_ESCALA:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case FTX:
                case RFF:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case RFF:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TDT:
                case RF1:
                case DTM:
                case MEA:
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TDT:
                case DTM:
                    return true;
                default:
                    return false;
                }
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TDT:
                case TSR:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case QTY:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                    return true;
                default:
                    return false;
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TDT:
                case RF1:
                case DTM:
                case MEA:
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case QTY:
                case NAD:
                case TDT:
                case DTM:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case NAD:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
                switch (segmentoSiguiente) {
                case NAD:
                case TDT:
                    return true;
                default:
                    return false;
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case NAD:
                case TDT:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case NAD:
                case TDT:
                case RF1:
                case DTM:
                case MEA:
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case NAD:
                case TDT:
                case DTM:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case TDT:
        case RF1:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case RF1:
                case DTM:
                    return true;
                default:
                    return false;
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case RF1:
                case DTM:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case RF1:
                case DTM:
                case MEA:
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case DTM:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
                switch (segmentoSiguiente) {
                case DTM:
                case MEA:
                case FT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case DTM:
                case MEA:
                case FT1:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case DTM:
                case MEA:
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case DTM:
                case MEA:
                case FT1:
                case LOC:
                case TSR:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case MEA:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
                switch (segmentoSiguiente) {
                case MEA:
                case FT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case MEA:
                case FT1:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case MEA:
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case MEA:
                case FT1:
                case LOC:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case FT1:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case FT1:
                case LOC:
                    return true;
                default:
                    return false;
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case FT1:
                case LOC:
                case TSR:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case FT1:
                case LOC:
                case DT1:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case LOC:
        case DT1:
            switch (segmentoSiguiente) {
            case LOC:
            case DT1:
            case DOC:
            case TSR:
                return true;
            default:
                return false;
            }
        case DOC:
            switch (segmentoSiguiente) {
            case DOC:
            case TSR:
                return true;
            default:
                return false;
            }
        case TSR:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_MODIFICACION_ETA:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                if (SEC.equals(tipoTsr)) {
                    switch (segmentoSiguiente) {
                    case LO1:
                    case DT2:
                    case FT2:
                    case TSR:
                        return true;
                    default:
                        return false;
                    }
                } else {
                    switch (segmentoSiguiente) {
                    case LO1:
                    case ME1:
                    case DT2:
                        return true;
                    default:
                        return false;
                    }
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case LO1:
                case DT2:
                case FT2:
                case TSR:
                case ME1:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case LO1:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                if (SEC.equals(tipoTsr)) {
                    switch (segmentoSiguiente) {
                    case DT2:
                    case FT2:
                    case TSR:
                        return true;
                    default:
                        return false;
                    }
                } else {
                    switch (segmentoSiguiente) {
                    case LO1:
                    case ME1:
                    case DT2:
                        return true;
                    default:
                        return false;
                    }
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case LO1:
                case ME1:
                case DT2:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
            case BERMAN_MODIFICACION_ETA:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case LO1:
                case DT2:
                case FT2:
                case TSR:
                case ME1:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case ME1:
            switch (segmentoSiguiente) {
            case ME1:
            case DT2:
                return true;
            default:
                return false;
            }
        case DT2:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                if (SEC.equals(tipoTsr)) {
                    switch (segmentoSiguiente) {
                    case FT2:
                    case TSR:
                        return true;
                    default:
                        return false;
                    }
                } else {
                    switch (segmentoSiguiente) {
                    case DT2:
                    case POC:
                        return true;
                    default:
                        return false;
                    }
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case DT2:
                case POC:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_CABECERA:
                switch (segmentoSiguiente) {
                case DT2:
                case FT2:
                case TSR:
                case POC:
                    return true;
                default:
                    return false;
                }
            case BERMAN_MODIFICACION_ETA:
                switch (segmentoSiguiente) {
                case DT2:
                case TSR:
                case POC:
                    return true;
                default:
                    return false;
                }
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case DT2:
                case FT2:
                case POC:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case POC:
            switch (segmentoSiguiente) {
            case POC:
            case FT2:
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        case FT2:
            switch (mensaje) {
            case BERMAN_ALTA_SOLICITUD_ESCALA:
            case BERMAN_REEMPLAZO_ATRAQUE_FONDEO:
                if (SEC.equals(tipoTsr)) {
                    switch (segmentoSiguiente) {
                    case FT2:
                    case TSR:
                        return true;
                    default:
                        return false;
                    }
                } else {
                    switch (segmentoSiguiente) {
                    case FT2:
                    case HAN:
                    case TSR:
                        return true;
                    default:
                        return false;
                    }
                }
            case BERMAN_ALTA_ATRAQUE_FONDEO:
            case BERMAN_MODIFICACION_CABECERA:
            case BERMAN_MODIFICACION_ETA:
            case BERMAN_BORRADO_ATRAQUE_FONDEO:
                switch (segmentoSiguiente) {
                case FT2:
                case HAN:
                case TSR:
                    return true;
                default:
                    return false;
                }
            default:
                throw new Error("No implementado");
            }
        case HAN:
            switch (segmentoSiguiente) {
            case NA2:
            case GDS:
            case FT3:
            case ME2:
            case EQN:
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        case NA2:
            switch (segmentoSiguiente) {
            case GDS:
            case FT3:
            case ME2:
            case EQN:
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        case GDS:
            switch (segmentoSiguiente) {
            case FT3:
            case ME2:
            case EQN:
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        case FT3:
            switch (segmentoSiguiente) {
            case ME2:
            case EQN:
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        case ME2:
            switch (segmentoSiguiente) {
            case EQN:
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        case EQN:
            switch (segmentoSiguiente) {
            case HAN:
            case TSR:
                return true;
            default:
                return false;
            }
        default:
            return false;
        }
    }
}
