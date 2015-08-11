package xeredi.integra.model.estadistica.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.vo.ItemDatoVO;
import xeredi.integra.model.comun.vo.PuertoVO;
import xeredi.integra.model.estadistica.vo.EstadisticaVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoDatoProxy;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaDetailVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class OppeFileImport.
 */
public final class OppeFileImport {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(OppeFileImport.class);

    /** The Constant DATE_PATTERN. */
    private static final String DATE_PATTERN = "dd/MM/yyyy";

    /** The Constant SIGMA_TOKEN. */
    private static final String SIGMA_TOKEN = "SIGMA";

    /** The autp map. */
    private Map<String, PuertoVO> prtoMap;

    /** The estd list. */
    private final List<EstadisticaVO> estdList = new ArrayList<EstadisticaVO>();

    /** The prmn list. */
    private final ProcesoTemplate proceso;

    /**
     * Instantiates a new oppe file import.
     *
     * @param aproceso
     *            the aproceso
     */
    public OppeFileImport(final ProcesoTemplate aproceso) {
        super();
        proceso = aproceso;
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
     * @param lines
     *            the lines
     * @return true, if successful
     */
    public boolean verifyIsSigma(final List<String> lines) {
        for (final String line : lines) {
            if (line.startsWith(SIGMA_TOKEN)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Read maestros epp.
     *
     * @param lines
     *            the lines
     */
    public void readMaestrosEPP(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                getPrto(EstadisticaFileKeyword.Autp, line, i);
            }
        }

        for (final PuertoVO prto : prtoMap.values()) {
            proceso.addCodigoMaestro(Entidad.UNLOCODE, prto.getUnlocode());
        }
    }

    /**
     * Read maestros eap.
     *
     * @param lines
     *            the lines
     */
    public void readMaestrosEAP(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                proceso.addCodigoMaestro(Entidad.TIPO_CAPTURA_PESCA,
                        getTokenString(EstadisticaFileKeyword.EAP_TipoCaptura, line, i));
            }
        }
    }

    /**
     * Read maestros eav.
     *
     * @param lines
     *            the lines
     */
    public void readMaestrosEAV(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final String tipoSuministro = getTokenString(EstadisticaFileKeyword.EAV_TipoSuministro, line, i);

                proceso.addCodigoMaestro(Entidad.TIPO_SUMINISTRO, getTipoSuministroNormalizado(tipoSuministro));
            }
        }
    }

    /**
     * Read maestros eae.
     *
     * @param lines
     *            the lines
     */
    public void readMaestrosEAE(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                proceso.addCodigoMaestro(Entidad.TIPO_BUQUE,
                        getTokenString(EstadisticaFileKeyword.EAE_TipoBuque, line, i));
                proceso.addCodigoMaestro(Entidad.TIPO_NAVEGACION,
                        getTokenString(EstadisticaFileKeyword.EAE_TipoNavEntrada, line, i));
                proceso.addCodigoMaestro(Entidad.TIPO_NAVEGACION,
                        getTokenString(EstadisticaFileKeyword.EAE_TipoNavSalida, line, i));
                proceso.addCodigoMaestro(Entidad.PAIS, getTokenString(EstadisticaFileKeyword.EAE_Bandera, line, i));
                proceso.addCodigoMaestro(Entidad.TIPO_ACTIVIDAD,
                        getTokenString(EstadisticaFileKeyword.EAE_TipoActividad, line, i));

                // FIXME Entidad Rango GTs
                proceso.addCodigoMaestro(Entidad.BUQUE, EstadisticaFileKeyword.EAE_Buque.getGenericValue());
                proceso.addCodigoMaestro(Entidad.SERVICIO_TRAFICO,
                        EstadisticaFileKeyword.EAE_Trafico.getGenericValue());
                proceso.addCodigoMaestro(Entidad.ACUERDO, EstadisticaFileKeyword.EAE_Acuerdo.getGenericValue());
                proceso.addCodigoMaestro(Entidad.ORGANIZACION,
                        EstadisticaFileKeyword.EAE_Consignatario.getGenericValue());
            }
        }
    }

    /**
     * Read maestros emm.
     *
     * @param lines
     *            the lines
     */
    public void readMaestrosEMM(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                proceso.addCodigoMaestro(Entidad.UNLOCODE,
                        getTokenString(EstadisticaFileKeyword.EMM_UnloOrigen, line, i));
                proceso.addCodigoMaestro(Entidad.UNLOCODE,
                        getTokenString(EstadisticaFileKeyword.EMM_UnloDestino, line, i));
                proceso.addCodigoMaestro(Entidad.ALINEACION,
                        "***" + getTokenString(EstadisticaFileKeyword.EMM_Alineacion, line, i));
                proceso.addCodigoMaestro(Entidad.MERCANCIA,
                        getTokenString(EstadisticaFileKeyword.EMM_Mercancia, line, i));
                proceso.addCodigoMaestro(Entidad.TIPO_NAVEGACION,
                        getTokenString(EstadisticaFileKeyword.EMM_TipoNavegacion, line, i));

                final String uc = getTokenString(EstadisticaFileKeyword.EMM_UnidadCarga, line, i);

                proceso.addCodigoMaestro(Entidad.UNIDAD_CARGA, getUCNormalizada(uc));
                proceso.addCodigoMaestro(Entidad.INSTALACION_ESPECIAL,
                        "**************" + getTokenString(EstadisticaFileKeyword.EMM_InstEspecial, line, i));

                if (line.length() > EstadisticaFileKeyword.EMM_UnloCargaDescarga.getOffset()) {
                    proceso.addCodigoMaestro(Entidad.UNLOCODE,
                            getTokenString(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i));
                } else {
                    proceso.addCodigoMaestro(Entidad.UNLOCODE,
                            EstadisticaFileKeyword.EMM_UnloCargaDescarga.getGenericValue());
                }

                proceso.addCodigoMaestro(Entidad.ORGANIZACION, EstadisticaFileKeyword.EMM_Estibador.getGenericValue());
                proceso.addCodigoMaestro(Entidad.ORGANIZACION,
                        EstadisticaFileKeyword.EMM_Consignatario.getGenericValue());
                proceso.addCodigoMaestro(Entidad.BUQUE, EstadisticaFileKeyword.EMM_Buque.getGenericValue());
                proceso.addCodigoMaestro(Entidad.SERVICIO_TRAFICO,
                        EstadisticaFileKeyword.EMM_ServicioTrafico.getGenericValue());
                proceso.addCodigoMaestro(Entidad.ACUERDO, EstadisticaFileKeyword.EMM_Acuerdo.getGenericValue());
                proceso.addCodigoMaestro(Entidad.TERMINAL, EstadisticaFileKeyword.EMM_Terminal.getGenericValue());
            }
        }
    }

    /**
     * Read maestros eme.
     *
     * @param lines
     *            the lines
     * @param isSigma
     *            the is sigma
     */
    public void readMaestrosEME(final List<String> lines, final boolean isSigma) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                proceso.addCodigoMaestro(Entidad.UNLOCODE,
                        getTokenString(EstadisticaFileKeyword.EME_UnloCargaDescarga, line, i));
                proceso.addCodigoMaestro(Entidad.UNIDAD_CARGA,
                        getTokenString(EstadisticaFileKeyword.EME_UnidadCarga, line, i));
                proceso.addCodigoMaestro(Entidad.REGISTRO_TIPO_BUQUE_EEE,
                        getTokenString(EstadisticaFileKeyword.EME_RegistroBuqueEEE, line, i));

                if (isSigma) {
                    proceso.addCodigoMaestro(Entidad.GRUPO_NST,
                            getTokenString(EstadisticaFileKeyword.EME_GrupoNST, line, i));
                    proceso.addCodigoMaestro(Entidad.MERCANCIA, EstadisticaFileKeyword.EME_Mercancia.getGenericValue());
                } else {
                    proceso.addCodigoMaestro(Entidad.MERCANCIA,
                            getTokenString(EstadisticaFileKeyword.EME_Mercancia, line, i));
                }
            }
        }
    }

    /**
     * Read maestros emt.
     *
     * @param lines
     *            the lines
     */
    public void readMaestrosEMT(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                proceso.addCodigoMaestro(Entidad.TIPO_BUQUE_EEE,
                        getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i));
                proceso.addCodigoMaestro(Entidad.TIPO_BUQUE_EST,
                        getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i));
                proceso.addCodigoMaestro(Entidad.TIPO_BUQUE_GT_EEE,
                        getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE, line, i));
            }
        }
    }

    /**
     * Read epp.
     *
     * @param lines
     *            the lines
     */
    public void readEPP(final List<String> lines) {
        int i = 0;

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                getTokenInteger(EstadisticaFileKeyword.Anio, line, i);
                getTokenInteger(EstadisticaFileKeyword.Mes, line, i);
                getTokenDate(EstadisticaFileKeyword.EPP_FechaTransmision, line, i, DATE_PATTERN);

                getPrto(EstadisticaFileKeyword.Autp, line, i);
            }
        }
    }

    /**
     * Read eap.
     *
     * @param lines
     *            the lines
     */
    public void readEAP(final List<String> lines) {
        int i = 0;

        final TipoEstadisticaDetailVO tpesDetail = TipoEstadisticaProxy.select(Entidad.ACTIVIDAD_PESQUERA.getId());

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final EstadisticaVO estd = new EstadisticaVO();

                estd.setEntiId(tpesDetail.getEnti().getId());
                estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                estd.setPrto(getPrto(EstadisticaFileKeyword.Autp, line, i));

                estd.addItdt(TipoDato.TIPO_CAPTURA_PESCA.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EAP_TipoCaptura, line, i, Entidad.TIPO_CAPTURA_PESCA));
                estd.addItdt(TipoDato.ENTERO_01.getId(), getTokenLong(EstadisticaFileKeyword.EAP_Kilos, line, i));
                estd.addItdt(TipoDato.DECIMAL_01.getId(),
                        getTokenDouble(EstadisticaFileKeyword.EAP_Euros, line, i) / 100);

                estdList.add(estd);
            }
        }
    }

    /**
     * Read eav.
     *
     * @param lines
     *            the lines
     */
    public void readEAV(final List<String> lines) {
        int i = 0;

        final TipoEstadisticaDetailVO tpesDetail = TipoEstadisticaProxy.select(Entidad.AVITUALLAMIENTO.getId());

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final EstadisticaVO estd = new EstadisticaVO();

                estd.setEntiId(tpesDetail.getEnti().getId());
                estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                estd.setPrto(getPrto(EstadisticaFileKeyword.Autp, line, i));

                final String tipoSuministro = getTipoSuministroNormalizado(
                        getTokenString(EstadisticaFileKeyword.EAV_TipoSuministro, line, i));

                estd.addItdt(TipoDato.TIPO_SUM.getId(), getMaestro(EstadisticaFileKeyword.EAV_TipoSuministro, line, i,
                        Entidad.TIPO_SUMINISTRO, tipoSuministro));
                estd.addItdt(TipoDato.ENTERO_01.getId(), getTokenLong(EstadisticaFileKeyword.EAV_Toneladas, line, i));

                estdList.add(estd);
            }
        }
    }

    /**
     * Read eae.
     *
     * @param lines
     *            the lines
     */
    public void readEAE(final List<String> lines) {
        int i = 0;

        final TipoEstadisticaDetailVO tpesDetail = TipoEstadisticaProxy.select(Entidad.AGREGACION_ESCALA.getId());

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final EstadisticaVO estd = new EstadisticaVO();

                estd.setEntiId(tpesDetail.getEnti().getId());
                estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                estd.setPrto(getPrto(EstadisticaFileKeyword.Autp, line, i));

                // FIXME Conversion de Tipo de Buque
                estd.addItdt(TipoDato.TIPO_BUQUE.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EAE_TipoBuque, line, i, Entidad.TIPO_BUQUE));
                estd.addItdt(TipoDato.TIPO_NAV.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EAE_TipoNavEntrada, line, i, Entidad.TIPO_NAVEGACION));
                estd.addItdt(TipoDato.TIPO_NAV_2.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EAE_TipoNavSalida, line, i, Entidad.TIPO_NAVEGACION));
                estd.addItdt(TipoDato.PAIS.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EAE_Bandera, line, i, Entidad.PAIS));
                estd.addItdt(TipoDato.TIPO_ACT.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EAE_TipoActividad, line, i, Entidad.TIPO_ACTIVIDAD));
                estd.addItdt(TipoDato.ENTERO_01.getId(), getTokenLong(EstadisticaFileKeyword.EAE_NumEscalas, line, i));
                estd.addItdt(TipoDato.ENTERO_02.getId(), getTokenLong(EstadisticaFileKeyword.EAE_NumGTs, line, i));

                estdList.add(estd);
            }
        }
    }

    /**
     * Read emm.
     *
     * @param lines
     *            the lines
     */
    public void readEMM(final List<String> lines) {
        int i = 0;

        final TipoEstadisticaDetailVO tpesDetail = TipoEstadisticaProxy.select(Entidad.MOVIMIENTO_MERCANCIA.getId());

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final EstadisticaVO estd = new EstadisticaVO();

                estd.setEntiId(tpesDetail.getEnti().getId());
                estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                estd.setPrto(getPrto(EstadisticaFileKeyword.Autp, line, i));

                estd.addItdt(TipoDato.TIPO_OP_BL.getId(),
                        getTokenCR(EstadisticaFileKeyword.EMM_TipoOperacion, line, i, TipoDato.TIPO_OP_BL));
                estd.addItdt(TipoDato.UNLOCODE_3.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EMM_UnloOrigen, line, i, Entidad.UNLOCODE));
                estd.addItdt(TipoDato.UNLOCODE_4.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EMM_UnloDestino, line, i, Entidad.UNLOCODE));

                final String alineacion = "***" + getTokenString(EstadisticaFileKeyword.EMM_Alineacion, line, i);

                estd.addItdt(TipoDato.ALIN.getId(), getMaestro(EstadisticaFileKeyword.EMM_Alineacion, i,
                        Entidad.ALINEACION, estd.getPrto(), alineacion));
                estd.addItdt(TipoDato.MERCANCIA.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EMM_Mercancia, line, i, Entidad.MERCANCIA));
                estd.addItdt(TipoDato.TIPO_NAV.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EMM_TipoNavegacion, line, i, Entidad.TIPO_NAVEGACION));
                estd.addItdt(TipoDato.BOOLEANO_01.getId(),
                        getTokenString(EstadisticaFileKeyword.EMM_Roro, line, i).equals("N") ? 0L : 1L);

                final String uc = getUCNormalizada(getTokenString(EstadisticaFileKeyword.EMM_UnidadCarga, line, i));

                estd.addItdt(TipoDato.UNIDAD_CARGA.getId(),
                        getMaestro(EstadisticaFileKeyword.EMM_UnidadCarga, line, i, Entidad.UNIDAD_CARGA, uc));

                final String instalacionEsp = "**************"
                        + getTokenString(EstadisticaFileKeyword.EMM_InstEspecial, line, i);

                estd.addItdt(TipoDato.INST_ESP.getId(), getMaestro(EstadisticaFileKeyword.EMM_InstEspecial, i,
                        Entidad.INSTALACION_ESPECIAL, estd.getPrto(), instalacionEsp));
                estd.addItdt(TipoDato.TIPO_TRANSPORTE.getId(),
                        getTokenCR(EstadisticaFileKeyword.EMM_TipoTransporte, line, i, TipoDato.TIPO_TRANSPORTE));
                estd.addItdt(TipoDato.DECIMAL_01.getId(),
                        getTokenDouble(EstadisticaFileKeyword.EMM_Toneladas, line, i));
                estd.addItdt(TipoDato.ENTERO_01.getId(), getTokenLong(EstadisticaFileKeyword.EMM_Unidades, line, i));
                estd.addItdt(TipoDato.DECIMAL_02.getId(), getTokenDouble(EstadisticaFileKeyword.EMM_Teus, line, i));

                // FIXME Acabar
                ParametroVO unloCargaDescargaVO = null;

                if (line.length() > EstadisticaFileKeyword.EMM_UnloCargaDescarga.getOffset()) {
                    unloCargaDescargaVO = getTokenMaestro(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i,
                            Entidad.UNLOCODE);
                } else {
                    unloCargaDescargaVO = getTokenMaestroGeneric(EstadisticaFileKeyword.EMM_UnloCargaDescarga, i,
                            Entidad.UNLOCODE);
                }

                if (unloCargaDescargaVO != null) {
                    final String tipoOperacion = getTokenString(EstadisticaFileKeyword.EMM_TipoOperacion, line, i);
                    final ParametroVO autpUnlo = getMaestro(EstadisticaFileKeyword.EMM_UnloCargaDescarga, line, i,
                            Entidad.UNLOCODE, estd.getPrto().getUnlocode());

                    if ("TE".equals(tipoOperacion) || tipoOperacion.startsWith("E")) {
                        estd.addItdt(TipoDato.UNLOCODE.getId(), autpUnlo);
                        estd.addItdt(TipoDato.UNLOCODE_2.getId(), unloCargaDescargaVO);
                    } else {
                        estd.addItdt(TipoDato.UNLOCODE.getId(), unloCargaDescargaVO);
                        estd.addItdt(TipoDato.UNLOCODE_2.getId(), autpUnlo);
                    }
                }

                estdList.add(estd);
            }
        }
    }

    /**
     * Read eme.
     *
     * @param lines
     *            the lines
     * @param isSigma
     *            the is sigma
     */
    public void readEME(final List<String> lines, final boolean isSigma) {
        int i = 0;

        final TipoEstadisticaDetailVO tpesDetail = TipoEstadisticaProxy
                .select(Entidad.MOVIMIENTO_MERCANCIA_EEE.getId());

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final EstadisticaVO estd = new EstadisticaVO();

                estd.setEntiId(tpesDetail.getEnti().getId());
                estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                estd.setPrto(getPrto(EstadisticaFileKeyword.Autp, line, i));

                estd.addItdt(TipoDato.UNLOCODE.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EME_UnloCargaDescarga, line, i, Entidad.UNLOCODE));
                estd.addItdt(TipoDato.UNIDAD_CARGA.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EME_UnidadCarga, line, i, Entidad.UNIDAD_CARGA));

                if (isSigma) {
                    estd.addItdt(TipoDato.GRUPO_NST.getId(),
                            getTokenMaestro(EstadisticaFileKeyword.EME_GrupoNST, line, i, Entidad.GRUPO_NST));
                    estd.addItdt(TipoDato.MERCANCIA.getId(),
                            getTokenMaestroGeneric(EstadisticaFileKeyword.EME_Mercancia, i, Entidad.MERCANCIA));
                } else {
                    final ParametroVO mercanciaVO = getTokenMaestro(EstadisticaFileKeyword.EME_Mercancia, line, i,
                            Entidad.MERCANCIA);

                    if (mercanciaVO != null) {
                        estd.addItdt(TipoDato.MERCANCIA.getId(), mercanciaVO);
                        estd.addItdt(TipoDato.GRUPO_NST.getId(),
                                mercanciaVO.getItdtMap().get(TipoDato.GRUPO_NST.getId()).getPrmt());
                    }
                }

                estd.addItdt(TipoDato.REG_TBUQUE_EEE.getId(), getTokenMaestro(
                        EstadisticaFileKeyword.EME_RegistroBuqueEEE, line, i, Entidad.REGISTRO_TIPO_BUQUE_EEE));

                final String direccionMerc = getDireccionMercanciaNormalizada(
                        getTokenString(EstadisticaFileKeyword.EME_DireccionTransporte, line, i));

                estd.addItdt(TipoDato.DIREC_MERC.getId(), direccionMerc);
                estd.addItdt(TipoDato.DECIMAL_01.getId(),
                        getTokenDouble(EstadisticaFileKeyword.EME_Toneladas, line, i));
                estd.addItdt(TipoDato.ENTERO_01.getId(), getTokenLong(EstadisticaFileKeyword.EME_Pasajeros, line, i));
                estd.addItdt(TipoDato.ENTERO_02.getId(), getTokenLong(EstadisticaFileKeyword.EME_UCLlenas, line, i));
                estd.addItdt(TipoDato.ENTERO_03.getId(), getTokenLong(EstadisticaFileKeyword.EME_UCVacias, line, i));

                if (line.length() > EstadisticaFileKeyword.EME_Roro.getOffset()) {
                    estd.addItdt(TipoDato.BOOLEANO_01.getId(),
                            getTokenString(EstadisticaFileKeyword.EME_Roro, line, i).equals("N") ? 0L : 1L);
                }

                if (isSigma) {
                    estd.addItdt(TipoDato.ENTERO_04.getId(),
                            getTokenLong(EstadisticaFileKeyword.EME_PasajerosCrucero, line, i));
                    estd.addItdt(TipoDato.ENTERO_05.getId(),
                            getTokenLong(EstadisticaFileKeyword.EME_PasajerosInicioFinLinea, line, i));
                }
                // FIXME Acabar

                estdList.add(estd);
            }
        }
    }

    /**
     * Read emt.
     *
     * @param lines
     *            the lines
     */
    public void readEMT(final List<String> lines) {
        int i = 0;

        final TipoEstadisticaDetailVO tpesDetail = TipoEstadisticaProxy
                .select(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId());

        for (final String line : lines) {
            i++;

            if (!line.isEmpty() && !line.startsWith(SIGMA_TOKEN)) {
                final EstadisticaVO estd = new EstadisticaVO();

                estd.setEntiId(tpesDetail.getEnti().getId());
                estd.setItdtMap(new HashMap<Long, ItemDatoVO>());
                estd.setPrto(getPrto(EstadisticaFileKeyword.Autp, line, i));

                final String tipoBuque = getTokenString(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i);

                ParametroVO tipoBuqueEst = null;

                if (proceso.existsMaestro(Entidad.TIPO_BUQUE_EST, tipoBuque)) {
                    tipoBuqueEst = getMaestro(EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i,
                            Entidad.TIPO_BUQUE_EST, tipoBuque);
                }

                if (tipoBuqueEst != null) {
                    estd.addItdt(TipoDato.TIPO_BUQUE_EEE.getId(),
                            tipoBuqueEst.getItdtMap().get(TipoDato.TIPO_BUQUE_EEE.getId()).getPrmt());
                } else {
                    estd.addItdt(TipoDato.TIPO_BUQUE_EEE.getId(), getTokenMaestro(
                            EstadisticaFileKeyword.EMT_TipoBuqueEstEEE, line, i, Entidad.TIPO_BUQUE_EEE));
                }

                estd.addItdt(TipoDato.TIPO_BUQUE_GT_EEE.getId(),
                        getTokenMaestro(EstadisticaFileKeyword.EMT_TipoBuqueGtEEE, line, i, Entidad.TIPO_BUQUE_GT_EEE));
                estd.addItdt(TipoDato.ENTERO_01.getId(),
                        getTokenLong(EstadisticaFileKeyword.EMT_NumeroBuques, line, i));
                estd.addItdt(TipoDato.ENTERO_02.getId(), getTokenLong(EstadisticaFileKeyword.EMT_NumeroGTs, line, i));

                estdList.add(estd);
            }
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
                final String errorMessage = "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                        + ", campo: " + keyword.name();

                proceso.addError(MensajeCodigo.G_005, errorMessage);

                if (LOG.isDebugEnabled()) {
                    LOG.debug(MensajeCodigo.G_005.name() + ": " + errorMessage);
                    LOG.debug("Line: " + line);
                }
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
            proceso.addError(MensajeCodigo.G_003,
                    "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber + ", valor: " + codigo);

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
            proceso.addError(MensajeCodigo.G_003,
                    "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber + ", valor: " + codigo);

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

        final TipoDatoVO tpdtVO = TipoDatoProxy.select(tipoDato.getId());

        if (!tpdtVO.getCdrfCodeSet().contains(codigo)) {
            proceso.addError(MensajeCodigo.G_004, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", CR: " + tipoDato.name() + ", codigo: " + codigo);
        }

        return codigo;
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
            proceso.addError(MensajeCodigo.G_003,
                    "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber + ", valor: " + codigo);

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
            proceso.addError(MensajeCodigo.G_002, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
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

        return getMaestro(keyword, line, lineNumber, entidad, codigo);
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

        final ParametroVO prmt = proceso.findMaestro(entidad, codigo);

        if (prmt == null) {
            proceso.addError(MensajeCodigo.G_001, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", entidad: " + entidad.name() + ", codigo: " + codigo);
        }

        return prmt;
    }

    /**
     * Gets the maestro.
     *
     * @param keyword
     *            the keyword
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @param prto
     *            the prto
     * @param codigo
     *            the codigo
     * @return the maestro
     */
    private ParametroVO getMaestro(final EstadisticaFileKeyword keyword, final int lineNumber, final Entidad entidad,
            final PuertoVO prto, final String codigo) {
        final ParametroVO prmt = proceso.findMaestro(entidad, prto, codigo);

        if (prmt == null) {
            proceso.addError(MensajeCodigo.G_001, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", entidad: " + entidad.name() + ", prto: " + prto.getCodigo() + ", codigo: " + codigo);
        }

        return prmt;
    }

    /**
     * Gets the token maestro generic.
     *
     * @param keyword
     *            the keyword
     * @param lineNumber
     *            the line number
     * @param entidad
     *            the entidad
     * @return the token maestro generic
     */
    private ParametroVO getTokenMaestroGeneric(final EstadisticaFileKeyword keyword, final int lineNumber,
            final Entidad entidad) {
        final ParametroVO prmt = proceso.findMaestro(entidad, keyword.getGenericValue());

        if (prmt == null) {
            proceso.addError(MensajeCodigo.G_001, "archivo: " + keyword.getFileType().name() + ", linea: " + lineNumber
                    + ", entidad: " + entidad.name() + ", codigo: " + keyword.getGenericValue());
        }

        return prmt;
    }

    /**
     * Gets the prto.
     *
     * @param keyword
     *            the keyword
     * @param line
     *            the line
     * @param lineNumber
     *            the line number
     * @return the prto
     */
    public PuertoVO getPrto(final EstadisticaFileKeyword keyword, final String line, final int lineNumber) {
        final String codigo = getTokenString(keyword, line, lineNumber);

        if (codigo == null || !prtoMap.containsKey(getTokenString(keyword, line, lineNumber))) {
            throw new Error("Puerto no encontrado: " + codigo);
        }

        return prtoMap.get(codigo);
    }

    /**
     * Sets the prto map.
     *
     * @param value
     *            the value
     */
    public void setPrtoMap(final Map<String, PuertoVO> value) {
        prtoMap = value;
    }

}
