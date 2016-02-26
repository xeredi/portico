package xeredi.argo.http.controller.action.estadistica;

import java.io.IOException;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoZipExportAction.
 */
public final class PeriodoProcesoFileExportAction extends CrudFileExportAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -139099742146825401L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();
        final ArchivoBO archBO = new ArchivoBO();

        model = peprBO.select(model.getId(), getIdioma());
        stream = archBO.selectStream(model.getArin().getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return model.getFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ContentType getContentType() {
        return ContentType.zip;
    }
}
