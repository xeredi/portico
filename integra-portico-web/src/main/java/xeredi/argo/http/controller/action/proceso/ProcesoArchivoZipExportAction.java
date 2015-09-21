package xeredi.argo.http.controller.action.proceso;

import java.io.IOException;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.bo.ArchivoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;
import xeredi.argo.model.proceso.vo.ProcesoArchivoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoArchivoZipExportAction.
 */
public final class ProcesoArchivoZipExportAction extends CrudFileExportAction<ProcesoArchivoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1822556969160920692L;

    /** The arin. */
    private ArchivoInfoVO arin;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getArchId());

        final ArchivoBO archBO = new ArchivoBO();

        arin = archBO.select(model.getArchId());
        stream = archBO.selectStream(model.getArchId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return arin.getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrudFileExportAction.ContentType getContentType() {
        return ContentType.zip;
    }
}
