package xeredi.integra.proceso.servicio.pesca;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.pesca.ManifiestoPescaBO;
import xeredi.integra.model.servicio.io.pesca.PescaFileImport;
import xeredi.integra.proceso.FiledateComparator;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaPesca.
 */
public final class ProcesoCargaPesca extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaPesca.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepararProcesos() {
        final ProcesoBO prbtBO = new ProcesoBO();

        final String folderPath = ConfigurationProxy.getString(ConfigurationKey.pesca_files_entrada_home);
        final File folder = new File(folderPath);
        final File[] files = folder.listFiles();

        if (files.length > 0) {
            Arrays.sort(files, new FiledateComparator());

            for (final File file : files) {
                try {
                    if (LOG.isInfoEnabled()) {
                        LOG.info("Crear proceso para archivo: " + file.getCanonicalPath());
                    }

                    prbtBO.crear(ProcesoModulo.S, ProcesoTipo.PES_CARGA, null, null, file);

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
        if (prmnList.isEmpty()) {
            for (final ArchivoInfoVO arin : arinEntradaList) {
                LOG.info("Importar: " + arin.getNombre());

                final ArchivoBO flsrBO = new ArchivoBO();

                try (final InputStream stream = flsrBO.select(arin.getId())) {
                    final List<String> lines = IOUtils.readLines(stream);
                    final PescaFileImport pescaFileImport = new PescaFileImport(this);

                    pescaFileImport.readMaestros(lines);

                    if (prmnList.isEmpty()) {
                        buscarMaestros(pescaFileImport.getSrvc().getFref());
                    }

                    if (prmnList.isEmpty()) {
                        pescaFileImport.readFile(lines, arin.getNombre());
                    }

                    if (prmnList.isEmpty()) {
                        final ManifiestoPescaBO srvcBO = new ManifiestoPescaBO();

                        try {
                            // FIXME Verificar si ya se ha cargado el archivo

                            srvcBO.insert(pescaFileImport.getSrvc(), pescaFileImport.getSsrvList(), null, arin.getId());

                            final ProcesoItemVO pritSalidaVO = new ProcesoItemVO();

                            pritSalidaVO.setItemId(pescaFileImport.getSrvc().getId());
                            pritSalidaList.add(pritSalidaVO);
                        } catch (final DuplicateInstanceException ex) {
                            addError(MensajeCodigo.G_011, pescaFileImport.getSrvc().getEtiqueta());
                        }
                    }

                    if (LOG.isInfoEnabled()) {
                        LOG.info(prmnList);
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
     * {@inheritDoc}
     */
    @Override
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.S;
    }
}
