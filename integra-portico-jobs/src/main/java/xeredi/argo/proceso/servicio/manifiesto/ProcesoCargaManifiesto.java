package xeredi.argo.proceso.servicio.manifiesto;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.maestro.bo.ParametroBO;
import xeredi.argo.model.maestro.bo.ParametroBOFactory;
import xeredi.argo.model.maestro.vo.ParametroVO;
import xeredi.argo.model.metamodelo.vo.Entidad;
import xeredi.argo.model.metamodelo.vo.TipoDato;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.seguridad.bo.UsuarioBO;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.bo.escala.EscalaBO;
import xeredi.argo.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.argo.model.servicio.io.manifiesto.ManifiestoFileImport;
import xeredi.argo.model.servicio.io.manifiesto.ManifiestoMensaje;
import xeredi.argo.model.servicio.vo.ServicioCriterioVO;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.proceso.FiledateComparator;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaManifiesto.
 */
public final class ProcesoCargaManifiesto extends ProcesoTemplate {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ProcesoCargaManifiesto.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void prepararProcesos() {
		final ArchivoBO archBO = new ArchivoBO();

		final String folderPath = confService.getString(ConfigurationKey.manifiesto_files_entrada_home);
		final String userBatch = confService.getString(ConfigurationKey.user_batch);

		final UsuarioBO usroBO = new UsuarioBO();
		final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

		usroCriterio.setLogin(userBatch);

		try {
			final UsuarioVO usro = usroBO.selectObject(usroCriterio);

			final File folder = new File(folderPath);
			final File[] files = folder.listFiles();

			if (files != null && files.length > 0) {
				Arrays.sort(files, new FiledateComparator());

				for (final File file : files) {
					try {
						if (LOG.isInfoEnabled()) {
							LOG.info("Crear proceso para archivo: " + file.getCanonicalPath());
						}

						final ArchivoVO arch = archBO.create(file, ArchivoSentido.E);

						prbtService.crear(usro.getId(), ProcesoTipo.MAN_CARGA, null, ItemTipo.arch,
								Arrays.asList(arch.getArin().getId()));

						file.delete();
					} catch (final ApplicationException ex) {
						LOG.fatal(ex, ex);
					} catch (final IOException ex) {
						LOG.fatal(ex, ex);
					}
				}
			}
		} catch (final InstanceNotFoundException ex) {
			LOG.fatal(ex, ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void ejecutarProceso() {
		for (final ProcesoItemVO prit : prbtData.getPritEntradaList()) {
			try {
				final ArchivoBO flsrBO = new ArchivoBO();
				final ArchivoInfoVO arin = flsrBO.select(prit.getItemId());

				LOG.info("Importar: " + arin.getNombre());

				try (final InputStream stream = flsrBO.selectStream(arin.getId())) {
					final ManifiestoFileImport fileImport = new ManifiestoFileImport(this);
					final List<String> lines = IOUtils.readLines(stream);
					final int primeraLinea = fileImport.findPrimeraLinea(lines);

					if (prbtData.getPrmnList().isEmpty()) {
						fileImport.validarSegmentos(lines, primeraLinea);
					}
					if (prbtData.getPrmnList().isEmpty()) {
						fileImport.readMaestros(lines, primeraLinea);
					}
					if (prbtData.getPrmnList().isEmpty()) {
						// FIXME Obtener la fecha de vigencia
						final Date fechaVigencia = Calendar.getInstance().getTime();

						buscarMaestros(fechaVigencia);
						buscarOrganizaciones(fechaVigencia);

						findEscala(fileImport, fechaVigencia);
					}
					if (prbtData.getPrmnList().isEmpty()) {
						fileImport.readFile(lines, primeraLinea);
					}
					if (prbtData.getPrmnList().isEmpty()) {
						final ManifiestoMensaje mensaje = fileImport.getMensaje();
						final ManifiestoBO srvcBO = new ManifiestoBO(prbtData.getPrbt().getUsro().getId());

						switch (mensaje) {
						case MANIFIESTO_ALTA:
							try {
								if (LOG.isDebugEnabled()) {
									LOG.debug("Alta de un nuevo manifiesto");
								}

								srvcBO.insert(fileImport.getManifiestoVO(), fileImport.getSsrvList(),
										fileImport.getSsssList(), arin.getId());

								prbtData.getItemSalidaList().add(fileImport.getManifiestoVO().getId());
							} catch (final DuplicateInstanceException ex) {
								throw new Error(ex);
							}

							break;

						default:
							break;
						}
					}
				} catch (final IOException ex) {
					LOG.error(ex, ex);

					addError(MensajeCodigo.G_010, "archivo:" + arin.getNombre() + ", error:" + ex.getMessage());
				} catch (final InstanceNotFoundException ex) {
					LOG.error(ex, ex);

					addError(MensajeCodigo.G_000, "archivo:" + arin.getNombre() + ", error:" + ex.getMessage());
				}
			} catch (final InstanceNotFoundException ex) {
				LOG.fatal(ex, ex);

				addError(MensajeCodigo.G_000, "archivoId:" + prit.getItemId() + ", error:" + ex.getMessage());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ProcesoTipo getProcesoTipo() {
		return ProcesoTipo.MAN_CARGA;
	}

	/**
	 * Find escala.
	 *
	 * @param fileImport
	 *            the file import
	 * @param fechaVigencia
	 *            the fecha vigencia
	 */
	private void findEscala(final ManifiestoFileImport fileImport, final Date fechaVigencia) {
		final String recintoAduaneroCode = fileImport.getRecintoAduanero();

		PuertoVO prto = null;
		ServicioVO escala = null;

		if (recintoAduaneroCode == null) {
			addError(MensajeCodigo.G_001, Entidad.RECINTO_ADUANERO.name() + ": " + recintoAduaneroCode);
		} else {
			final PuertoBO prtoBO = new PuertoBO();
			final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

			prtoCriterio.setRecAduanero(recintoAduaneroCode);

			try {
				prto = prtoBO.selectObject(prtoCriterio);

				if (prbtData.getPrmnList().isEmpty()) {
					// Busqueda de la escala
					final EscalaBO escaBO = new EscalaBO(prbtData.getPrbt().getUsro().getId());
					final ServicioCriterioVO srvcCriterioVO = new ServicioCriterioVO();

					srvcCriterioVO.setPrto(new PuertoCriterioVO());
					srvcCriterioVO.getPrto().setId(prto.getId());

					srvcCriterioVO.setAnno(fileImport.getEscalaVO().getAnno());
					srvcCriterioVO.setNumero(fileImport.getEscalaVO().getNumero());
					srvcCriterioVO.setEntiId(Entidad.ESCALA.getId());

					try {
						escala = escaBO.selectObject(srvcCriterioVO);

						try {
							// Busqueda del buque de la escala
							final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.BUQUE.getId());
							final ParametroVO buque = prmtBO.select(
									escala.getItdtMap().get(TipoDato.BUQUE.getId()).getPrmt().getId(), null,
									fechaVigencia);

							escala.getItdtMap().get(TipoDato.BUQUE.getId()).setPrmt(buque);

							fileImport.setEscalaVO(escala);
						} catch (final InstanceNotFoundException ex) {
							throw new Error(ex);
						}
					} catch (final InstanceNotFoundException ex) {
						addError(MensajeCodigo.G_001, Entidad.ESCALA.name() + ": " + prto.getCodigoCorto() + '/'
								+ srvcCriterioVO.getAnno() + '/' + srvcCriterioVO.getNumero());
					}
				}
			} catch (final InstanceNotFoundException ex) {
				addError(MensajeCodigo.G_001, Entidad.SUBPUERTO.name() + ": " + recintoAduaneroCode);
			}
		}

	}
}
