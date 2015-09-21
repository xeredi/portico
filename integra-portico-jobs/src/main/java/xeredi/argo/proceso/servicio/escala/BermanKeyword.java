package xeredi.argo.proceso.servicio.escala;

// TODO: Auto-generated Javadoc
/**
 * The Enum BermanKeyword.
 */
public enum BermanKeyword {

    /** The Segmento. */
    Segmento(0, 3, true),
    /** The Calificador. */
    Calificador(3, 3, true),

    /** The UN b_ nombre mensaje. */
    UNB_NombreMensaje(101, 6, true),
    /** The UN b_ emisor edi. */
    UNB_EmisorEDI(3, 35, true),
    /** The UN b_ referencia mensaje edi. */
    UNB_ReferenciaMensajeEDI(73, 14, true),

    /** The BG m_ funcion mensaje. */
    BGM_FuncionMensaje(41, 3, true),
    /** The BG m_ fecha solicitud. */
    BGM_FechaSolicitud(44, 35, true),

    /** The FT x_ observaciones due. */
    FTX_ObservacionesDUE(9, 350, true),
    /** The FT x_ campo. */
    FTX_Campo(6, 3, true),

    /** The QT y_ cantidad. */
    QTY_Cantidad(6, 35, true),

    /** The NA d_ nif consignatario. */
    NAD_NifConsignatario(6, 35, true),
    /** The NA d_ cod naviera. */
    NAD_CodNaviera(5, 35, true),

    /** The NA d_ tipo buque. */
    TDT_TipoBuque(23, 8, true),
    /** The NA d_ capitan. */
    TDT_Capitan(65, 35, false),
    /** The NA d_ im o_ nombre_ buque. */
    TDT_IMO_Nombre_Buque(100, 9, true),
    /** The NA d_ bandera. */
    TDT_Bandera(144, 3, true),

    /** The R f1_ numero referencia. */
    RF1_NumeroReferencia(6, 35, true),

    /** The DT m_ fecha hora. */
    DTM_FechaHora(6, 12, true),

    /** The ME a_ dimension. */
    MEA_Dimension(6, 3, true),
    /** The ME a_ atributo medida. */
    MEA_AtributoMedida(9, 70, false),
    /** The ME a_ unidad medida. */
    MEA_UnidadMedida(79, 3, false),
    /** The ME a_ valor medida. */
    MEA_ValorMedida(82, 18, true),

    /** The F t1_ observaciones buque. */
    FT1_ObservacionesBuque(6, 60, true),
    /** The F t1_ tareas obligatorias. */
    FT1_TareasObligatorias(6, 70, true),

    /** The LO c_ pais. */
    LOC_Pais(6, 2, true),
    /** The LO c_ unlocode. */
    LOC_Unlocode(6, 5, true),

    /** The D t1_ fecha. */
    DT1_Fecha(6, 35, true),

    /** The DO c_ numero. */
    DOC_Numero(6, 35, true),

    /** The TS r_ tipo. */
    TSR_Tipo(6, 3, true),
    /** The TS r_ numero atraque edi. */
    TSR_NumeroAtraqueEdi(7, 2, true),
    /** The TS r_ tipo atraque edi solicitado. */
    TSR_TipoAtraqueEdiSolicitado(9, 3, true),

    /** The L o1_ alineacion solicitada. */
    LO1_AlineacionSolicitada(6, 4, true),
    /** The L o1_ noray inicial final. */
    LO1_NorayInicialFinal(11, 20, false),

    /** The M e1_ valor medida. */
    ME1_ValorMedida(6, 18, true),

    /** The D t2_ fecha. */
    DT2_Fecha(6, 10, true),

    /** The PO c_ tipo actividad edi. */
    POC_TipoActividadEdi(3, 3, true),

    /** The F t2_ texto codificado. */
    FT2_TextoCodificado(6, 3, true),
    /** The F t2_ observaciones atraque. */
    FT2_ObservacionesAtraque(9, 70, true),

    /** The HA n_ cod tipo operacion. */
    HAN_CodTipoOperacion(4, 1, true),

    /** The N a2_ nif estibador. */
    NA2_NifEstibador(5, 35, false),
    /** The N a2_ nombre estibador. */
    NA2_NombreEstibador(41, 35, true),

    /** The GD s_ tipo mercancia. */
    GDS_TipoMercancia(3, 3, true),

    /** The F t3_ lugar operacion. */
    FT3_LugarOperacion(6, 70, true),
    /** The F t3_ detalle mercancia. */
    FT3_DetalleMercancia(76, 70, true),

    /** The M e2_ dimension medida. */
    ME2_DimensionMedida(6, 3, true),
    /** The M e2_ unidad medida. */
    ME2_UnidadMedida(9, 3, true),
    /** The M e2_ valor medida. */
    ME2_ValorMedida(12, 18, true),

    /** The EQ n_ numero unidades. */
    EQN_NumeroUnidades(3, 15, true),

    /** The RF f_ subpuerto escala. */
    RFF_SubpuertoEscala(3, 1, true),
    /** The RF f_ anio escala. */
    RFF_AnioEscala(4, 4, true),
    /** The RF f_ numero escala. */
    RFF_NumeroEscala(8, 5, true),

    ;

    /** The offset. */
    private final int offset;

    /** The length. */
    private final int length;

    /** The required. */
    private final boolean required;

    /**
     * Instantiates a new berman keyword.
     * 
     * @param aoffset
     *            the aoffset
     * @param alength
     *            the alength
     * @param arequired
     *            the arequired
     */
    private BermanKeyword(final int aoffset, final int alength, final boolean arequired) {
        offset = aoffset;
        length = alength;
        required = arequired;
    }

    /**
     * Gets the offset.
     * 
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Gets the length.
     * 
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Checks if is required.
     * 
     * @return true, if is required
     */
    public boolean isRequired() {
        return required;
    }

}
