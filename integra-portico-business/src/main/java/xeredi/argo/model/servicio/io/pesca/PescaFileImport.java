package xeredi.argo.model.servicio.io.pesca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemDatoVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.proceso.batch.pesca.ProcesoCargaPesca;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.model.servicio.vo.SubservicioVO;

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

    /** The Constant DESTINO_PARTIDA. */
    private static final String DESTINO_PARTIDA = "H";

    /** The Constant SUJ_PAS_SUST. */
    private static final Boolean SUJ_PAS_SUST = false;

    /** The srvc. */
    @Getter
    private Map<String, ServicioVO> srvcMap;

    /** The ssrv list. */
    @Getter
    private Map<String, List<SubservicioVO>> ssrvMap;

    /** The fecha referencia. */
    @Getter
    private Map<String, Date> fechaReferenciaMap;

    /** The prmn list. */
    private final ProcesoCargaPesca proceso;

    /**
     * Instantiates a new pesca file import.
     *
     * @param aproceso
     *            the aproceso
     */
    public PescaFileImport(final ProcesoCargaPesca aproceso) {
        super();

        proceso = aproceso;
    }

    /**
     * Read file.
     *
     * @param lines
     *            the lines
     * @param filename
     *            the filename
     */
    public void readFile(final List<String> lines, final String filename) {
        // Generacion del servicio
        srvcMap = new HashMap<>();
        ssrvMap = new HashMap<>();
        fechaReferenciaMap = new HashMap<>();

        Double pesoTotal = 0.0;
        Double importeTotal = 0.0;

        int i = 0;

        final ParametroVO tipoIvaVO = proceso.findMaestro(Entidad.TIPO_IVA, TIPO_IVA);

        for (final String line : lines) {
            i++;

            final String referencia = getTokenString(PescaKeyword.MAN_NumeroReferencia, line, i);
            final Date fechaReferencia = getTokenDate(PescaKeyword.MAN_FechaRecepcion, line, i, DATE_FORMAT);

            if (!srvcMap.containsKey(referencia)) {
                pesoTotal = 0.0;
                importeTotal = 0.0;

                final Calendar calendar = Calendar.getInstance();

                calendar.setTime(fechaReferencia);

                final ServicioVO srvc = new ServicioVO();

                srvc.setAnno(String.valueOf(calendar.get(Calendar.YEAR)));
                srvc.setEntiId(Entidad.MANIFIESTO_PESCA.getId());
                srvc.setItdtMap(new HashMap<Long, ItemDatoVO>());

                srvcMap.put(referencia, srvc);
                ssrvMap.put(referencia, new ArrayList<SubservicioVO>());
                fechaReferenciaMap.put(referencia, fechaReferencia);

                proceso.buscarMaestros(fechaReferencia);
            }

            final ServicioVO srvc = srvcMap.get(referencia);
            final List<SubservicioVO> ssrvList = ssrvMap.get(referencia);

            srvc.setPrto(getTokenPrto(PescaKeyword.MAN_Subp, line, i));
            srvc.setEstado(ESTADO_MANIFIESTO);
            srvc.setFref(fechaReferencia);

            final ParametroVO tiop = getTokenMaestro(PescaKeyword.MAN_TipoOperacion, line, i,
                    Entidad.TIPO_OPERACION_PESCA);

            srvc.addItdt(TipoDato.BUQUE_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Buque, line, i, Entidad.BUQUE_PESCA));
            srvc.addItdt(TipoDato.ORGA.getId(),
                    getTokenMaestro(PescaKeyword.MAN_Vendedor, line, i, Entidad.ORGANIZACION));
            srvc.addItdt(TipoDato.TIPO_OP_PESCA.getId(), tiop);
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
            srvc.addItdt(TipoDato.INDIC_VENTA.getId(), tiop.getItdtCadena(TipoDato.INDIC_VENTA.getId()));
            srvc.addItdt(TipoDato.CADENA_01.getId(), referencia);
            srvc.addItdt(TipoDato.CADENA_02.getId(), filename);
            srvc.addItdt(TipoDato.TIPO_IVA.getId(), tipoIvaVO);
            srvc.addItdt(TipoDato.BOOLEANO_01.getId(), SUJ_PAS_SUST ? 1L : 0L);

            pesoTotal += getTokenDouble(PescaKeyword.PAR_Peso, line, i);
            importeTotal += getTokenDouble(PescaKeyword.PAR_Importe, line, i);

            srvc.addItdt(TipoDato.DECIMAL_01.getId(), pesoTotal);
            srvc.addItdt(TipoDato.DECIMAL_02.getId(), importeTotal);

            final SubservicioVO ssrv = new SubservicioVO();

            ssrv.setEntiId(Entidad.PARTIDA_PESCA.getId());
            ssrv.setNumero(i);
            ssrv.setItdtMap(new HashMap<Long, ItemDatoVO>());

            ssrv.addItdt(TipoDato.DEST_PART_PESCA.getId(), DESTINO_PARTIDA);
            ssrv.addItdt(TipoDato.COMPRADOR_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.PAR_Comprador, line, i, Entidad.COMPRADOR_PESCA));
            ssrv.addItdt(TipoDato.ESPECIE_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.PAR_Especie, line, i, Entidad.ESPECIE_PESCA));
            ssrv.addItdt(TipoDato.PRESENT_PESCA.getId(),
                    getTokenMaestro(PescaKeyword.PAR_Presentacion, line, i, Entidad.PRESENTACION_PESCA));
            ssrv.addItdt(TipoDato.DECIMAL_01.getId(), getTokenDouble(PescaKeyword.PAR_Cajas, line, i));
            ssrv.addItdt(TipoDato.DECIMAL_02.getId(), getTokenDouble(PescaKeyword.PAR_Peso, line, i));
            ssrv.addItdt(TipoDato.DECIMAL_04.getId(), getTokenDouble(PescaKeyword.PAR_Importe, line, i));
            ssrv.addItdt(TipoDato.DECIMAL_03.getId(),
                    getTokenDouble(PescaKeyword.PAR_Importe, line, i) / getTokenDouble(PescaKeyword.PAR_Peso, line, i));

            ssrvList.add(ssrv);
        }
    }

    /**
     * Read maestros.
     *
     * @param lines
     *            the lines
     */
    public void readMaestros(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            final String buque = getTokenString(PescaKeyword.MAN_Buque, line, i);

            if (buque == null || buque.isEmpty()) {
                proceso.addCodigoMaestro(Entidad.BUQUE_PESCA, getTokenString(PescaKeyword.MAN_Buque, line, i));
            } else {
                proceso.addCodigoMaestro(Entidad.BUQUE_PESCA, getTokenString(PescaKeyword.MAN_BuqueAlt, line, i));
            }

            proceso.addCodigoMaestro(Entidad.BUQUE_PESCA, getTokenString(PescaKeyword.MAN_Buque, line, i));
            proceso.addCodigoMaestro(Entidad.TIPO_OPERACION_PESCA,
                    getTokenString(PescaKeyword.MAN_TipoOperacion, line, i));
            proceso.addCodigoMaestro(Entidad.TIPO_MANIFIESTO_PESCA, getTokenString(PescaKeyword.MAN_Tipo, line, i));
            proceso.addCodigoMaestro(Entidad.SUBTIPO_MANIFIESTO_PESCA,
                    getTokenString(PescaKeyword.MAN_Subtipo, line, i));
            proceso.addCodigoMaestro(Entidad.ARTE_PESCA, getTokenString(PescaKeyword.MAN_Arte, line, i));
            proceso.addCodigoMaestro(Entidad.ZONA_PESCA, getTokenString(PescaKeyword.MAN_Zona, line, i));
            proceso.addCodigoMaestro(Entidad.ORGANIZACION, getTokenString(PescaKeyword.MAN_Vendedor, line, i));
            proceso.addCodigoMaestro(Entidad.ORGANIZACION, getTokenString(PescaKeyword.MAN_ClienteAdicional, line, i));
            proceso.addCodigoMaestro(Entidad.COMPRADOR_PESCA, getTokenString(PescaKeyword.PAR_Comprador, line, i));
            proceso.addCodigoMaestro(Entidad.ESPECIE_PESCA, getTokenString(PescaKeyword.PAR_Especie, line, i));
            proceso.addCodigoMaestro(Entidad.PRESENTACION_PESCA,
                    getTokenString(PescaKeyword.PAR_Presentacion, line, i));
        }

        proceso.addCodigoMaestro(Entidad.TIPO_IVA, TIPO_IVA);
    }

    /**
     * Gets the token prto.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token prto
     */
    private PuertoVO getTokenPrto(final PescaKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (!proceso.getPrtoMap().containsKey(codigo)) {
            proceso.addError(MensajeCodigo.G_001, "linea: " + lineNumber + ", puerto: " + codigo);
        }

        return proceso.getPrtoMap().get(codigo);
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

        final ParametroVO prmt = proceso.findMaestro(entidad, codigo);

        if (prmt == null) {
            proceso.addError(MensajeCodigo.G_001,
                    "linea: " + lineNumber + ", entidad: " + entidad.name() + ", codigo: " + codigo);
        }

        return prmt;
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
                proceso.addError(MensajeCodigo.G_005, "linea: " + lineNumber + ", campo: " + keyword.name());
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
            proceso.addError(MensajeCodigo.G_004,
                    "linea: " + lineNumber + ", CR: " + tipoDato.name() + ", codigo: " + codigo);
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
            proceso.addError(MensajeCodigo.G_003, "linea: " + lineNumber + ", valor: " + codigo);

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
            proceso.addError(MensajeCodigo.G_002,
                    "linea: " + lineNumber + ", valor: " + codigo + ", formato: " + dateFormat);

            return null;
        }
    }
}
