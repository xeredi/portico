package xeredi.integra.proceso;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.bo.maestro.Parametro;
import xeredi.integra.model.bo.proceso.OperacionNoPermitidaException;
import xeredi.integra.model.bo.proceso.Proceso;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.comun.vo.ItemDatoCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroCriterioVO;
import xeredi.integra.model.maestro.vo.ParametroVO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.MensajeNivel;
import xeredi.integra.model.proceso.vo.ProcesoMensajeVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.integra.model.util.Entidad;
import xeredi.integra.model.util.GlobalNames;
import xeredi.integra.model.util.TipoDato;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoTemplate.
 */
public abstract class ProcesoTemplate {

    /** The Constant LOG. */
    protected static final Log LOG = LogFactory.getLog(ProcesoTemplate.class);

    /** The prbt vo. */
    protected ProcesoVO prbtVO;

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
        if (LOG.isInfoEnabled()) {
            LOG.info("Inicio del proceso batch");
        }

        final Proceso prbtBO = BOFactory.getInjector().getInstance(Proceso.class);

        do {
            prbtVO = prbtBO.proteger(getProcesoModulo(), getProcesoTipo());

            if (prbtVO != null) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Ejecucion del proceso: " + prbtVO);
                }

                ejecutar();

                try {
                    prbtBO.finalizar(prbtVO);
                } catch (final InstanceNotFoundException ex) {
                    LOG.fatal("Proceso " + prbtVO.getId() + " no encontrado al tratar de finalizarlo. " + prbtVO);
                    throw new Error("Error grave de proceso en ejecucion no encontrado");
                } catch (final OperacionNoPermitidaException ex) {
                    LOG.fatal("Proceso " + prbtVO.getId() + " en un estado invalido al tratar de finalizarlo. "
                            + prbtVO);
                    throw new Error("Error grave de inconsistencia de estados en los procesos");
                }
            }
        } while (prbtVO != null);

        if (LOG.isInfoEnabled()) {
            LOG.info("Fin del proceso batch");
        }
    }

    /**
     * Buscar maestros.
     *
     * @param fechaVigencia
     *            the fecha vigencia
     */
    protected final void buscarMaestros(final Date fechaVigencia) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Busqueda de Maestros");
        }

        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);

        for (final Entidad entidad : codigoMaestroMap.keySet()) {
            final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

            prmtCriterioVO.setEntiId(entidad.getId());
            prmtCriterioVO.setParametros(codigoMaestroMap.get(entidad));
            prmtCriterioVO.setFechaVigencia(fechaVigencia);
            prmtCriterioVO.setIdioma(GlobalNames.DEFAULT_LANGUAGE);

            maestroMap.put(entidad, prmtBO.selectMapByCodigo(prmtCriterioVO));
        }
    }

    /**
     * Buscar organizaciones.
     *
     * @param fechaVigencia
     *            the fecha vigencia
     */
    protected void buscarOrganizaciones(final Date fechaVigencia) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Busqueda de Organizaciones");
        }

        final Parametro prmtBO = BOFactory.getInjector().getInstance(Parametro.class);
        final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

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

    /**
     * Adds the codigo maestro.
     *
     * @param entidad
     *            the entidad
     * @param codigo
     *            the codigo
     */
    protected final void addCodigoMaestro(final Entidad entidad, final String codigo) {
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

        prbtVO.getPrmnList().add(prmnVO);
    }

    /**
     * Adds the mensaje.
     *
     * @param codigo
     *            the codigo
     * @param mensaje
     *            the mensaje
     */
    protected final void addError(final MensajeCodigo codigo, final String mensaje) {
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
    protected final void addWarning(final MensajeCodigo codigo, final String mensaje) {
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
    protected final void addInfo(final MensajeCodigo codigo, final String mensaje) {
        addMensaje(codigo, MensajeNivel.I, mensaje);
    }

    // FIXME Quitar - Es solo para pruebas
    /**
     * Sets the prbt vo.
     *
     * @param value
     *            the new prbt vo
     */
    public void setPrbtVO(final ProcesoVO value) {
        prbtVO = value;
    }

    /**
     * Ejecutar.
     */
    protected abstract void ejecutar();

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
}
