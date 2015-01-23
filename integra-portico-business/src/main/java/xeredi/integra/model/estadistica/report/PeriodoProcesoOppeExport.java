package xeredi.integra.model.estadistica.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.io.EstadisticaFileType;
import xeredi.integra.model.estadistica.io.OppeFileExport;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.Entidad;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoOppeExport.
 */
public final class PeriodoProcesoOppeExport {

    /** The Constant LOG. */
    private static final Log LOG = LogFactory.getLog(PeriodoProcesoOppeExport.class);

    /**
     * Export.
     *
     * @param peprVO
     *            the pepr vo
     * @param stream
     *            the stream
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    public void export(final PeriodoProcesoVO peprVO, final ZipOutputStream stream) throws IOException,
    InstanceNotFoundException {
        Preconditions.checkNotNull(peprVO);
        Preconditions.checkNotNull(peprVO.getAutp());
        Preconditions.checkNotNull(peprVO.getAutp().getId());
        Preconditions.checkNotNull(peprVO.getAnio());
        Preconditions.checkNotNull(peprVO.getMes());

        final OppeFileExport export = new OppeFileExport();
        final Date exportDate = new Date();
        final EstadisticaBO estdBO = new EstadisticaBO();
        final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();
        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        peprCriterioVO.setAutpId(peprVO.getAutp().getId());
        peprCriterioVO.setAnio(peprVO.getAnio());
        peprCriterioVO.setMes(peprVO.getMes());

        estdCriterioVO.setPepr(peprCriterioVO);

        estdCriterioVO.setEntiId(Entidad.ACTIVIDAD_PESQUERA.getId());
        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EAP)));
        export.generarEAP(stream, estdBO.selectList(estdCriterioVO),
                TipoEstadisticaProxy.select(estdCriterioVO.getEntiId()));
        stream.closeEntry();

        estdCriterioVO.setEntiId(Entidad.AVITUALLAMIENTO.getId());
        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EAV)));
        export.generarEAV(stream, estdBO.selectList(estdCriterioVO),
                TipoEstadisticaProxy.select(estdCriterioVO.getEntiId()));
        stream.closeEntry();

        estdCriterioVO.setEntiId(Entidad.AGREGACION_ESCALA.getId());
        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EAE)));
        export.generarEAE(stream, estdBO.selectList(estdCriterioVO),
                TipoEstadisticaProxy.select(estdCriterioVO.getEntiId()));
        stream.closeEntry();

        estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_MERCANCIA.getId());
        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EMM)));
        export.generarEMM(stream, estdBO.selectList(estdCriterioVO),
                TipoEstadisticaProxy.select(estdCriterioVO.getEntiId()));
        stream.closeEntry();

        estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_MERCANCIA_EEE.getId());
        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EME)));
        export.generarEME(stream, estdBO.selectList(estdCriterioVO),
                TipoEstadisticaProxy.select(estdCriterioVO.getEntiId()));
        stream.closeEntry();

        estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId());
        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EMT)));
        export.generarEMT(stream, estdBO.selectList(estdCriterioVO),
                TipoEstadisticaProxy.select(estdCriterioVO.getEntiId()));
        stream.closeEntry();

        stream.putNextEntry(new ZipEntry(getFilename(peprVO, EstadisticaFileType.EPP)));
        export.generarEPP(stream, peprVO, exportDate);
        stream.closeEntry();
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
    private String getFilename(final PeriodoProcesoVO peprVO, final EstadisticaFileType fileType) {
        return peprVO.getAutp().getParametro() + peprVO.getAnio()
                + StringUtils.leftPad(peprVO.getMes().toString(), 2, '0') + '.' + fileType.name();
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        LOG.info("Start");

        final PeriodoProcesoOppeExport export = new PeriodoProcesoOppeExport();
        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        final List<PeriodoProcesoVO> peprList = peprBO.selectList(peprCriterioVO);

        for (final PeriodoProcesoVO peprVO : peprList) {
            try (final ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream("/TEMP/"
                    + export.getFilename(peprVO, EstadisticaFileType.zip)))) {
                export.export(peprVO, outputStream);
            } catch (final Throwable ex) {
                LOG.fatal(ex, ex);
            }
        }

        LOG.info("End");
    }
}
