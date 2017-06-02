package xeredi.argo.model.proceso.batch.pesca;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import lombok.Getter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.service.PuertoService;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ArchivoSentido;
import xeredi.argo.model.comun.vo.ArchivoVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.proceso.vo.ItemTipo;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoItemVO;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.seguridad.service.UsuarioService;
import xeredi.argo.model.seguridad.vo.UsuarioCriterioVO;
import xeredi.argo.model.seguridad.vo.UsuarioVO;
import xeredi.argo.model.servicio.bo.pesca.ManifiestoPescaBO;
import xeredi.argo.model.servicio.io.pesca.PescaFileImport;
import xeredi.argo.model.servicio.vo.ServicioVO;
import xeredi.argo.proceso.FiledateComparator;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaPesca.
 */
public final class ProcesoCargaPesca extends ProcesoTemplate {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ProcesoCargaPesca.class);

	@Inject
	private PuertoService prtoService;

	@Inject
	private ArchivoService archService;

	@Inject
	private UsuarioService usroService;

	/** The prto map. */
	@Getter
	private Map<String, PuertoVO> prtoMap;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void prepararProcesos() {
		final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

		prtoMap = new HashMap<>();

		for (final PuertoVO prto : prtoService.selectList(prtoCriterio)) {
			prtoMap.put(prto.getCodigoCorto(), prto);
		}

		final String folderPath = confService.getString(ConfigurationKey.pesca_files_entrada_home);
		final String userBatch = confService.getString(ConfigurationKey.user_batch);

		final UsuarioCriterioVO usroCriterio = new UsuarioCriterioVO();

		usroCriterio.setLogin(userBatch);

		try {
			final UsuarioVO usro = usroService.selectObject(usroCriterio);

			final File folder = new File(folderPath);
			final File[] files = folder.listFiles();

			if (files != null && files.length > 0) {
				Arrays.sort(files, new FiledateComparator());

				for (final File file : files) {
					try {
						if (LOG.isInfoEnabled()) {
							LOG.info("Crear proceso para archivo: " + file.getCanonicalPath());
						}

						final ArchivoVO arch = archService.create(file, ArchivoSentido.E);

						prbtService.crear(usro.getId(), ProcesoTipo.PES_CARGA, null, ItemTipo.arch,
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
				final ArchivoInfoVO arin = archService.select(prit.getItemId());

				LOG.info("Importar: " + arin.getNombre());

				try (final InputStream stream = archService.selectStream(arin.getId())) {
					final List<String> lines = IOUtils.readLines(stream);
					final PescaFileImport pescaFileImport = new PescaFileImport(this);

					pescaFileImport.readMaestros(lines);

					if (prbtData.getPrmnList().isEmpty()) {
						pescaFileImport.readFile(lines, arin.getNombre());
					}

					if (prbtData.getPrmnList().isEmpty()) {
						final ManifiestoPescaBO srvcBO = new ManifiestoPescaBO(prbtData.getPrbt().getUsro().getId());

						try {
							// FIXME Verificar si ya se ha cargado el archivo
							srvcBO.insertList(pescaFileImport.getSrvcMap(), pescaFileImport.getSsrvMap(), null,
									arin.getId());

							for (final ServicioVO srvc : pescaFileImport.getSrvcMap().values()) {
								prbtData.getItemSalidaList().add(srvc.getId());
							}
						} catch (final DuplicateInstanceException ex) {
							addError(MensajeCodigo.G_011, ex.getMessage());
						}
					}
				} catch (final IOException ex) {
					LOG.error(ex, ex);

					addError(MensajeCodigo.G_010, "archivo: " + arin.getNombre() + ", error: " + ex.getMessage());
				} catch (final InstanceNotFoundException ex) {
					LOG.error(ex, ex);

					addError(MensajeCodigo.G_000, "archivo: " + arin.getNombre() + ", error: " + ex.getMessage());
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
		return ProcesoTipo.PES_CARGA;
	}
}
