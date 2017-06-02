package xeredi.argo.proceso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Preconditions;

import lombok.Getter;
import lombok.NonNull;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.exception.OperacionNoPermitidaException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.item.vo.ItemDatoCriterioVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroCriterioVO;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.metamodelo.vo.TipoParametroDetailVO;
import xeredi.argo.model.proceso.service.ProcesoService;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.MensajeNivel;
import xeredi.argo.model.proceso.vo.ProcesoMensajeVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoTemplate.
 */
public abstract class ProcesoTemplate {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ProcesoTemplate.class);

	/** The Constant BATCH_MAX_SIZE. */
	private static final int BATCH_MAX_SIZE = 1000;

	/** The prbt service. */
	@Inject
	private ProcesoService prbtService;

	/** The prbt data. */
	@Getter
	protected ProcesoData prbtData;

	/** The usro id. */
	@Getter
	protected Long usroId;

	/**
	 * Procesar.
	 */
	public final void procesar() {
		prepararProcesos();

		ProcesoVO prbt = null;

		do {
			prbt = prbtService.proteger(getProcesoTipo());

			if (prbt != null) {
				if (LOG.isDebugEnabled()) {
					LOG.debug("Ejecucion del proceso: " + prbt);
				}

				try {
					prbtData = new ProcesoData();

					prbtData.setPrbt(prbt);
					prbtData.getPrpmMap().putAll(prbtService.selectPrpmMap(prbt.getId()));
					prbtData.getPritEntradaList().addAll(prbtService.selectPritEntradaList(prbt.getId()));

					ejecutarProceso();
				} catch (final Throwable ex) {
					LOG.fatal("Error en el Proceso " + prbt.getId());
					LOG.fatal(ex, ex);

					addError(MensajeCodigo.G_000, ex.getMessage());
				}

				try {
					prbtService.finalizar(prbt.getId(), prbtData.getPrmnList(), getProcesoTipo().getItemTipoSalida(),
							prbtData.getItemSalidaList());
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
	public final void buscarMaestros(final Date fechaVigencia) {
		if (LOG.isInfoEnabled()) {
			LOG.info("Busqueda de Maestros");
		}

		for (final Entidad entidad : prbtData.getCodigoMaestroMap().keySet()) {
			final TipoParametroDetailVO tpprDetail = TipoParametroProxy.select(entidad.getId());
			final ParametroBO prmtBO = ParametroBOFactory.newInstance(entidad.getId());

			prbtData.getMaestroMap().put(entidad, new HashMap<String, ParametroVO>());
			prbtData.getMaestroPrtoMap().put(entidad, new HashMap<Long, Map<String, ParametroVO>>());

			final Set<String> batchPrmtSet = new HashSet<>();
			final Iterator<String> prmtIterator = prbtData.getCodigoMaestroMap().get(entidad).iterator();

			while (prmtIterator.hasNext()) {
				batchPrmtSet.add(prmtIterator.next());

				if (batchPrmtSet.size() == BATCH_MAX_SIZE || !prmtIterator.hasNext()) {
					final ParametroCriterioVO prmtCriterio = new ParametroCriterioVO();

					prmtCriterio.setEntiId(entidad.getId());
					prmtCriterio.setParametros(batchPrmtSet);
					prmtCriterio.setFechaVigencia(fechaVigencia);
					prmtCriterio.setIdioma(ConfigurationProxy.getString(ConfigurationKey.language_default));

					for (final ParametroVO prmt : prmtBO.selectList(prmtCriterio)) {
						if (tpprDetail.getEnti().getPuerto()) {
							if (!prbtData.getMaestroPrtoMap().get(entidad).containsKey(prmt.getPrto().getId())) {
								prbtData.getMaestroPrtoMap().get(entidad).put(prmt.getPrto().getId(),
										new HashMap<String, ParametroVO>());
							}

							prbtData.getMaestroPrtoMap().get(entidad).get(prmt.getPrto().getId())
									.put(prmt.getParametro(), prmt);
						} else {
							prbtData.getMaestroMap().get(entidad).put(prmt.getParametro(), prmt);
						}
					}

					batchPrmtSet.clear();
				}
			}

			// Validacion de los maestros
			for (final String parametro : prbtData.getCodigoMaestroMap().get(entidad)) {
				if (tpprDetail.getEnti().getPuerto()) {
					// FIXME Validar maestros con Puerto
				} else {
					if (!prbtData.getMaestroMap().get(entidad).containsKey(parametro)) {
						addError(MensajeCodigo.G_001, "entidad: " + entidad.name() + ", codigo: " + parametro);
					}
				}
			}
		}
	}

	/**
	 * Buscar organizaciones.
	 *
	 * @param fechaVigencia
	 *            the fecha vigencia
	 */
	protected final void buscarOrganizaciones(final Date fechaVigencia) {
		if (!prbtData.getNifSet().isEmpty()) {
			if (LOG.isInfoEnabled()) {
				LOG.info("Busqueda de Organizaciones");
			}

			final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.ORGANIZACION.getId());
			final Set<String> batchNifSet = new HashSet<>();
			final Iterator<String> nifIterator = prbtData.getNifSet().iterator();

			while (nifIterator.hasNext()) {
				batchNifSet.add(nifIterator.next());

				if (batchNifSet.size() == BATCH_MAX_SIZE || !nifIterator.hasNext()) {
					final ParametroCriterioVO prmtCriterioVO = new ParametroCriterioVO();

					prmtCriterioVO.setItdtMap(new HashMap<Long, ItemDatoCriterioVO>());
					prmtCriterioVO.setEntiId(Entidad.ORGANIZACION.getId());
					prmtCriterioVO.setFechaVigencia(fechaVigencia);

					final ItemDatoCriterioVO itdtCriterioVO = new ItemDatoCriterioVO();

					itdtCriterioVO.setTpdtId(TipoDato.CADENA_02.getId());
					itdtCriterioVO.setCadenas(batchNifSet);

					prmtCriterioVO.getItdtMap().put(TipoDato.CADENA_02.getId(), itdtCriterioVO);

					final List<ParametroVO> prmtList = prmtBO.selectList(prmtCriterioVO);

					for (final ParametroVO prmtVO : prmtList) {
						prbtData.getOrganizacionesMap()
								.put(prmtVO.getItdtMap().get(TipoDato.CADENA_02.getId()).getCadena(), prmtVO);
					}

					batchNifSet.clear();
				}
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
	public final void addCodigoMaestro(@NonNull final Entidad entidad, final String codigo) {
		if (!prbtData.getCodigoMaestroMap().containsKey(entidad)) {
			prbtData.getCodigoMaestroMap().put(entidad, new HashSet<String>());
		}

		if (codigo != null && !codigo.isEmpty()) {
			prbtData.getCodigoMaestroMap().get(entidad).add(codigo);
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
	public final ParametroVO findMaestro(@NonNull final Entidad entidad, final String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			return null;
		}

		if (prbtData.getMaestroMap().containsKey(entidad)) {
			return prbtData.getMaestroMap().get(entidad).get(codigo);
		}

		return null;
	}

	/**
	 * Find maestro.
	 *
	 * @param entidad
	 *            the entidad
	 * @param prto
	 *            the prto
	 * @param codigo
	 *            the codigo
	 * @return the parametro vo
	 */
	public final ParametroVO findMaestro(final Entidad entidad, final PuertoVO prto, final String codigo) {
		Preconditions.checkNotNull(entidad);
		Preconditions.checkNotNull(prto);

		if (codigo == null || codigo.isEmpty()) {
			return null;
		}

		if (prbtData.getMaestroPrtoMap().containsKey(entidad)
				&& prbtData.getMaestroPrtoMap().get(entidad).containsKey(prto.getId())) {
			return prbtData.getMaestroPrtoMap().get(entidad).get(prto.getId()).get(codigo);
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
	public final boolean existsMaestro(@NonNull final Entidad entidad, final String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			return false;
		}

		if (prbtData.getMaestroMap().containsKey(entidad)) {
			return prbtData.getMaestroMap().get(entidad).containsKey(codigo);
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

		return prbtData.getOrganizacionesMap().get(codigo);
	}

	/**
	 * Adds the nif.
	 *
	 * @param nif
	 *            the nif
	 */
	public final void addNif(final String nif) {
		prbtData.getNifSet().add(nif);
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
	private final void addMensaje(@NonNull final MensajeCodigo codigo, @NonNull final MensajeNivel nivel,
			final String mensaje) {
		final ProcesoMensajeVO prmnVO = new ProcesoMensajeVO();

		prmnVO.setCodigo(codigo);
		prmnVO.setNivel(nivel);

		if (mensaje != null) {
			prmnVO.setMensaje(mensaje.length() < 250 ? mensaje : mensaje.substring(0, 250));
		}

		prbtData.getPrmnList().add(prmnVO);
	}

	/**
	 * Adds the mensaje.
	 *
	 * @param codigo
	 *            the codigo
	 * @param mensaje
	 *            the mensaje
	 */
	public final void addError(@NonNull final MensajeCodigo codigo, final String mensaje) {
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
	protected final void addWarning(@NonNull final MensajeCodigo codigo, final String mensaje) {
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
	protected final void addInfo(@NonNull final MensajeCodigo codigo, final String mensaje) {
		addMensaje(codigo, MensajeNivel.I, mensaje);
	}

	/**
	 * Checks for errors.
	 *
	 * @return true, if successful
	 */
	public final boolean hasErrors() {
		if (prbtData == null) {
			return false;
		}

		for (final ProcesoMensajeVO prmn : prbtData.getPrmnList()) {
			if (prmn.getNivel() == MensajeNivel.E) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Find date parameter.
	 *
	 * @param paramName
	 *            the param name
	 * @return the date
	 */
	protected final Date findDateParameter(final String paramName) {
		final String parameterValueString = findStringParameter(paramName);

		if (parameterValueString != null) {
			final SimpleDateFormat format = new SimpleDateFormat(
					ConfigurationProxy.getString(ConfigurationKey.date_format));

			try {
				return format.parse(parameterValueString);
			} catch (final ParseException ex) {
				addError(MensajeCodigo.G_002, paramName + ": " + parameterValueString);
			}
		}

		return null;
	}

	/**
	 * Find integer parameter.
	 *
	 * @param paramName
	 *            the param name
	 * @return the integer
	 */
	protected final Integer findIntegerParameter(final String paramName) {
		final String parameterValueString = findStringParameter(paramName);

		if (parameterValueString != null) {
			try {
				return Integer.parseInt(parameterValueString);
			} catch (final NumberFormatException ex) {
				addError(MensajeCodigo.G_013, paramName);
			}
		}

		return null;
	}

	/**
	 * Find boolean parameter.
	 *
	 * @param paramName
	 *            the param name
	 * @return the boolean
	 */
	protected final Boolean findBooleanParameter(final String paramName) {
		final String parameterValueString = findStringParameter(paramName);

		if (parameterValueString != null) {
			return Boolean.parseBoolean(parameterValueString);
		}

		return null;
	}

	/**
	 * Find string parameter.
	 *
	 * @param paramName
	 *            the param name
	 * @return the string
	 */
	protected final String findStringParameter(final String paramName) {
		if (prbtData.getPrpmMap().containsKey(paramName)) {
			final String parameterValue = prbtData.getPrpmMap().get(paramName).getValor();

			if (parameterValue == null || parameterValue.isEmpty()) {
				addError(MensajeCodigo.G_012, paramName);
			} else {
				return parameterValue;
			}
		} else {
			addError(MensajeCodigo.G_012, paramName);
		}

		return null;
	}

	/**
	 * Adds the prit salida.
	 *
	 * @param itemId
	 *            the item id
	 */
	public final void addPritSalida(@NonNull final Long itemId) {
		prbtData.getItemSalidaList().add(itemId);
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
}
