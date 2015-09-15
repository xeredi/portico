package xeredi.integra.proceso.servicio.escala;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.bo.PuertoBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.PuertoCriterioVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.item.vo.ItemDatoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.escala.EscalaEdiBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.proceso.FiledateComparator;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaEscala.
 */
public final class ProcesoCargaEscala extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaEscala.class);

    /** The mensaje. */
    private EscalaTipoMensaje mensaje = null;

    /** The emisor edi. */
    private String emisorEDI = null;

    /** The referencia mensaje edi. */
    private String referenciaMensajeEDI = null;

    /** The nombre documento. */
    private String nombreDocumento = null;

    /** The berman mensaje. */
    private EscalaMensaje bermanMensaje = null;

    /** The fecha solicitud. */
    private Date fechaSolicitud = null;

    /** The escala vo. */
    private final ServicioVO escalaVO = new ServicioVO();

    /** The buque vo. */
    private final ParametroVO buqueVO = new ParametroVO();

    /** The atraque list. */
    private final List<SubservicioVO> atraqueList = new ArrayList<>();

    /** The operaciones map. */
    private final Map<Long, List<SubservicioVO>> operacionesMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepararProcesos() {
        final ProcesoBO prbtBO = new ProcesoBO();

        final String folderPath = ConfigurationProxy.getString(ConfigurationKey.escala_files_entrada_home);
        final File folder = new File(folderPath);
        final File[] files = folder.listFiles();

        if (files.length > 0) {
            Arrays.sort(files, new FiledateComparator());

            for (final File file : files) {
                try {
                    if (LOG.isInfoEnabled()) {
                        LOG.info("Crear proceso para archivo: " + file.getCanonicalPath());
                    }

                    prbtBO.crear(ProcesoTipo.ESC_CARGA, null, null, null, file);

                    file.delete();
                } catch (final IOException ex) {
                    LOG.fatal(ex, ex);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutarProceso() {
        for (final ArchivoInfoVO arin : arinEntradaList) {
            final ArchivoBO flsrBO = new ArchivoBO();

            LOG.info("Importar: " + arin.getNombre());

            try (final InputStream stream = flsrBO.selectStream(arin.getId())) {
                final List<String> lines = IOUtils.readLines(stream);

                tratarUNB(lines);

                if (prmnList.isEmpty()) {
                    if (EscalaTipoMensaje.BERMAN == mensaje) {
                        tratarBGM(lines);

                        final int primeraLinea = getPrimeraLineaBerman(lines);

                        if (prmnList.isEmpty()) {
                            validarSegmentosBerman(lines, primeraLinea);
                        }

                        if (prmnList.isEmpty()) {
                            busquedaCodigosMaestrosBerman(lines, primeraLinea);
                        }
                        if (prmnList.isEmpty()) {
                            buscarMaestros(fechaSolicitud);
                            buscarOrganizaciones(fechaSolicitud);
                        }
                        if (prmnList.isEmpty()) {
                            lecturaEscalaBerman(lines, primeraLinea);
                        }
                        if (prmnList.isEmpty()) {
                            final EscalaEdiBO escalaEdiBO = new EscalaEdiBO();

                            switch (bermanMensaje) {
                            case BERMAN_ALTA_SOLICITUD_ESCALA:
                                try {
                                    escalaEdiBO.altaEscala(escalaVO, atraqueList, operacionesMap);
                                } catch (final DuplicateInstanceException ex) {
                                    addError(MensajeCodigo.G_011, escalaVO.getEtiqueta());
                                }

                                break;
                            default:
                                throw new Error("Mensaje Berman no implementado: " + bermanMensaje.name());
                            }
                        }
                    } else if (EscalaTipoMensaje.APERAK == mensaje) {

                    }
                }
            } catch (final IOException ex) {
                LOG.error(ex, ex);

                addError(MensajeCodigo.G_010, "archivo:" + arin.getNombre() + ", error:" + ex.getMessage());
            } catch (final InstanceNotFoundException ex) {
                LOG.error(ex, ex);

                addError(MensajeCodigo.G_000, "archivo:" + arin.getNombre() + ", error:" + ex.getMessage());
            }
        }

        LOG.info(prmnList);
    }

    /**
     * Tratar unb.
     *
     * @param lines
     *            the lines
     */
    private void tratarUNB(final List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);

            if (line.startsWith(BermanSegmento.UNB.name())) {
                mensaje = EscalaTipoMensaje.valueOf(getTokenString(BermanKeyword.UNB_NombreMensaje, line, i));
                emisorEDI = getTokenString(BermanKeyword.UNB_EmisorEDI, line, i);
                referenciaMensajeEDI = getTokenString(BermanKeyword.UNB_ReferenciaMensajeEDI, line, i);

                if (LOG.isInfoEnabled()) {
                    LOG.info("mensaje: " + mensaje);
                    LOG.info("emisorEDI: " + emisorEDI);
                    LOG.info("referenciaMensajeEDI: " + referenciaMensajeEDI);
                }

                return;
            }
        }

        addError(MensajeCodigo.G_008, BermanSegmento.UNB.name());
    }

    /**
     * Tratar bgm.
     *
     * @param lines
     *            the lines
     */
    private void tratarBGM(final List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);

            if (line.startsWith(BermanSegmento.BGM.name())) {
                nombreDocumento = getTokenString(BermanKeyword.Calificador, line, i);
                fechaSolicitud = getTokenDate(BermanKeyword.BGM_FechaSolicitud, line, i, "yyMMddHHmm");
                bermanMensaje = EscalaMensaje.valueOf(getTokenInteger(BermanKeyword.BGM_FuncionMensaje, line, i));

                if (fechaSolicitud != null) {
                    // FIXME Revisar
                    final Calendar calendar = Calendar.getInstance();

                    calendar.setTime(fechaSolicitud);

                    escalaVO.setAnno(String.valueOf(calendar.get(Calendar.YEAR)));
                    escalaVO.setFref(fechaSolicitud);
                }

                if (LOG.isInfoEnabled()) {
                    LOG.info("nombreDocumento: " + nombreDocumento);
                    LOG.info("fechaSolicitud: " + fechaSolicitud);
                    LOG.info("bermanMensaje: " + bermanMensaje);
                }

                return;
            }
        }

        addError(MensajeCodigo.G_008, BermanSegmento.UNB.name());
    }

    /**
     * Gets the primera linea berman.
     *
     * @param lines
     *            the lines
     * @return the primera linea berman
     */
    private int getPrimeraLineaBerman(final List<String> lines) {
        // Busqueda de la primera linea del BERMAN
        int primeraLinea = 0;

        do {
            final String line = lines.get(primeraLinea);

            if (line.startsWith(BermanSegmento.FTX.name()) || line.startsWith(BermanSegmento.RFF.name())) {
                return primeraLinea;
            }

            primeraLinea++;
        } while (primeraLinea < lines.size());

        addError(MensajeCodigo.G_008, BermanSegmento.FTX.name() + ", " + BermanSegmento.RFF.name());

        return primeraLinea;
    }

    /**
     * Validar segmentos berman.
     *
     * @param lines
     *            the lines
     * @param primeraLinea
     *            the primera linea
     */
    private void validarSegmentosBerman(final List<String> lines, final int primeraLinea) {
        // Validacion de Segmentos
        for (int i = primeraLinea; i < lines.size(); i++) {
            final BermanSegmento segmento = getTokenSegmento(BermanKeyword.Segmento, lines.get(i), i);

            if (!BermanSegmento.segmentoValido(segmento, bermanMensaje)) {
                addError(MensajeCodigo.G_006,
                        "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:" + segmento.name());
            }
        }

        for (int i = primeraLinea + 1; i < lines.size(); i++) {
            final BermanSegmento segmento = getTokenSegmento(BermanKeyword.Segmento, lines.get(i - 1), i - 1);
            final BermanSegmento segmentoSiguiente = getTokenSegmento(BermanKeyword.Segmento, lines.get(i), i);

            String tipoTSR = null;

            if (BermanSegmento.TSR == segmento) {
                tipoTSR = getTokenString(BermanKeyword.TSR_Tipo, lines.get(i - 1), i - 1);
            }

            if (!BermanSegmento.segmentoValido(bermanMensaje, segmento, segmentoSiguiente, tipoTSR)) {
                addError(MensajeCodigo.G_006, "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:"
                        + segmento.name() + ", segmentoSiguiente:" + segmentoSiguiente.name());
            }
        }
    }

    /**
     * Busqueda maestros berman.
     *
     * @param lines
     *            the lines
     * @param primeraLinea
     *            the primera linea
     */
    private void busquedaCodigosMaestrosBerman(final List<String> lines, final int primeraLinea) {
        // Lectura de Codigos de Maestros
        for (int i = primeraLinea; i < lines.size(); i++) {
            final String line = lines.get(i);
            final BermanSegmento segmento = getTokenSegmento(BermanKeyword.Segmento, line, i);

            BermanConstante calificador = null;

            switch (segmento) {
            case NAD:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.CV) {
                    addNif(getTokenString(BermanKeyword.NAD_NifConsignatario, line, i));
                }

                break;
            case TDT:
                addCodigoMaestro(Entidad.TIPO_BUQUE_EDI, getTokenString(BermanKeyword.TDT_TipoBuque, line, i));
                addCodigoMaestro(Entidad.PAIS, getTokenString(BermanKeyword.TDT_Bandera, line, i));
                addCodigoMaestro(Entidad.BUQUE, getTokenString(BermanKeyword.TDT_IMO_Nombre_Buque, line, i));

                break;
            case RF1:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.ZCS) {
                    addCodigoMaestro(Entidad.SERVICIO_TRAFICO,
                            getTokenString(BermanKeyword.RF1_NumeroReferencia, line, i));
                }

                break;
            case LOC:
                addCodigoMaestro(Entidad.PAIS, getTokenString(BermanKeyword.LOC_Pais, line, i));
                addCodigoMaestro(Entidad.UNLOCODE, getTokenString(BermanKeyword.LOC_Unlocode, line, i));

                break;
            case LO1:
                final Integer calificadorLo1 = getTokenInteger(BermanKeyword.Calificador, line, i);

                if (calificadorLo1 == 60) {
                    addCodigoMaestro(Entidad.ALINEACION,
                            getTokenString(BermanKeyword.LO1_AlineacionSolicitada, line, i));
                }

                break;
            case POC:
                addCodigoMaestro(Entidad.TIPO_ACTIVIDAD_EDI,
                        getTokenString(BermanKeyword.POC_TipoActividadEdi, line, i));

                break;
            case HAN:
                addCodigoMaestro(Entidad.TIPO_OPERACION_MERCANCIA,
                        getTokenString(BermanKeyword.HAN_CodTipoOperacion, line, i));

                break;
            case NA2:
                addNif(getTokenString(BermanKeyword.NA2_NifEstibador, line, i));

                break;
            case GDS:
                addCodigoMaestro(Entidad.TIPO_MERCANCIA, getTokenString(BermanKeyword.GDS_TipoMercancia, line, i));

                break;
            case RFF:
                addCodigoMaestro(Entidad.SUBPUERTO, getTokenString(BermanKeyword.RFF_SubpuertoEscala, line, i));

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
    private void lecturaEscalaBerman(final List<String> lines, final int primeraLinea) {
        // Carga de la Escala
        SubservicioVO atraqueVO = new SubservicioVO();
        SubservicioVO operacionVO = new SubservicioVO();

        Long numeroAtraqueEDI = null;
        BermanConstante calificadorME2 = null;

        for (int i = primeraLinea; i < lines.size(); i++) {
            final String line = lines.get(i);
            final BermanSegmento segmento = getTokenSegmento(BermanKeyword.Segmento, line, i);
            BermanConstante calificador = null;

            switch (segmento) {
            case FTX:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.AAI) {
                    escalaVO.getItdtMap().get(TipoDato.CADENA_08.getId())
                            .setCadena(getTokenString(BermanKeyword.FTX_ObservacionesDUE, line, i));
                }
                if (calificador == BermanConstante.ACB) {
                    final BermanConstante campo = getTokenConstante(BermanKeyword.FTX_Campo, line, i);

                    // FIXME Acabar
                    switch (campo) {
                    case ZIE:
                        buqueVO.getItdtMap().get(TipoDato.BOOLEANO_07.getId()).setCantidadEntera(1L);
                        break;
                    case ZIN:
                        buqueVO.getItdtMap().get(TipoDato.BOOLEANO_07.getId()).setCantidadEntera(0L);
                        break;
                    case ZFU:
                        escalaVO.getItdtMap().get(TipoDato.BOOLEANO_09.getId()).setCantidadEntera(1L);
                        break;
                    case ZNF:
                        escalaVO.getItdtMap().get(TipoDato.BOOLEANO_09.getId()).setCantidadEntera(0L);
                        break;

                    default:
                        break;
                    }
                }

                break;
            case QTY:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                final Long cantidad = getTokenLong(BermanKeyword.QTY_Cantidad, line, i);

                switch (calificador) {
                case ZTE:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).setCantidadEntera(cantidad);
                    break;
                case ZTS:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_03.getId()).setCantidadEntera(cantidad);
                    break;
                case ZPE:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_04.getId()).setCantidadEntera(cantidad);
                    break;
                case ZPS:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_05.getId()).setCantidadEntera(cantidad);
                    break;
                case ZWE:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_06.getId()).setCantidadEntera(cantidad);
                    break;
                case ZWS:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_07.getId()).setCantidadEntera(cantidad);
                    break;
                case ZDP:
                    buqueVO.getItdtMap().get(TipoDato.ENTERO_15.getId()).setCantidadEntera(cantidad);
                    break;

                default:
                    addError(MensajeCodigo.G_009, "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:"
                            + segmento.name() + ", calificador:" + calificador.name());
                }

                break;
            case NAD:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                switch (calificador) {
                case OV:
                    buqueVO.getItdtMap().get(TipoDato.CADENA_08.getId())
                            .setCadena(getTokenString(BermanKeyword.NAD_CodNaviera, line, i));

                    break;
                case CV:
                    escalaVO.getItdtMap().get(TipoDato.ORGA_3.getId())
                            .setPrmt(getTokenOrganizacion(BermanKeyword.NAD_NifConsignatario, line, i));

                    break;

                default:
                    break;
                }

                // FIXME Falta el codigo de naviera

                break;
            case TDT:
                final ParametroVO tipoBuqueEdiVO = getTokenMaestro(BermanKeyword.TDT_TipoBuque, line, i,
                        Entidad.TIPO_BUQUE_EDI);

                if (tipoBuqueEdiVO != null) {
                    escalaVO.getItdtMap().get(TipoDato.TIPO_BUQUE.getId())
                            .setPrmt(tipoBuqueEdiVO.getItdtMap().get(TipoDato.TIPO_BUQUE.getId()).getPrmt());
                    escalaVO.getItdtMap().get(TipoDato.TIPO_BUQUE_2.getId())
                            .setPrmt(tipoBuqueEdiVO.getItdtMap().get(TipoDato.TIPO_BUQUE.getId()).getPrmt());
                }

                escalaVO.getItdtMap().get(TipoDato.CADENA_04.getId())
                        .setCadena(getTokenString(BermanKeyword.TDT_Capitan, line, i));
                escalaVO.getItdtMap().get(TipoDato.CADENA_05.getId())
                        .setCadena(getTokenString(BermanKeyword.TDT_Capitan, line, i));

                escalaVO.getItdtMap().get(TipoDato.BUQUE.getId())
                        .setPrmt(getTokenMaestro(BermanKeyword.TDT_IMO_Nombre_Buque, line, i, Entidad.BUQUE));

                buqueVO.setParametro(getTokenString(BermanKeyword.TDT_IMO_Nombre_Buque, line, i));
                // FIXME Ver si es correcto lo del nombre del buque
                buqueVO.getItdtMap().get(TipoDato.PAIS.getId())
                        .setPrmt(getTokenMaestro(BermanKeyword.TDT_Bandera, line, i, Entidad.PAIS));

                break;
            case RF1:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                switch (calificador) {
                case VM:
                    buqueVO.getItdtMap().get(TipoDato.CADENA_02.getId())
                            .setCadena(getTokenString(BermanKeyword.RF1_NumeroReferencia, line, i));

                    break;
                case ZIO:
                    buqueVO.getItdtMap().get(TipoDato.CADENA_06.getId())
                            .setCadena(getTokenString(BermanKeyword.RF1_NumeroReferencia, line, i));

                    break;
                case ZIC:
                    buqueVO.getItdtMap().get(TipoDato.CADENA_05.getId())
                            .setCadena(getTokenString(BermanKeyword.RF1_NumeroReferencia, line, i));

                    break;
                case ZSC:
                    buqueVO.getItdtMap().get(TipoDato.CADENA_04.getId())
                            .setCadena(getTokenString(BermanKeyword.RF1_NumeroReferencia, line, i));

                    break;
                case ZCS:
                    escalaVO.getItdtMap().get(TipoDato.SERV_TRAF.getId()).setPrmt(
                            getTokenMaestro(BermanKeyword.RF1_NumeroReferencia, line, i, Entidad.SERVICIO_TRAFICO));

                    break;
                case ZNG:
                    // FIXME Certificado Buque

                    break;
                case ZSB:
                    buqueVO.getItdtMap().get(TipoDato.ENTERO_11.getId())
                            .setCantidadEntera(getTokenLong(BermanKeyword.RF1_NumeroReferencia, line, i));

                    break;
                case ZAE:
                    buqueVO.getItdtMap().get(TipoDato.BOOLEANO_07.getId()).setCantidadEntera(1L);

                    break;
                case ZAN:
                    buqueVO.getItdtMap().get(TipoDato.BOOLEANO_07.getId()).setCantidadEntera(0L);

                    break;
                case ZME:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_14.getId()).setCantidadEntera(1L);

                    break;
                case ZNM:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_14.getId()).setCantidadEntera(0L);

                    break;
                default:
                    break;
                }

                break;
            case DTM:
                final Integer calificadorDTM = getTokenInteger(BermanKeyword.Calificador, line, i);

                switch (calificadorDTM) {
                case 132:
                    escalaVO.setFini(getTokenDate(BermanKeyword.DTM_FechaHora, line, i, "ddMMyyyyHHmm"));

                    break;
                case 133:
                    escalaVO.setFfin(getTokenDate(BermanKeyword.DTM_FechaHora, line, i, "ddMMyyyyHHmm"));

                    break;
                case 36:
                    // FIXME Fecha Certificado Buque

                    break;
                default:
                    break;
                }

                break;
            case MEA:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                switch (calificador) {
                case ZMD:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_02.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case WM:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_04.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case LM:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_03.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case HM:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_05.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case AAM:
                    buqueVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                            .setCantidadEntera(getTokenLong(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case ZDW:
                    buqueVO.getItdtMap().get(TipoDato.ENTERO_04.getId())
                            .setCantidadEntera(getTokenLong(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case HT:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_06.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case ZMP:
                    buqueVO.getItdtMap().get(TipoDato.ENTERO_06.getId())
                            .setCantidadEntera(getTokenLong(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case ZVC:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_07.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case ZVM:
                    buqueVO.getItdtMap().get(TipoDato.DECIMAL_08.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                case ZTL:
                    buqueVO.getItdtMap().get(TipoDato.ENTERO_05.getId())
                            .setCantidadEntera(getTokenLong(BermanKeyword.MEA_ValorMedida, line, i));
                    buqueVO.getItdtMap().get(TipoDato.UNID_MED_SBT.getId())
                            .setCadena(getTokenCR(BermanKeyword.MEA_UnidadMedida, line, i, TipoDato.UNID_MED_SBT));

                    break;
                case ZHE:
                    final ItemDatoVO prdtHelicesVO = buqueVO.getItdtMap().get(TipoDato.ENTERO_10.getId());
                    final Long helices = getTokenLong(BermanKeyword.MEA_ValorMedida, line, i);

                    if (prdtHelicesVO.getCantidadEntera() == null) {
                        prdtHelicesVO.setCantidadEntera(0L);
                    }

                    prdtHelicesVO.setCantidadEntera(prdtHelicesVO.getCantidadEntera() + helices);

                    buqueVO.getItdtMap().put(TipoDato.ENTERO_10.getId(), prdtHelicesVO);

                    break;
                case ZVL:
                    escalaVO.getItdtMap().get(TipoDato.ENTERO_10.getId())
                            .setCantidadEntera(getTokenLong(BermanKeyword.MEA_ValorMedida, line, i));

                    break;
                default:
                    break;
                }

                break;
            case FT1:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                switch (calificador) {
                case ZCD:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_03.getId()).setCantidadEntera(1L);

                    break;
                case ZDD:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_05.getId()).setCantidadEntera(1L);

                    break;
                case ZBD:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_04.getId()).setCantidadEntera(1L);

                    break;
                case ZNM:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_02.getId()).setCantidadEntera(1L);

                    break;
                case ZAC:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_08.getId()).setCantidadEntera(1L);

                    break;
                case Z2C:
                    buqueVO.getItdtMap().get(TipoDato.BOOLEANO_02.getId()).setCantidadEntera(1L);

                    break;
                case ZOB:
                    buqueVO.getItdtMap().get(TipoDato.CADENA_03.getId())
                            .setCadena(getTokenString(BermanKeyword.FT1_ObservacionesBuque, line, i));

                    break;
                case ZCL:
                    escalaVO.getItdtMap().get(TipoDato.COND_TANQUE_CARGA.getId()).setCadena(BermanConstante.L.name());

                    break;
                case ZCV:
                    escalaVO.getItdtMap().get(TipoDato.COND_TANQUE_CARGA.getId()).setCadena(BermanConstante.V.name());

                    break;
                case ZCI:
                    escalaVO.getItdtMap().get(TipoDato.COND_TANQUE_CARGA.getId()).setCadena(BermanConstante.I.name());

                    break;
                case ZLL:
                    escalaVO.getItdtMap().get(TipoDato.COND_TANQUE_LASTRE.getId()).setCadena(BermanConstante.L.name());

                    break;
                case ZLV:
                    escalaVO.getItdtMap().get(TipoDato.COND_TANQUE_LASTRE.getId()).setCadena(BermanConstante.V.name());

                    break;
                case ZLI:
                    escalaVO.getItdtMap().get(TipoDato.COND_TANQUE_LASTRE.getId()).setCadena(BermanConstante.I.name());

                    break;
                case ZOI:
                    escalaVO.getItdtMap().get(TipoDato.BOOLEANO_15.getId()).setCantidadEntera(1L);
                    escalaVO.getItdtMap().get(TipoDato.CADENA_12.getId())
                            .setCadena(getTokenString(BermanKeyword.FT1_TareasObligatorias, line, i));

                    break;
                default:
                    break;
                }

                break;
            case LOC:
                final Integer calificadorLOC = getTokenInteger(BermanKeyword.Calificador, line, i);

                switch (calificadorLOC) {
                case 92:
                    escalaVO.getItdtMap().get(TipoDato.UNLOCODE_2.getId())
                            .setPrmt(getTokenMaestro(BermanKeyword.LOC_Unlocode, line, i, Entidad.UNLOCODE));

                    break;
                case 61:
                    escalaVO.getItdtMap().get(TipoDato.UNLOCODE.getId())
                            .setPrmt(getTokenMaestro(BermanKeyword.LOC_Unlocode, line, i, Entidad.UNLOCODE));

                    break;
                case 229:
                    buqueVO.getItdtMap().get(TipoDato.UNLOCODE.getId())
                            .setPrmt(getTokenMaestro(BermanKeyword.LOC_Unlocode, line, i, Entidad.UNLOCODE));

                    break;
                case 153:
                    final String unlocode = getTokenString(BermanKeyword.LOC_Unlocode, line, i);

                    if (unlocode != null) {
                        escalaVO.setPrto(getPrtoUnlo(unlocode, line, i));
                    }

                    break;
                default:
                    break;
                }

                break;
            case DT1:
                final Integer calificadorDT1 = getTokenInteger(BermanKeyword.Calificador, line, i);

                switch (calificadorDT1) {
                case 183:
                    buqueVO.getItdtMap().get(TipoDato.FECHA_03.getId())
                            .setFecha(getTokenDate(BermanKeyword.DT1_Fecha, line, i, "yyyyMMdd"));

                    break;
                case 379:
                    buqueVO.getItdtMap().get(TipoDato.FECHA_05.getId())
                            .setFecha(getTokenDate(BermanKeyword.DT1_Fecha, line, i, "yyyyMMdd"));

                    break;
                default:
                    break;
                }

                break;
            case DOC:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.ZCA) {
                    buqueVO.getItdtMap().get(TipoDato.CADENA_09.getId())
                            .setCadena(getTokenString(BermanKeyword.DOC_Numero, line, i));
                }

                break;
            case TSR:
                numeroAtraqueEDI = getTokenLong(BermanKeyword.TSR_NumeroAtraqueEdi, line, i);
                atraqueVO = new SubservicioVO();

                atraqueList.add(atraqueVO);
                operacionesMap.put(numeroAtraqueEDI, new ArrayList<SubservicioVO>());

                atraqueVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).setCantidadEntera(numeroAtraqueEDI);

                final ParametroVO atetAtraqueVO = getTokenMaestro(BermanKeyword.TSR_TipoAtraqueEdiSolicitado, line, i,
                        Entidad.TIPO_ATRAQUE_EDI);

                if (atetAtraqueVO != null) {
                    atraqueVO.getItdtMap().get(TipoDato.TIPO_ATR_EDI.getId()).setPrmt(atetAtraqueVO);
                    atraqueVO.getItdtMap().get(TipoDato.TIPO_ATR.getId())
                            .setPrmt(atetAtraqueVO.getItdtMap().get(TipoDato.TIPO_ATR.getId()).getPrmt());
                }

                atraqueVO.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()).setCadena(BermanConstante.C.name());
                atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_03.getId()).setCantidadEntera(0L);
                atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_04.getId()).setCantidadEntera(0L);
                atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_05.getId()).setCantidadEntera(0L);
                atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_06.getId()).setCantidadEntera(0L);
                atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_07.getId()).setCantidadEntera(0L);
                atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_08.getId()).setCantidadEntera(0L);

                atraqueVO.getItdtMap().get(TipoDato.DECIMAL_06.getId()).setCantidadDecimal(0.0);
                atraqueVO.getItdtMap().get(TipoDato.DECIMAL_03.getId())
                        .setCantidadDecimal(buqueVO.getItdtMap().get(TipoDato.DECIMAL_02.getId()).getCantidadDecimal());
                atraqueVO.getItdtMap().get(TipoDato.DECIMAL_04.getId())
                        .setCantidadDecimal(buqueVO.getItdtMap().get(TipoDato.DECIMAL_02.getId()).getCantidadDecimal());
                atraqueVO.getItdtMap().get(TipoDato.DECIMAL_05.getId()).setCantidadDecimal(0.0);
                atraqueVO.getItdtMap().get(TipoDato.COD_EXEN.getId()).setCadena("0");

                // FIXME Cliente

                break;
            case LO1:
                final Integer calificadorLO1 = getTokenInteger(BermanKeyword.Calificador, line, i);

                if (calificadorLO1 == 60) {
                    atraqueVO.getItdtMap().get(TipoDato.ALIN.getId()).setPrmt(
                            getTokenMaestro(BermanKeyword.LO1_AlineacionSolicitada, line, i, Entidad.ALINEACION));

                    final String norays = getTokenString(BermanKeyword.LO1_NorayInicialFinal, line, i);

                    if (norays.indexOf('-') > 0) {
                        final Double norayInicial = Double.valueOf(norays.substring(0, norays.indexOf('-')));
                        final Double norayFinal = Double.valueOf(norays.substring(norays.indexOf('-') + 1));

                        atraqueVO.getItdtMap().get(TipoDato.DECIMAL_01.getId()).setCantidadDecimal(norayInicial);
                        atraqueVO.getItdtMap().get(TipoDato.DECIMAL_02.getId()).setCantidadDecimal(norayFinal);
                    }
                }

                break;
            case ME1:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.ZAD) {
                    atraqueVO.getItdtMap().get(TipoDato.DECIMAL_03.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.ME1_ValorMedida, line, i));
                } else {
                    atraqueVO.getItdtMap().get(TipoDato.DECIMAL_04.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.ME1_ValorMedida, line, i));
                }

                break;
            case DT2:
                final Integer calificadorDT2 = getTokenInteger(BermanKeyword.Calificador, line, i);
                final Date fecha = getTokenDate(BermanKeyword.DT2_Fecha, line, i, "yyMMddHHmm");

                switch (calificadorDT2) {
                case 178:
                    atraqueVO.setFini(fecha);

                    break;
                case 189:
                    atraqueVO.setFfin(fecha);

                    break;
                case 291:
                    // FIXME Fecha inicio operaciones

                    break;
                case 292:
                    // FIXME Fecha fin operaciones

                    break;
                default:
                    break;
                }

                break;
            case POC:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                atraqueVO.getItdtMap().get(TipoDato.TIPO_ACTIVIDAD_EDI.getId())
                        .setPrmt(getTokenMaestro(BermanKeyword.Calificador, line, i, Entidad.TIPO_ACTIVIDAD_EDI));

                switch (calificador) {
                case ZSA:
                    atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_07.getId()).setCantidadEntera(1L);

                    break;
                case ZSH:
                    atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_06.getId()).setCantidadEntera(1L);

                    break;
                case ZSE:
                    atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_03.getId()).setCantidadEntera(1L);

                    break;
                case ZSC:
                    atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_05.getId()).setCantidadEntera(1L);

                    break;
                default:
                    break;
                }

                break;
            case FT2:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.ACB) {
                    final BermanConstante calificadorACB = getTokenConstante(BermanKeyword.FT2_TextoCodificado, line,
                            i);

                    if (calificadorACB == BermanConstante.ZEP) {
                        atraqueVO.getItdtMap().get(TipoDato.BOOLEANO_08.getId()).setCantidadEntera(1L);
                    } else if (calificadorACB == BermanConstante.ZEL) {
                        atraqueVO.getItdtMap().get(TipoDato.TIPO_ESTAN_ATR.getId()).setCadena(BermanConstante.L.name());
                    }
                } else if (calificador == BermanConstante.AAI) {
                    atraqueVO.getItdtMap().get(TipoDato.CADENA_02.getId())
                            .setCadena(getTokenString(BermanKeyword.FT2_ObservacionesAtraque, line, i));
                }

                break;
            case HAN:
                operacionVO = new SubservicioVO();
                operacionesMap.get(numeroAtraqueEDI).add(operacionVO);

                operacionVO.getItdtMap().get(TipoDato.TIPO_OP_MERC.getId()).setPrmt(
                        getTokenMaestro(BermanKeyword.HAN_CodTipoOperacion, line, i, Entidad.TIPO_OPERACION_MERCANCIA));

                break;
            case NA2:
                operacionVO.getItdtMap().get(TipoDato.ORGA.getId())
                        .setPrmt(getTokenOrganizacion(BermanKeyword.NA2_NifEstibador, line, i));
                operacionVO.getItdtMap().get(TipoDato.CADENA_03.getId())
                        .setCadena(getTokenString(BermanKeyword.NA2_NombreEstibador, line, i));

                break;
            case GDS:
                operacionVO.getItdtMap().get(TipoDato.TIPO_MERC.getId())
                        .setPrmt(getTokenMaestro(BermanKeyword.GDS_TipoMercancia, line, i, Entidad.TIPO_MERCANCIA));

                break;
            case FT3:
                calificador = getTokenConstante(BermanKeyword.Calificador, line, i);

                if (calificador == BermanConstante.ACB) {
                    operacionVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                            .setCadena(getTokenString(BermanKeyword.FT3_LugarOperacion, line, i));
                    operacionVO.getItdtMap().get(TipoDato.CADENA_02.getId())
                            .setCadena(getTokenString(BermanKeyword.FT3_DetalleMercancia, line, i));
                }

                break;
            case ME2:
                calificadorME2 = getTokenConstante(BermanKeyword.Calificador, line, i);

                final String dimensionMedida = getTokenString(BermanKeyword.ME2_DimensionMedida, line, i);
                final Double valorMedida = getTokenDouble(BermanKeyword.ME2_ValorMedida, line, i);

                if (BermanConstante.U.name().equals(dimensionMedida)) {
                    operacionVO.getItdtMap().get(TipoDato.DECIMAL_01.getId()).setCantidadDecimal(valorMedida);
                } else {
                    operacionVO.getItdtMap().get(TipoDato.DECIMAL_02.getId()).setCantidadDecimal(valorMedida);
                }

                operacionVO.getItdtMap().get(TipoDato.UNID_MED_BERMAN.getId())
                        .setCadena(getTokenCR(BermanKeyword.ME2_UnidadMedida, line, i, TipoDato.UNID_MED_BERMAN));

                break;
            case EQN:
                // Toma el valor del calificador del segmento ME2

                if (BermanConstante.CT.equals(calificadorME2) || BermanConstante.AAV.equals(calificadorME2)) {
                    operacionVO.getItdtMap().get(TipoDato.DECIMAL_02.getId())
                            .setCantidadDecimal(getTokenDouble(BermanKeyword.EQN_NumeroUnidades, line, i));
                }

                break;
            case RFF:
                final String codigoPuerto = getTokenString(BermanKeyword.RFF_SubpuertoEscala, line, i);

                escalaVO.setPrto(getPrtoCodigoCorto(codigoPuerto, line, i));
                escalaVO.setAnno(getTokenString(BermanKeyword.RFF_AnioEscala, line, i));
                escalaVO.setNumero(getTokenString(BermanKeyword.RFF_NumeroEscala, line, i));

                break;
            default:
                break;
            }
        }
    }

    /**
     * Gets the subpuerto escala.
     *
     * @param unlocode
     *            the unlocode
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the subpuerto escala
     */
    private PuertoVO getPrtoUnlo(final String unlocode, final String line, final int lineNumber) {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setUnlocode(unlocode);

        try {
            return prtoBO.selectObject(prtoCriterio);
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_001,
                    "linea:" + lineNumber + ", entidad:" + Entidad.SUBPUERTO.name() + ", unlocode:" + unlocode);
        }

        return null;
    }

    /**
     * Gets the prto codigo corto.
     *
     * @param codigoCorto
     *            the codigo corto
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the prto codigo corto
     */
    private PuertoVO getPrtoCodigoCorto(final String codigoCorto, final String line, final int lineNumber) {
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoCriterio.setCodigoCorto(codigoCorto);

        try {
            return prtoBO.selectObject(prtoCriterio);
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_001,
                    "linea:" + lineNumber + ", entidad:" + Entidad.SUBPUERTO.name() + ", codigo:" + codigoCorto);
        }

        return null;
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
    private String getTokenString(final BermanKeyword keyword, final String line, final int lineNumber) {
        if (line.length() >= keyword.getOffset() + keyword.getLength()) {
            final String token = line.substring(keyword.getOffset(), keyword.getOffset() + keyword.getLength()).trim();

            if ((token == null || token.isEmpty()) && keyword.isRequired()) {
                addError(MensajeCodigo.G_005, "linea:" + lineNumber + ", campo:" + keyword.name());
            }

            return token;
        }

        return null;
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
    private ParametroVO getTokenMaestro(final BermanKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            addError(MensajeCodigo.G_001, "linea:" + lineNumber + ", entidad:" + entidad.name() + ", codigo:" + codigo);
        }

        return maestroMap.get(entidad).get(codigo);
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
    private ParametroVO getTokenOrganizacion(final BermanKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!organizacionesMap.containsKey(codigo)) {
            addError(MensajeCodigo.G_001,
                    "linea:" + lineNumber + ", entidad:" + Entidad.ORGANIZACION.name() + ", codigo:" + codigo);
        }

        return organizacionesMap.get(codigo);
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
    private String getTokenCR(final BermanKeyword keyword, final String line, final int lineNumber,
            final TipoDato tipoDato) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        final TipoDatoVO tpdtVO = TipoDatoProxy.select(tipoDato.getId());

        if (!tpdtVO.getCdrfCodeSet().contains(codigo)) {
            addError(MensajeCodigo.G_004, "linea:" + lineNumber + ", CR:" + tipoDato.name() + ", codigo:" + codigo);
        }

        return codigo;
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
    private BermanSegmento getTokenSegmento(final BermanKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        return BermanSegmento.valueOf(codigo);
    }

    /**
     * Gets the token constante.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the token constante
     */
    private BermanConstante getTokenConstante(final BermanKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        return BermanConstante.valueOf(codigo);
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
    private Long getTokenLong(final BermanKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Long.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            addError(MensajeCodigo.G_003, "linea:" + lineNumber + ", valor:" + codigo);

            return null;
        }
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
    private Integer getTokenInteger(final BermanKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Integer.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            addError(MensajeCodigo.G_003, "linea:" + lineNumber + ", valor:" + codigo);

            return null;
        }
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
    private Double getTokenDouble(final BermanKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Double.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            addError(MensajeCodigo.G_003, "linea:" + lineNumber + ", valor:" + codigo);

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
    private Date getTokenDate(final BermanKeyword keyword, final String line, final int lineNumber,
            final String dateFormat) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return new SimpleDateFormat(dateFormat).parse(codigo);
        } catch (final ParseException ex) {
            addError(MensajeCodigo.G_002, "linea:" + lineNumber + ", valor:" + codigo + ", formato:" + dateFormat);

            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.ESC_CARGA;
    }

}
