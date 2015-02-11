package xeredi.integra.proceso;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.comun.vo.ItemDatoCriterioVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.metamodelo.vo.TipoDato;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.MensajeNivel;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoParametroVO;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoTemplate.
 */
public abstract class ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoTemplate.class);

    /** The prbt vo. */
    protected ProcesoVO prbt;

    /** The prmn list. */
    protected List<ProcesoMensajeVO> prmnList;

    /** The prit salida list. */
    protected List<Long> itemSalidaList;

    /** The arin salida list. */
    protected File fileSalida;

    /** The arin entrada list. */
    protected List<ArchivoInfoVO> arinEntradaList;

    /** The prpm map. */
    protected Map<String, ProcesoParametroVO> prpmMap;

    /** The codigo maestro map. */
    protected final Map<Entidad, Set<String>> codigoMaestroMap = new HashMap<>();

    /** The nif set. */
    protected final Set<String> nifSet = new HashSet<>();

    /** The maestro map. */
    protected final Map<Entidad, Map<String, ParametroVO>> maestroMap = new HashMap<>();

    /** The organizaciones map. */
    protected final Map<String, ParametroVO> organizacionesMap = new HashMap<>();

    /**
     * Procesar.
     */
    public final void procesar() {
        prepararProcesos();

        final ProcesoBO prbtBO = new ProcesoBO();

        do {
            prbt = prbtBO.proteger(getProcesoModulo(), getProcesoTipo());

            if (prbt != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Ejecucion del proceso: " + prbt);
                }

                try {
                    prmnList = new ArrayList<>();
                    itemSalidaList = new ArrayList<>();

                    prpmMap = prbtBO.selectPrpmMap(prbt.getId());
                    arinEntradaList = prbtBO.selectArinEntradaList(prbt.getId());

                    ejecutarProceso();
                } catch (final Throwable ex) {
                    LOG.fatal("Error en el Proceso " + prbt.getId());
                    LOG.fatal(ex, ex);

                    addError(MensajeCodigo.G_000, ex.getMessage());
                }

                try {
                    prbtBO.finalizar(prbt.getId(), prmnList, getItemTipoSalida(), itemSalidaList, fileSalida);
                } catch (final InstanceNotFoundException ex) {
                    LOG.fatal("Proceso " + prbt.getId() + " no encontrado al tratar de finalizarlo. " + prbt);
                } catch (final OperacionNoPermitidaException ex) {
                    LOG.fatal("Proceso " + prbt.getId() + " en un estado invalido al tratar de finalizarlo. " + prbt);
                }
            }
        } while (prbt != null);
    }

    /**
     * Buscar maestros.
     *
     * @param fechaVigencia
     *            the fecha vigencia
     */
    protected final void buscarMaestros(final Date fechaVigencia) {
        Preconditions.checkNotNull(fechaVigencia);

        if (LOG.isInfoEnabled()) {
            LOG.info("Busqueda de Maestros");
        }

        for (final Entidad entidad : codigoMaestroMap.keySet()) {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(entidad.getId());
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setEntiId(entidad.getId());
            prmtCriterioVO.setParametros(codigoMaestroMap.get(entidad));
            prmtCriterioVO.setFechaVigencia(fechaVigencia);
            prmtCriterioVO.setIdioma(ConfigurationProxy.getString(ConfigurationKey.language_default));

            maestroMap.put(entidad, prmtBO.selectMapByCodigo(prmtCriterioVO));
        }
    }

    /**
     * Buscar organizaciones.
     *
     * @param fechaVigencia
     *            the fecha vigencia
     */
    protected final void buscarOrganizaciones(final Date fechaVigencia) {
        Preconditions.checkNotNull(fechaVigencia);

        if (!nifSet.isEmpty()) {
            if (LOG.isInfoEnabled()) {
                LOG.info("Busqueda de Organizaciones");
            }

            final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());
            prmtCriterioVO.setEntiId(Entidad.ORGANIZACION.getId());
            prmtCriterioVO.setFechaVigencia(fechaVigencia);

            final ItemDatoCriterioVO itdtCriterioVO = new ItemDatoCriterioVO();

            itdtCriterioVO.setTpdtId(TipoDato.CADENA_02.getId());
            itdtCriterioVO.setCadenas(nifSet);

            prmtCriterioVO.getItdtMap().put(TipoDato.CADENA_02.getId(), itdtCriterioVO);

            final List<ParametroVO> prmtList = prmtBO.selectList(prmtCriterioVO);

            for (final ParametroVO prmtVO : prmtList) {
                organizacionesMap.put(prmtVO.getItdtMap().get(TipoDato.CADENA_02.getId()).getCadena(), prmtVO);
            }
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
    public final void addCodigoMaestro(final Entidad entidad, final String codigo) {
        Preconditions.checkNotNull(entidad);

        if (!codigoMaestroMap.containsKey(entidad)) {
            codigoMaestroMap.put(entidad, new HashSet<String>());
        }

        if (codigo != null && !codigo.isEmpty()) {
            codigoMaestroMap.get(entidad).add(codigo);
        }
    }

    /**
     * Find maestro.
     *
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     * @return the parametro vo
     */
    public final ParametroVO findMaestro(final Entidad entidad, final String codigo) {
        Preconditions.checkNotNull(entidad);

        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        if (maestroMap.containsKey(entidad)) {
            return maestroMap.get(entidad).get(codigo);
        }

        return null;
    }

    /**
     * Exists maestro.
     *
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     * @return true, if successful
     */
    public final boolean existsMaestro(final Entidad entidad, final String codigo) {
        Preconditions.checkNotNull(entidad);

        if (codigo == null || codigo.isEmpty()) {
            return false;
        }

        if (maestroMap.containsKey(entidad)) {
            return maestroMap.get(entidad).containsKey(codigo);
        }

        return false;
    }

    /**
     * Find organizacion.
     *
     * @param codigo
     *            the codigo
     * @return the parametro vo
     */
    public final ParametroVO findOrganizacion(final String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            return null;
        }

        return organizacionesMap.get(codigo);
    }

    /**
     * Adds the nif.
     *
     * @param nif
     *            the nif
     */
    public final void addNif(final String nif) {
        nifSet.add(nif);
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

        if (mensaje != null) {
            prmnVO.setMensaje(mensaje.length() < 250 ? mensaje : mensaje.substring(0, 250));
        }

        prmnList.add(prmnVO);
    }

    /**
     * Adds the mensaje.
     *
     * @param codigo
     *            the codigo
     * @param mensaje
     *            the mensaje
     */
    public final void addError(final MensajeCodigo codigo, final String mensaje) {
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
    public final void addWarning(final MensajeCodigo codigo, final String mensaje) {
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
    public final void addInfo(final MensajeCodigo codigo, final String mensaje) {
        addMensaje(codigo, MensajeNivel.I, mensaje);
    }

    /**
     * Preparar procesos.
     */
    protected abstract void prepararProcesos();

    /**
     * Ejecutar.
     */
    protected abstract void ejecutarProceso();

    /**
     * Gets the proceso tipo.
     *
     * @return the proceso tipo
     */
    protected abstract ProcesoTipo getProcesoTipo();

    /**
     * Gets the proceso modulo.
     *
     * @return the proceso modulo
     */
    protected abstract ProcesoModulo getProcesoModulo();

    /**
     * Gets the item tipo salida.
     *
     * @return the item tipo salida
     */
    protected abstract ItemTipo getItemTipoSalida();
}