package xeredi.integra.http.controller.action.estadistica;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.estadistica.bo.EstadisticaBO;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.io.EstadisticaFileType;
import xeredi.integra.model.estadistica.io.OppeFileExport;
import xeredi.integra.model.estadistica.vo.EstadisticaCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.integra.model.metamodelo.vo.Entidad;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoExportAction.
 */
public final class PeriodoProcesoExportAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4344754234690990490L;

    /** The pepr. */
    private PeriodoProcesoVO pepr;

    /** The stream. */
    private InputStream stream;

    // acciones web

    /**
     * Xls export.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action(value = "pepr-export", results = { @Result(name = "success", type = "stream", params = { "contentType",
            "application/zip", "inputName", "stream", "contentDisposition", "filename=${pepr.filename}.zip" }) })
    public String export() throws ApplicationException {
        Preconditions.checkNotNull(pepr);
        Preconditions.checkNotNull(pepr.getId());

        final OppeFileExport export = new OppeFileExport();
        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final Date exportDate = new Date();
        final EstadisticaBO estdBO = new EstadisticaBO();
        final EstadisticaCriterioVO estdCriterioVO = new EstadisticaCriterioVO();
        final PeriodoProcesoCriterioVO peprCriterioVO = new PeriodoProcesoCriterioVO();

        try (final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                final ZipOutputStream zipOutputStream = new ZipOutputStream(baos)) {
            pepr = peprBO.select(pepr.getId());

            peprCriterioVO.setId(pepr.getId());
            estdCriterioVO.setPepr(peprCriterioVO);

            estdCriterioVO.setEntiId(Entidad.ACTIVIDAD_PESQUERA.getId());
            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EAP));
            export.generarEAP(zipOutputStream, estdBO.selectList(estdCriterioVO));
            zipOutputStream.closeEntry();

            estdCriterioVO.setEntiId(Entidad.AVITUALLAMIENTO.getId());
            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EAV));
            export.generarEAV(zipOutputStream, estdBO.selectList(estdCriterioVO));
            zipOutputStream.closeEntry();

            estdCriterioVO.setEntiId(Entidad.AGREGACION_ESCALA.getId());
            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EAE));
            export.generarEAE(zipOutputStream, estdBO.selectList(estdCriterioVO));
            zipOutputStream.closeEntry();

            estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_MERCANCIA.getId());
            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EMM));
            export.generarEMM(zipOutputStream, estdBO.selectList(estdCriterioVO));
            zipOutputStream.closeEntry();

            estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_MERCANCIA_EEE.getId());
            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EME));
            export.generarEME(zipOutputStream, estdBO.selectList(estdCriterioVO));
            zipOutputStream.closeEntry();

            estdCriterioVO.setEntiId(Entidad.MOVIMIENTO_TIPO_BUQUE_EEE.getId());
            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EMT));
            export.generarEMT(zipOutputStream, estdBO.selectList(estdCriterioVO));
            zipOutputStream.closeEntry();

            zipOutputStream.putNextEntry(new ZipEntry(pepr.getFilename() + '.' + EstadisticaFileType.EPP));
            export.generarEPP(zipOutputStream, pepr, exportDate);
            zipOutputStream.closeEntry();

            zipOutputStream.flush();
            zipOutputStream.close();

            stream = new ByteArrayInputStream(baos.toByteArray());
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }

        return SUCCESS;
    }

    // get/set

    /**
     * Gets the pepr.
     *
     * @return the pepr
     */
    public PeriodoProcesoVO getPepr() {
        return pepr;
    }

    /**
     * Sets the pepr.
     *
     * @param value
     *            the new pepr
     */
    public void setPepr(final PeriodoProcesoVO value) {
        pepr = value;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public InputStream getStream() {
        return stream;
    }

}
