package xeredi.integra.model.servicio.io.pesca;

// TODO: Auto-generated Javadoc
/**
 * The Enum PescaKeyword.
 */
public enum PescaKeyword {

    /** The Subp. */
    MAN_Subp(0, 1, true),
    /** The MA n_ numero referencia. */
    MAN_NumeroReferencia(1, 8, true),
    /** The MA n_ fecha recepcion. */
    MAN_FechaRecepcion(9, 10, true),
    /** The Buque alt. */
    MAN_BuqueAlt(19, 8, false),
    /** The Vendedor. */
    MAN_Vendedor(27, 5, false),
    /** The Tipo operacion. */
    MAN_TipoOperacion(33, 1, true),
    /** The Especie. */
    PAR_Especie(34, 3, false), // En el funcional dice que la especie es obligatoria
    /** The PA r_ peso. */
    PAR_Peso(45, 8, true),
    /** The PA r_ cajas. */
    PAR_Cajas(57, 7, false),
    /** The PA r_ importe. */
    PAR_Importe(64, 10, true),
    /** The Presentacion. */
    PAR_Presentacion(74, 2, true),
    /** The Comprador. */
    PAR_Comprador(76, 5, false),
    /** The MA n_ cliente adicional. */
    MAN_ClienteAdicional(81, 5, false),
    /** The Buque. */
    MAN_Buque(87, 15, true),
    /** The BU q_ matricula. */
    BUQ_Matricula(102, 6, false),
    /** The BU q_ folio. */
    BUQ_Folio(108, 6, false),
    /** The BU q_ lista. */
    BUQ_Lista(114, 1, false),
    /** The MA n_ venta. */
    MAN_IndicadorVenta(115, 1, false),
    /** The MA n_ tipo. */
    MAN_Tipo(116, 1, false),
    /** The MA n_ subtipo. */
    MAN_Subtipo(117, 1, false),
    /** The MA n_ arte. */
    MAN_Arte(118, 2, false),
    /** The MA n_ zona. */
    MAN_Zona(120, 4, false),
    /** The MA n_ cod exencion. */
    MAN_CodExencion(124, 1, false),

    ;

    /** The offset. */
    private final int offset;

    /** The length. */
    private final int length;

    /** The required. */
    private final boolean required;

    /**
     * Instantiates a new pesca keyword.
     * 
     * @param aoffset
     *            the aoffset
     * @param alength
     *            the alength
     * @param arequired
     *            the arequired
     */
    private PescaKeyword(final int aoffset, final int alength, final boolean arequired) {
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
