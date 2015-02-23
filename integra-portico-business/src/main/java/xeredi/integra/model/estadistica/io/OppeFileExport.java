package xeredi.integra.model.estadistica.io;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.TipoDato;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class OppeFileExport.
 */
public final class OppeFileExport {

    /** The Constant DECIMAL_FORMAT. */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#################0.00");

    /** The Constant DATE_FORMAT. */
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /** The subport codes. */
    private final Set<String> subportCodes = new HashSet<String>();

    /**
     * Gets the subport codes.
     *
     * @return the subport codes
     */
    public Set<String> getSubportCodes() {
        return subportCodes;
    }

    /**
     * Generar epp.
     *
     * @param stream
     *            the stream
     * @param peprVO
     *            the pepr vo
     * @param exportDate
     *            the export date
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEPP(final OutputStream stream, final PeriodoProcesoVO peprVO, final Date exportDate)
            throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(exportDate);

        for (final String subportCode : subportCodes) {
            final StringBuffer buffer = new StringBuffer();

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, peprVO.getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, peprVO.getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, subportCode));

            buffer.append(DATE_FORMAT.format(exportDate));

            buffer.append('\n');

            stream.write(buffer.toString().getBytes());
        }
    }

    /**
     * Generar eap.
     *
     * @param stream
     *            the stream
     * @param estdList
     *            the estd list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEAP(final OutputStream stream, final List<EstadisticaVO> estdList) throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(estdList);

        for (final EstadisticaVO estdVO : estdList) {
            final StringBuffer buffer = new StringBuffer();

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

            stream.write(buffer.toString().getBytes());
        }
    }

    /**
     * Generar eav.
     *
     * @param stream
     *            the stream
     * @param estdList
     *            the estd list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEAV(final OutputStream stream, final List<EstadisticaVO> estdList) throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(estdList);

        for (final EstadisticaVO estdVO : estdList) {
            final StringBuffer buffer = new StringBuffer();

            subportCodes.add(estdVO.getSubp().getParametro());

            buffer.append(getTokenInteger(EstadisticaFileKeyword.Anio, estdVO.getPepr().getAnio()));
            buffer.append(getTokenInteger(EstadisticaFileKeyword.Mes, estdVO.getPepr().getMes()));
            buffer.append(getTokenString(EstadisticaFileKeyword.Autp, estdVO.getSubp().getParametro()));

            buffer.append(getTokenPrmt(EstadisticaFileKeyword.EAV_TipoSuministro,
                    estdVO.getItdtMap().get(TipoDato.TIPO_SUM.getId()).getPrmt()));
            buffer.append(getTokenLong(EstadisticaFileKeyword.EAV_Toneladas,
                    estdVO.getItdtMap().get(TipoDato.ENTERO_01.getId()).getCantidadEntera()));

            buffer.append('\n');

            stream.write(buffer.toString().getBytes());
        }
    }

    /**
     * Generar eae.
     *
     * @param stream
     *            the stream
     * @param estdList
     *            the estd list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEAE(final OutputStream stream, final List<EstadisticaVO> estdList) throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(estdList);

        for (final EstadisticaVO estdVO : estdList) {
            final StringBuffer buffer = new StringBuffer();

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

            stream.write(buffer.toString().getBytes());
        }
    }

    /**
     * Generar emm.
     *
     * @param stream
     *            the stream
     * @param estdList
     *            the estd list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEMM(final OutputStream stream, final List<EstadisticaVO> estdList) throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(estdList);

        for (final EstadisticaVO estdVO : estdList) {
            final StringBuffer buffer = new StringBuffer();

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

            stream.write(buffer.toString().getBytes());
        }
    }

    /**
     * Generar eme.
     *
     * @param stream
     *            the stream
     * @param estdList
     *            the estd list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEME(final OutputStream stream, final List<EstadisticaVO> estdList) throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(estdList);

        for (final EstadisticaVO estdVO : estdList) {
            final StringBuffer buffer = new StringBuffer();

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

            stream.write(buffer.toString().getBytes());
        }
    }

    /**
     * Generar emt.
     *
     * @param stream
     *            the stream
     * @param estdList
     *            the estd list
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void generarEMT(final OutputStream stream, final List<EstadisticaVO> estdList) throws IOException {
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(estdList);

        for (final EstadisticaVO estdVO : estdList) {
            final StringBuffer buffer = new StringBuffer();

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

            stream.write(buffer.toString().getBytes());
        }
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

}
