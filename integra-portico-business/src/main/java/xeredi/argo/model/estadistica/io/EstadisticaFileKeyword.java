package xeredi.argo.model.estadistica.io;

import org.apache.commons.lang3.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Enum OppeKeyword.
 */
public enum EstadisticaFileKeyword {

    // Campos Comunes
    /** The Anio. */
    Anio(EstadisticaFileType.EPP, 0, 4, true),
    /** The EP p_ mes. */
    Mes(EstadisticaFileType.EPP, 4, 2, true),
    /** The EP p_ autp. */
    Autp(EstadisticaFileType.EPP, 6, 2, true),

    // Fichero EPP
    /** The EP p_ fecha transmision. */
    EPP_FechaTransmision(EstadisticaFileType.EPP, 8, 10, true),

    // Fichero EAP
    /** The EA p_ tipo captura. */
    EAP_TipoCaptura(EstadisticaFileType.EAP, 8, 2, true),
    /** The EA p_ kilos. */
    EAP_Kilos(EstadisticaFileType.EAP, 10, 12, true),
    /** The EA p_ euros. */
    EAP_Euros(EstadisticaFileType.EAP, 22, 12, true),

    // Fichero EAV
    /** The EA v_ tipo suministro. */
    EAV_TipoSuministro(EstadisticaFileType.EAV, 8, 2, true),
    /** The EA v_ toneladas. */
    EAV_Toneladas(EstadisticaFileType.EAV, 10, 8, true),

    // Fichero EAE
    /** The EA e_ tipo buque. */
    EAE_TipoBuque(EstadisticaFileType.EAE, 8, 2, true),
    /** The EA e_ tipo nav entrada. */
    EAE_TipoNavEntrada(EstadisticaFileType.EAE, 10, 2, true),
    /** The EA e_ tipo nav salida. */
    EAE_TipoNavSalida(EstadisticaFileType.EAE, 12, 2, true),
    /** The EA e_ bandera. */
    EAE_Bandera(EstadisticaFileType.EAE, 14, 2, true),
    /** The EA e_ tipo actividad. */
    EAE_TipoActividad(EstadisticaFileType.EAE, 16, 2, true),
    /** The EA e_ num escalas. */
    EAE_NumEscalas(EstadisticaFileType.EAE, 18, 6, true),
    /** The EA e_ num g ts. */
    EAE_NumGTs(EstadisticaFileType.EAE, 24, 7, true),
    /** The EA e_ rango g ts. */
    EAE_RangoGTs(EstadisticaFileType.EAE, 31, 2, true),
    /** The EA e_ buque. */
    EAE_Buque(EstadisticaFileType.EAE, 33, 7, true),
    /** The EA e_ trafico. */
    EAE_Trafico(EstadisticaFileType.EAE, 40, 4, true),
    /** The EA e_ acuerdo. */
    EAE_Acuerdo(EstadisticaFileType.EAE, 44, 10, true),
    /** The EA e_ consignatario. */
    EAE_Consignatario(EstadisticaFileType.EAE, 54, 5, true),

    // Fichero EMM
    /** The EM m_ tipo operacion. */
    EMM_TipoOperacion(EstadisticaFileType.EMM, 8, 2, true),
    /** The EM m_ unlo origen. */
    EMM_UnloOrigen(EstadisticaFileType.EMM, 10, 5, true),
    /** The EM m_ unlo destino. */
    EMM_UnloDestino(EstadisticaFileType.EMM, 15, 5, true),
    /** The EM m_ alineacion. */
    EMM_Alineacion(EstadisticaFileType.EMM, 20, 1, true),
    /** The EM m_ mercancia. */
    EMM_Mercancia(EstadisticaFileType.EMM, 21, 5, true),
    /** The EM m_ tipo navegacion. */
    EMM_TipoNavegacion(EstadisticaFileType.EMM, 26, 2, true),
    /** The EM m_ roro. */
    EMM_Roro(EstadisticaFileType.EMM, 28, 1, true),
    /** The EM m_ unidad carga. */
    EMM_UnidadCarga(EstadisticaFileType.EMM, 29, 2, true),
    /** The EM m_ inst especial. */
    EMM_InstEspecial(EstadisticaFileType.EMM, 31, 1, true),
    /** The EM m_ tipo transporte. */
    EMM_TipoTransporte(EstadisticaFileType.EMM, 32, 2, true),
    /** The EM m_ toneladas. */
    EMM_Toneladas(EstadisticaFileType.EMM, 34, 12, true),
    /** The EM m_ unidades. */
    EMM_Unidades(EstadisticaFileType.EMM, 46, 10, true),
    /** The EM m_ teus. */
    EMM_Teus(EstadisticaFileType.EMM, 56, 13, true),
    /** The EM m_ unlo carga descarga. */
    EMM_UnloCargaDescarga(EstadisticaFileType.EMM, 69, 5, true),
    /** The EM m_ estibador. */
    EMM_Estibador(EstadisticaFileType.EMM, 74, 5, true),
    /** The EM m_ consignatario. */
    EMM_Consignatario(EstadisticaFileType.EMM, 79, 5, true),
    /** The EM m_ buque. */
    EMM_Buque(EstadisticaFileType.EMM, 84, 7, true),
    /** The EM m_ servicio trafico. */
    EMM_ServicioTrafico(EstadisticaFileType.EMM, 91, 4, true),
    /** The EM m_ acuerdo. */
    EMM_Acuerdo(EstadisticaFileType.EMM, 95, 10, true),
    /** The EM m_ terminal. */
    EMM_Terminal(EstadisticaFileType.EMM, 105, 15, true),
    /** The EM m_ tipo equipamiento. */
    EMM_TipoEquipamiento(EstadisticaFileType.EMM, 120, 3, true),

    // Fichero EME
    /** The EM e_ unlo carga descarga. */
    EME_UnloCargaDescarga(EstadisticaFileType.EME, 8, 5, true),
    /** The EM e_ unidad carga. */
    EME_UnidadCarga(EstadisticaFileType.EME, 13, 2, true),
    /** The EM e_ mercancia. */
    EME_Mercancia(EstadisticaFileType.EME, 15, 5, true),
    /** The EM e_ grupo nst. */
    EME_GrupoNST(EstadisticaFileType.EME, 15, 2, true),
    /** The EM e_ registro buque eee. */
    EME_RegistroBuqueEEE(EstadisticaFileType.EME, 20, 4, true),
    /** The EM e_ direccion transporte. */
    EME_DireccionTransporte(EstadisticaFileType.EME, 24, 1, true),
    /** The EM e_ toneladas. */
    EME_Toneladas(EstadisticaFileType.EME, 25, 9, true),
    /** The EM e_ pasajeros. */
    EME_Pasajeros(EstadisticaFileType.EME, 34, 9, true),
    /** The EM e_ uc llenas. */
    EME_UCLlenas(EstadisticaFileType.EME, 43, 9, true),
    /** The EM e_ uc vacias. */
    EME_UCVacias(EstadisticaFileType.EME, 52, 9, true),
    /** The EM e_ roro. */
    EME_Roro(EstadisticaFileType.EME, 61, 1, false),
    /** The EM e_ pasajeros crucero. */
    EME_PasajerosCrucero(EstadisticaFileType.EME, 62, 9, true),
    /** The EM e_ pasajeros inicio fin linea. */
    EME_PasajerosInicioFinLinea(EstadisticaFileType.EME, 71, 9, true),

    // Fichero EMT
    /** The EM t_ tipo buque est eee. */
    EMT_TipoBuqueEstEEE(EstadisticaFileType.EMT, 8, 2, true),
    /** The EM t_ tipo buque gt eee. */
    EMT_TipoBuqueGtEEE(EstadisticaFileType.EMT, 10, 2, true),
    /** The EM t_ numero buques. */
    EMT_NumeroBuques(EstadisticaFileType.EMT, 12, 6, true),
    /** The EM t_ numero g ts. */
    EMT_NumeroGTs(EstadisticaFileType.EMT, 18, 9, true), ;

    /** The file type. */
    private final EstadisticaFileType fileType;

    /** The offset. */
    private final int offset;

    /** The length. */
    private final int length;

    /** The required. */
    private final boolean required;

    /**
     * Instantiates a new oppe keyword.
     *
     * @param afileType
     *            the afile type
     * @param aoffset
     *            the aoffset
     * @param alength
     *            the alength
     * @param arequired
     *            the arequired
     */
    private EstadisticaFileKeyword(final EstadisticaFileType afileType, final int aoffset, final int alength,
            final boolean arequired) {
        fileType = afileType;
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
     * Gets the file type.
     *
     * @return the file type
     */
    public EstadisticaFileType getFileType() {
        return fileType;
    }

    /**
     * Checks if is required.
     *
     * @return true, if is required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Gets the default value.
     *
     * @return the default value
     */
    public String getGenericValue() {
        final StringBuffer buffer = new StringBuffer(length);

        for (int i = 0; i < length; i++) {
            buffer.append('*');
        }

        return buffer.toString();
    }

    /**
     * Gets the string value.
     *
     * @param line
     *            the line
     * @return the string value
     */
    public String getStringValue(final String line) {
        return line.substring(offset, offset + length).trim();
    }

    /**
     * Generate string value.
     * 
     * @param object
     *            the object
     * @param padChar
     *            the pad char
     * @return the string
     */
    public String generateStringValue(final Object object, final char padChar) {
        if (required && object == null) {
            throw new Error("Token " + name() + " obligatorio");
        }

        final String string = StringUtils.leftPad(object.toString(), length, padChar);

        if (string.length() > length) {
            return StringUtils.leftPad("9", length, '9');
        }

        return string;
    }

    /**
     * Generate string value.
     * 
     * @param object
     *            the object
     * @return the string
     */
    public String generateStringValue(final Object object) {
        return generateStringValue(object, ' ');
    }

}
