package xeredi.integra.model.servicio.io.manifiesto;

// TODO: Auto-generated Javadoc
/**
 * The Enum ManifiestoKeyword.
 */
public enum ManifiestoKeyword {

    /** The Segmento. */
    Segmento(0, 3, true),

    /** The UN b_ funcion mensaje. */
    UNB_FuncionMensaje(142, 3, true),
    /** The UN b_ tipo operacion. */
    UNB_TipoOperacion(139, 3, true),
    /** The UN b_ numero intercambio edi. */
    UNB_NumeroIntercambioEDI(102, 14, true),

    /** The IF c_ numero edi. */
    IFC_NumeroEDI(3, 11, true),
    /** The IF c_ recinto aduanero. */
    IFC_CodigoRecintoAduanero(3, 4, true),
    /** The IF c_ anio escala. */
    IFC_AnioEscala(7, 1, true),
    /** The IF c_ numero escala. */
    IFC_NumeroEscala(9, 5, true),
    /** The IF c_ tipo manifiesto. */
    IFC_TipoManifiesto(27, 3, true),
    /** The IF c_ tramo bl. */
    IFC_TramoBL(510, 3, true),
    /** The IF c_ tipo lugar embarque. */
    IFC_TipoLugarEmbarque(136, 3, false),
    /** The IF c_ pais ens. */
    IFC_CodigoPaisENS(139, 2, false),
    /** The IF c_ regimen simplificado. */
    IFC_RegimenSimplificado(513, 2, false),
    /** The IF c_ numero tramos. */
    IFC_NumeroTramos(24, 2, true),
    /** The IF c_ tipo consignatario buque. */
    IFC_TipoConsignatarioBuque(290, 3, false),
    /** The IF c_ tipo consignatario mercancia. */
    IFC_TipoConsignatarioMercancia(310, 3, true),
    /** The IF c_ tipo estibador. */
    IFC_TipoEstibador(330, 3, true),
    /** The IF c_ nif consignatario buque. */
    IFC_NIFConsignatarioBuque(293, 17, false),
    /** The IF c_ fecha ultimo envio. */
    IFC_FechaUltimoEnvio(14, 10, true),
    /** The IF c_ nif consignatario mercancia. */
    IFC_NIFConsignatarioMercancia(313, 17, true),
    /** The IF c_ nif estibador. */
    IFC_NIFEstibador(333, 17, true),
    /** The IF c_ numero viaje. */
    IFC_NumeroViaje(39, 17, true),
    /** The IF c_ calificador servicio regular. */
    IFC_CalificadorServicioRegular(30, 3, true),
    /** The IF c_ transito comunitario simplificado. */
    IFC_TransitoComunitarioSimplificado(33, 3, true),
    /** The IF c_ codigo alineacion. */
    IFC_CodigoAlineacion(352, 25, true),
    /** The IF c_ codigo terminal. */
    IFC_CodigoTerminal(515, 35, false),
    /** The IF c_ codigo acuerdo. */
    IFC_CodigoAcuerdo(402, 35, false),
    /** The IF c_ codigo servicio. */
    IFC_CodigoServicio(437, 35, false),

    /** The NA d_ consignatario mercancia. */
    NAD_NIFConsignatarioMercancia(3, 17, true),

    /** The CN i_ numero bl. */
    CNI_NumeroBL(3, 4, true),
    /** The CN i_ nombre bl. */
    CNI_NombreBL(10, 35, true),
    /** The CN i_ tipo bl. */
    CNI_TipoBL(7, 3, true),
    /** The CN i_ calificador puerto1. */
    CNI_CalificadorPuerto_1(45, 3, true),
    /** The CN i_ codigo pais1. */
    CNI_CodigoPais_1(48, 2, true),
    /** The CN i_ codigo unlocode1. */
    CNI_CodigoUnlocode_1(48, 5, true),
    /** The CN i_ agencia1. */
    CNI_Agencia_1(76, 3, true),
    /** The CN i_ lugar1. */
    CNI_Lugar_1(79, 17, true),
    /** The CN i_ calificador puerto2. */
    CNI_CalificadorPuerto_2(96, 3, true),
    /** The CN i_ codigo pais2. */
    CNI_CodigoPais_2(99, 2, true),
    /** The CN i_ codigo unlocode2. */
    CNI_CodigoUnlocode_2(99, 5, true),
    /** The CN i_ agencia2. */
    CNI_Agencia_2(127, 3, true),
    /** The CN i_ lugar2. */
    CNI_Lugar_2(130, 17, true),
    /** The CN i_ calificador puerto3. */
    CNI_CalificadorPuerto_3(147, 3, true),
    /** The CN i_ codigo pais3. */
    CNI_CodigoPais_3(150, 2, true),
    /** The CN i_ codigo unlocode3. */
    CNI_CodigoUnlocode_3(150, 5, true),
    /** The CN i_ agencia3. */
    CNI_Agencia_3(178, 3, true),
    /** The CN i_ lugar3. */
    CNI_Lugar_3(181, 17, true),
    /** The CN i_ calificador puerto4. */
    CNI_CalificadorPuerto_4(285, 3, true),
    /** The CN i_ codigo pais4. */
    CNI_CodigoPais_4(288, 2, true),
    /** The CN i_ codigo unlocode4. */
    CNI_CodigoUnlocode_4(288, 5, true),
    /** The CN i_ agencia4. */
    CNI_Agencia_4(316, 3, true),
    /** The CN i_ lugar4. */
    CNI_Lugar_4(319, 17, true),
    /** The CN i_ declaracion sumaria transito. */
    CNI_DeclaracionSumariaTransito(204, 11, false),
    /** The CN i_ numero bl transito. */
    CNI_NumeroBlTransito(215, 5, true),
    /** The CN i_ modo transporte edi. */
    CNI_CodigoModoTransporteEDI(201, 3, true),
    /** The CN i_ buque transporte posterior. */
    CNI_BuqueTransportePosterior(220, 9, false),
    /** The CN i_ tipo destino bl. */
    CNI_TipoDestinoBl(406, 3, false),
    /** The CN i_ codigo alineacion. */
    CNI_CodigoAlineacion(260, 25, false), // FIXME En el modelo de datos dice que es obligatorio
    /** The CN i_ codigo terminal. */
    CNI_CodigoTerminal(459, 35, false),
    /** The CN i_ codigo acuerdo. */
    CNI_CodigoAcuerdo(371, 35, false),
    /** The CN i_ codigo servicio. */
    CNI_CodigoServicio(336, 35, false),
    /** The CN i_ nif estibador. */
    CNI_NIFEstibador(243, 17, false),

    /** The GI d_ numero partida. */
    GID_NumeroPartida(3, 5, true),
    /** The GI d_ numero bultos. */
    GID_NumeroBultos(8, 8, true),
    /** The GI d_ codigo tipo bulto. */
    GID_CodigoTipoBulto(16, 7, true),
    /** The GI d_ codigo mercancia. */
    GID_CodigoMercancia(77, 5, true),
    /** The GI d_ calificador medida_1. */
    GID_CalificadorMedida_1(23, 3, true),
    /** The GI d_ valor medida_1. */
    GID_ValorMedida_1(32, 18, true),
    /** The GI d_ calificador medida_2. */
    GID_CalificadorMedida_2(50, 3, false),
    /** The GI d_ valor medida_2. */
    GID_ValorMedida_2(59, 18, false),
    /** The GI d_ codigo marca vehiculo. */
    GID_CodigoMarcaVehiculo(82, 3, false),
    /** The GI d_ codigo acuerdo. */
    GID_CodigoAcuerdo(85, 5, false),
    /** The GI d_ declaracion sumaria transito. */
    GID_DeclaracionSumariaTransito(168, 35, false),
    /** The GI d_ numero partida transito. */
    GID_NumeroPartidaTransito(203, 6, true),
    /** The GI d_ codigo instalacion especial. */
    GID_CodigoInstalacionEspecial(133, 35, false),
    /** The GI d_ codigo terminal. */
    GID_CodigoTerminal(209, 35, false),
    /** The GI d_ nif estibador. */
    GID_NifEstibador(91, 17, false),
    /** The GI d_ declara ens. */
    GID_DeclaraENS(243, 3, true),

    /** The PC i_ codigo instruccion marcaje. */
    PCI_CodigoInstruccionMarcaje(3, 3, true),
    /** The PC i_ marca. */
    PCI_Marca(6, 350, true),

    /** The GO r_ codigo situacion aduanera. */
    GOR_CodigoSituacionAduanera(3, 3, true),

    /** The DO c_ codigo tipo documento. */
    DOC_CodigoTipoDocumento(3, 3, true),
    /** The DO c_ fecha emision. */
    DOC_FechaEmision(22, 6, true),
    /** The DO c_ numero documento. */
    DOC_NumeroDocumento(28, 35, true),
    /** The DO c_ situacion embarque. */
    DOC_SituacionEmbarque(63, 3, false),

    /** The SG p_ matricula. */
    SGP_Matricula(3, 17, true),
    /** The SG p_ numero bultos. */
    SGP_NumeroBultos(20, 8, true),

    /** The DG s_ clase. */
    DGS_Clase(3, 7, true),
    /** The DG s_ numero onu. */
    DGS_NumeroONU(27, 4, true),

    /** The EQ d_ indicador lleno. */
    EQD_IndicadorLleno(27, 1, true),
    /** The EQ d_ matricula. */
    EQD_Matricula(6, 17, true),
    /** The EQ d_ codigo tipo equipamiento. */
    EQD_CodigoTipoEquipamiento(3, 3, true),
    /** The EQ d_ tamanio equipamiento. */
    EQD_TamanioEquipamiento(23, 4, true),
    /** The EQ d_ tara equipamiento. */
    EQD_TaraEquipamiento(31, 18, true),
    /** The EQ d_ numero vacios. */
    EQD_NumeroVacios(49, 15, true),
    /** The EQ d_ matricula_2. */
    EQD_Matricula_2(6, 5, true),
    /** The EQ d_ numero vacios_2. */
    EQD_NumeroVacios_2(11, 12, true),

    /** The SE l_ precinto. */
    SEL_Precinto(3, 10, true),

    ;

    /** The offset. */
    private final int offset;

    /** The length. */
    private final int length;

    /** The required. */
    private final boolean required;

    /**
     * Instantiates a new manifiesto keyword.
     *
     * @param aoffset
     *            the aoffset
     * @param alength
     *            the alength
     * @param arequired
     *            the arequired
     */
    private ManifiestoKeyword(final int aoffset, final int alength, final boolean arequired) {
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
