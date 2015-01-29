package xeredi.integra.proceso.servicio.pesca;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoArchivoVO;
import xeredi.integra.model.proceso.vo.ProcesoItemVO;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.io.pesca.PescaFileImport;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaPesca.
 */
public final class ProcesoCargaPesca extends ProcesoTemplate {
    /** The path entrada. */
    private static String PATH_ENTRADA;

    /** The path procesado. */
    private static String PATH_PROCESADO;

    /** The path erroneo. */
    private static String PATH_ERRONEO;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutar() {
        PATH_ENTRADA = ConfigurationProxy.getString(ConfigurationKey.pesca_files_entrada_home);
        PATH_PROCESADO = ConfigurationProxy.getString(ConfigurationKey.pesca_files_procesado_home);
        PATH_ERRONEO = ConfigurationProxy.getString(ConfigurationKey.pesca_files_erroneo_home);

        if (prbtVO.getPrmnList().isEmpty()) {
            for (final ProcesoArchivoVO prarVO : prbtVO.getPrarEntradaList()) {
                final String pathArchivo = PATH_ENTRADA + "/" + prarVO.getNombre();

                LOG.info("Importar: " + pathArchivo);

                try (final InputStream stream = new FileInputStream(pathArchivo)) {
                    final List<String> lines = IOUtils.readLines(stream);
                    final PescaFileImport pescaFileImport = new PescaFileImport(prbtVO);

                    pescaFileImport.readMaestros(lines);

                    if (prbtVO.getPrmnList().isEmpty()) {
                        buscarMaestros(pescaFileImport.getCodigoMaestroMap(), pescaFileImport.getSrvc().getFref());
                    }

                    if (prbtVO.getPrmnList().isEmpty()) {
                        pescaFileImport.setMaestroMap(maestroMap);
                        pescaFileImport.readFile(lines, prarVO.getNombre());
                    }

                    if (prbtVO.getPrmnList().isEmpty()) {
                        final ServicioBO srvcBO = new ServicioBO();

                        try {
                            // FIXME Verificar si ya se ha cargado el archivo

                            srvcBO.insert(pescaFileImport.getSrvc(), pescaFileImport.getSsrvList(), null);

                            final ProcesoItemVO pritSalidaVO = new ProcesoItemVO();

                            pritSalidaVO.setItemId(pescaFileImport.getSrvc().getId());
                            prbtVO.getPritSalidaList().add(pritSalidaVO);
                        } catch (final DuplicateInstanceException ex) {
                            addError(MensajeCodigo.G_011, pescaFileImport.getSrvc().getEtiqueta());
                        }
                    }

                    if (LOG.isInfoEnabled()) {
                        LOG.info(prbtVO.getPrmnList());
                    }
                } catch (final IOException ex) {
                    LOG.error(ex, ex);

                    addError(MensajeCodigo.G_010, "archivo:" + pathArchivo + ", error:" + ex.getMessage());
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
