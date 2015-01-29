package xeredi.integra.model.servicio.io.pesca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PescaFileImport.
 */
public final class PescaFileImport {

    /** The Constant DATE_FORMAT. */
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    /** The Constant TIPO_IVA. */
    private static final String TIPO_IVA = "X";

    /** The Constant ESTADO_MANIFIESTO. */
    private static final String ESTADO_MANIFIESTO = "R";

    /** The Constant SUJ_PAS_SUST. */
    private static final Boolean SUJ_PAS_SUST = false;

    /** The codigo maestro map. */
    private final Map<Entidad, Set<String>> codigoMaestroMap = new HashMap<Entidad, Set<String>>();

    /** The srvc. */
    private final ServicioVO srvc = new ServicioVO();

    /** The ssrv list. */
    private final List<SubservicioVO> ssrvList = new ArrayList<>();

    /** The prmn list. */
    private final ProcesoVO prbt;

    /** The maestro map. */
    private Map<Entidad, Map<String, ParametroVO>> maestroMap;

    /**
     * Instantiates a new pesca file import.
     *
     * @param aprmnList
     *            the aprmn list
     */
    public PescaFileImport(final ProcesoVO aprbt) {
        super();
        prbt = aprbt;
    }

    /**
     * Read file.
     *
     * @param stream
     *            the stream
     * @param filename
     *            the filename
     */
    public void readFile(final List<String> lines, final String filename) {
        // Generacion del servicio
        final Calendar calendar = Calendar.getInstance();

        srvc.setAnno(String.valueOf(calendar.get(Calendar.YEAR)));
        srvc.setEntiId(Entidad.MANIFIESTO_PESCA.getId());
        srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());

        Double pesoTotal = 0.0;
        Double importeTotal = 0.0;

        int i = 0;

        final ParametroVO tipoIvaVO = maestroMap.get(Entidad.TIPO_IVA).get(TIPO_IVA);

        for (final String line : lines) {
            i++;

            srvc.setSubp(getTokenMaestro(PescaKeyword.MAN_Subp, line, i, Entidad.SUBPUERTO));
            srvc.setEstado(ESTADO_MANIFIESTO);

            srvc.addItdt(TipoDato.BUQUE_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Buque, line, i, Entidad.BUQUE_PESCA));
            srvc.addItdt(TipoDato.ORGA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Vendedor, line, i, Entidad.ORGANIZACION));
            srvc.addItdt(TipoDato.TIPO_OP_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_TipoOperacion, line, i, Entidad.TIPO_OPERACION_PESCA));
            srvc.addItdt(TipoDato.ORGA_2.getId(),
                    getTokenMaestro(PescaKeyword.MAN_ClienteAdicional, line, i, Entidad.ORGANIZACION));
            srvc.addItdt(TipoDato.TIPO_MAN_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Tipo, line, i, Entidad.TIPO_MANIFIESTO_PESCA));
            srvc.addItdt(TipoDato.SUBT_MAN_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Subtipo, line, i, Entidad.SUBTIPO_MANIFIESTO_PESCA));
            srvc.addItdt(TipoDato.ARTE_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Arte, line, i, Entidad.ARTE_PESCA));
            srvc.addItdt(TipoDato.ZONA_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Zona, line, i, Entidad.ZONA_PESCA));
            srvc.addItdt(TipoDato.COD_EXEN.getId(),
                    getTokenCR(PescaKeyword.MAN_CodExencion, line, i, TipoDato.COD_EXEN));
            srvc.addItdt(TipoDato.INDIC_VENTA.getId(),
                    getTokenCR(PescaKeyword.MAN_IndicadorVenta, line, i, TipoDato.INDIC_VENTA));
            srvc.addItdt(TipoDato.CADENA_02.getId(), filename);
            srvc.addItdt(TipoDato.TIPO_IVA.getId(), tipoIvaVO);
            srvc.addItdt(TipoDato.BOOLEANO_01.getId(), SUJ_PAS_SUST ? 1L : 0L);

            final SubservicioVO ssrv = new SubservicioVO();

            ssrv.setEntiId(Entidad.PARTIDA_PESCA.getId());
            ssrv.setNumero(i);
            ssrv.setItdtMap(new HashMap<Long, ItemDatoVO>());

            pesoTotal += getTokenDouble(PescaKeyword.PAR_Peso, line, i);
            importeTotal += getTokenDouble(PescaKeyword.PAR_Importe, line, i);

            ssrv.addItdt(TipoDato.COMPRADOR_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.PAR_Comprador, line, i, Entidad.COMPRADOR_PESCA));
            ssrv.addItdt(TipoDato.ESPECIE_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.PAR_Especie, line, i, Entidad.ESPECIE_PESCA));
            ssrv.addItdt(TipoDato.PRESENT_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.PAR_Presentacion, line, i, Entidad.PRESENTACION_PESCA));
            ssrv.addItdt(TipoDato.DECIMAL_01.getId(), getTokenDouble(PescaKeyword.PAR_Cajas, line, i));
            ssrv.addItdt(TipoDato.DECIMAL_02.getId(), getTokenDouble(PescaKeyword.PAR_Peso, line, i));
            ssrv.addItdt(TipoDato.DECIMAL_04.getId(), getTokenDouble(PescaKeyword.PAR_Importe, line, i));

            ssrvList.add(ssrv);
        }

        srvc.addItdt(TipoDato.DECIMAL_01.getId(), pesoTotal);
        srvc.addItdt(TipoDato.DECIMAL_01.getId(), importeTotal);
    }

    /**
     * Read maestros.
     *
     * @param stream
     *            the stream
     */
    public void readMaestros(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            srvc.setFref(getTokenDate(PescaKeyword.MAN_FechaRecepcion, line, i, DATE_FORMAT));

            final String buque = getTokenString(PescaKeyword.MAN_Buque, line, i);

            if (buque == null || buque.isEmpty()) {
                addCodigoMaestro(Entidad.BUQUE_PESCA, getTokenString(PescaKeyword.MAN_Buque, line, i));
            } else {
                addCodigoMaestro(Entidad.BUQUE_PESCA, getTokenString(PescaKeyword.MAN_BuqueAlt, line, i));
            }

            addCodigoMaestro(Entidad.SUBPUERTO, getTokenString(PescaKeyword.MAN_Subp, line, i));
            addCodigoMaestro(Entidad.BUQUE_PESCA, getTokenString(PescaKeyword.MAN_Buque, line, i));
            addCodigoMaestro(Entidad.TIPO_OPERACION_PESCA, getTokenString(PescaKeyword.MAN_TipoOperacion, line, i));
            addCodigoMaestro(Entidad.TIPO_MANIFIESTO_PESCA, getTokenString(PescaKeyword.MAN_Tipo, line, i));
            addCodigoMaestro(Entidad.SUBTIPO_MANIFIESTO_PESCA, getTokenString(PescaKeyword.MAN_Subtipo, line, i));
            addCodigoMaestro(Entidad.ARTE_PESCA, getTokenString(PescaKeyword.MAN_Arte, line, i));
            addCodigoMaestro(Entidad.ZONA_PESCA, getTokenString(PescaKeyword.MAN_Zona, line, i));
            addCodigoMaestro(Entidad.ORGANIZACION, getTokenString(PescaKeyword.MAN_Vendedor, line, i));
            addCodigoMaestro(Entidad.ORGANIZACION, getTokenString(PescaKeyword.MAN_ClienteAdicional, line, i));
            addCodigoMaestro(Entidad.COMPRADOR_PESCA, getTokenString(PescaKeyword.PAR_Comprador, line, i));
            addCodigoMaestro(Entidad.ESPECIE_PESCA, getTokenString(PescaKeyword.PAR_Especie, line, i));
            addCodigoMaestro(Entidad.PRESENTACION_PESCA, getTokenString(PescaKeyword.PAR_Presentacion, line, i));
        }

        addCodigoMaestro(Entidad.TIPO_IVA, TIPO_IVA);
    }

    /**
     * Gets the token maestro.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @return the token maestro
     */
    private ParametroVO getTokenMaestro(final PescaKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            prbt.addError(MensajeCodigo.G_001, "linea:" + lineNumber + ", entidad:" + entidad.name() + ", codigo:"
                    + codigo);
        }

        return maestroMap.get(entidad).get(codigo);
    }

    /**
     * Gets the token string.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token string
     */
    private String getTokenString(final PescaKeyword keyword, final String line, final int lineNumber) {
        if (line.length() >= keyword.getOffset() + keyword.getLength()) {
            final String token = line.substring(keyword.getOffset(), keyword.getOffset() + keyword.getLength()).trim();

            if ((token == null || token.isEmpty()) && keyword.isRequired()) {
                prbt.addError(MensajeCodigo.G_005, "linea:" + lineNumber + ", campo:" + keyword.name());
            }

            return token;
        }

        return null;
    }

    /**
     * Gets the token cr.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param tipoDato
     *            the tipo dato
     * @return the token cr
     */
    private String getTokenCR(final PescaKeyword keyword, final String line, final int lineNumber,
            final TipoDato tipoDato) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        final TipoDatoVO tpdtVO = TipoDatoProxy.select(tipoDato.getId());

        if (!tpdtVO.getCdrfCodeSet().contains(codigo)) {
            prbt.addError(MensajeCodigo.G_004, "linea:" + lineNumber + ", CR:" + tipoDato.name() + ", codigo:" + codigo);
        }

        return codigo;
    }

    /**
     * Gets the token double.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token double
     */
    private Double getTokenDouble(final PescaKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Double.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            prbt.addError(MensajeCodigo.G_003, "linea:" + lineNumber + ", valor:" + codigo);

            return null;
        }
    }

    /**
     * Gets the token date.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param dateFormat
     *            the date format
     * @return the token date
     */
    private Date getTokenDate(final PescaKeyword keyword, final String line, final int lineNumber,
            final String dateFormat) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return new SimpleDateFormat(dateFormat).parse(codigo);
        } catch (final ParseException ex) {
            prbt.addError(MensajeCodigo.G_002, "linea:" + lineNumber + ", valor:" + codigo + ", formato:" + dateFormat);

            return null;
        }
    }

    /**
     * Adds the codigo maestro.
     *
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     */
    protected final void addCodigoMaestro(final Entidad entidad, final String codigo) {
        Preconditions.checkNotNull(entidad);

        if (!codigoMaestroMap.containsKey(entidad)) {
            codigoMaestroMap.put(entidad, new HashSet<String>());
        }

        if (codigo != null && !codigo.isEmpty()) {
            codigoMaestroMap.get(entidad).add(codigo);
        }
    }

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getSrvc() {
        return srvc;
    }

    /**
     * Gets the ssrv list.
     *
     * @return the ssrv list
     */
    public List<SubservicioVO> getSsrvList() {
        return ssrvList;
    }

    /**
     * Gets the codigo maestro map.
     *
     * @return the codigo maestro map
     */
    public Map<Entidad, Set<String>> getCodigoMaestroMap() {
        return codigoMaestroMap;
    }

    /**
     * Sets the maestro map.
     *
     * @param value
     *            the value
     */
    public void setMaestroMap(final Map<Entidad, Map<String, ParametroVO>> value) {
        maestroMap = value;
    }

}
