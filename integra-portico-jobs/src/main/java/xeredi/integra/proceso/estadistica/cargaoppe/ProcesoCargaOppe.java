package xeredi.integra.proceso.estadistica.cargaoppe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.io.EstadisticaFileType;
import xeredi.integra.model.estadistica.io.OppeFileImport;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.maestro.bo.ParametroBOFactory;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ItemTipo;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaOppe2.
 */
public final class ProcesoCargaOppe extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaOppe.class);

    /** The Constant AUTP_PARAM. */
    public static final String AUTP_PARAM = "autp";

    /** The Constant MES_PARAM. */
    public static final String MES_PARAM = "mes";

    /** The Constant ANIO_PARAM. */
    public static final String ANIO_PARAM = "anio";

    /** The Constant SOBREESCRIBIR_PARAM. */
    public static final String SOBREESCRIBIR_PARAM = "sobreescribir";

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

        // Lectura de los parametros de entrada
        final long autpId = Long.parseLong(prpmMap.get(AUTP_PARAM).getValor());
        final int anio = Integer.parseInt(prpmMap.get(ANIO_PARAM).getValor());
        final int mes = Integer.parseInt(prpmMap.get(MES_PARAM).getValor());
        final boolean sobreescribir = Boolean.parseBoolean(prpmMap.get(SOBREESCRIBIR_PARAM).getValor());

        LOG.info("Carga estadisticas: " + autpId + ", " + anio + ", " + mes);

        try {
            final ParametroBO prmtBO = ParametroBOFactory.newInstance(Entidad.AUTORIDAD_PORTUARIA.getId());

            pepr.setAutp(prmtBO.select(autpId, ConfigurationProxy.getString(ConfigurationKey.language_default),
                    new Date()));
            pepr.setAnio(anio);
            pepr.setMes(mes);
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_001, "entidad: " + Entidad.AUTORIDAD_PORTUARIA.name() + ", codigo: " + autpId);
        }

        if (prmnList.isEmpty()) {
            final ProcesoBO prbtBO = new ProcesoBO();

            final List<ArchivoInfoVO> arinList = prbtBO.selectArinEntradaList(prbt.getId());

            if (arinList.isEmpty()) {
                addError(MensajeCodigo.G_000, EstadisticaFileType.zip.name());
            } else {
                final ArchivoInfoVO arin = arinList.get(0);

                pepr.setArin(arin);

                try (final InputStream stream = flsrBO.select(arin.getId())) {
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
                peprBO.cargarArchivo(pepr, fileImport.getAutpMap(), fileImport.getEstdList(), sobreescribir);

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
     * {@inheritDoc}
     */
    @Override
    protected ItemTipo getItemTipoSalida() {
        return ItemTipo.pepr;
    }

    /**
     * Gets the entry.
     *
     * @param zis
     *            the zis
     * @param peprVO
     *            the pepr vo
     * @param fileType
     *            the file type
     * @return the entry
     */
    private Map<EstadisticaFileType, List<String>> readFile(final @Nonnull InputStream stream) throws IOException {
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
