package xeredi.integra.proceso.estadistica.cargaoppe;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.proxy.ConfigurationProxy;
import xeredi.integra.model.comun.vo.ConfigurationKey;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.io.EstadisticaFileType;
import xeredi.integra.model.estadistica.io.OppeFileImport;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.maestro.bo.ParametroBO;
import xeredi.integra.model.metamodelo.vo.Entidad;
import xeredi.integra.model.proceso.vo.MensajeCodigo;
import xeredi.integra.model.proceso.vo.ProcesoModulo;
import xeredi.integra.model.proceso.vo.ProcesoTipo;
import xeredi.integra.proceso.ProcesoTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoCargaOppe2.
 */
public final class ProcesoCargaOppe extends ProcesoTemplate {

    /** The Constant FILENAME_PATTERN. */
    private static final String FILENAME_PATTERN = "{0}{1,number,0000}{2,number,00}.{3}";

    /** The path entrada. */
    private static String PATH_ENTRADA;

    /** The path procesado. */
    private static String PATH_PROCESADO;

    /** The path erroneo. */
    private static String PATH_ERRONEO;

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
    protected void ejecutar() {
        PATH_ENTRADA = ConfigurationProxy.getString(ConfigurationKey.estadistica_files_oppe_entrada_home);
        PATH_PROCESADO = ConfigurationProxy.getString(ConfigurationKey.estadistica_files_oppe_procesado_home);
        PATH_ERRONEO = ConfigurationProxy.getString(ConfigurationKey.estadistica_files_oppe_erroneo_home);

        final OppeFileImport fileImport = new OppeFileImport(prbtVO);
        final PeriodoProcesoVO peprVO = new PeriodoProcesoVO();

        // Lectura de los parametros de entrada
        final ParametroBO prmtBO = new ParametroBO();
        final long autpId = Long.parseLong(prbtVO.getPrpmMap().get(AUTP_PARAM));
        final int anio = Integer.parseInt(prbtVO.getPrpmMap().get(ANIO_PARAM));
        final int mes = Integer.parseInt(prbtVO.getPrpmMap().get(MES_PARAM));
        final boolean sobreescribir = Boolean.parseBoolean(prbtVO.getPrpmMap().get(SOBREESCRIBIR_PARAM));

        LOG.info("Carga estadisticas: " + autpId + ", " + anio + ", " + mes);

        try {
            peprVO.setAutp(prmtBO.select(autpId, ConfigurationProxy.getString(ConfigurationKey.language_default),
                    new Date()));
            peprVO.setAnio(anio);
            peprVO.setMes(mes);
        } catch (final InstanceNotFoundException ex) {
            addError(MensajeCodigo.G_001, "entidad: " + Entidad.AUTORIDAD_PORTUARIA.name() + ", codigo: " + autpId);
        }

        if (prbtVO.getPrmnList().isEmpty()) {
            try (final ZipFile zf = new ZipFile(getFilepath(PATH_ENTRADA, peprVO, EstadisticaFileType.zip))) {
                if (prbtVO.getPrmnList().isEmpty()) {
                    getEntry(zf, peprVO, EstadisticaFileType.EPP);
                    getEntry(zf, peprVO, EstadisticaFileType.EAP);
                    getEntry(zf, peprVO, EstadisticaFileType.EAV);
                    getEntry(zf, peprVO, EstadisticaFileType.EAE);
                    getEntry(zf, peprVO, EstadisticaFileType.EMM);
                    getEntry(zf, peprVO, EstadisticaFileType.EME);
                    getEntry(zf, peprVO, EstadisticaFileType.EMT);
                }

                if (prbtVO.getPrmnList().isEmpty()) {
                    isSigma = fileImport.verifyIsSigma(getEntry(zf, peprVO, EstadisticaFileType.EPP));

                    fileImport.readMaestrosEPP(getEntry(zf, peprVO, EstadisticaFileType.EPP));
                    fileImport.readMaestrosEAP(getEntry(zf, peprVO, EstadisticaFileType.EAP));
                    fileImport.readMaestrosEAV(getEntry(zf, peprVO, EstadisticaFileType.EAV));
                    fileImport.readMaestrosEAE(getEntry(zf, peprVO, EstadisticaFileType.EAE));
                    fileImport.readMaestrosEMM(getEntry(zf, peprVO, EstadisticaFileType.EMM));
                    fileImport.readMaestrosEME(getEntry(zf, peprVO, EstadisticaFileType.EME), isSigma);
                    fileImport.readMaestrosEMT(getEntry(zf, peprVO, EstadisticaFileType.EMT));
                }

                if (prbtVO.getPrmnList().isEmpty()) {
                    buscarMaestros(fileImport.getCodigoMaestroMap(), Calendar.getInstance().getTime());

                    fileImport.setMaestroMap(maestroMap);
                }

                if (prbtVO.getPrmnList().isEmpty()) {
                    fileImport.readEPP(getEntry(zf, peprVO, EstadisticaFileType.EPP));
                    fileImport.readEAP(getEntry(zf, peprVO, EstadisticaFileType.EAP));
                    fileImport.readEAV(getEntry(zf, peprVO, EstadisticaFileType.EAV));
                    fileImport.readEAE(getEntry(zf, peprVO, EstadisticaFileType.EAE));
                    fileImport.readEMM(getEntry(zf, peprVO, EstadisticaFileType.EMM));
                    fileImport.readEME(getEntry(zf, peprVO, EstadisticaFileType.EME), isSigma);
                    fileImport.readEMT(getEntry(zf, peprVO, EstadisticaFileType.EMT));
                }
            } catch (final IOException ex) {
                addError(MensajeCodigo.G_010, EstadisticaFileType.zip.name());
            }
        }

        if (prbtVO.getPrmnList().isEmpty()) {
            LOG.info("Guardar Datos");

            final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

            try {
                peprBO.cargarArchivo(peprVO, fileImport.getAutpMap(), fileImport.getEstdList(), sobreescribir);
            } catch (final DuplicateInstanceException ex) {
                addError(MensajeCodigo.E_001,
                        "Periodo de Proceso: " + peprVO.getAutp().getParametro() + " " + peprVO.getAnio() + " "
                                + peprVO.getMes());
            }
        }

        if (!prbtVO.getPrmnList().isEmpty()) {
            LOG.error("Errores en la carga");
            LOG.info(prbtVO.getPrmnList());
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
     * Gets the filepath.
     *
     * @param folder
     *            the folder
     * @param peprVO
     *            the pepr vo
     * @param fileType
     *            the file type
     * @return the filepath
     */
    private static String getFilepath(final String folder, final PeriodoProcesoVO peprVO,
            final EstadisticaFileType fileType) {
        return folder + '/' + getFilename(peprVO, fileType);
    }

    /**
     * Gets the entry.
     *
     * @param zf
     *            the zf
     * @param peprVO
     *            the pepr vo
     * @param fileType
     *            the file type
     * @return the entry
     */
    private InputStream getEntry(final ZipFile zf, final PeriodoProcesoVO peprVO, final EstadisticaFileType fileType) {
        final ZipEntry entry = zf.getEntry(getFilename(peprVO, fileType));

        try {
            return entry == null ? null : zf.getInputStream(entry);
        } catch (final IOException ex) {
            addError(MensajeCodigo.G_010, fileType.name());
        }

        return null;
    }

}
