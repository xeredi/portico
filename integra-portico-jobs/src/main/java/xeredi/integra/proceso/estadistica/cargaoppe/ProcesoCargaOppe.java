package xeredi.integra.proceso.estadistica.cargaoppe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaOppe2.
 */
public final class ProcesoCargaOppe extends ProcesoTemplate {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(ProcesoCargaOppe.class);

    /** The Constant FILENAME_PATTERN. */
    private static final String FILENAME_PATTERN = "{0}{1,number,0000}{2,number,00}.{3}";

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
                try (final InputStream stream = flsrBO.select(arinList.get(0).getId());
                        final ZipInputStream zis = new ZipInputStream(stream)) {
                    if (prmnList.isEmpty()) {
                        getEntry(zis, pepr, EstadisticaFileType.EPP);
                        getEntry(zis, pepr, EstadisticaFileType.EAP);
                        getEntry(zis, pepr, EstadisticaFileType.EAV);
                        getEntry(zis, pepr, EstadisticaFileType.EAE);
                        getEntry(zis, pepr, EstadisticaFileType.EMM);
                        getEntry(zis, pepr, EstadisticaFileType.EME);
                        getEntry(zis, pepr, EstadisticaFileType.EMT);
                    }

                    if (prmnList.isEmpty()) {
                        isSigma = fileImport.verifyIsSigma(getEntry(zis, pepr, EstadisticaFileType.EPP));

                        fileImport.readMaestrosEPP(getEntry(zis, pepr, EstadisticaFileType.EPP));
                        fileImport.readMaestrosEAP(getEntry(zis, pepr, EstadisticaFileType.EAP));
                        fileImport.readMaestrosEAV(getEntry(zis, pepr, EstadisticaFileType.EAV));
                        fileImport.readMaestrosEAE(getEntry(zis, pepr, EstadisticaFileType.EAE));
                        fileImport.readMaestrosEMM(getEntry(zis, pepr, EstadisticaFileType.EMM));
                        fileImport.readMaestrosEME(getEntry(zis, pepr, EstadisticaFileType.EME), isSigma);
                        fileImport.readMaestrosEMT(getEntry(zis, pepr, EstadisticaFileType.EMT));
                    }

                    if (prmnList.isEmpty()) {
                        buscarMaestros(Calendar.getInstance().getTime());
                    }

                    if (prmnList.isEmpty()) {
                        fileImport.readEPP(getEntry(zis, pepr, EstadisticaFileType.EPP));
                        fileImport.readEAP(getEntry(zis, pepr, EstadisticaFileType.EAP));
                        fileImport.readEAV(getEntry(zis, pepr, EstadisticaFileType.EAV));
                        fileImport.readEAE(getEntry(zis, pepr, EstadisticaFileType.EAE));
                        fileImport.readEMM(getEntry(zis, pepr, EstadisticaFileType.EMM));
                        fileImport.readEME(getEntry(zis, pepr, EstadisticaFileType.EME), isSigma);
                        fileImport.readEMT(getEntry(zis, pepr, EstadisticaFileType.EMT));
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
    protected ProcesoModulo getProcesoModulo() {
        return ProcesoModulo.E;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ItemTipo getItemTipoSalida() {
        return ItemTipo.pepr;
    }

    /**
     * Gets the filename.
     *
     * @param peprVO
     *            the pepr vo
     * @param fileType
     *            the file type
     * @return the filename
     */
    private static String getFilename(final PeriodoProcesoVO peprVO, final EstadisticaFileType fileType) {
        return MessageFormat.format(FILENAME_PATTERN, new Object[] { peprVO.getAutp().getParametro(), peprVO.getAnio(),
                peprVO.getMes(), fileType.name() });
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
    private InputStream getEntry(final ZipInputStream zis, final PeriodoProcesoVO peprVO,
            final EstadisticaFileType fileType) {
        final String filename = getFilename(peprVO, fileType);

        ZipEntry entry = null;

        try {
            do {
                entry = zis.getNextEntry();

                if (entry != null && entry.getName().equals(filename)) {
                    final byte[] buffer = new byte[(int) entry.getSize()];

                    zis.read(buffer);

                    return new ByteArrayInputStream(buffer);
                }
            } while (entry != null);

        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, fileType.name());
        }

        return null;
    }

}
