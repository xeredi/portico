package xeredi.integra.proceso.servicio.manifiesto;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.io.IOUtils;

import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.proxy.TipoSubservicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.ConfigurationUtil;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaManifiesto.
 */
public final class ProcesoCargaManifiesto extends ProcesoTemplate {
    /** The Constant PATH_ENTRADA_PARAM. */
    private static final String PATH_ENTRADA_PARAM = "manifiesto.files.entrada.home";

    /** The Constant PATH_PROCESADO_PARAM. */
    private static final String PATH_PROCESADO_PARAM = "manifiesto.files.procesado.home";

    /** The Constant PATH_ERRONEO_PARAM. */
    private static final String PATH_ERRONEO_PARAM = "manifiesto.files.erroneo.home";

    /** The path entrada. */
    private static String PATH_ENTRADA;

    /** The path procesado. */
    private static String PATH_PROCESADO;

    /** The path erroneo. */
    private static String PATH_ERRONEO;

    /** The mensaje. */
    private ManifiestoMensaje mensaje;

    /** The tipo operacion. */
    private String tipoOperacion;

    /** The numero edi. */
    private String numeroEDI;

    /** The manifiesto vo. */
    private final ServicioVO manifiestoVO = ServicioVO
            .newInstance(TipoServicioProxy.select(Entidad.MANIFIESTO.getId()));

    /** The ssrv list. */
    private final List<SubservicioVO> ssrvList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutar() {
        final Configuration configuration = ConfigurationUtil.getConfiguration();

        PATH_ENTRADA = configuration.getString(PATH_ENTRADA_PARAM);
        PATH_PROCESADO = configuration.getString(PATH_PROCESADO_PARAM);
        PATH_ERRONEO = configuration.getString(PATH_ERRONEO_PARAM);

        for (final ProcesoArchivoVO prarVO : prbtVO.getPrarEntradaList()) {
            final String pathArchivo = PATH_ENTRADA + "/" + prarVO.getNombre();

            LOG.info("Importar: " + pathArchivo);

            try (final Reader reader = new FileReader(pathArchivo)) {
                final List<String> lines = IOUtils.readLines(reader);
                final int primeraLinea = getPrimeraLinea(lines);

                if (prbtVO.getPrmnList().isEmpty()) {
                    validarSegmentos(lines, primeraLinea);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    busquedaCodigosMaestros(lines, primeraLinea);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    // FIXME Obtener la fecha de vigencia
                    final Date fechaVigencia = Calendar.getInstance().getTime();

                    buscarMaestros(fechaVigencia);
                    buscarOrganizaciones(fechaVigencia);
                }
                if (prbtVO.getPrmnList().isEmpty()) {
                    lecturaManifiesto(lines, primeraLinea);
                }
            } catch (final IOException ex) {
                LOG.error(ex, ex);

                addError(MensajeCodigo.G_010, "archivo:" + pathArchivo + ", error:" + ex.getMessage());
            }
        }
    }

    /**
     * Validar segmentos.
     *
     * @param lines
     *            the lines
     * @param primeraLinea
     *            the primera linea
     */
    private void validarSegmentos(final List<String> lines, final int primeraLinea) {
        // Validacion de Segmentos
        for (int i = primeraLinea; i < lines.size(); i++) {
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, lines.get(i), i);

            if (!ManifiestoSegmento.segmentoValido(segmento, mensaje)) {
                addError(MensajeCodigo.G_006,
                        "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:" + segmento.name());
            }
        }

        for (int i = primeraLinea + 1; i < lines.size(); i++) {
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, lines.get(i - 1), i - 1);
            final ManifiestoSegmento segmentoSiguiente = getTokenSegmento(ManifiestoKeyword.Segmento, lines.get(i), i);

            if (!ManifiestoSegmento.segmentoValido(segmento, segmentoSiguiente)) {
                addError(MensajeCodigo.G_006,
                        "linea:" + i + ", mensaje:" + mensaje.name() + ", segmento:" + segmento.name()
                        + ", segmentoSiguiente:" + segmentoSiguiente.name());
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
    private void busquedaCodigosMaestros(final List<String> lines, final int primeraLinea) {
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
    private void lecturaManifiesto(final List<String> lines, final int primeraLinea) {
        // Generacion de datos del manifiesto
        SubservicioVO blActualVO = null;
        SubservicioVO partidaActualVO = null;
        SubservicioVO partidaImActualVO = null;
        SubservicioVO partidaDocumentoActualVO = null;
        SubservicioVO partidaMmppActualVO = null;
        SubservicioVO partidaEquipamientoActualVO = null;
        SubservicioVO equipamientoActualVO = null;
        SubservicioVO manifiestoConsignatarioActualVO = null;
        SubservicioVO precintoEquipamientoActualVO = null;

        ParametroVO estibadorVO = null;

        Integer anioEscala = null;
        Integer numeroEscala = null;

        for (int i = primeraLinea; i < lines.size(); i++) {
            final String line = lines.get(i);
            final ManifiestoSegmento segmento = getTokenSegmento(ManifiestoKeyword.Segmento, line, i);

            switch (segmento) {
            case IFC:
                anioEscala = getTokenInteger(ManifiestoKeyword.IFC_AnioEscala, line, i);
                numeroEscala = getTokenInteger(ManifiestoKeyword.IFC_NumeroEscala, line, i);

                manifiestoVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.IFC_NumeroEDI, line, i));
                manifiestoVO
                .getItdtMap()
                .get(TipoDato.REC_ADU.getId())
                .setPrmt(
                        getTokenMaestro(ManifiestoKeyword.IFC_CodigoRecintoAduanero, line, i,
                                Entidad.RECINTO_ADUANERO));

                final String tipoManifiestoEDI = getTokenString(ManifiestoKeyword.IFC_TipoManifiesto, line, i);
                final String tipoManifiesto = getTipoManifiesto(tipoManifiestoEDI);

                manifiestoVO.getItdtMap().get(TipoDato.TIPO_MANIF.getId()).setCadena(tipoManifiesto);
                manifiestoVO.getItdtMap().get(TipoDato.TIPO_OPER_MANIF.getId()).setCadena(tipoOperacion);

                final String califPais = getTokenString(ManifiestoKeyword.IFC_TipoLugarEmbarque, line, i);

                if ("9".equals(califPais)) {
                    manifiestoVO.getItdtMap().get(TipoDato.PAIS.getId())
                    .setPrmt(getTokenMaestro(ManifiestoKeyword.IFC_CodigoPaisENS, line, i, Entidad.PAIS));
                }

                manifiestoVO
                .getItdtMap()
                .get(TipoDato.BOOLEANO_03.getId())
                .setCantidadEntera(
                        "SI".equals(getTokenString(ManifiestoKeyword.IFC_RegimenSimplificado, line, i)) ? 1L
                                : 0L);

                manifiestoVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                .setCantidadEntera(getTokenLong(ManifiestoKeyword.IFC_NumeroTramos, line, i));

                final String califConsignatarioBuque = getTokenString(ManifiestoKeyword.IFC_TipoConsignatarioBuque,
                        line, i);

                if ("CV".equals(califConsignatarioBuque)) {
                    manifiestoVO.getItdtMap().get(TipoDato.ORGA_2.getId())
                    .setPrmt(getTokenOrganizacion(ManifiestoKeyword.IFC_NIFConsignatarioBuque, line, i));
                }

                final String califConsignatarioMercancia = getTokenString(
                        ManifiestoKeyword.IFC_TipoConsignatarioMercancia, line, i);

                if ("CN".equals(califConsignatarioMercancia)) {
                }

                final String califEstibador = getTokenString(ManifiestoKeyword.IFC_TipoEstibador, line, i);

                if ("TR".equals(califEstibador)) {
                    manifiestoVO.getItdtMap().get(TipoDato.ORGA.getId())
                    .setPrmt(getTokenOrganizacion(ManifiestoKeyword.IFC_NIFEstibador, line, i));
                }

                manifiestoVO.getItdtMap().get(TipoDato.FECHA_01.getId())
                .setFecha(getTokenDate(ManifiestoKeyword.IFC_FechaUltimoEnvio, line, i, "ddMMyyHHmm"));
                manifiestoVO.getItdtMap().get(TipoDato.CADENA_02.getId())
                .setCadena(getTokenString(ManifiestoKeyword.IFC_NumeroViaje, line, i));
                manifiestoVO
                .getItdtMap()
                .get(TipoDato.BOOLEANO_02.getId())
                .setCantidadEntera(
                        "ZRE".equals(getTokenString(ManifiestoKeyword.IFC_CalificadorServicioRegular, line, i)) ? 1L
                                : 0L);
                manifiestoVO.getItdtMap().get(TipoDato.CADENA_03.getId())
                .setCadena(getTokenString(ManifiestoKeyword.IFC_TransitoComunitarioSimplificado, line, i));
                manifiestoVO.getItdtMap().get(TipoDato.ALIN.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.IFC_CodigoAlineacion, line, i, Entidad.ALINEACION));
                manifiestoVO.getItdtMap().get(TipoDato.TERMINAL.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.IFC_CodigoTerminal, line, i, Entidad.TERMINAL));
                manifiestoVO.getItdtMap().get(TipoDato.ACUERDO.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.IFC_CodigoAcuerdo, line, i, Entidad.ACUERDO));
                manifiestoVO
                .getItdtMap()
                .get(TipoDato.SERV_TRAF.getId())
                .setPrmt(
                        getTokenMaestro(ManifiestoKeyword.IFC_CodigoServicio, line, i, Entidad.SERVICIO_TRAFICO));

                break;
            case NAD:
                manifiestoConsignatarioActualVO = SubservicioVO.newInstance(TipoSubservicioProxy
                        .select(Entidad.MANIFIESTO_CONSIGNATARIO.getId()));

                manifiestoConsignatarioActualVO.getItdtMap().get(TipoDato.ORGA.getId())
                .setPrmt(getTokenOrganizacion(ManifiestoKeyword.NAD_NIFConsignatarioMercancia, line, i));

                ssrvList.add(manifiestoConsignatarioActualVO);

                break;
            case CNI:
                blActualVO = SubservicioVO.newInstance(TipoSubservicioProxy.select(Entidad.BL.getId()));

                blActualVO.setNumero(getTokenInteger(ManifiestoKeyword.CNI_NumeroBL, line, i));

                blActualVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.CNI_NombreBL, line, i));
                blActualVO.getItdtMap().get(TipoDato.TIPO_BL.getId())
                .setCadena(getTipoBl(getTokenString(ManifiestoKeyword.CNI_TipoBL, line, i)));

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
                blActualVO.getItdtMap().get(TipoDato.CADENA_02.getId())
                .setCadena(getTokenString(ManifiestoKeyword.CNI_DeclaracionSumariaTransito, line, i));

                final ParametroVO modoTransporteEdiVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoModoTransporteEDI,
                        line, i, Entidad.MODO_TRANSPORTE_EDI);

                if (modoTransporteEdiVO != null) {
                    blActualVO.getItdtMap().get(TipoDato.MODO_TRANS_EDI.getId()).setPrmt(modoTransporteEdiVO);
                    blActualVO
                    .getItdtMap()
                    .get(TipoDato.TIPO_TRANSPORTE.getId())
                    .setCadena(
                            modoTransporteEdiVO.getItdtMap().get(TipoDato.TIPO_TRANSPORTE.getId()).getCadena());
                }

                blActualVO.getItdtMap().get(TipoDato.CADENA_03.getId())
                .setCadena(getTokenString(ManifiestoKeyword.CNI_BuqueTransportePosterior, line, i));
                blActualVO.getItdtMap().get(TipoDato.TIPO_DEST.getId())
                .setCadena(getTokenCR(ManifiestoKeyword.CNI_TipoDestinoBl, line, i, TipoDato.TIPO_DEST));

                final ParametroVO alineacionBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoAlineacion, line, i,
                        Entidad.ALINEACION);

                blActualVO
                .getItdtMap()
                .get(TipoDato.ALIN.getId())
                .setPrmt(
                        alineacionBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.ALIN.getId())
                                .getPrmt() : alineacionBlVO);

                final ParametroVO terminalBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoTerminal, line, i,
                        Entidad.TERMINAL);

                blActualVO
                .getItdtMap()
                .get(TipoDato.TERMINAL.getId())
                .setPrmt(
                        terminalBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.TERMINAL.getId())
                                .getPrmt() : terminalBlVO);

                final ParametroVO acuerdoBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoAcuerdo, line, i,
                        Entidad.ACUERDO);

                blActualVO
                .getItdtMap()
                .get(TipoDato.ACUERDO.getId())
                .setPrmt(
                        acuerdoBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.ACUERDO.getId()).getPrmt()
                                : acuerdoBlVO);

                final ParametroVO servicioBlVO = getTokenMaestro(ManifiestoKeyword.CNI_CodigoServicio, line, i,
                        Entidad.SERVICIO_TRAFICO);

                blActualVO
                .getItdtMap()
                .get(TipoDato.SERV_TRAF.getId())
                .setPrmt(
                        servicioBlVO == null ? manifiestoVO.getItdtMap().get(TipoDato.SERV_TRAF.getId())
                                .getPrmt() : servicioBlVO);

                estibadorVO = getTokenOrganizacion(ManifiestoKeyword.CNI_NIFEstibador, line, i);

                blActualVO
                .getItdtMap()
                        .get(TipoDato.ORGA_2.getId())
                .setPrmt(
                                estibadorVO == null ? manifiestoVO.getItdtMap().get(TipoDato.ORGA.getId())
                                .getPrmt() : estibadorVO);

                ssrvList.add(blActualVO);

                break;
            case GID:
                if (blActualVO == null) {
                    throw new Error("BL no puede ser nulo");
                }

                partidaActualVO = SubservicioVO.newInstance(TipoSubservicioProxy.select(Entidad.PARTIDA.getId()));

                partidaActualVO.setNumero(getTokenInteger(ManifiestoKeyword.GID_NumeroPartida, line, i));

                final Long numeroBultos = getTokenLong(ManifiestoKeyword.GID_NumeroBultos, line, i);
                final String tipoBl = blActualVO.getItdtMap().get(TipoDato.TIPO_BL.getId()).getCadena();

                if ("M".equals(tipoBl)) {
                    partidaActualVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).setCantidadEntera(numeroBultos);
                } else if ("P".equals(tipoBl)) {
                    partidaActualVO.getItdtMap().get(TipoDato.ENTERO_03.getId()).setCantidadEntera(numeroBultos);
                }

                partidaActualVO.getItdtMap().get(TipoDato.TIPO_BULTO.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.GID_CodigoTipoBulto, line, i, Entidad.TIPO_BULTO));
                partidaActualVO.getItdtMap().get(TipoDato.MERCANCIA.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.GID_CodigoMercancia, line, i, Entidad.MERCANCIA));
                partidaActualVO
                .getItdtMap()
                .get(TipoDato.MARCA_VEHIC.getId())
                .setPrmt(
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoMarcaVehiculo, line, i,
                                Entidad.MARCA_VEHICULO));
                partidaActualVO.getItdtMap().get(TipoDato.ACUERDO.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.GID_CodigoAcuerdo, line, i, Entidad.ACUERDO));
                partidaActualVO
                .getItdtMap()
                .get(TipoDato.INST_ESP.getId())
                .setPrmt(
                        getTokenMaestro(ManifiestoKeyword.GID_CodigoInstalacionEspecial, line, i,
                                Entidad.INSTALACION_ESPECIAL));
                partidaActualVO.getItdtMap().get(TipoDato.TERMINAL.getId())
                .setPrmt(getTokenMaestro(ManifiestoKeyword.GID_CodigoTerminal, line, i, Entidad.TERMINAL));

                partidaActualVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.GID_DeclaracionSumariaTransito, line, i));

                estibadorVO = getTokenOrganizacion(ManifiestoKeyword.GID_NifEstibador, line, i);

                partidaActualVO
                .getItdtMap()
                        .get(TipoDato.ORGA.getId())
                .setPrmt(
                                estibadorVO == null ? blActualVO.getItdtMap().get(TipoDato.ORGA_2.getId())
                                .getPrmt() : estibadorVO);

                ssrvList.add(partidaActualVO);

                break;
            case PCI:
                partidaImActualVO = SubservicioVO.newInstance(TipoSubservicioProxy.select(Entidad.PARTIDA_IM.getId()));

                partidaImActualVO
                .getItdtMap()
                .get(TipoDato.INST_MARC.getId())
                .setPrmt(
                        getTokenMaestro(ManifiestoKeyword.PCI_CodigoInstruccionMarcaje, line, i,
                                Entidad.INSTRUCCION_MARCAJE));
                partidaImActualVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.PCI_Marca, line, i));

                ssrvList.add(partidaImActualVO);

                break;
            case GOR:
                partidaDocumentoActualVO = SubservicioVO.newInstance(TipoSubservicioProxy
                        .select(Entidad.PARTIDA_DOCUMENTO.getId()));

                partidaDocumentoActualVO
                .getItdtMap()
                .get(TipoDato.SIT_ADU.getId())
                .setCadena(getTokenCR(ManifiestoKeyword.GOR_CodigoSituacionAduanera, line, i, TipoDato.SIT_ADU));

                ssrvList.add(partidaDocumentoActualVO);

                break;
            case DOC:
                if (partidaDocumentoActualVO == null) {
                    throw new Error("Nunca deberia ser null");
                }

                if (partidaDocumentoActualVO.getEntiId() != Entidad.PARTIDA_DOCUMENTO.getId()) {
                    throw new Error("Tipo de Subservicio no valido");
                }

                partidaDocumentoActualVO
                .getItdtMap()
                .get(TipoDato.TIPO_DOC_AEAT.getId())
                .setPrmt(
                        getTokenMaestro(ManifiestoKeyword.DOC_CodigoTipoDocumento, line, i,
                                Entidad.TIPO_DOCUMENTO_AEAT));
                partidaDocumentoActualVO.getItdtMap().get(TipoDato.FECHA_01.getId())
                .setFecha(getTokenDate(ManifiestoKeyword.DOC_FechaEmision, line, i, "ddMMyy"));
                partidaDocumentoActualVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.DOC_NumeroDocumento, line, i));
                partidaDocumentoActualVO.getItdtMap().get(TipoDato.SIT_EMB.getId())
                .setCadena(getTokenCR(ManifiestoKeyword.DOC_SituacionEmbarque, line, i, TipoDato.SIT_EMB));

                break;
            case SGP:
                partidaEquipamientoActualVO = SubservicioVO.newInstance(TipoSubservicioProxy
                        .select(Entidad.PARTIDA_EQUIPAMIENTO.getId()));

                partidaEquipamientoActualVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                .setCantidadEntera(getTokenLong(ManifiestoKeyword.SGP_NumeroBultos, line, i));
                // FIXME Chapu para poder relacionar despues el
                // Partida-Equipamiento con el Equipamiento.
                // Guardo la matricula en el campo 'cadena'.
                partidaEquipamientoActualVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.SGP_Matricula, line, i));

                ssrvList.add(partidaEquipamientoActualVO);

                break;
            case DGS:
                partidaMmppActualVO = SubservicioVO.newInstance(TipoSubservicioProxy.select(Entidad.PARTIDA_MMPP
                        .getId()));

                final String codigoMmpp = getTokenString(ManifiestoKeyword.DGS_NumeroONU, line, i)
                        + getTokenString(ManifiestoKeyword.DGS_Clase, line, i);

                partidaMmppActualVO.getItdtMap().get(TipoDato.MERC_PELIG.getId())
                .setPrmt(getTokenMaestro(codigoMmpp, line, i, Entidad.MERCANCIAS_PELIGROSAS));

                ssrvList.add(partidaMmppActualVO);

                break;
            case EQD:
                equipamientoActualVO = SubservicioVO.newInstance(TipoSubservicioProxy.select(Entidad.EQUIPAMIENTO
                        .getId()));

                final String indicadorLleno = getTokenString(ManifiestoKeyword.EQD_IndicadorLleno, line, i);

                equipamientoActualVO.getItdtMap().get(TipoDato.CADENA_02.getId()).setCadena(indicadorLleno);

                if (!"4".equals(indicadorLleno)) {
                    equipamientoActualVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                    .setCadena(getTokenString(ManifiestoKeyword.EQD_Matricula, line, i));
                }

                final String codigoTipoEquipamiento = getTokenString(ManifiestoKeyword.EQD_CodigoTipoEquipamiento,
                        line, i) + getTokenString(ManifiestoKeyword.EQD_TamanioEquipamiento, line, i);

                equipamientoActualVO.getItdtMap().get(TipoDato.TIPO_EQUI.getId())
                .setPrmt(getTokenMaestro(codigoTipoEquipamiento, line, i, Entidad.TIPO_EQUIPAMIENTO));
                equipamientoActualVO.getItdtMap().get(TipoDato.ENTERO_02.getId())
                .setCantidadEntera(getTokenLong(ManifiestoKeyword.EQD_TaraEquipamiento, line, i));
                equipamientoActualVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                .setCantidadEntera(getTokenLong(ManifiestoKeyword.EQD_NumeroVacios, line, i));

                ssrvList.add(equipamientoActualVO);

                break;
            case SEL:
                precintoEquipamientoActualVO = SubservicioVO.newInstance(TipoSubservicioProxy
                        .select(Entidad.PRECINTO_EQUIPAMIENTO.getId()));

                precintoEquipamientoActualVO.getItdtMap().get(TipoDato.CADENA_01.getId())
                .setCadena(getTokenString(ManifiestoKeyword.SEL_Precinto, line, i));
                ssrvList.add(precintoEquipamientoActualVO);

                break;
            default:
                break;
            }
        }

        LOG.info(prbtVO);
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
            addError(MensajeCodigo.G_001, "linea:" + lineNumber + ", entidad:" + Entidad.ORGANIZACION.name()
                    + ", codigo:" + codigo);
        }

        return organizacionesMap.get(codigo);
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
            addError(MensajeCodigo.G_001, "linea:" + lineNumber + ", entidad:" + entidad.name() + ", codigo:" + codigo);
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
            addError(MensajeCodigo.G_001, "linea:" + lineNumber + ", entidad:" + entidad.name() + ", codigo:" + codigo);
        }

        return maestroMap.get(entidad).get(codigo);
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
            bl.getItdtMap().get(TipoDato.UNLOCODE.getId()).setPrmt(unlocode);

            break;
        case "9":
            bl.getItdtMap().get(TipoDato.UNLOCODE_2.getId()).setPrmt(unlocode);

            break;
        case "11":
            bl.getItdtMap().get(TipoDato.UNLOCODE_3.getId()).setPrmt(unlocode);

            break;
        case "8":
            bl.getItdtMap().get(TipoDato.UNLOCODE_4.getId()).setPrmt(unlocode);

            break;
        case "13":
            bl.getItdtMap().get(TipoDato.UNLOCODE_5.getId()).setPrmt(unlocode);

            break;
        default:
            throw new Error("Calificador puerto '" + calificadorPuerto + "' no valido");
        }
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
     * Gets the primera linea.
     *
     * @param lines
     *            the lines
     * @return the primera linea
     */
    private int getPrimeraLinea(final List<String> lines) {
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

        addError(MensajeCodigo.G_008, ManifiestoSegmento.IFC.name());

        return primeraLinea;
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
                addError(MensajeCodigo.G_005, "linea:" + lineNumber + ", campo:" + keyword.name());
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
    private String getTokenCR(final ManifiestoKeyword keyword, final String line, final int lineNumber,
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
            addError(MensajeCodigo.G_003, "linea:" + lineNumber + ", valor:" + codigo);

            return null;
        }
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
    private Date getTokenDate(final ManifiestoKeyword keyword, final String line, final int lineNumber,
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
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.MAN_CARGA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.S;
    }

}
