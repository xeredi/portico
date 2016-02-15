package xeredi.argo.model.proceso.batch.pesca;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.proxy.ConfigurationProxy;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.ConfigurationKey;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.model.servicio.bo.pesca.ManifiestoPescaBO;
import xeredi.argo.model.servicio.io.pesca.PescaFileImport;
import xeredi.argo.proceso.FiledateComparator;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaPesca.
 */
public final class ProcesoCargaPesca extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaPesca.class);

    /** The prto map. */
    private Map<String, PuertoVO> prtoMap;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepararProcesos() {
        final ProcesoBO prbtBO = new ProcesoBO();
        final PuertoBO prtoBO = new PuertoBO();
        final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

        prtoMap = new HashMap<>();

        for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
            prtoMap.put(prto.getCodigoCorto(), prto);
        }

        final String folderPath = ConfigurationProxy.getString(ConfigurationKey.pesca_files_entrada_home);
        final File folder = new File(folderPath);
        final File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            Arrays.sort(files, new FiledateComparator());

            for (final File file : files) {
                try {
                    if (LOG.isInfoEnabled()) {
                        LOG.info("Crear proceso para archivo: " + file.getCanonicalPath());
                    }

                    prbtBO.crear(ProcesoTipo.PES_CARGA, null, null, null, file);

                    file.delete();
                } catch (final IOException ex) {
                    LOG.fatal(ex, ex);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutarProceso() {
        if (prbtData.getPrmnList().isEmpty()) {
            for (final ArchivoInfoVO arin : prbtData.getArinEntradaList()) {
                LOG.info("Importar: " + arin.getNombre());

                final ArchivoBO flsrBO = new ArchivoBO();

                try (final InputStream stream = flsrBO.selectStream(arin.getId())) {
                    final List<String> lines = IOUtils.readLines(stream);
                    final PescaFileImport pescaFileImport = new PescaFileImport(this);

                    pescaFileImport.readMaestros(lines);

                    if (prbtData.getPrmnList().isEmpty()) {
                        buscarMaestros(pescaFileImport.getFechaReferencia());
                    }

                    if (prbtData.getPrmnList().isEmpty()) {
                        pescaFileImport.readFile(lines, arin.getNombre());
                    }

                    if (prbtData.getPrmnList().isEmpty()) {
                        final ManifiestoPescaBO srvcBO = new ManifiestoPescaBO();

                        try {
                            // FIXME Verificar si ya se ha cargado el archivo

                            srvcBO.insert(pescaFileImport.getSrvc(), pescaFileImport.getSsrvList(), null, arin.getId());

                            prbtData.getItemSalidaList().add(pescaFileImport.getSrvc().getId());
                        } catch (final DuplicateInstanceException ex) {
                            addError(MensajeCodigo.G_011, pescaFileImport.getSrvc().getEtiqueta());
                        }
                    }
                } catch (final IOException ex) {
                    LOG.error(ex, ex);

                    addError(MensajeCodigo.G_010, "archivo: " + arin.getNombre() + ", error: " + ex.getMessage());
                } catch (final InstanceNotFoundException ex) {
                    LOG.error(ex, ex);

                    addError(MensajeCodigo.G_000, "archivo: " + arin.getNombre() + ", error: " + ex.getMessage());
                }
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

    /**
     * Gets the prto map.
     *
     * @return the prto map
     */
    public Map<String, PuertoVO> getPrtoMap() {
        return prtoMap;
    }
}
