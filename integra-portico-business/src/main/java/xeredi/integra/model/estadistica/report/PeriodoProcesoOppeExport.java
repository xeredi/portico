package xeredi.integra.model.estadistica.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.bo.EstadisticaFileKeyword;
import xeredi.integra.model.estadistica.bo.EstadisticaFileType;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoOppeExport.
 */
public final class PeriodoProcesoOppeExport {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PeriodoProcesoOppeExport.class);

    /** The Constant DECIMAL_FORMAT. */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#################0.00");

    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The subport codes. */
    private final Set<String> subportCodes = new HashSet<String>();

    /**
     * Export.
     *
     * @param peprVO
     *            the pepr vo
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void export(final PeriodoProcesoVO peprVO, final ZipOutputStream stream) throws IOException,
    InstanceNotFoundException {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(peprVO.getAutp());
        Preconditions.checkNotNull(peprVO.getAutp().getId());
        Preconditions.checkNotNull(peprVO.getAnio());
        Preconditions.checkNotNull(peprVO.getMes());

        final Date exportDate = new Date();
        final EstadisticaBO estdBO = new EstadisticaBO();
        final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();
        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        peprCriterioVO.setAutpId(peprVO.getAutp().getId());
        peprCriterioVO.setAnio(peprVO.getAnio());
        peprCriterioVO.setMes(peprVO.getMes());

        estdCriterioVO.setPepr(peprCriterioVO);

        {
            estdCriterioVO.setEntiId(Entidad.ACTIVIDAD_PESQUERA.getId());

            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(estdCriterioVO.getEntiId());
            final List<EstadisticaVO> estdList = estdBO.selectList(estdCriterioVO);

            stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EAP)));
            stream.write(generarEAP(estdList, tpesVO).getBytes());
            stream.closeEntry();
        }

        {
            estdCriterioVO.setEntiId(Entidad.AVITUALLAMIENTO.getId());

            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(estdCriterioVO.getEntiId());
            final List<EstadisticaVO> estdList = estdBO.selectList(estdCriterioVO);

            stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EAV)));
            stream.write(generarEAV(estdList, tpesVO).getBytes());
            stream.closeEntry();
        }

        {
            estdCriterioVO.setEntiId(Entidad.AGREGACION_ESCALA.getId());

            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(estdCriterioVO.getEntiId());
            final List<EstadisticaVO> estdList = estdBO.selectList(estdCriterioVO);

            stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EAE)));
            stream.write(generarEAE(estdList, tpesVO).getBytes());
            stream.closeEntry();
        }

        {
            estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_MERCANCIA.getId());

            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(estdCriterioVO.getEntiId());
            final List<EstadisticaVO> estdList = estdBO.selectList(estdCriterioVO);

            stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EMM)));
            stream.write(generarEMM(estdList, tpesVO).getBytes());
            stream.closeEntry();
        }

        {
            estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_MERCANCIA_EEE.getId());

            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(estdCriterioVO.getEntiId());
            final List<EstadisticaVO> estdList = estdBO.selectList(estdCriterioVO);

            stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EME)));
            stream.write(generarEME(estdList, tpesVO).getBytes());
            stream.closeEntry();
        }

        {
            estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId());

            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(estdCriterioVO.getEntiId());
            final List<EstadisticaVO> estdList = estdBO.selectList(estdCriterioVO);

            stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EMT)));
            stream.write(generarEMT(estdList, tpesVO).getBytes());
            stream.closeEntry();
        }

        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EPP)));
        stream.write(generarEPP(peprVO, exportDate).getBytes());
        stream.closeEntry();
    }

    /**
     * Generar epp.
     *
     * @param peprVO
     *            the pepr vo
     * @param exportDate
     *            the export date
     * @return the string
     */
    private String generarEPP(final PeriodoProcesoVO peprVO, final Date exportDate) {
        Preconditions.checkNotNull(peprVO);

        final StringBuffer buffer = new StringBuffer();
        for (final String subportCode : subportCodes) {
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, peprVO.getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, peprVO.getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, subportCode));

            buffer.append(DATE_FORMAT.format(exportDate));

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Generar eap.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @return the string
     */
    private String generarEAP(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);

        final StringBuffer buffer = new StringBuffer();
        for (final EstadisticaVO estdVO : estdList) {
            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAP_TipoCaptura,
                    estdVO.getItdtMap().get(TipoDato.TIPO_CAPTURA_PESCA.getId()).getPrmt()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EAP_Kilos,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EAP_Euros,
                    estdVO.getItdtMap().get(TipoDato.DECIMAL_01.getId()).getCantidadDecimal() * 100));

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Generar eav.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @return the string
     */
    private String generarEAV(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);

        final StringBuffer buffer = new StringBuffer();
        for (final EstadisticaVO estdVO : estdList) {
            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAV_TipoSuministro,
                    estdVO.getItdtMap().get(TipoDato.TIPO_SUM.getId()).getPrmt()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EAV_Toneladas,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Generar eae.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @return the string
     */
    private String generarEAE(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);

        final StringBuffer buffer = new StringBuffer();
        for (final EstadisticaVO estdVO : estdList) {
            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            // FIXME Conversion de Tipo de Buque
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAE_TipoBuque,
                    estdVO.getItdtMap().get(TipoDato.TIPO_BUQUE.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAE_TipoNavEntrada,
                    estdVO.getItdtMap().get(TipoDato.TIPO_NAV.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAE_TipoNavSalida,
                    estdVO.getItdtMap().get(TipoDato.TIPO_NAV_2.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAE_Bandera,
                    estdVO.getItdtMap().get(TipoDato.PAIS.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAE_TipoActividad,
                    estdVO.getItdtMap().get(TipoDato.TIPO_ACT.getId()).getPrmt()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EAE_NumEscalas,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EAE_NumGTs,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_02.getId()).getCantidadEntera()));

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Generar emm.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @return the string
     */
    private String generarEMM(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);

        final StringBuffer buffer = new StringBuffer();
        for (final EstadisticaVO estdVO : estdList) {
            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            final String tipoOperacionBl = getTokenPrmt(EstadisticaFileKeyword.EMM_TipoOperacion, estdVO.getItdtMap()
                    .get(TipoDato.TIPO_OP_BL.getId()).getPrmt());

            buffer.append(tipoOperacionBl);
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_UnloOrigen,
                    estdVO.getItdtMap().get(TipoDato.UNLOCODE_3.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_UnloDestino,
                    estdVO.getItdtMap().get(TipoDato.UNLOCODE_4.getId()).getPrmt()));

            // TODO Quitar * a la alineacion
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_Alineacion,
                    estdVO.getItdtMap().get(TipoDato.ALIN.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_Mercancia,
                    estdVO.getItdtMap().get(TipoDato.MERCANCIA.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_TipoNavegacion,
                    estdVO.getItdtMap().get(TipoDato.TIPO_NAV.getId()).getPrmt()));
            buffer.append(getTokenBoolean(EstadisticaFileKeyword.EMM_Roro,
                    estdVO.getItdtMap().get(TipoDato.BOOLEANO_01.getId()).getCantidadEntera()));

            // TODO Desnormalizar UC
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_UnidadCarga,
                    estdVO.getItdtMap().get(TipoDato.UNIDAD_CARGA.getId()).getPrmt()));

            final ParametroVO prmtIesp = estdVO.getItdtMap().get(TipoDato.INST_ESP.getId()).getPrmt();

            buffer.append(getTokenBoolean(EstadisticaFileKeyword.EMM_InstEspecial,
                    prmtIesp == null || prmtIesp.getParametro() == null ? 0L : 1L));

            buffer.append(getTokenString(EstadisticaFileKeyword.EMM_TipoTransporte,
                    estdVO.getItdtMap().get(TipoDato.TIPO_TRANSPORTE.getId()).getCadena()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EMM_Toneladas,
                    estdVO.getItdtMap().get(TipoDato.DECIMAL_01.getId()).getCantidadDecimal()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EMM_Unidades,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));

            // . en vez de ,
            buffer.append(getTokenDouble(EstadisticaFileKeyword.EMM_Teus,
                    estdVO.getItdtMap().get(TipoDato.DECIMAL_02.getId()).getCantidadDecimal()));

            if ("TE".equals(tipoOperacionBl) || "E".equals(tipoOperacionBl)) {
                buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_UnloCargaDescarga,
                        estdVO.getItdtMap().get(TipoDato.UNLOCODE_2.getId()).getPrmt()));
            } else {
                buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMM_UnloCargaDescarga,
                        estdVO.getItdtMap().get(TipoDato.UNLOCODE.getId()).getPrmt()));
            }

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Generar eme.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @return the string
     */
    private String generarEME(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);

        final StringBuffer buffer = new StringBuffer();
        for (final EstadisticaVO estdVO : estdList) {
            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EME_UnloCargaDescarga,
                    estdVO.getItdtMap().get(TipoDato.UNLOCODE.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EME_UnidadCarga,
                    estdVO.getItdtMap().get(TipoDato.UNIDAD_CARGA.getId()).getPrmt()));

            // TODO Ver si hay que pasar la mercancia
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EME_Mercancia,
                    estdVO.getItdtMap().get(TipoDato.GRUPO_NST.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EME_RegistroBuqueEEE,
                    estdVO.getItdtMap().get(TipoDato.REG_TBUQUE_EEE.getId()).getPrmt()));

            final String direccion = getTokenString(EstadisticaFileKeyword.EME_DireccionTransporte, estdVO.getItdtMap()
                    .get(TipoDato.DIREC_MERC.getId()).getCadena());

            buffer.append("E".equals(direccion) ? "1" : "2");

            buffer.append(getTokenLong(EstadisticaFileKeyword.EME_Toneladas,
                    estdVO.getItdtMap().get(TipoDato.DECIMAL_01.getId()).getCantidadDecimal()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EME_Pasajeros,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EME_UCLlenas,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_02.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EME_UCVacias,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_03.getId()).getCantidadEntera()));
            buffer.append(getTokenBoolean(EstadisticaFileKeyword.EME_Roro,
                    estdVO.getItdtMap().get(TipoDato.BOOLEANO_01.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EME_PasajerosCrucero,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_04.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EME_PasajerosInicioFinLinea,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_05.getId()).getCantidadEntera()));

            // TODO Acabar

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Generar emt.
     *
     * @param estdList
     *            the estd list
     * @param tpesVO
     *            the tpes vo
     * @return the string
     */
    private String generarEMT(final List<EstadisticaVO> estdList, final TipoEstadisticaVO tpesVO) {
        Preconditions.checkNotNull(estdList);
        Preconditions.checkNotNull(tpesVO);

        final StringBuffer buffer = new StringBuffer();
        for (final EstadisticaVO estdVO : estdList) {
            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE,
                    estdVO.getItdtMap().get(TipoDato.TIPO_BUQUE_EEE.getId()).getPrmt()));
            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE,
                    estdVO.getItdtMap().get(TipoDato.TIPO_BUQUE_GT_EEE.getId()).getPrmt()));

            buffer.append(getTokenLong(EstadisticaFileKeyword.EMT_NumeroBuques,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EMT_NumeroGTs,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_02.getId()).getCantidadEntera()));

            buffer.append('\n');
        }

        return buffer.toString();
    }

    /**
     * Gets the token integer.
     *
     * @param keyword
     *            the keyword
     * @param value
     *            the value
     * @return the token integer
     */
    private String getTokenInteger(final EstadisticaFileKeyword keyword, final Integer value) {
        return StringUtils.leftPad(value == null ? "" : value.toString(), keyword.getLength(), '0');
    }

    /**
     * Gets the token long.
     *
     * @param keyword
     *            the keyword
     * @param value
     *            the value
     * @return the token long
     */
    private String getTokenLong(final EstadisticaFileKeyword keyword, final Long value) {
        return StringUtils.leftPad(value == null ? "" : value.toString(), keyword.getLength(), '0');
    }

    /**
     * Gets the token long.
     *
     * @param keyword
     *            the keyword
     * @param value
     *            the value
     * @return the token long
     */
    private String getTokenLong(final EstadisticaFileKeyword keyword, final Double value) {
        return StringUtils.leftPad(value == null ? "" : String.valueOf(value.longValue()), keyword.getLength(), '0');
    }

    /**
     * Gets the token double.
     *
     * @param keyword
     *            the keyword
     * @param value
     *            the value
     * @return the token double
     */
    private String getTokenDouble(final EstadisticaFileKeyword keyword, final Double value) {
        return StringUtils.leftPad(value == null ? "" : DECIMAL_FORMAT.format(value), keyword.getLength(), '0');
    }

    /**
     * Gets the token boolean.
     *
     * @param keyword
     *            the keyword
     * @param value
     *            the value
     * @return the token boolean
     */
    private String getTokenBoolean(final EstadisticaFileKeyword keyword, final Long value) {
        return value == null || value == 0 ? "N" : "S";
    }

    /**
     * Gets the token string.
     *
     * @param keyword
     *            the keyword
     * @param value
     *            the value
     * @return the token string
     */
    private String getTokenString(final EstadisticaFileKeyword keyword, final String value) {
        return StringUtils.rightPad(value == null ? "" : value, keyword.getLength(), ' ');
    }

    /**
     * Gets the token prmt.
     *
     * @param keyword
     *            the keyword
     * @param prmtVO
     *            the prmt vo
     * @return the token prmt
     */
    private String getTokenPrmt(final EstadisticaFileKeyword keyword, final ParametroVO prmtVO) {
        return getTokenString(keyword, prmtVO == null ? null : prmtVO.getParametro());
    }

    /**
     * Gets the filename.
     *
     * @param peprVO
     *            the pepr vo
     * @param fileType
     *            the file type
     * @return the filename
     */
    private String getFilename(final PeriodoProcesoVO peprVO, final EstadisticaFileType fileType) {
        return peprVO.getAutp().getParametro() + peprVO.getAnio()
                + StringUtils.leftPad(peprVO.getMes().toString(), 2, '0') + '.' + fileType.name();
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        LOG.info("Start");

        final PeriodoProcesoOppeExport export = new PeriodoProcesoOppeExport();
        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        final List<PeriodoProcesoVO> peprList = peprBO.selectList(peprCriterioVO);

        for (final PeriodoProcesoVO peprVO : peprList) {
            try (final ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream("/TEMP/"
                    + export.getFilename(peprVO, EstadisticaFileType.zip)))) {
                export.export(peprVO, outputStream);
            } catch (final Throwable ex) {
                LOG.fatal(ex, ex);
            }
        }

        LOG.info("End");
    }
}
