package xeredi.integra.proceso.servicio.pesca;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoServicioVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.TipoDato;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaPesca.
 */
public final class ProcesoCargaPesca extends ProcesoTemplate {
    /** The path entrada. */
    private static String PATH_ENTRADA;

    /** The path procesado. */
    private static String PATH_PROCESADO;

    /** The path erroneo. */
    private static String PATH_ERRONEO;

    /** The Constant DATE_FORMAT. */
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    /** The Constant TIPO_IVA. */
    private static final String TIPO_IVA = "X";

    /** The Constant ESTADO_MANIFIESTO. */
    private static final String ESTADO_MANIFIESTO = "R";

    /** The Constant SUJ_PAS_SUST. */
    private static final Boolean SUJ_PAS_SUST = false;

    /** The fecha referencia. */
    private Date fechaReferencia = null;

    /** The manifiesto pesca vo. */
    private final ServicioVO manifiestoPescaVO = new ServicioVO();

    /** The partida pesca list. */
    private final List<SubservicioVO> partidaPescaList = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutar() {
        PATH_ENTRADA = ConfigurationProxy.getString(ConfigurationKey.pesca_files_entrada_home);
        PATH_PROCESADO = ConfigurationProxy.getString(ConfigurationKey.pesca_files_procesado_home);
        PATH_ERRONEO = ConfigurationProxy.getString(ConfigurationKey.pesca_files_erroneo_home);

        final TipoServicioVO tpsrVO = TipoServicioProxy.select(Entidad.MANIFIESTO_PESCA.getId());

        for (final ProcesoArchivoVO prarVO : prbtVO.getPrarEntradaList()) {
            final String pathArchivo = PATH_ENTRADA + "/" + prarVO.getNombre();

            LOG.info("Importar: " + pathArchivo);

            try (final Reader reader = new FileReader(pathArchivo)) {
                final List<String> lines = IOUtils.readLines(reader);

                busquedaCodigosMaestros(lines);

                if (prbtVO.getPrmnList().isEmpty()) {
                    buscarMaestros(fechaReferencia);
                }

                if (prbtVO.getPrmnList().isEmpty()) {
                    lecturaManifiesto(lines, prarVO.getNombre());
                }

                if (prbtVO.getPrmnList().isEmpty()) {
                    final ServicioBO srvcBO = new ServicioBO();

                    try {
                        srvcBO.insert(manifiestoPescaVO, tpsrVO, partidaPescaList);

                        final ProcesoItemVO pritSalidaVO = new ProcesoItemVO();

                        pritSalidaVO.setItemId(manifiestoPescaVO.getId());
                        prbtVO.getPritSalidaList().add(pritSalidaVO);
                    } catch (final DuplicateInstanceException ex) {
                        addError(MensajeCodigo.G_011, manifiestoPescaVO.getEtiqueta());
                    }
                }

                if (LOG.isInfoEnabled()) {
                    LOG.info(prbtVO.getPrmnList());
                }
            } catch (final IOException ex) {
                LOG.error(ex, ex);

                addError(MensajeCodigo.G_010, "archivo:" + pathArchivo + ", error:" + ex.getMessage());
            }
        }
    }

    /**
     * Busqueda codigos maestros.
     *
     * @param lines
     *            the lines
     */
    private void busquedaCodigosMaestros(final List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);

            fechaReferencia = getTokenDate(PescaKeyword.MAN_FechaRecepcion, line, i, DATE_FORMAT);
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
     * Procesar archivo.
     *
     * @param lines
     *            the lines
     * @param filename
     *            the filename
     */
    private void lecturaManifiesto(final List<String> lines, final String filename) {
        // Generacion del servicio
        final Calendar calendar = Calendar.getInstance();

        calendar.setTime(fechaReferencia);

        manifiestoPescaVO.setFref(fechaReferencia);
        manifiestoPescaVO.setAnno(String.valueOf(calendar.get(Calendar.YEAR)));

        Double pesoTotal = 0.0;
        Double importeTotal = 0.0;

        final ParametroVO tipoIvaVO = maestroMap.get(Entidad.TIPO_IVA).get(TIPO_IVA);

        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);

            manifiestoPescaVO.setSubp(getTokenMaestro(PescaKeyword.MAN_Subp, line, i, Entidad.SUBPUERTO));
            manifiestoPescaVO.setEstado(ESTADO_MANIFIESTO);

            manifiestoPescaVO.getItdtMap().get(TipoDato.BUQUE_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_Buque, line, i, Entidad.BUQUE_PESCA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.ORGA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_Vendedor, line, i, Entidad.ORGANIZACION));
            manifiestoPescaVO.getItdtMap().get(TipoDato.TIPO_OP_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_TipoOperacion, line, i, Entidad.TIPO_OPERACION_PESCA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.ORGA_2.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_ClienteAdicional, line, i, Entidad.ORGANIZACION));
            manifiestoPescaVO.getItdtMap().get(TipoDato.TIPO_MAN_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_Tipo, line, i, Entidad.TIPO_MANIFIESTO_PESCA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.SUBT_MAN_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_Subtipo, line, i, Entidad.SUBTIPO_MANIFIESTO_PESCA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.ARTE_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_Arte, line, i, Entidad.ARTE_PESCA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.ZONA_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.MAN_Zona, line, i, Entidad.ZONA_PESCA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.COD_EXEN.getId())
            .setCadena(getTokenCR(PescaKeyword.MAN_CodExencion, line, i, TipoDato.COD_EXEN));
            manifiestoPescaVO.getItdtMap().get(TipoDato.INDIC_VENTA.getId())
            .setCadena(getTokenCR(PescaKeyword.MAN_IndicadorVenta, line, i, TipoDato.INDIC_VENTA));
            manifiestoPescaVO.getItdtMap().get(TipoDato.CADENA_02.getId()).setCadena(filename);
            manifiestoPescaVO.getItdtMap().get(TipoDato.TIPO_IVA.getId()).setPrmt(tipoIvaVO);
            manifiestoPescaVO.getItdtMap().get(TipoDato.BOOLEANO_01.getId()).setCantidadEntera(SUJ_PAS_SUST ? 1L : 0L);

            final SubservicioVO ssrv = new SubservicioVO();

            pesoTotal += getTokenDouble(PescaKeyword.PAR_Peso, line, i);
            importeTotal += getTokenDouble(PescaKeyword.PAR_Importe, line, i);

            ssrv.getItdtMap().get(TipoDato.COMPRADOR_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.PAR_Comprador, line, i, Entidad.COMPRADOR_PESCA));
            ssrv.getItdtMap().get(TipoDato.ESPECIE_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.PAR_Especie, line, i, Entidad.ESPECIE_PESCA));
            ssrv.getItdtMap().get(TipoDato.PRESENT_PESCA.getId())
            .setPrmt(getTokenMaestro(PescaKeyword.PAR_Presentacion, line, i, Entidad.PRESENTACION_PESCA));
            ssrv.getItdtMap().get(TipoDato.DECIMAL_01.getId())
            .setCantidadDecimal(getTokenDouble(PescaKeyword.PAR_Cajas, line, i));
            ssrv.getItdtMap().get(TipoDato.DECIMAL_02.getId())
            .setCantidadDecimal(getTokenDouble(PescaKeyword.PAR_Peso, line, i));
            ssrv.getItdtMap().get(TipoDato.DECIMAL_04.getId())
            .setCantidadDecimal(getTokenDouble(PescaKeyword.PAR_Importe, line, i));

            ssrv.setNumero(i + 1);
            partidaPescaList.add(ssrv);
        }

        manifiestoPescaVO.getItdtMap().get(TipoDato.DECIMAL_01.getId()).setCantidadDecimal(pesoTotal);
        manifiestoPescaVO.getItdtMap().get(TipoDato.DECIMAL_02.getId()).setCantidadDecimal(importeTotal);
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
    private ParametroVO getTokenOrganizacion(final PescaKeyword keyword, final String line, final int lineNumber) {
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
            addError(MensajeCodigo.G_004, "linea:" + lineNumber + ", CR:" + tipoDato.name() + ", codigo:" + codigo);
        }

        return codigo;
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
                addError(MensajeCodigo.G_005, "linea:" + lineNumber + ", campo:" + keyword.name());
            }

            return token;
        }

        return null;
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
            addError(MensajeCodigo.G_002, "linea:" + lineNumber + ", valor:" + codigo + ", formato:" + dateFormat);

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
    private Double getTokenDouble(final PescaKeyword keyword, final String line, final int lineNumber) {
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
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.PES_CARGA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.S;
    }
}
