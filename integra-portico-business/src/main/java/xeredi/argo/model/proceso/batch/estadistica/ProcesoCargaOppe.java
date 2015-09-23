package xeredi.argo.model.proceso.batch.estadistica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.bo.PuertoBO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.DuplicateInstanceException;
import xeredi.argo.model.comun.exception.InstanceNotFoundException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.comun.vo.PuertoCriterioVO;
import xeredi.argo.model.comun.vo.PuertoVO;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.io.EstadisticaFileType;
import xeredi.argo.model.estadistica.io.OppeFileImport;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.MensajeCodigo;
import xeredi.argo.model.proceso.vo.ProcesoTipo;
import xeredi.argo.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaOppe2.
 */
public final class ProcesoCargaOppe extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaOppe.class);

    /**
     * The Enum params.
     */
    public enum params {
        /** The autp. */
        autp,

        /** The mes. */
        mes,

        /** The anio. */
        anio,

        /** The sobreescribir. */
        sobreescribir
    }

    /** The is sigma. */
    private boolean isSigma;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepararProcesos() {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void ejecutarProceso() {
        final ArchivoBO flsrBO = new ArchivoBO();
        final OppeFileImport fileImport = new OppeFileImport(this);
        final PeriodoProcesoVO pepr = new PeriodoProcesoVO();
        final Map<String, PuertoVO> prtoMap = new HashMap<>();

        // Lectura de los parametros de entrada
        final String sprtCodigo = prpmMap.get(params.autp.name()).getValor();
        final int anio = Integer.parseInt(prpmMap.get(params.anio.name()).getValor());
        final int mes = Integer.parseInt(prpmMap.get(params.mes.name()).getValor());
        final boolean sobreescribir = Boolean.parseBoolean(prpmMap.get(params.sobreescribir.name()).getValor());

        LOG.info("Carga estadisticas: " + sprtCodigo + ", " + anio + ", " + mes);

        try {
            final SuperpuertoBO sprtBO = new SuperpuertoBO();
            final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

            sprtCriterio.setCodigo(sprtCodigo);

            final SuperpuertoVO sprt = sprtBO.selectObject(sprtCriterio);

            final PuertoBO prtoBO = new PuertoBO();
            final PuertoCriterioVO prtoCriterio = new PuertoCriterioVO();

            prtoCriterio.setSprtId(sprt.getId());

            for (final PuertoVO prto : prtoBO.selectList(prtoCriterio)) {
                prtoMap.put(prto.getCodigo(), prto);
            }

            fileImport.setPrtoMap(prtoMap);

            pepr.setSprt(sprt);
            pepr.setAnio(anio);
            pepr.setMes(mes);
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.E_003, sprtCodigo);
        }

        if (prmnList.isEmpty()) {
            final ProcesoBO prbtBO = new ProcesoBO();

            final List<ArchivoInfoVO> arinList = prbtBO.selectArinEntradaList(prbt.getId());

            if (arinList.isEmpty()) {
                addError(MensajeCodigo.G_000, EstadisticaFileType.zip.name());
            } else {
                final ArchivoInfoVO arin = arinList.get(0);

                pepr.setArin(arin);

                try (final InputStream stream = flsrBO.selectStream(arin.getId())) {
                    final Map<EstadisticaFileType, List<String>> mapFiles = readFile(stream);

                    if (prmnList.isEmpty()) {
                        isSigma = fileImport.verifyIsSigma(mapFiles.get(EstadisticaFileType.EPP));

                        fileImport.readMaestrosEPP(mapFiles.get(EstadisticaFileType.EPP));
                        fileImport.readMaestrosEAP(mapFiles.get(EstadisticaFileType.EAP));
                        fileImport.readMaestrosEAV(mapFiles.get(EstadisticaFileType.EAV));
                        fileImport.readMaestrosEAE(mapFiles.get(EstadisticaFileType.EAE));
                        fileImport.readMaestrosEMM(mapFiles.get(EstadisticaFileType.EMM));
                        fileImport.readMaestrosEME(mapFiles.get(EstadisticaFileType.EME), isSigma);
                        fileImport.readMaestrosEMT(mapFiles.get(EstadisticaFileType.EMT));
                    }

                    if (prmnList.isEmpty()) {
                        buscarMaestros(Calendar.getInstance().getTime());
                    }

                    if (prmnList.isEmpty()) {
                        fileImport.readEPP(mapFiles.get(EstadisticaFileType.EPP));
                        fileImport.readEAP(mapFiles.get(EstadisticaFileType.EAP));
                        fileImport.readEAV(mapFiles.get(EstadisticaFileType.EAV));
                        fileImport.readEAE(mapFiles.get(EstadisticaFileType.EAE));
                        fileImport.readEMM(mapFiles.get(EstadisticaFileType.EMM));
                        fileImport.readEME(mapFiles.get(EstadisticaFileType.EME), isSigma);
                        fileImport.readEMT(mapFiles.get(EstadisticaFileType.EMT));
                    }
                } catch (final IOException ex) {
                    addError(MensajeCodigo.G_010,
                            "archivo: " + EstadisticaFileType.zip.name() + "error: " + ex.getMessage());
                } catch (final InstanceNotFoundException ex) {
                    addError(MensajeCodigo.G_000,
                            "archivo: " + EstadisticaFileType.zip.name() + "error: " + ex.getMessage());
                }
            }
        }

        if (prmnList.isEmpty()) {
            LOG.info("Guardar Datos");

            final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

            try {
                peprBO.cargarArchivo(pepr, prtoMap, fileImport.getEstdList(), sobreescribir);

                itemSalidaList.add(pepr.getId());
            } catch (final DuplicateInstanceException ex) {
                addError(MensajeCodigo.E_001, "Periodo de Proceso: " + pepr.getEtiqueta());
            }
        }

        if (!prmnList.isEmpty()) {
            LOG.error("Errores en la carga");
            LOG.info(prmnList);
        }

        LOG.info("Fin Proceso");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ProcesoTipo getProcesoTipo() {
        return ProcesoTipo.EST_CARGA;
    }

    /**
     * Gets the entry.
     *
     * @param stream
     *            the stream
     * @return the entry
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private Map<EstadisticaFileType, List<String>> readFile(final InputStream stream) throws IOException {
        final Map<EstadisticaFileType, List<String>> fileMap = new HashMap<EstadisticaFileType, List<String>>();

        try (final ZipArchiveInputStream zis = new ZipArchiveInputStream(stream)) {
            ArchiveEntry entry = null;

            do {
                entry = zis.getNextEntry();

                if (entry != null) {
                    try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                        final String fileExtension = entry.getName().substring(entry.getName().lastIndexOf('.') + 1)
                                .toUpperCase();
                        final byte[] buffer = new byte[2048];

                        int bytesRead = 0;

                        do {
                            bytesRead = zis.read(buffer);

                            if (bytesRead > 0) {
                                baos.write(buffer, 0, bytesRead);
                            }
                        } while (bytesRead > 0);

                        fileMap.put(EstadisticaFileType.valueOf(fileExtension),
                                IOUtils.readLines(new ByteArrayInputStream(baos.toByteArray())));
                    }
                }
            } while (entry != null);
        }

        return fileMap;
    }
}