package xeredi.integra.model.estadistica.io;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.MensajeNivel;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class OppeFileImport.
 */
public final class OppeFileImport {

    /** The Constant DATE_PATTERN. */
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    /** The Constant SIGMA_TOKEN. */
    private static final String SIGMA_TOKEN = "SIGMA";

    /** The codigo maestro map. */
    private final Map<Entidad, Set<String>> codigoMaestroMap = new HashMap<Entidad, Set<String>>();

    /** The autp map. */
    private final Map<String, ParametroVO> autpMap = new HashMap<String, ParametroVO>();

    /** The estd list. */
    private final List<EstadisticaVO> estdList = new ArrayList<EstadisticaVO>();

    /** The prmn list. */
    private final List<ProcesoMensajeVO> prmnList;

    /** The maestro map. */
    private Map<Entidad, Map<String, ParametroVO>> maestroMap;

    /**
     * Instantiates a new oppe file import.
     *
     * @param aprmnList
     *            the aprmn list
     */
    public OppeFileImport(final List<ProcesoMensajeVO> aprmnList) {
        super();
        prmnList = aprmnList;
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
     * Gets the prmn list.
     *
     * @return the prmn list
     */
    public List<ProcesoMensajeVO> getPrmnList() {
        return prmnList;
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
     * Gets the autp map.
     *
     * @return the autp map
     */
    public Map<String, ParametroVO> getAutpMap() {
        return autpMap;
    }

    /**
     * Gets the estd list.
     *
     * @return the estd list
     */
    public List<EstadisticaVO> getEstdList() {
        return estdList;
    }

    /**
     * Verify is sigma.
     *
     * @param stream
     *            the stream
     * @return true, if successful
     */
    public boolean verifyIsSigma(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        try {
            for (final String line : IOUtils.readLines(stream)) {
                if (line.startsWith(SIGMA_TOKEN)) {
                    return true;
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EPP.name());
        }

        return false;
    }

    /**
     * Read maestros epp.
     *
     * @param stream
     *            the stream
     */
    public void readMaestrosEPP(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.AUTORIDAD_PORTUARIA, getTokenString(EstadisticaFileKeyword.Autp, line, i));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EPP.name());
        }
    }

    /**
     * Read maestros eap.
     *
     * @param stream
     *            the stream
     */
    public void readMaestrosEAP(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_CAPTURA_PESCA,
                            getTokenString(EstadisticaFileKeyword.EAP_TipoCaptura, line, i));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EAP.name());
        }
    }

    /**
     * Read maestros eav.
     *
     * @param stream
     *            the stream
     */
    public void readMaestrosEAV(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final String tipoSuministro = getTokenString(EstadisticaFileKeyword.EAV_TipoSuministro, line, i);

                    addCodigoMaestro(Entidad.TIPO_SUMINISTRO, getTipoSuministroNormalizado(tipoSuministro));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EAV.name());
        }
    }

    /**
     * Read maestros eae.
     *
     * @param stream
     *            the stream
     */
    public void readMaestrosEAE(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_BUQUE, getTokenString(EstadisticaFileKeyword.EAE_TipoBuque, line, i));
                    addCodigoMaestro(Entidad.TIPO_NAVEGACION,
                            getTokenString(EstadisticaFileKeyword.EAE_TipoNavEntrada, line, i));
                    addCodigoMaestro(Entidad.TIPO_NAVEGACION,
                            getTokenString(EstadisticaFileKeyword.EAE_TipoNavSalida, line, i));
                    addCodigoMaestro(Entidad.PAIS, getTokenString(EstadisticaFileKeyword.EAE_Bandera, line, i));
                    addCodigoMaestro(Entidad.TIPO_ACTIVIDAD,
                            getTokenString(EstadisticaFileKeyword.EAE_TipoActividad, line, i));

                    // FIXME Entidad Rango GTs
                    addCodigoMaestro(Entidad.BUQUE, EstadisticaFileKeyword.EAE_Buque.getGenericValue());
                    addCodigoMaestro(Entidad.SERVICIO_TRAFICO, EstadisticaFileKeyword.EAE_Trafico.getGenericValue());
                    addCodigoMaestro(Entidad.ACUERDO, EstadisticaFileKeyword.EAE_Acuerdo.getGenericValue());
                    addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EAE_Consignatario.getGenericValue());
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EAE.name());
        }
    }

    /**
     * Read maestros emm.
     *
     * @param stream
     *            the stream
     */
    public void readMaestrosEMM(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_OPERACION_BL,
                            getTokenString(EstadisticaFileKeyword.EMM_TipoOperacion, line, i));
                    addCodigoMaestro(Entidad.UNLOCODE, getTokenString(EstadisticaFileKeyword.EMM_UnloOrigen, line, i));
                    addCodigoMaestro(Entidad.UNLOCODE, getTokenString(EstadisticaFileKeyword.EMM_UnloDestino, line, i));
                    addCodigoMaestro(Entidad.ALINEACION,
                            "***" + getTokenString(EstadisticaFileKeyword.EMM_Alineacion, line, i));
                    addCodigoMaestro(Entidad.MERCANCIA, getTokenString(EstadisticaFileKeyword.EMM_Mercancia, line, i));
                    addCodigoMaestro(Entidad.TIPO_NAVEGACION,
                            getTokenString(EstadisticaFileKeyword.EMM_TipoNavegacion, line, i));

                    final String uc = getTokenString(EstadisticaFileKeyword.EMM_UnidadCarga, line, i);

                    addCodigoMaestro(Entidad.UNIDAD_CARGA, getUCNormalizada(uc));
                    addCodigoMaestro(Entidad.INSTALACION_ESPECIAL,
                            "**************" + getTokenString(EstadisticaFileKeyword.EMM_InstEspecial, line, i));

                    if (line.length() > EstadisticaFileKeyword.EMM_UnloCargaDescarga.getOffset()) {
                        addCodigoMaestro(Entidad.UNLOCODE,
                                getTokenString(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i));
                    } else {
                        addCodigoMaestro(Entidad.UNLOCODE,
                                EstadisticaFileKeyword.EMM_UnloCargaDescarga.getGenericValue());
                    }

                    addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EMM_Estibador.getGenericValue());
                    addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EMM_Consignatario.getGenericValue());
                    addCodigoMaestro(Entidad.BUQUE, EstadisticaFileKeyword.EMM_Buque.getGenericValue());
                    addCodigoMaestro(Entidad.SERVICIO_TRAFICO,
                            EstadisticaFileKeyword.EMM_ServicioTrafico.getGenericValue());
                    addCodigoMaestro(Entidad.ACUERDO, EstadisticaFileKeyword.EMM_Acuerdo.getGenericValue());
                    addCodigoMaestro(Entidad.TERMINAL, EstadisticaFileKeyword.EMM_Terminal.getGenericValue());
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EMM.name());
        }
    }

    /**
     * Read maestros eme.
     *
     * @param stream
     *            the stream
     * @param isSigma
     *            the is sigma
     */
    public void readMaestrosEME(final InputStream stream, final boolean isSigma) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.UNLOCODE,
                            getTokenString(EstadisticaFileKeyword.EME_UnloCargaDescarga, line, i));
                    addCodigoMaestro(Entidad.UNIDAD_CARGA,
                            getTokenString(EstadisticaFileKeyword.EME_UnidadCarga, line, i));
                    addCodigoMaestro(Entidad.REGISTRO_TIPO_BUQUE_EEE,
                            getTokenString(EstadisticaFileKeyword.EME_RegistroBuqueEEE, line, i));

                    if (isSigma) {
                        addCodigoMaestro(Entidad.GRUPO_NST,
                                getTokenString(EstadisticaFileKeyword.EME_GrupoNST, line, i));
                        addCodigoMaestro(Entidad.MERCANCIA, EstadisticaFileKeyword.EME_Mercancia.getGenericValue());
                    } else {
                        addCodigoMaestro(Entidad.MERCANCIA,
                                getTokenString(EstadisticaFileKeyword.EME_Mercancia, line, i));
                    }
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EME.name());
        }
    }

    /**
     * Read maestros emt.
     *
     * @param stream
     *            the stream
     */
    public void readMaestrosEMT(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    addCodigoMaestro(Entidad.TIPO_BUQUE_EEE,
                            getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i));
                    addCodigoMaestro(Entidad.TIPO_BUQUE_EST,
                            getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i));
                    addCodigoMaestro(Entidad.TIPO_BUQUE_GT_EEE,
                            getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE, line, i));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EMT.name());
        }
    }

    /**
     * Read epp.
     *
     * @param stream
     *            the stream
     */
    public void readEPP(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    getTokenInteger(EstadisticaFileKeyword.Anio, line, i);
                    getTokenInteger(EstadisticaFileKeyword.Mes, line, i);
                    getTokenDate(EstadisticaFileKeyword.EPP_FechaTransmision, line, i, DATE_PATTERN);

                    autpMap.put(getTokenString(EstadisticaFileKeyword.Autp, line, i),
                            getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EPP.name());
        }
    }

    /**
     * Read eap.
     *
     * @param stream
     *            the stream
     */
    public void readEAP(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.ACTIVIDAD_PESQUERA.getId());

            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estd = new EstadisticaVO();

                    estd.setEntiId(tpesVO.getId());
                    estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    estd.setSubp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    generateItdtMaestro(
                            estd,
                            TipoDato.TIPO_CAPTURA_PESCA,
                            getTokenMaestro(EstadisticaFileKeyword.EAP_TipoCaptura, line, i, Entidad.TIPO_CAPTURA_PESCA));
                    generateItdtLong(estd, TipoDato.ENTERO_01, getTokenLong(EstadisticaFileKeyword.EAP_Kilos, line, i));
                    generateItdtDouble(estd, TipoDato.DECIMAL_01,
                            getTokenDouble(EstadisticaFileKeyword.EAP_Euros, line, i) / 100);

                    estdList.add(estd);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EAP.name());
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_000, ex.getMessage());
        }
    }

    /**
     * Read eav.
     *
     * @param stream
     *            the stream
     */
    public void readEAV(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.AVITUALLAMIENTO.getId());

            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estd = new EstadisticaVO();

                    estd.setEntiId(tpesVO.getId());
                    estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    estd.setSubp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    final String tipoSuministro = getTipoSuministroNormalizado(getTokenString(
                            EstadisticaFileKeyword.EAV_TipoSuministro, line, i));

                    generateItdtMaestro(
                            estd,
                            TipoDato.TIPO_SUM,
                            getMaestro(EstadisticaFileKeyword.EAV_TipoSuministro, line, i, Entidad.TIPO_SUMINISTRO,
                                    tipoSuministro));
                    generateItdtLong(estd, TipoDato.ENTERO_01,
                            getTokenLong(EstadisticaFileKeyword.EAV_Toneladas, line, i));

                    estdList.add(estd);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EAV.name());
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_000, ex.getMessage());
        }
    }

    /**
     * Read eae.
     *
     * @param stream
     *            the stream
     */
    public void readEAE(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.AGREGACION_ESCALA.getId());

            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estd = new EstadisticaVO();

                    estd.setEntiId(tpesVO.getId());
                    estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    estd.setSubp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    // FIXME Conversion de Tipo de Buque
                    generateItdtMaestro(estd, TipoDato.TIPO_BUQUE,
                            getTokenMaestro(EstadisticaFileKeyword.EAE_TipoBuque, line, i, Entidad.TIPO_BUQUE));
                    generateItdtMaestro(
                            estd,
                            TipoDato.TIPO_NAV,
                            getTokenMaestro(EstadisticaFileKeyword.EAE_TipoNavEntrada, line, i, Entidad.TIPO_NAVEGACION));
                    generateItdtMaestro(estd, TipoDato.TIPO_NAV_2,
                            getTokenMaestro(EstadisticaFileKeyword.EAE_TipoNavSalida, line, i, Entidad.TIPO_NAVEGACION));
                    generateItdtMaestro(estd, TipoDato.PAIS,
                            getTokenMaestro(EstadisticaFileKeyword.EAE_Bandera, line, i, Entidad.PAIS));
                    generateItdtMaestro(estd, TipoDato.TIPO_ACT,
                            getTokenMaestro(EstadisticaFileKeyword.EAE_TipoActividad, line, i, Entidad.TIPO_ACTIVIDAD));
                    generateItdtLong(estd, TipoDato.ENTERO_01,
                            getTokenLong(EstadisticaFileKeyword.EAE_NumEscalas, line, i));
                    generateItdtLong(estd, TipoDato.ENTERO_02, getTokenLong(EstadisticaFileKeyword.EAE_NumGTs, line, i));

                    estdList.add(estd);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EAE.name());
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_000, ex.getMessage());
        }
    }

    /**
     * Read emm.
     *
     * @param stream
     *            the stream
     */
    public void readEMM(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.MOVIMIENTO_MERCANCIA.getId());

            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estd = new EstadisticaVO();

                    estd.setEntiId(tpesVO.getId());
                    estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    estd.setSubp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    generateItdtMaestro(
                            estd,
                            TipoDato.TIPO_OP_BL,
                            getTokenMaestro(EstadisticaFileKeyword.EMM_TipoOperacion, line, i,
                                    Entidad.TIPO_OPERACION_BL));
                    generateItdtMaestro(estd, TipoDato.UNLOCODE_3,
                            getTokenMaestro(EstadisticaFileKeyword.EMM_UnloOrigen, line, i, Entidad.UNLOCODE));
                    generateItdtMaestro(estd, TipoDato.UNLOCODE_4,
                            getTokenMaestro(EstadisticaFileKeyword.EMM_UnloDestino, line, i, Entidad.UNLOCODE));

                    final String alineacion = "***" + getTokenString(EstadisticaFileKeyword.EMM_Alineacion, line, i);

                    generateItdtMaestro(estd, TipoDato.ALIN,
                            getMaestro(EstadisticaFileKeyword.EMM_Alineacion, line, i, Entidad.ALINEACION, alineacion));
                    generateItdtMaestro(estd, TipoDato.MERCANCIA,
                            getTokenMaestro(EstadisticaFileKeyword.EMM_Mercancia, line, i, Entidad.MERCANCIA));
                    generateItdtMaestro(
                            estd,
                            TipoDato.TIPO_NAV,
                            getTokenMaestro(EstadisticaFileKeyword.EMM_TipoNavegacion, line, i, Entidad.TIPO_NAVEGACION));

                    generateItdtLong(estd, TipoDato.BOOLEANO_01,
                            getTokenString(EstadisticaFileKeyword.EMM_Roro, line, i).equals("N") ? 0L : 1L);

                    final String uc = getUCNormalizada(getTokenString(EstadisticaFileKeyword.EMM_UnidadCarga, line, i));

                    generateItdtMaestro(estd, TipoDato.UNIDAD_CARGA,
                            getMaestro(EstadisticaFileKeyword.EMM_UnidadCarga, line, i, Entidad.UNIDAD_CARGA, uc));

                    final String instalacionEsp = "**************"
                            + getTokenString(EstadisticaFileKeyword.EMM_InstEspecial, line, i);

                    generateItdtMaestro(
                            estd,
                            TipoDato.INST_ESP,
                            getMaestro(EstadisticaFileKeyword.EMM_InstEspecial, line, i, Entidad.INSTALACION_ESPECIAL,
                                    instalacionEsp));

                    generateItdtCadena(estd, TipoDato.TIPO_TRANSPORTE,
                            getTokenCR(EstadisticaFileKeyword.EMM_TipoTransporte, line, i, TipoDato.TIPO_TRANSPORTE));
                    generateItdtDouble(estd, TipoDato.DECIMAL_01,
                            getTokenDouble(EstadisticaFileKeyword.EMM_Toneladas, line, i));
                    generateItdtLong(estd, TipoDato.ENTERO_01,
                            getTokenLong(EstadisticaFileKeyword.EMM_Unidades, line, i));
                    generateItdtDouble(estd, TipoDato.DECIMAL_02,
                            getTokenDouble(EstadisticaFileKeyword.EMM_Teus, line, i));

                    // FIXME Acabar
                    ParametroVO unloCargaDescargaVO = null;

                    if (line.length() > EstadisticaFileKeyword.EMM_UnloCargaDescarga.getOffset()) {
                        unloCargaDescargaVO = getTokenMaestro(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i,
                                Entidad.UNLOCODE);
                    } else {
                        unloCargaDescargaVO = getTokenMaestroGeneric(EstadisticaFileKeyword.EMM_UnloCargaDescarga,
                                line, i, Entidad.UNLOCODE);
                    }

                    if (unloCargaDescargaVO != null) {
                        final String tipoOperacion = getTokenString(EstadisticaFileKeyword.EMM_TipoOperacion, line, i);
                        final ParametroVO autpUnlo = estd.getSubp().getItdtMap().get(TipoDato.UNLOCODE.getId())
                                .getPrmt();

                        if ("TE".equals(tipoOperacion) || tipoOperacion.startsWith("E")) {
                            generateItdtMaestro(estd, TipoDato.UNLOCODE, autpUnlo);
                            generateItdtMaestro(estd, TipoDato.UNLOCODE_2, unloCargaDescargaVO);
                        } else {
                            generateItdtMaestro(estd, TipoDato.UNLOCODE, unloCargaDescargaVO);
                            generateItdtMaestro(estd, TipoDato.UNLOCODE_2, autpUnlo);
                        }
                    }

                    estdList.add(estd);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EMM.name());
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_000, ex.getMessage());
        }
    }

    /**
     * Read eme.
     *
     * @param stream
     *            the stream
     * @param isSigma
     *            the is sigma
     */
    public void readEME(final InputStream stream, final boolean isSigma) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.MOVIMIENTO_MERCANCIA_EEE.getId());

            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estd = new EstadisticaVO();

                    estd.setEntiId(tpesVO.getId());
                    estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    estd.setSubp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    generateItdtMaestro(estd, TipoDato.UNLOCODE,
                            getTokenMaestro(EstadisticaFileKeyword.EME_UnloCargaDescarga, line, i, Entidad.UNLOCODE));
                    generateItdtMaestro(estd, TipoDato.UNIDAD_CARGA,
                            getTokenMaestro(EstadisticaFileKeyword.EME_UnidadCarga, line, i, Entidad.UNIDAD_CARGA));

                    if (isSigma) {
                        generateItdtMaestro(estd, TipoDato.GRUPO_NST,
                                getTokenMaestro(EstadisticaFileKeyword.EME_GrupoNST, line, i, Entidad.GRUPO_NST));
                        generateItdtMaestro(
                                estd,
                                TipoDato.MERCANCIA,
                                getTokenMaestroGeneric(EstadisticaFileKeyword.EME_Mercancia, line, i, Entidad.MERCANCIA));
                    } else {
                        final ParametroVO mercanciaVO = getTokenMaestro(EstadisticaFileKeyword.EME_Mercancia, line, i,
                                Entidad.MERCANCIA);

                        if (mercanciaVO != null) {
                            generateItdtMaestro(estd, TipoDato.MERCANCIA, mercanciaVO);
                            generateItdtMaestro(estd, TipoDato.GRUPO_NST,
                                    mercanciaVO.getItdtMap().get(TipoDato.GRUPO_NST.getId()).getPrmt());
                        }
                    }

                    generateItdtMaestro(
                            estd,
                            TipoDato.REG_TBUQUE_EEE,
                            getTokenMaestro(EstadisticaFileKeyword.EME_RegistroBuqueEEE, line, i,
                                    Entidad.REGISTRO_TIPO_BUQUE_EEE));

                    final String direccionMerc = getDireccionMercanciaNormalizada(getTokenString(
                            EstadisticaFileKeyword.EME_DireccionTransporte, line, i));

                    generateItdtCadena(estd, TipoDato.DIREC_MERC, direccionMerc);
                    generateItdtDouble(estd, TipoDato.DECIMAL_01,
                            getTokenDouble(EstadisticaFileKeyword.EME_Toneladas, line, i));
                    generateItdtLong(estd, TipoDato.ENTERO_01,
                            getTokenLong(EstadisticaFileKeyword.EME_Pasajeros, line, i));
                    generateItdtLong(estd, TipoDato.ENTERO_02,
                            getTokenLong(EstadisticaFileKeyword.EME_UCLlenas, line, i));
                    generateItdtLong(estd, TipoDato.ENTERO_03,
                            getTokenLong(EstadisticaFileKeyword.EME_UCVacias, line, i));

                    if (line.length() > EstadisticaFileKeyword.EME_Roro.getOffset()) {
                        generateItdtLong(estd, TipoDato.BOOLEANO_01,
                                getTokenString(EstadisticaFileKeyword.EME_Roro, line, i).equals("N") ? 0L : 1L);
                    }

                    if (isSigma) {
                        generateItdtLong(estd, TipoDato.ENTERO_04,
                                getTokenLong(EstadisticaFileKeyword.EME_PasajerosCrucero, line, i));
                        generateItdtLong(estd, TipoDato.ENTERO_05,
                                getTokenLong(EstadisticaFileKeyword.EME_PasajerosInicioFinLinea, line, i));
                    }
                    // FIXME Acabar

                    estdList.add(estd);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EME.name());
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_000, ex.getMessage());
        }
    }

    /**
     * Read emt.
     *
     * @param stream
     *            the stream
     */
    public void readEMT(final InputStream stream) {
        Preconditions.checkNotNull(stream);

        int i = 0;

        try {
            final TipoEstadisticaVO tpesVO = TipoEstadisticaProxy.select(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId());

            for (final String line : IOUtils.readLines(stream)) {
                i++;

                if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                    final EstadisticaVO estd = new EstadisticaVO();

                    estd.setEntiId(tpesVO.getId());
                    estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                    estd.setSubp(getTokenMaestro(EstadisticaFileKeyword.Autp, line, i, Entidad.AUTORIDAD_PORTUARIA));

                    final String tipoBuque = getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i);

                    ParametroVO tipoBuqueEst = null;

                    if (maestroMap.get(Entidad.TIPO_BUQUE_EST).containsKey(tipoBuque)) {
                        tipoBuqueEst = getMaestro(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i,
                                Entidad.TIPO_BUQUE_EST, tipoBuque);
                    }

                    if (tipoBuqueEst != null) {
                        generateItdtMaestro(estd, TipoDato.TIPO_BUQUE_EEE,
                                tipoBuqueEst.getItdtMap().get(TipoDato.TIPO_BUQUE_EEE.getId()).getPrmt());
                    } else {
                        generateItdtMaestro(
                                estd,
                                TipoDato.TIPO_BUQUE_EEE,
                                getTokenMaestro(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i,
                                        Entidad.TIPO_BUQUE_EEE));
                    }

                    generateItdtMaestro(
                            estd,
                            TipoDato.TIPO_BUQUE_GT_EEE,
                            getTokenMaestro(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE, line, i,
                                    Entidad.TIPO_BUQUE_GT_EEE));
                    generateItdtLong(estd, TipoDato.ENTERO_01,
                            getTokenLong(EstadisticaFileKeyword.EMT_NumeroBuques, line, i));
                    generateItdtLong(estd, TipoDato.ENTERO_02,
                            getTokenLong(EstadisticaFileKeyword.EMT_NumeroGTs, line, i));

                    estdList.add(estd);
                }
            }
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, EstadisticaFileType.EMT.name());
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_000, ex.getMessage());
        }
    }

    /**
     * Generate itdt long.
     *
     * @param estd
     *            the estd
     * @param tpdt
     *            the tpdt
     * @param value
     *            the value
     */
    private void generateItdtLong(final EstadisticaVO estd, final TipoDato tpdt, final Long value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdt.getId());
        itdt.setCantidadEntera(value);

        estd.getItdtMap().put(tpdt.getId(), itdt);
    }

    /**
     * Generate itdt cadena.
     *
     * @param estd
     *            the estd
     * @param tpdt
     *            the tpdt
     * @param value
     *            the value
     */
    private void generateItdtCadena(final EstadisticaVO estd, final TipoDato tpdt, final String value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdt.getId());
        itdt.setCadena(value);

        estd.getItdtMap().put(tpdt.getId(), itdt);
    }

    /**
     * Generate itdt double.
     *
     * @param estd
     *            the estd
     * @param tpdt
     *            the tpdt
     * @param value
     *            the value
     */
    private void generateItdtDouble(final EstadisticaVO estd, final TipoDato tpdt, final Double value) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdt.getId());
        itdt.setCantidadDecimal(value);

        estd.getItdtMap().put(tpdt.getId(), itdt);
    }

    /**
     * Generate itdt maestro.
     *
     * @param estd
     *            the estd
     * @param tpdt
     *            the tpdt
     * @param prmt
     *            the prmt
     */
    private void generateItdtMaestro(final EstadisticaVO estd, final TipoDato tpdt, final ParametroVO prmt) {
        final ItemDatoVO itdt = new ItemDatoVO();

        itdt.setTpdtId(tpdt.getId());
        itdt.setPrmt(prmt);

        estd.getItdtMap().put(tpdt.getId(), itdt);
    }

    /**
     * Adds the codigo maestro.
     *
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     */
    private void addCodigoMaestro(final Entidad entidad, final String codigo) {
        if (!codigoMaestroMap.containsKey(entidad)) {
            codigoMaestroMap.put(entidad, new HashSet<String>());
        }

        if (codigo != null && !codigo.isEmpty()) {
            codigoMaestroMap.get(entidad).add(codigo);
        }
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
    private String getTokenCR(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final TipoDato tipoDato) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        try {
            final TipoDatoVO tpdtVO = TipoDatoProxy.select(tipoDato.getId());

            if (!tpdtVO.getCdrfCodeSet().contains(codigo)) {
                addError(MensajeCodigo.G_004, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                        + ", CR: " + tipoDato.name() + ", codigo: " + codigo);
            }
        } catch (final InstanceNotFoundException ex) {
            throw new Error(ex);
        }

        return codigo;
    }

    /**
     * Adds the mensaje.
     *
     * @param codigo
     *            the codigo
     * @param mensaje
     *            the mensaje
     */
    private void addError(final MensajeCodigo codigo, final String mensaje) {
        addMensaje(codigo, MensajeNivel.E, mensaje);
    }

    /**
     * Adds the warning.
     *
     * @param codigo
     *            the codigo
     * @param mensaje
     *            the mensaje
     */
    private void addWarning(final MensajeCodigo codigo, final String mensaje) {
        addMensaje(codigo, MensajeNivel.W, mensaje);
    }

    /**
     * Adds the info.
     *
     * @param codigo
     *            the codigo
     * @param mensaje
     *            the mensaje
     */
    private void addInfo(final MensajeCodigo codigo, final String mensaje) {
        addMensaje(codigo, MensajeNivel.I, mensaje);
    }

    /**
     * Adds the mensaje.
     *
     * @param codigo
     *            the codigo
     * @param nivel
     *            the nivel
     * @param mensaje
     *            the mensaje
     */
    private final void addMensaje(final MensajeCodigo codigo, final MensajeNivel nivel, final String mensaje) {
        final ProcesoMensajeVO prmnVO = new ProcesoMensajeVO();

        prmnVO.setCodigo(codigo);
        prmnVO.setNivel(nivel);
        prmnVO.setMensaje(mensaje);

        prmnList.add(prmnVO);
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
     * Gets the UC normalizada.
     *
     * @param uc
     *            the uc
     * @return the UC normalizada
     */
    private String getUCNormalizada(final String uc) {
        if ("P3".equals(uc)) {
            return "CP2";
        } else if ("P4".equals(uc)) {
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
        if ("1".equals(direccion)) {
            return "E";
        } else if ("2".equals(direccion)) {
            return "S";
        }

        return direccion;
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
    private ParametroVO getTokenMaestro(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            addError(MensajeCodigo.G_001, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", entidad: " + entidad.name() + ", codigo: " + codigo);

            return null;
        }

        return maestroMap.get(entidad).get(codigo);
    }

    /**
     * Gets the maestro.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     * @return the maestro
     */
    private ParametroVO getMaestro(final EstadisticaFileKeyword keyword, final String line, final int lineNumber,
            final Entidad entidad, final String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (!maestroMap.containsKey(entidad) || !maestroMap.get(entidad).containsKey(codigo)) {
            addError(MensajeCodigo.G_001, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", entidad: " + entidad.name() + ", codigo: " + codigo);

            return null;
        }

        return maestroMap.get(entidad).get(codigo);
    }

    /**
     * Gets the token maestro generic.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @return the token maestro generic
     */
    private ParametroVO getTokenMaestroGeneric(final EstadisticaFileKeyword keyword, final String line,
            final int lineNumber, final Entidad entidad) {
        return maestroMap.get(entidad).get(keyword.getGenericValue());
    }

}
