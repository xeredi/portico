package xeredi.integra.proceso.estadistica.cargaoppe;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.io.IOUtils;

import xeredi.integra.model.bo.estadistica.EstadisticaFileKeyword;
import xeredi.integra.model.bo.estadistica.EstadisticaFileType;
import xeredi.integra.model.bo.estadistica.PeriodoProceso;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.proxy.metamodelo.TipoDatoProxy;
import xeredi.integra.model.proxy.metamodelo.TipoEstadisticaProxy;
import xeredi.integra.model.util.ConfigurationUtil;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.model.vo.estadistica.EstadisticaVO;
import xeredi.integra.model.vo.estadistica.PeriodoProcesoVO;
import xeredi.integra.model.vo.maestro.ParametroVO;
import xeredi.integra.model.vo.metamodelo.TipoDatoVO;
import xeredi.integra.model.vo.metamodelo.TipoEstadisticaVO;
import xeredi.integra.model.vo.proceso.MensajeCodigo;
import xeredi.integra.model.vo.proceso.ProcesoModulo;
import xeredi.integra.model.vo.proceso.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;
import xeredi.util.exception.DuplicateInstanceException;

// TODO: Auto-generated Javadoc
/**
 * The Class CargaOppe.
 */
public final class ProcesoCargaOppe extends ProcesoTemplate {
    /** The Constant SIGMA_TOKEN. */
    private static final String SIGMA_TOKEN = "SIGMA";

    /** The Constant PATH_ENTRADA_PARAM. */
    private static final String PATH_ENTRADA_PARAM = "estadistica.files.oppe.entrada.home";

    /** The Constant PATH_PROCESADO_PARAM. */
    private static final String PATH_PROCESADO_PARAM = "estadistica.files.oppe.procesado.home";

    /** The Constant PATH_ERRONEO_PARAM. */
    private static final String PATH_ERRONEO_PARAM = "estadistica.files.oppe.erroneo.home";

    /** The path entrada. */
    private static String PATH_ENTRADA;

    /** The path procesado. */
    private static String PATH_PROCESADO;

    /** The path erroneo. */
    private static String PATH_ERRONEO;

    /** The Constant AUTP_PARAM. */
    public static final String AUTP_PARAM = "autp";

    /** The Constant MES_PARAM. */
    public static final String MES_PARAM = "mes";

    /** The Constant ANIO_PARAM. */
    public static final String ANIO_PARAM = "anio";

    /** The Constant SOBREESCRIBIR_PARAM. */
    public static final String SOBREESCRIBIR_PARAM = "sobreescribir";

    /** The Constant FILENAME_PATTERN. */
    private static final String FILENAME_PATTERN = "/{0}{1,number,0000}{2,number,00}.{3}";

    /** The Constant DATE_PATTERN. */
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    /** The autp vo. */
    private ParametroVO autpVO;

    /** The pepr vo. */
    private PeriodoProcesoVO peprVO;

    /** The autp map. */
    private Map<String, ParametroVO> autpMap;

    /** The esta list. */
    private List<EstadisticaVO> estaList;

    /** The is sigma. */
    private boolean isSigma;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutar() {
        final Configuration configuration = ConfigurationUtil.getConfiguration();

        PATH_ENTRADA = configuration.getString(PATH_ENTRADA_PARAM);
        PATH_PROCESADO = configuration.getString(PATH_PROCESADO_PARAM);
        PATH_ERRONEO = configuration.getString(PATH_ERRONEO_PARAM);

        // Lectura de los parametros de entrada
        final String autp = prbtVO.getPrpmMap().get(AUTP_PARAM);
        final int anio = Integer.parseInt(prbtVO.getPrpmMap().get(ANIO_PARAM));
        final int mes = Integer.parseInt(prbtVO.getPrpmMap().get(MES_PARAM));
        final boolean sobreescribir = Boolean.parseBoolean(prbtVO.getPrpmMap().get(SOBREESCRIBIR_PARAM));

        autpVO = new ParametroVO();
        autpVO.setParametro(autp);

        peprVO = new PeriodoProcesoVO();
        autpMap = new HashMap<>();
        estaList = new ArrayList<>();
        isSigma = false;

        isSigma = verificaEsSigma(autpVO, anio, mes);

        cargaCodigoMaestros(autpVO, anio, mes);

        if (prbtVO.getPrmnList().isEmpty()) {
            buscarMaestros(Calendar.getInstance().getTime());
        }

        if (prbtVO.getPrmnList().isEmpty()) {
            generarDatos(autpVO, anio, mes);
        }

        if (prbtVO.getPrmnList().isEmpty()) {
            LOG.info("Guardar Datos");
            final PeriodoProceso peprBO = BOFactory.getInjector().getInstance(PeriodoProceso.class);

            try {
                peprBO.cargarArchivo(peprVO, autpMap, estaList, sobreescribir);
            } catch (final DuplicateInstanceException ex) {
                addError(MensajeCodigo.E_001,
                        "Periodo de Proceso: " + peprVO.getAutp().getParametro() + " " + peprVO.getAnio() + " "
                                + peprVO.getMes());
            }
        }

        if (!prbtVO.getPrmnList().isEmpty()) {
            LOG.error("Errores en la carga");
            LOG.info(prbtVO.getPrmnList());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.EST_CARGA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.E;
    }

    /**
     * Generar datos.
     *
     * @param autpVO
     *            the autp vo
     * @param anio
     *            the anio
     * @param mes
     *            the mes
     */
    private void generarDatos(final ParametroVO autpVO, final Integer anio, final Integer mes) {
        peprVO.setAutp(autpVO);
        peprVO.setAnio(anio);
        peprVO.setMes(mes);
        peprVO.setFalta(Calendar.getInstance().getTime());
        peprVO.setAutp(maestroMap.get(Entidad.AUTORIDAD_PORTUARIA).get(peprVO.getAutp().getParametro()));

        String filename = null;

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EPP);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    getTokenInteger(EstadisticaFileKeyword.Anio, line, i);
                    getTokenInteger(EstadisticaFileKeyword.Mes, line, i);
                    getTokenDate(EstadisticaFileKeyword.EPP_FechaTransmision, line, i, DATE_PATTERN);

                    autpMap.put(getTokenString(EstadisticaFileKeyword.Autp, line, i),
                            getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EAP);

        try (final Reader reader = new FileReader(filename);) {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.ACTIVIDAD_PESQUERA.getId());
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estaVO = EstadisticaVO.newInstance(tpesVO);

                    estaVO.getItdtMap().get(TipoDato.TIPO_CAPTURA_PESCA.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EAP_TipoCaptura, line, i, Entidad.TIPO_CAPTURA_PESCA));
                    estaVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                    .setCantidadEntera(getTokenLong(EstadisticaFileKeyword.EAP_Kilos, line, i));
                    estaVO.getItdtMap().get(TipoDato.DECIMAL_01.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EAP_Euros, line, i) / 100);
                    estaVO.setAutp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    estaList.add(estaVO);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EAV);

        try (final Reader reader = new FileReader(filename);) {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.AVITUALLAMIENTO.getId());
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estaVO = EstadisticaVO.newInstance(tpesVO);

                    String tipoSuministro = getTokenString(EstadisticaFileKeyword.EAV_TipoSuministro, line, i);

                    tipoSuministro = getTipoSuministroNormalizado(tipoSuministro);

                    final ParametroVO tipoSuministroPrmt = maestroMap.get(Entidad.TIPO_SUMINISTRO).get(tipoSuministro);

                    estaVO.getItdtMap().get(TipoDato.TIPO_SUM.getId()).setPrmt(tipoSuministroPrmt);
                    estaVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                    .setCantidadEntera(getTokenLong(EstadisticaFileKeyword.EAV_Toneladas, line, i));
                    estaVO.setAutp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    estaList.add(estaVO);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EAE);

        try (final Reader reader = new FileReader(filename);) {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.AGREGACION_ESCALA.getId());
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estaVO = EstadisticaVO.newInstance(tpesVO);

                    // FIXME Conversion de Tipo de Buque
                    estaVO.getItdtMap().get(TipoDato.TIPO_BUQUE.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EAE_TipoBuque, line, i, Entidad.TIPO_BUQUE));
                    estaVO.getItdtMap().get(TipoDato.TIPO_NAV.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EAE_TipoNavEntrada, line, i, Entidad.TIPO_NAVEGACION));
                    estaVO.getItdtMap().get(TipoDato.TIPO_NAV_2.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EAE_TipoNavSalida, line, i, Entidad.TIPO_NAVEGACION));
                    estaVO.getItdtMap().get(TipoDato.PAIS.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EAE_Bandera, line, i, Entidad.PAIS));
                    estaVO.getItdtMap().get(TipoDato.TIPO_ACT.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EAE_TipoActividad, line, i, Entidad.TIPO_ACTIVIDAD));

                    estaVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                    .setCantidadEntera(getTokenLong(EstadisticaFileKeyword.EAE_NumEscalas, line, i));
                    estaVO.getItdtMap().get(TipoDato.ENTERO_02.getId())
                    .setCantidadEntera(getTokenLong(EstadisticaFileKeyword.EAE_NumGTs, line, i));
                    estaVO.setAutp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    estaList.add(estaVO);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EMM);

        try (final Reader reader = new FileReader(filename);) {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.MOVIMIENTO_MERCANCIA.getId());
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estaVO = EstadisticaVO.newInstance(tpesVO);

                    estaVO.setAutp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    estaVO.getItdtMap()
                    .get(TipoDato.TIPO_OP_BL.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EMM_TipoOperacion, line, i, Entidad.TIPO_OPERACION_BL));
                    estaVO.getItdtMap().get(TipoDato.UNLOCODE_3.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EMM_UnloOrigen, line, i, Entidad.UNLOCODE));
                    estaVO.getItdtMap().get(TipoDato.UNLOCODE_4.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EMM_UnloDestino, line, i, Entidad.UNLOCODE));
                    estaVO.getItdtMap()
                    .get(TipoDato.ALIN.getId())
                    .setPrmt(
                            getMaestro(Entidad.ALINEACION,
                                    "***" + getTokenString(EstadisticaFileKeyword.EMM_Alineacion, line, i), line, i));
                    estaVO.getItdtMap().get(TipoDato.MERCANCIA.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EMM_Mercancia, line, i, Entidad.MERCANCIA));
                    estaVO.getItdtMap().get(TipoDato.TIPO_NAV.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EMM_TipoNavegacion, line, i, Entidad.TIPO_NAVEGACION));

                    estaVO.getItdtMap().get(TipoDato.BOOLEANO_01.getId())
                    .setCantidadEntera(!getTokenString(EstadisticaFileKeyword.EMM_Roro, line, i).equals("N") ? 1L : 0L);

                    String uc = getTokenString(EstadisticaFileKeyword.EMM_UnidadCarga, line, i);

                    uc = getUCNormalizada(uc);

                    final ParametroVO ucPrmt = maestroMap.get(Entidad.UNIDAD_CARGA).get(uc);

                    estaVO.getItdtMap().get(TipoDato.UNIDAD_CARGA.getId()).setPrmt(ucPrmt);
                    estaVO.getItdtMap()
                    .get(TipoDato.INST_ESP.getId())
                    .setPrmt(
                            getMaestro(Entidad.INSTALACION_ESPECIAL,
                                    "**************" + getTokenString(EstadisticaFileKeyword.EMM_InstEspecial, line, i),
                                    line, i));

                    estaVO.getItdtMap().get(TipoDato.TIPO_TRANSPORTE.getId())
                    .setCadena(getTokenCR(EstadisticaFileKeyword.EMM_TipoTransporte, line, i, TipoDato.TIPO_TRANSPORTE));

                    estaVO.getItdtMap().get(TipoDato.DECIMAL_01.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EMM_Toneladas, line, i));
                    estaVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                    .setCantidadEntera(getTokenLong(EstadisticaFileKeyword.EMM_Unidades, line, i));
                    estaVO.getItdtMap().get(TipoDato.DECIMAL_02.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EMM_Teus, line, i));

                    // FIXME Acabar
                    ParametroVO unloCargaDescargaVO = null;

                    if (line.length() > EstadisticaFileKeyword.EMM_UnloCargaDescarga.getOffset()) {
                        unloCargaDescargaVO = getTokenMaestro(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i,
                                Entidad.UNLOCODE);
                    } else {
                        unloCargaDescargaVO = getTokenMaestroGeneric(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i,
                                Entidad.UNLOCODE);
                    }

                    if (unloCargaDescargaVO != null) {
                        final String tipoOperacion = getTokenString(EstadisticaFileKeyword.EMM_TipoOperacion, line, i);
                        final ParametroVO autpUnlo = estaVO.getAutp().getItdtMap().get(TipoDato.UNLOCODE.getId())
                                .getPrmt();

                        if ("TE".equals(tipoOperacion) || tipoOperacion.startsWith("E")) {
                            estaVO.getItdtMap().get(TipoDato.UNLOCODE.getId()).setPrmt(autpUnlo);
                            estaVO.getItdtMap().get(TipoDato.UNLOCODE_2.getId()).setPrmt(unloCargaDescargaVO);
                        } else {
                            estaVO.getItdtMap().get(TipoDato.UNLOCODE.getId()).setPrmt(unloCargaDescargaVO);
                            estaVO.getItdtMap().get(TipoDato.UNLOCODE_2.getId()).setPrmt(autpUnlo);
                        }
                    }

                    estaList.add(estaVO);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EME);

        try (final Reader reader = new FileReader(filename);) {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.MOVIMIENTO_MERCANCIA_EEE.getId());
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estaVO = EstadisticaVO.newInstance(tpesVO);

                    estaVO.getItdtMap().get(TipoDato.UNLOCODE.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EME_UnloCargaDescarga, line, i, Entidad.UNLOCODE));
                    estaVO.getItdtMap().get(TipoDato.UNIDAD_CARGA.getId())
                    .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EME_UnidadCarga, line, i, Entidad.UNIDAD_CARGA));

                    if (isSigma) {
                        estaVO.getItdtMap().get(TipoDato.GRUPO_NST.getId())
                        .setPrmt(getTokenMaestro(EstadisticaFileKeyword.EME_GrupoNST, line, i, Entidad.GRUPO_NST));
                        estaVO.getItdtMap().get(TipoDato.MERCANCIA.getId())
                        .setPrmt(getTokenMaestroGeneric(EstadisticaFileKeyword.EME_Mercancia, line, i, Entidad.MERCANCIA));
                    } else {
                        final ParametroVO mercanciaVO = getTokenMaestro(EstadisticaFileKeyword.EME_Mercancia, line, i,
                                Entidad.MERCANCIA);

                        if (mercanciaVO != null) {
                            estaVO.getItdtMap().get(TipoDato.MERCANCIA.getId()).setPrmt(mercanciaVO);
                            estaVO.getItdtMap().get(TipoDato.GRUPO_NST.getId())
                            .setPrmt(mercanciaVO.getItdtMap().get(TipoDato.GRUPO_NST.getId()).getPrmt());
                        }
                    }

                    estaVO.getItdtMap()
                    .get(TipoDato.REG_TBUQUE_EEE.getId())
                    .setPrmt(
                            getTokenMaestro(EstadisticaFileKeyword.EME_RegistroBuqueEEE, line, i,
                                    Entidad.REGISTRO_TIPO_BUQUE_EEE));

                    estaVO.getItdtMap()
                    .get(TipoDato.DIREC_MERC.getId())
                    .setCadena(
                            getDireccionMercanciaNormalizada(getTokenString(
                                    EstadisticaFileKeyword.EME_DireccionTransporte, line, i)));

                    estaVO.getItdtMap().get(TipoDato.DECIMAL_01.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EME_Toneladas, line, i));
                    estaVO.getItdtMap().get(TipoDato.ENTERO_01.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EME_Pasajeros, line, i));
                    estaVO.getItdtMap().get(TipoDato.ENTERO_02.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EME_UCLlenas, line, i));
                    estaVO.getItdtMap().get(TipoDato.ENTERO_03.getId())
                    .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EME_UCVacias, line, i));

                    if (line.length() > EstadisticaFileKeyword.EME_Roro.getOffset()) {
                        estaVO.getItdtMap()
                        .get(TipoDato.BOOLEANO_01.getId())
                        .setCantidadEntera(!getTokenString(EstadisticaFileKeyword.EME_Roro, line, i).equals("N") ? 1L : 0L);
                    }

                    if (isSigma) {
                        estaVO.getItdtMap().get(TipoDato.ENTERO_04.getId())
                        .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EME_PasajerosCrucero, line, i));
                        estaVO.getItdtMap().get(TipoDato.ENTERO_05.getId())
                        .setCantidadDecimal(getTokenDouble(EstadisticaFileKeyword.EME_PasajerosInicioFinLinea, line, i));
                    }
                    // FIXME Acabar

                    estaVO.setAutp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    estaList.add(estaVO);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        // FIXME Falta el EMT

    }

    /**
     * Verifica es sigma.
     *
     * @param autp
     *            the autp
     * @param anio
     *            the anio
     * @param mes
     *            the mes
     * @return true, if successful
     */
    private static boolean verificaEsSigma(final ParametroVO autp, final Integer anio, final Integer mes) {
        final String eppFile = getFilename(PATH_ENTRADA, autp, anio, mes, EstadisticaFileType.EPP);

        try {
            return IOUtils.readLines(new FileReader(eppFile)).iterator().next().startsWith(SIGMA_TOKEN);
        } catch (final IOException ex) {
            LOG.fatal(ex, ex);
        }

        return false;
    }

    /**
     * Carga maestros.
     *
     * @param autpVO
     *            the autp vo
     * @param anio
     *            the anio
     * @param mes
     *            the mes
     */
    private void cargaCodigoMaestros(final ParametroVO autpVO, final Integer anio, final Integer mes) {
        addCodigoMaestro(Entidad.AUTORIDAD_PORTUARIA, autpVO.getParametro());

        String filename = null;

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EPP);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.AUTORIDAD_PORTUARIA, getTokenString(EstadisticaFileKeyword.Autp, line, i));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EAP);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_CAPTURA_PESCA, getTokenString(EstadisticaFileKeyword.EAP_TipoCaptura, line, i));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EAV);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final String tipoSuministro = getTokenString(EstadisticaFileKeyword.EAV_TipoSuministro, line, i);

                    addCodigoMaestro(Entidad.TIPO_SUMINISTRO, getTipoSuministroNormalizado(tipoSuministro));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EAE);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_BUQUE, getTokenString(EstadisticaFileKeyword.EAE_TipoBuque, line, i));
                    addCodigoMaestro(Entidad.TIPO_NAVEGACION, getTokenString(EstadisticaFileKeyword.EAE_TipoNavEntrada, line, i));
                    addCodigoMaestro(Entidad.TIPO_NAVEGACION, getTokenString(EstadisticaFileKeyword.EAE_TipoNavSalida, line, i));
                    addCodigoMaestro(Entidad.PAIS, getTokenString(EstadisticaFileKeyword.EAE_Bandera, line, i));
                    addCodigoMaestro(Entidad.TIPO_ACTIVIDAD, getTokenString(EstadisticaFileKeyword.EAE_TipoActividad, line, i));

                    // FIXME Entidad Rango GTs
                    addCodigoMaestro(Entidad.BUQUE, EstadisticaFileKeyword.EAE_Buque.getGenericValue());
                    addCodigoMaestro(Entidad.SERVICIO_TRAFICO, EstadisticaFileKeyword.EAE_Trafico.getGenericValue());
                    addCodigoMaestro(Entidad.ACUERDO, EstadisticaFileKeyword.EAE_Acuerdo.getGenericValue());
                    addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EAE_Consignatario.getGenericValue());
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EMM);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_OPERACION_BL, getTokenString(EstadisticaFileKeyword.EMM_TipoOperacion, line, i));
                    addCodigoMaestro(Entidad.UNLOCODE, getTokenString(EstadisticaFileKeyword.EMM_UnloOrigen, line, i));
                    addCodigoMaestro(Entidad.UNLOCODE, getTokenString(EstadisticaFileKeyword.EMM_UnloDestino, line, i));
                    addCodigoMaestro(Entidad.ALINEACION, "***" + getTokenString(EstadisticaFileKeyword.EMM_Alineacion, line, i));
                    addCodigoMaestro(Entidad.MERCANCIA, getTokenString(EstadisticaFileKeyword.EMM_Mercancia, line, i));
                    addCodigoMaestro(Entidad.TIPO_NAVEGACION, getTokenString(EstadisticaFileKeyword.EMM_TipoNavegacion, line, i));

                    final String uc = getTokenString(EstadisticaFileKeyword.EMM_UnidadCarga, line, i);

                    addCodigoMaestro(Entidad.UNIDAD_CARGA, getUCNormalizada(uc));
                    addCodigoMaestro(Entidad.INSTALACION_ESPECIAL,
                            "**************" + getTokenString(EstadisticaFileKeyword.EMM_InstEspecial, line, i));

                    if (line.length() > EstadisticaFileKeyword.EMM_UnloCargaDescarga.getOffset()) {
                        addCodigoMaestro(Entidad.UNLOCODE, getTokenString(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i));
                    } else {
                        addCodigoMaestro(Entidad.UNLOCODE, EstadisticaFileKeyword.EMM_UnloCargaDescarga.getGenericValue());
                    }

                    addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EMM_Estibador.getGenericValue());
                    addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EMM_Consignatario.getGenericValue());
                    addCodigoMaestro(Entidad.BUQUE, EstadisticaFileKeyword.EMM_Buque.getGenericValue());
                    addCodigoMaestro(Entidad.SERVICIO_TRAFICO, EstadisticaFileKeyword.EMM_ServicioTrafico.getGenericValue());
                    addCodigoMaestro(Entidad.ACUERDO, EstadisticaFileKeyword.EMM_Acuerdo.getGenericValue());
                    addCodigoMaestro(Entidad.TERMINAL, EstadisticaFileKeyword.EMM_Terminal.getGenericValue());
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EME);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.UNLOCODE, getTokenString(EstadisticaFileKeyword.EME_UnloCargaDescarga, line, i));
                    addCodigoMaestro(Entidad.UNIDAD_CARGA, getTokenString(EstadisticaFileKeyword.EME_UnidadCarga, line, i));
                    addCodigoMaestro(Entidad.REGISTRO_TIPO_BUQUE_EEE,
                            getTokenString(EstadisticaFileKeyword.EME_RegistroBuqueEEE, line, i));

                    if (isSigma) {
                        addCodigoMaestro(Entidad.GRUPO_NST, getTokenString(EstadisticaFileKeyword.EME_GrupoNST, line, i));
                        addCodigoMaestro(Entidad.MERCANCIA, EstadisticaFileKeyword.EME_Mercancia.getGenericValue());
                    } else {
                        addCodigoMaestro(Entidad.MERCANCIA, getTokenString(EstadisticaFileKeyword.EME_Mercancia, line, i));
                    }
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }

        filename = getFilename(PATH_ENTRADA, autpVO, anio, mes, EstadisticaFileType.EMT);

        try (final Reader reader = new FileReader(filename);) {
            final List<String> lines = IOUtils.readLines(reader);

            for (int i = 0; i < lines.size(); i++) {
                final String line = lines.get(i);

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_BUQUE_EEE, getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i));
                    addCodigoMaestro(Entidad.TIPO_BUQUE_EST, getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i));
                    addCodigoMaestro(Entidad.TIPO_BUQUE_GT, getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE, line, i));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, filename);
        }
    }

    /**
     * Gets the string token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the string token
     */
    private String getTokenString(final EstadisticaFileKeyword keyword, final String line, final int lineNumber) {
        if (line.length() >= keyword.getOffset() + keyword.getLength()) {
            final String token = line.substring(keyword.getOffset(), keyword.getOffset() + keyword.getLength()).trim();

            if ((token == null || token.isEmpty()) && keyword.isRequired()) {
                addError(MensajeCodigo.G_005, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                        + ", campo: " + keyword.name());
            }

            return token;
        }

        return null;
    }

    /**
     * Gets the cR token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param tipoDato
     *            the tipo dato
     * @return the cR token
     */
    private String getTokenCR(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final TipoDato tipoDato) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        final TipoDatoVO tpdtVO = TipoDatoProxy.select(tipoDato.getId());

        if (!tpdtVO.getCdrfCodeSet().contains(codigo)) {
            addError(MensajeCodigo.G_004, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", CR: " + tipoDato.name() + ", codigo: " + codigo);
        }

        return codigo;
    }

    /**
     * Gets the maestro token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @return the maestro token
     */
    private ParametroVO getTokenMaestro(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            addError(MensajeCodigo.G_001, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", entidad: " + entidad.name() + ", codigo: " + codigo);
        }

        return maestroMap.get(entidad).get(codigo);
    }

    /**
     * Gets the maestro.
     *
     * @param entidad
     *            the entidad
     * @param code
     *            the code
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the maestro
     */
    private ParametroVO getMaestro(final Entidad entidad, final String code, final String line, final int lineNumber) {
        return maestroMap.get(entidad).get(code);
    }

    /**
     * Gets the maestro generic token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @return the maestro generic token
     */
    private ParametroVO getTokenMaestroGeneric(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad) {
        return maestroMap.get(entidad).get(keyword.getGenericValue());
    }

    /**
     * Gets the long token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the long token
     */
    private Long getTokenLong(final EstadisticaFileKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Long.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            addError(MensajeCodigo.G_003, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", valor: " + codigo);

            return null;
        }
    }

    /**
     * Gets the integer token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the integer token
     */
    private Integer getTokenInteger(final EstadisticaFileKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Integer.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            addError(MensajeCodigo.G_003, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", valor: " + codigo);

            return null;
        }
    }

    /**
     * Gets the double token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the double token
     */
    private Double getTokenDouble(final EstadisticaFileKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return Double.valueOf(codigo);
        } catch (final NumberFormatException ex) {
            addError(MensajeCodigo.G_003, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", valor: " + codigo);

            return null;
        }
    }

    /**
     * Gets the date token.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param dateFormat
     *            the date format
     * @return the date token
     */
    private Date getTokenDate(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final String dateFormat) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            return new SimpleDateFormat(dateFormat).parse(codigo);
        } catch (final ParseException ex) {
            addError(MensajeCodigo.G_002, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", valor:" + codigo + ", formato: " + dateFormat);

            return null;
        }
    }

    /**
     * Gets the filename.
     *
     * @param folder
     *            the folder
     * @param autp
     *            the autp
     * @param anio
     *            the anio
     * @param mes
     *            the mes
     * @param fileType
     *            the file type
     * @return the filename
     */
    private static String getFilename(final String folder, final ParametroVO autp, final Integer anio,
            final Integer mes, final EstadisticaFileType fileType) {
        return folder
                + MessageFormat.format(FILENAME_PATTERN,
                        new Object[] { autp.getParametro(), anio, mes, fileType.name() });
    }

    /**
     * Gets the tipo suministro normalizado.
     *
     * @param tipoSuministro
     *            the tipo suministro
     * @return the tipo suministro normalizado
     */
    private String getTipoSuministroNormalizado(final String tipoSuministro) {
        if (tipoSuministro.startsWith("1")) {
            return "10";
        } else if (tipoSuministro.startsWith("3")) {
            return "30";
        } else if (tipoSuministro.startsWith("4")) {
            return "40";
        }

        return "50";
    }

    /**
     * Gets the uC normalizada.
     *
     * @param uc
     *            the uc
     * @return the uC normalizada
     */
    private String getUCNormalizada(final String uc) {
        if (uc.equals("P3")) {
            return "CP2";
        } else if (uc.equals("P4")) {
            return "CP4";
        }

        return uc;
    }

    /**
     * Gets the direccion mercancia normalizada.
     *
     * @param direccion
     *            the direccion
     * @return the direccion mercancia normalizada
     */
    private String getDireccionMercanciaNormalizada(final String direccion) {
        if (direccion.equals("1")) {
            return "E";
        } else if (direccion.equals("2")) {
            return "S";
        }

        return direccion;
    }
}
