package xeredi.integra.model.servicio.io.manifiesto;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioSubservicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoFileImport.
 */
public final class ManifiestoFileImport {

    /** The Constant LOG. */
    protected static final Log LOG = LogFactory.getLog(ManifiestoFileImport.class);

    /** The prbt. */
    private final ProcesoVO prbt;

    /** The manifiesto vo. */
    private final ServicioVO manifiestoVO = new ServicioVO();

    /** The ssrv list. */
    private final List<SubservicioVO> ssrvList = new ArrayList<>();

    /** The ssss list. */
    private final List<SubservicioSubservicioVO> ssssList = new ArrayList<>();

    /** The paeq map. */
    private final Map<String, List<Long>> paeqMap = new HashMap<>();

    /** The codigo maestro map. */
    private final Map<Entidad, Set<String>> codigoMaestroMap = new HashMap<Entidad, Set<String>>();

    /** The nif set. */
    private final Set<String> nifSet = new HashSet<>();

    /** The maestro map. */
    private Map<Entidad, Map<String, ParametroVO>> maestroMap;

    /** The organizaciones map. */
    private Map<String, ParametroVO> organizacionesMap;

    /** The subpuertos list. */
    private List<ParametroVO> subpuertosList;

    /** The mensaje. */
    private ManifiestoMensaje mensaje;

    /** The tipo operacion. */
    private String tipoOperacion;

    /** The numero edi. */
    private String numeroEDI;

    /**
     * Instantiates a new manifiesto file import.
     *
     * @param aprbt
     *            the aprbt
     */
    public ManifiestoFileImport(final ProcesoVO aprbt) {
        super();
        prbt = aprbt;
    }

    /**
     * Gets the primera linea.
     *
     * @param lines
     *            the lines
     * @return the primera linea
     */
    public int findPrimeraLinea(final List<String> lines) {
        int primeraLinea = 0;

        do {
            if (lines.get(primeraLinea).startsWith(ManifiestoSegmento.IFC.name())) {
                return primeraLinea;
            }

            if (lines.get(primeraLinea).startsWith(ManifiestoSegmento.UNB.name())) {
                final int mensajeInt = getTokenInteger(ManifiestoKeyword.UNB_FuncionMensaje, lines.get(primeraLinea),
                        primeraLinea);
                final int tipoOperacionInteger = getTokenInteger(ManifiestoKeyword.UNB_TipoOperacion,
                        lines.get(primeraLinea), primeraLinea);

                mensaje = ManifiestoMensaje.valueOf(mensajeInt);
                numeroEDI = getTokenString(ManifiestoKeyword.UNB_NumeroIntercambioEDI, lines.get(primeraLinea),
                        primeraLinea);
                tipoOperacion = tipoOperacionInteger == 833 ? "C" : "D";
            }

            primeraLinea++;
        } while (primeraLinea < lines.size());

        prbt.addError(MensajeCodigo.G_008, ManifiestoSegmento.IFC.name());

        return primeraLinea;
    }

    /**
     * Validar segmentos.
     *
     * @param lines
     *            the lines
     * @param primeraLinea
     *            the primera linea
     */
    public void validarSegmentos(final List<String> lines, final int primeraLinea) {
        // Validacion de Segmentos
        for (int i = primeraLinea; i < lines.size(); i++) {
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, lines.get(i), i);

            if (!ManifiestoSegmento.segmentoValido(segmento, mensaje)) {
                prbt.addError(MensajeCodigo.G_006, "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:"
                        + segmento.name());
            }
        }

        for (int i = primeraLinea + 1; i < lines.size(); i++) {
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, lines.get(i - 1), i - 1);
            final ManifiestoSegmento segmentoSiguiente = getTokenSegmento(ManifiestoKeyword.Segmento, lines.get(i), i);

            if (!ManifiestoSegmento.segmentoValido(segmento, segmentoSiguiente)) {
                prbt.addError(MensajeCodigo.G_006, "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:"
                        + segmento.name() + ", segmentoSiguiente:" + segmentoSiguiente.name());
            }
        }
    }

    /**
     * Busqueda maestros.
     *
     * @param lines
     *            the lines
     * @param primeraLinea
     *            the primera linea
     */
    public void readMaestros(final List<String> lines, final int primeraLinea) {
        // Lectura de Codigos de Maestros
        for (int i = primeraLinea; i < lines.size(); i++) {
            final String line = lines.get(i);
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, line, i);

            switch (segmento) {
            case IFC:
                addCodigoMaestro(Entidad.RECINTO_ADUANERO,
                        getTokenString(ManifiestoKeyword.IFC_CodigoRecintoAduanero, line, i));
                addCodigoMaestro(Entidad.PAIS, getTokenString(ManifiestoKeyword.IFC_CodigoPaisENS, line, i));
                addCodigoMaestro(Entidad.ALINEACION, getTokenString(ManifiestoKeyword.IFC_CodigoAlineacion, line, i));
                addCodigoMaestro(Entidad.TERMINAL, getTokenString(ManifiestoKeyword.IFC_CodigoTerminal, line, i));
                addCodigoMaestro(Entidad.ACUERDO, getTokenString(ManifiestoKeyword.IFC_CodigoAcuerdo, line, i));
                addCodigoMaestro(Entidad.SERVICIO_TRAFICO,
                        getTokenString(ManifiestoKeyword.IFC_CodigoServicio, line, i));

                addNif(getTokenString(ManifiestoKeyword.IFC_NIFConsignatarioBuque, line, i));
                addNif(getTokenString(ManifiestoKeyword.IFC_NIFConsignatarioMercancia, line, i));
                addNif(getTokenString(ManifiestoKeyword.IFC_NIFEstibador, line, i));

                break;
            case NAD:
                addNif(getTokenString(ManifiestoKeyword.NAD_NIFConsignatarioMercancia, line, i));

                break;
            case CNI:
                addCodigoMaestro(Entidad.PAIS, getTokenString(ManifiestoKeyword.CNI_CodigoPais_1, line, i));
                addCodigoMaestro(Entidad.UNLOCODE, getTokenString(ManifiestoKeyword.CNI_CodigoUnlocode_1, line, i));
                addCodigoMaestro(Entidad.PAIS, getTokenString(ManifiestoKeyword.CNI_CodigoPais_2, line, i));
                addCodigoMaestro(Entidad.UNLOCODE, getTokenString(ManifiestoKeyword.CNI_CodigoUnlocode_2, line, i));
                addCodigoMaestro(Entidad.PAIS, getTokenString(ManifiestoKeyword.CNI_CodigoPais_3, line, i));
                addCodigoMaestro(Entidad.UNLOCODE, getTokenString(ManifiestoKeyword.CNI_CodigoUnlocode_3, line, i));
                addCodigoMaestro(Entidad.PAIS, getTokenString(ManifiestoKeyword.CNI_CodigoPais_4, line, i));
                addCodigoMaestro(Entidad.UNLOCODE, getTokenString(ManifiestoKeyword.CNI_CodigoUnlocode_4, line, i));
                addCodigoMaestro(Entidad.MODO_TRANSPORTE_EDI,
                        getTokenString(ManifiestoKeyword.CNI_CodigoModoTransporteEDI, line, i));
                addCodigoMaestro(Entidad.ALINEACION, getTokenString(ManifiestoKeyword.CNI_CodigoAlineacion, line, i));
                addCodigoMaestro(Entidad.TERMINAL, getTokenString(ManifiestoKeyword.CNI_CodigoTerminal, line, i));
                addCodigoMaestro(Entidad.ACUERDO, getTokenString(ManifiestoKeyword.CNI_CodigoAcuerdo, line, i));
                addCodigoMaestro(Entidad.SERVICIO_TRAFICO,
                        getTokenString(ManifiestoKeyword.CNI_CodigoServicio, line, i));

                addNif(getTokenString(ManifiestoKeyword.CNI_NIFEstibador, line, i));

                break;
            case GID:
                addCodigoMaestro(Entidad.TIPO_BULTO, getTokenString(ManifiestoKeyword.GID_CodigoTipoBulto, line, i));
                addCodigoMaestro(Entidad.MERCANCIA, getTokenString(ManifiestoKeyword.GID_CodigoMercancia, line, i));
                addCodigoMaestro(Entidad.MARCA_VEHICULO,
                        getTokenString(ManifiestoKeyword.GID_CodigoMarcaVehiculo, line, i));
                addCodigoMaestro(Entidad.ACUERDO, getTokenString(ManifiestoKeyword.GID_CodigoAcuerdo, line, i));
                addCodigoMaestro(Entidad.INSTALACION_ESPECIAL,
                        getTokenString(ManifiestoKeyword.GID_CodigoInstalacionEspecial, line, i));
                addCodigoMaestro(Entidad.TERMINAL, getTokenString(ManifiestoKeyword.GID_CodigoTerminal, line, i));

                addNif(getTokenString(ManifiestoKeyword.GID_NifEstibador, line, i));

                break;
            case PCI:
                addCodigoMaestro(Entidad.INSTRUCCION_MARCAJE,
                        getTokenString(ManifiestoKeyword.PCI_CodigoInstruccionMarcaje, line, i));

                break;
            case GOR:

                break;
            case DOC:
                addCodigoMaestro(Entidad.TIPO_DOCUMENTO_AEAT,
                        getTokenString(ManifiestoKeyword.DOC_CodigoTipoDocumento, line, i));

                break;
            case SGP:

                break;
            case DGS:
                addCodigoMaestro(
                        Entidad.MERCANCIAS_PELIGROSAS,
                        getTokenString(ManifiestoKeyword.DGS_NumeroONU, line, i)
                        + getTokenString(ManifiestoKeyword.DGS_Clase, line, i));

                break;
            case EQD:
                addCodigoMaestro(
                        Entidad.TIPO_EQUIPAMIENTO,
                        getTokenString(ManifiestoKeyword.EQD_CodigoTipoEquipamiento, line, i)
                        + getTokenString(ManifiestoKeyword.EQD_TamanioEquipamiento, line, i));

                break;
            case SEL:

                break;
            default:
                break;
            }
        }
    }

    /**
     * Procesar archivo.
     *
     * @param lines
     *            the lines
     * @param primeraLinea
     *            the primera linea
     */
    public void readFile(final List<String> lines, final int primeraLinea) {
        // Generacion de datos del manifiesto
        SubservicioVO blActualVO = null;
        SubservicioVO partActualVO = null;
        SubservicioVO paimActualVO = null;
        SubservicioVO padoActualVO = null;
        SubservicioVO pampActualVO = null;
        SubservicioVO paeqActualVO = null;
        SubservicioVO equiActualVO = null;
        SubservicioVO macoActualVO = null;
        SubservicioVO preqActualVO = null;

        ParametroVO estibadorVO = null;

        Integer anioEscala = null;
        Integer numeroEscala = null;

        long contadorSsrv = 0;
        int contadorMaco = 0;
        int contadorPado = 0;
        int contadorPaeq = 0;
        int contadorEqui = 0;
        int contadorPaim = 0;
        int contadorPamp = 0;
        int contadorPreq = 0;

        manifiestoVO.setEntiId(Entidad.MANIFIESTO.getId());
        manifiestoVO.setItdtMap(new HashMap<Long, ItemDatoVO>());

        for (int i = primeraLinea; i < lines.size(); i++) {
            final String line = lines.get(i);
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, line, i);

            switch (segmento) {
            case IFC:
                anioEscala = getTokenInteger(ManifiestoKeyword.IFC_AnioEscala, line, i);
                numeroEscala = getTokenInteger(ManifiestoKeyword.IFC_NumeroEscala, line, i);

                manifiestoVO.addItdt(TipoDato.CADENA_01.getId(),
                        getTokenString(ManifiestoKeyword.IFC_NumeroEDI, line, i));

                final ParametroVO recintoAduanero = getTokenMaestro(ManifiestoKeyword.IFC_CodigoRecintoAduanero, line,
                        i, Entidad.RECINTO_ADUANERO);
                final ParametroVO subpuerto = calcularSubpuerto(recintoAduanero);

                manifiestoVO.setSubp(subpuerto);
                // FIXME Calcular Año
                manifiestoVO.setAnno("201" + anioEscala);
                // FIXME Calcular fechaReferencia
                manifiestoVO.setFref(Calendar.getInstance().getTime());
                manifiestoVO.addItdt(TipoDato.REC_ADU.getId(), recintoAduanero);

                final String tipoManifiestoEDI = getTokenString(ManifiestoKeyword.IFC_TipoManifiesto, line, i);
                final String tipoManifiesto = getTipoManifiesto(tipoManifiestoEDI);

                manifiestoVO.addItdt(TipoDato.TIPO_MANIF.getId(), tipoManifiesto);
                manifiestoVO.addItdt(TipoDato.TIPO_OPER_MANIF.getId(), tipoOperacion);

                final String califPais = getTokenString(ManifiestoKeyword.IFC_TipoLugarEmbarque, line, i);

                if ("9".equals(califPais)) {
                    manifiestoVO.addItdt(TipoDato.PAIS.getId(),
                            getTokenMaestro(ManifiestoKeyword.IFC_CodigoPaisENS, line, i, Entidad.PAIS));
                }

                manifiestoVO.addItdt(TipoDato.BOOLEANO_03.getId(),
                        "SI".equals(getTokenString(ManifiestoKeyword.IFC_RegimenSimplificado, line, i)) ? 1L : 0L);
                manifiestoVO.addItdt(TipoDato.ENTERO_01.getId(),
                        getTokenLong(ManifiestoKeyword.IFC_NumeroTramos, line, i));

                final String califConsignatarioBuque = getTokenString(ManifiestoKeyword.IFC_TipoConsignatarioBuque,
                        line, i);

                if ("CV".equals(califConsignatarioBuque)) {
                    manifiestoVO.addItdt(TipoDato.ORGA_2.getId(),
                            getTokenOrganizacion(ManifiestoKeyword.IFC_NIFConsignatarioBuque, line, i));
                }

                final String califConsignatarioMercancia = getTokenString(
                        ManifiestoKeyword.IFC_TipoConsignatarioMercancia, line, i);

                if ("CN".equals(califConsignatarioMercancia)) {
                }

                final String califEstibador = getTokenString(ManifiestoKeyword.IFC_TipoEstibador, line, i);

                if ("TR".equals(califEstibador)) {
                    manifiestoVO.addItdt(TipoDato.ORGA.getId(),
                            getTokenOrganizacion(ManifiestoKeyword.IFC_NIFEstibador, line, i));
                }

                manifiestoVO.addItdt(TipoDato.FECHA_01.getId(),
                        getTokenDate(ManifiestoKeyword.IFC_FechaUltimoEnvio, line, i, "ddMMyyHHmm"));
                manifiestoVO.addItdt(TipoDato.CADENA_02.getId(),
                        getTokenString(ManifiestoKeyword.IFC_NumeroViaje, line, i));
                manifiestoVO.addItdt(TipoDato.BOOLEANO_02.getId(), "ZRE".equals(getTokenString(
                        ManifiestoKeyword.IFC_CalificadorServicioRegular, line, i)) ? 1L : 0L);
                manifiestoVO.addItdt(TipoDato.CADENA_03.getId(),
                        getTokenString(ManifiestoKeyword.IFC_TransitoComunitarioSimplificado, line, i));
                manifiestoVO.addItdt(TipoDato.ALIN.getId(),
                        getTokenMaestro(ManifiestoKeyword.IFC_CodigoAlineacion, line, i, Entidad.ALINEACION));
                manifiestoVO.addItdt(TipoDato.TERMINAL.getId(),
                        getTokenMaestro(ManifiestoKeyword.IFC_CodigoTerminal, line, i, Entidad.TERMINAL));
                manifiestoVO.addItdt(TipoDato.ACUERDO.getId(),
                        getTokenMaestro(ManifiestoKeyword.IFC_CodigoAcuerdo, line, i, Entidad.ACUERDO));
                manifiestoVO.addItdt(TipoDato.SERV_TRAF.getId(),
                        getTokenMaestro(ManifiestoKeyword.IFC_CodigoServicio, line, i, Entidad.SERVICIO_TRAFICO));

                break;
            case NAD:
                macoActualVO = new SubservicioVO();
                macoActualVO.setEntiId(Entidad.MANIFIESTO_CONSIGNATARIO.getId());
                macoActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                macoActualVO.setId(contadorSsrv++);
                macoActualVO.setNumero(++contadorMaco);

                macoActualVO.addItdt(TipoDato.ORGA.getId(),
                        getTokenOrganizacion(ManifiestoKeyword.NAD_NIFConsignatarioMercancia, line, i));

                ssrvList.add(macoActualVO);

                break;
            case CNI:
                blActualVO = new SubservicioVO();
                blActualVO.setEntiId(Entidad.BL.getId());
                blActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                blActualVO.setId(contadorSsrv++);
                blActualVO.setNumero(getTokenInteger(ManifiestoKeyword.CNI_NumeroBL, line, i));

                blActualVO.addItdt(TipoDato.CADENA_01.getId(), getTokenString(ManifiestoKeyword.CNI_NombreBL, line, i));
                blActualVO.addItdt(TipoDato.TIPO_BL.getId(),
                        getTipoBl(getTokenString(ManifiestoKeyword.CNI_TipoBL, line, i)));

                String calificadorPuerto = null;

                calificadorPuerto = getTokenString(ManifiestoKeyword.CNI_CalificadorPuerto_1, line, i);

                setUnlocodeBl(blActualVO, getTokenString(ManifiestoKeyword.CNI_CalificadorPuerto_1, line, i),
                        getTokenMaestro(ManifiestoKeyword.CNI_CodigoUnlocode_1, line, i, Entidad.UNLOCODE));
                setUnlocodeBl(blActualVO, getTokenString(ManifiestoKeyword.CNI_CalificadorPuerto_2, line, i),
                        getTokenMaestro(ManifiestoKeyword.CNI_CodigoUnlocode_2, line, i, Entidad.UNLOCODE));
                setUnlocodeBl(blActualVO, getTokenString(ManifiestoKeyword.CNI_CalificadorPuerto_3, line, i),
                        getTokenMaestro(ManifiestoKeyword.CNI_CodigoUnlocode_3, line, i, Entidad.UNLOCODE));
                setUnlocodeBl(blActualVO, getTokenString(ManifiestoKeyword.CNI_CalificadorPuerto_4, line, i),
                        getTokenMaestro(ManifiestoKeyword.CNI_CodigoUnlocode_4, line, i, Entidad.UNLOCODE));

                blActualVO.addItdt(TipoDato.CADENA_02.getId(),
                        getTokenString(ManifiestoKeyword.CNI_DeclaracionSumariaTransito, line, i));

                final ParametroVO modoTransporteEdiVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoModoTransporteEDI,
                        line, i, Entidad.MODO_TRANSPORTE_EDI);

                if (modoTransporteEdiVO != null) {
                    blActualVO.addItdt(TipoDato.MODO_TRANS_EDI.getId(), modoTransporteEdiVO);
                    blActualVO.addItdt(TipoDato.TIPO_TRANSPORTE.getId(),
                            modoTransporteEdiVO.getItdtMap().get(TipoDato.TIPO_TRANSPORTE.getId()).getCadena());
                }

                blActualVO.addItdt(TipoDato.CADENA_03.getId(),
                        getTokenString(ManifiestoKeyword.CNI_BuqueTransportePosterior, line, i));
                blActualVO.addItdt(TipoDato.TIPO_DEST.getId(),
                        getTokenCR(ManifiestoKeyword.CNI_TipoDestinoBl, line, i, TipoDato.TIPO_DEST));

                final ParametroVO alineacionBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoAlineacion, line, i,
                        Entidad.ALINEACION);

                blActualVO.addItdt(TipoDato.ALIN.getId(),
                        alineacionBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.ALIN.getId()).getPrmt()
                                : alineacionBlVO);

                final ParametroVO terminalBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoTerminal, line, i,
                        Entidad.TERMINAL);

                blActualVO.addItdt(TipoDato.TERMINAL.getId(),
                        terminalBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.TERMINAL.getId()).getPrmt()
                                : terminalBlVO);

                final ParametroVO acuerdoBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoAcuerdo, line, i,
                        Entidad.ACUERDO);

                blActualVO.addItdt(TipoDato.ACUERDO.getId(),
                        acuerdoBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.ACUERDO.getId()).getPrmt()
                                : acuerdoBlVO);

                final ParametroVO servicioBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoServicio, line, i,
                        Entidad.SERVICIO_TRAFICO);

                blActualVO.addItdt(TipoDato.SERV_TRAF.getId(),
                        servicioBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.SERV_TRAF.getId()).getPrmt()
                                : servicioBlVO);

                estibadorVO = getTokenOrganizacion(ManifiestoKeyword.CNI_NIFEstibador, line, i);

                blActualVO.addItdt(TipoDato.ORGA_2.getId(),
                        estibadorVO == null ? manifiestoVO.getItdtMap().get(TipoDato.ORGA.getId()).getPrmt()
                                : estibadorVO);

                ssrvList.add(blActualVO);
                ssssList.add(new SubservicioSubservicioVO(macoActualVO.getId(), blActualVO.getId()));

                break;
            case GID:
                if (blActualVO == null) {
                    throw new Error("BL no puede ser nulo");
                }

                partActualVO = new SubservicioVO();
                partActualVO.setEntiId(Entidad.PARTIDA.getId());
                partActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                partActualVO.setId(contadorSsrv++);
                partActualVO.setNumero(getTokenInteger(ManifiestoKeyword.GID_NumeroPartida, line, i));

                final Long numeroBultos = getTokenLong(ManifiestoKeyword.GID_NumeroBultos, line, i);
                final String tipoBl = blActualVO.getItdtMap().get(TipoDato.TIPO_BL.getId()).getCadena();

                if ("M".equals(tipoBl)) {
                    partActualVO.addItdt(TipoDato.ENTERO_01.getId(), numeroBultos);

                    final String calif1 = getTokenString(ManifiestoKeyword.GID_CalificadorMedida_1, line, i);
                    final Double valor1 = getTokenDouble(ManifiestoKeyword.GID_ValorMedida_1, line, i);

                    if (valor1 != null) {
                        if ("VOL".equals(calif1)) {
                            partActualVO.addItdt(TipoDato.DECIMAL_01.getId(), valor1);
                        } else {
                            partActualVO.addItdt(TipoDato.ENTERO_04.getId(), valor1.longValue());
                        }
                    }

                    final String calif2 = getTokenString(ManifiestoKeyword.GID_CalificadorMedida_2, line, i);
                    final Double valor2 = getTokenDouble(ManifiestoKeyword.GID_ValorMedida_2, line, i);

                    if (valor2 != null) {
                        if ("VOL".equals(calif2)) {
                            partActualVO.addItdt(TipoDato.DECIMAL_01.getId(), valor2);
                        } else {
                            partActualVO.addItdt(TipoDato.ENTERO_04.getId(), valor2.longValue());
                        }
                    }
                } else if ("P".equals(tipoBl)) {
                    partActualVO.addItdt(TipoDato.ENTERO_03.getId(), numeroBultos);
                    partActualVO.addItdt(TipoDato.ENTERO_04.getId(), 0L);
                }

                partActualVO.addItdt(TipoDato.TIPO_BULTO.getId(),
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoTipoBulto, line, i, Entidad.TIPO_BULTO));

                final ParametroVO mercancia = getTokenMaestro(ManifiestoKeyword.GID_CodigoMercancia, line, i,
                        Entidad.MERCANCIA);

                partActualVO.addItdt(TipoDato.MERCANCIA.getId(), mercancia);

                // TODO Asignarle despues el de el equipamiento (si lo hay)
                if (mercancia != null) {
                    partActualVO.addItdt(TipoDato.UNIDAD_CARGA.getId(),
                            mercancia.getItdtMap().get(TipoDato.UNIDAD_CARGA.getId()).getPrmt());
                }

                partActualVO.addItdt(TipoDato.MARCA_VEHIC.getId(),
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoMarcaVehiculo, line, i, Entidad.MARCA_VEHICULO));
                partActualVO.addItdt(TipoDato.ACUERDO.getId(),
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoAcuerdo, line, i, Entidad.ACUERDO));
                partActualVO.addItdt(
                        TipoDato.INST_ESP.getId(),
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoInstalacionEspecial, line, i,
                                Entidad.INSTALACION_ESPECIAL));
                partActualVO.addItdt(TipoDato.TERMINAL.getId(),
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoTerminal, line, i, Entidad.TERMINAL));
                partActualVO.addItdt(TipoDato.CADENA_01.getId(),
                        getTokenString(ManifiestoKeyword.GID_DeclaracionSumariaTransito, line, i));

                estibadorVO = getTokenOrganizacion(ManifiestoKeyword.GID_NifEstibador, line, i);

                partActualVO.addItdt(TipoDato.ORGA.getId(),
                        estibadorVO == null ? blActualVO.getItdtMap().get(TipoDato.ORGA_2.getId()).getPrmt()
                                : estibadorVO);

                ssrvList.add(partActualVO);
                ssssList.add(new SubservicioSubservicioVO(blActualVO.getId(), partActualVO.getId()));

                break;
            case PCI:
                paimActualVO = new SubservicioVO();
                paimActualVO.setEntiId(Entidad.PARTIDA_IM.getId());
                paimActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                paimActualVO.setId(contadorSsrv++);
                paimActualVO.setNumero(++contadorPaim);

                paimActualVO.addItdt(
                        TipoDato.INST_MARC.getId(),
                        getTokenMaestro(ManifiestoKeyword.PCI_CodigoInstruccionMarcaje, line, i,
                                Entidad.INSTRUCCION_MARCAJE));
                paimActualVO.addItdt(TipoDato.CADENA_01.getId(), getTokenString(ManifiestoKeyword.PCI_Marca, line, i));

                ssrvList.add(paimActualVO);
                ssssList.add(new SubservicioSubservicioVO(partActualVO.getId(), paimActualVO.getId()));

                break;
            case GOR:
                padoActualVO = new SubservicioVO();
                padoActualVO.setEntiId(Entidad.PARTIDA_DOCUMENTO.getId());
                padoActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                padoActualVO.setId(contadorSsrv++);
                padoActualVO.setNumero(++contadorPado);

                padoActualVO.addItdt(TipoDato.SIT_ADU.getId(),
                        getTokenCR(ManifiestoKeyword.GOR_CodigoSituacionAduanera, line, i, TipoDato.SIT_ADU));

                ssrvList.add(padoActualVO);
                ssssList.add(new SubservicioSubservicioVO(partActualVO.getId(), padoActualVO.getId()));

                break;
            case DOC:
                if (padoActualVO == null) {
                    throw new Error("Nunca deberia ser null");
                }

                if (padoActualVO.getEntiId() != Entidad.PARTIDA_DOCUMENTO.getId()) {
                    throw new Error("Tipo de Subservicio no valido");
                }

                padoActualVO
                .addItdt(
                        TipoDato.TIPO_DOC_AEAT.getId(),
                        getTokenMaestro(ManifiestoKeyword.DOC_CodigoTipoDocumento, line, i,
                                Entidad.TIPO_DOCUMENTO_AEAT));
                padoActualVO.addItdt(TipoDato.FECHA_01.getId(),
                        getTokenDate(ManifiestoKeyword.DOC_FechaEmision, line, i, "ddMMyy"));
                padoActualVO.addItdt(TipoDato.CADENA_01.getId(),
                        getTokenString(ManifiestoKeyword.DOC_NumeroDocumento, line, i));
                padoActualVO.addItdt(TipoDato.SIT_EMB.getId(),
                        getTokenCR(ManifiestoKeyword.DOC_SituacionEmbarque, line, i, TipoDato.SIT_EMB));

                break;
            case SGP:
                paeqActualVO = new SubservicioVO();
                paeqActualVO.setEntiId(Entidad.PARTIDA_EQUIPAMIENTO.getId());
                paeqActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                paeqActualVO.setId(contadorSsrv++);
                paeqActualVO.setNumero(++contadorPaeq);

                paeqActualVO.addItdt(TipoDato.ENTERO_01.getId(),
                        getTokenLong(ManifiestoKeyword.SGP_NumeroBultos, line, i));

                final String matricula = getTokenString(ManifiestoKeyword.SGP_Matricula, line, i);

                if (!paeqMap.containsKey(matricula)) {
                    paeqMap.put(matricula, new ArrayList<Long>());
                }

                paeqMap.get(matricula).add(paeqActualVO.getId());

                ssrvList.add(paeqActualVO);
                ssssList.add(new SubservicioSubservicioVO(partActualVO.getId(), paeqActualVO.getId()));

                break;
            case DGS:
                pampActualVO = new SubservicioVO();
                pampActualVO.setEntiId(Entidad.PARTIDA_MMPP.getId());
                pampActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                pampActualVO.setId(contadorSsrv++);
                pampActualVO.setNumero(++contadorPamp);

                final String codigoMmpp = getTokenString(ManifiestoKeyword.DGS_NumeroONU, line, i)
                        + getTokenString(ManifiestoKeyword.DGS_Clase, line, i);

                pampActualVO.addItdt(TipoDato.MERC_PELIG.getId(),
                        getTokenMaestro(codigoMmpp, line, i, Entidad.MERCANCIAS_PELIGROSAS));

                ssrvList.add(pampActualVO);
                ssssList.add(new SubservicioSubservicioVO(partActualVO.getId(), pampActualVO.getId()));

                break;
            case EQD:
                equiActualVO = new SubservicioVO();
                equiActualVO.setEntiId(Entidad.EQUIPAMIENTO.getId());
                equiActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                equiActualVO.setId(contadorSsrv++);
                equiActualVO.setNumero(++contadorEqui);

                final String indicadorLleno = getTokenString(ManifiestoKeyword.EQD_IndicadorLleno, line, i);

                equiActualVO.addItdt(TipoDato.CADENA_02.getId(), indicadorLleno);

                if (!"4".equals(indicadorLleno)) {
                    final String matriculaEqui = getTokenString(ManifiestoKeyword.EQD_Matricula, line, i);

                    equiActualVO.addItdt(TipoDato.CADENA_01.getId(), matriculaEqui);

                    if (matriculaEqui != null) {
                        if (!paeqMap.containsKey(matriculaEqui)) {
                            LOG.fatal("Matricula no encontrada!!! " + matriculaEqui);
                        } else {
                            for (final Long paeqId : paeqMap.get(matriculaEqui)) {
                                ssssList.add(new SubservicioSubservicioVO(equiActualVO.getId(), paeqId));
                            }
                        }
                    }
                }

                final String codigoTipoEquipamiento = getTokenString(ManifiestoKeyword.EQD_CodigoTipoEquipamiento,
                        line, i) + getTokenString(ManifiestoKeyword.EQD_TamanioEquipamiento, line, i);
                final ParametroVO tipoEquipamiento = getTokenMaestro(codigoTipoEquipamiento, line, i,
                        Entidad.TIPO_EQUIPAMIENTO);

                if (tipoEquipamiento != null) {
                    equiActualVO.addItdt(TipoDato.TIPO_EQUI.getId(), tipoEquipamiento);
                    equiActualVO.addItdt(TipoDato.UNIDAD_CARGA.getId(),
                            tipoEquipamiento.getItdtMap().get(TipoDato.UNIDAD_CARGA.getId()).getPrmt());
                }

                equiActualVO.addItdt(TipoDato.ENTERO_02.getId(),
                        getTokenLong(ManifiestoKeyword.EQD_TaraEquipamiento, line, i));
                equiActualVO.addItdt(TipoDato.ENTERO_01.getId(),
                        getTokenLong(ManifiestoKeyword.EQD_NumeroVacios, line, i));

                ssrvList.add(equiActualVO);
                ssssList.add(new SubservicioSubservicioVO(blActualVO.getId(), equiActualVO.getId()));

                break;
            case SEL:
                preqActualVO = new SubservicioVO();
                preqActualVO.setEntiId(Entidad.PRECINTO_EQUIPAMIENTO.getId());
                preqActualVO.setItdtMap(new HashMap<Long, ItemDatoVO>());
                preqActualVO.setId(contadorSsrv++);
                preqActualVO.setNumero(++contadorPreq);

                preqActualVO.addItdt(TipoDato.CADENA_01.getId(),
                        getTokenString(ManifiestoKeyword.SEL_Precinto, line, i));

                ssrvList.add(preqActualVO);
                ssssList.add(new SubservicioSubservicioVO(equiActualVO.getId(), preqActualVO.getId()));

                break;
            default:
                break;
            }
        }

        // LOG.info("prbt: " + prbt);
        // LOG.info("srvc: " + manifiestoVO);
        // LOG.info("ssrvList: " + ssrvList);
        // LOG.info("ssssList: " + ssssList);
    }

    /**
     * Gets the tipo bl.
     *
     * @param tipoBlEDI
     *            the tipo bl edi
     * @return the tipo bl
     */
    private String getTipoBl(final String tipoBlEDI) {
        switch (tipoBlEDI) {
        case "ZZ1":
            return "M";
        case "ZZ2":
            return "P";
        case "ZZ3":
            return "V";
        default:
            throw new Error("Tipo de BL EDI no valido '" + tipoBlEDI + "'");
        }
    }

    /**
     * Gets the tipo manifiesto.
     *
     * @param tipoManifiestoEDI
     *            the tipo manifiesto edi
     * @return the tipo manifiesto
     */
    private String getTipoManifiesto(final String tipoManifiestoEDI) {
        switch (tipoManifiestoEDI) {
        case "1":
            return "CA";
        case "ZSC":
            return "SC";
        case "ZCL":
            return "CL";
        case "2":
            return "DE";
        case "ZSD":
            return "SD";
        case "ZDL":
            return "DL";
        default:
            throw new Error("Tipo de Manifiesto EDI no valido '" + tipoManifiestoEDI + "'");
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
    private final void addCodigoMaestro(final Entidad entidad, final String codigo) {
        Preconditions.checkNotNull(entidad);

        if (!codigoMaestroMap.containsKey(entidad)) {
            codigoMaestroMap.put(entidad, new HashSet<String>());
        }

        if (codigo != null && !codigo.isEmpty()) {
            codigoMaestroMap.get(entidad).add(codigo);
        }
    }

    /**
     * Adds the nif.
     *
     * @param nif
     *            the nif
     */
    protected final void addNif(final String nif) {
        nifSet.add(nif);
    }

    /**
     * Sets the unlocode bl.
     *
     * @param bl
     *            the bl
     * @param calificadorPuerto
     *            the calificador puerto
     * @param unlocode
     *            the unlocode
     */
    private void setUnlocodeBl(final SubservicioVO bl, final String calificadorPuerto, final ParametroVO unlocode) {
        switch (calificadorPuerto) {
        case "5":
            bl.addItdt(TipoDato.UNLOCODE.getId(), unlocode);

            break;
        case "9":
            bl.addItdt(TipoDato.UNLOCODE_2.getId(), unlocode);

            break;
        case "11":
            bl.addItdt(TipoDato.UNLOCODE_3.getId(), unlocode);

            break;
        case "8":
            bl.addItdt(TipoDato.UNLOCODE_4.getId(), unlocode);

            break;
        case "13":
            bl.addItdt(TipoDato.UNLOCODE_5.getId(), unlocode);

            break;
        default:
            throw new Error("Calificador puerto '" + calificadorPuerto + "' no valido");
        }
    }

    private ParametroVO calcularSubpuerto(final ParametroVO recintoAduanero) {
        Preconditions.checkNotNull(recintoAduanero);

        final Long unlocodeId = recintoAduanero.getItdtMap().get(TipoDato.UNLOCODE.getId()).getItemId();

        for (final ParametroVO vo : subpuertosList) {
            if (unlocodeId == vo.getItdtMap().get(TipoDato.UNLOCODE.getId()).getItemId()) {
                return vo;
            }
        }

        throw new Error("Subpuerto no encontrado");
    }

    /**
     * Gets the token organizacion.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token organizacion
     */
    private ParametroVO getTokenOrganizacion(final ManifiestoKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!organizacionesMap.containsKey(codigo)) {
            prbt.addError(MensajeCodigo.G_001, "linea: " + lineNumber + ", entidad: " + Entidad.ORGANIZACION.name()
                    + ", codigo: " + codigo);
        }

        return organizacionesMap.get(codigo);
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
    private String getTokenString(final ManifiestoKeyword keyword, final String line, final int lineNumber) {
        if (line.length() >= keyword.getOffset() + keyword.getLength()) {
            final String token = line.substring(keyword.getOffset(), keyword.getOffset() + keyword.getLength()).trim();

            if ((token == null || token.isEmpty()) && keyword.isRequired()) {
                prbt.addError(MensajeCodigo.G_005, "linea: " + lineNumber + ", campo: " + keyword.name());
            }

            return token;
        }

        return null;
    }

    /**
     * Gets the token long.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token long
     */
    private Long getTokenLong(final ManifiestoKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Long.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            prbt.addError(MensajeCodigo.G_003, "linea: " + lineNumber + ", valor: " + codigo);

            return null;
        }
    }

    private Double getTokenDouble(final ManifiestoKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Double.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            prbt.addError(MensajeCodigo.G_003, "linea: " + lineNumber + ", valor: " + codigo);

            return null;
        }
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
    private ParametroVO getTokenMaestro(final ManifiestoKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            prbt.addError(MensajeCodigo.G_001, "linea: " + lineNumber + ", entidad: " + entidad.name() + ", codigo: "
                    + codigo);
        }

        return maestroMap.get(entidad).get(codigo);
    }

    /**
     * Gets the token maestro.
     *
     * @param codigo
     *            the codigo
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @return the token maestro
     */
    private ParametroVO getTokenMaestro(final String codigo, final String line, final int lineNumber,
            final Entidad entidad) {
        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            prbt.addError(MensajeCodigo.G_001, "linea: " + lineNumber + ", entidad: " + entidad.name() + ", codigo: "
                    + codigo);
        }

        return maestroMap.get(entidad).get(codigo);
    }

    /**
     * Gets the token segmento.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token segmento
     */
    private ManifiestoSegmento getTokenSegmento(final ManifiestoKeyword keyword, final String line, final int lineNumber) {
        return ManifiestoSegmento.valueOf(getTokenString(keyword, line, lineNumber));
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
    private String getTokenCR(final ManifiestoKeyword keyword, final String line, final int lineNumber,
            final TipoDato tipoDato) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        final TipoDatoVO tpdtVO = TipoDatoProxy.select(tipoDato.getId());

        if (!tpdtVO.getCdrfCodeSet().contains(codigo)) {
            prbt.addError(MensajeCodigo.G_004, "linea: " + lineNumber + ", CR: " + tipoDato.name() + ", codigo: "
                    + codigo);
        }

        return codigo;
    }

    /**
     * Gets the token integer.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token integer
     */
    private Integer getTokenInteger(final ManifiestoKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Integer.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            prbt.addError(MensajeCodigo.G_003, "linea: " + lineNumber + ", valor: " + codigo);

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
    private Date getTokenDate(final ManifiestoKeyword keyword, final String line, final int lineNumber,
            final String dateFormat) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return new SimpleDateFormat(dateFormat).parse(codigo);
        } catch (final ParseException ex) {
            prbt.addError(MensajeCodigo.G_002, "linea: " + lineNumber + ", valor: " + codigo + ", formato: "
                    + dateFormat);

            return null;
        }
    }

    // get / set

    /**
     * Gets the manifiesto vo.
     *
     * @return the manifiesto vo
     */
    public ServicioVO getManifiestoVO() {
        return manifiestoVO;
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
     * Gets the ssss list.
     *
     * @return the ssss list
     */
    public List<SubservicioSubservicioVO> getSsssList() {
        return ssssList;
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

    /**
     * Sets the organizaciones map.
     *
     * @param value
     *            the value
     */
    public void setOrganizacionesMap(final Map<String, ParametroVO> value) {
        organizacionesMap = value;
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
     * Gets the nif set.
     *
     * @return the nif set
     */
    public Set<String> getNifSet() {
        return nifSet;
    }

    /**
     * Gets the mensaje.
     *
     * @return the mensaje
     */
    public ManifiestoMensaje getMensaje() {
        return mensaje;
    }

    /**
     * Sets the subpuertos list.
     *
     * @param value
     *            the new subpuertos list
     */
    public void setSubpuertosList(final List<ParametroVO> value) {
        subpuertosList = value;
    }
}
