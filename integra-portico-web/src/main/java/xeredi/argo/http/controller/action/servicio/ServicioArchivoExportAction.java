package xeredi.argo.http.controller.action.servicio;

import java.io.IOException;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudFileExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.service.ArchivoService;
import xeredi.argo.model.comun.vo.ArchivoInfoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioArchivoExportAction.
 */
public final class ServicioArchivoExportAction extends CrudFileExportAction<ArchivoInfoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5307490519714600140L;

	@Inject
	private ArchivoService archService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getId());

        model = archService.select(model.getId());
        stream = archService.selectStream(model.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFilename() {
        return model.getNombre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrudFileExportAction.ContentType getContentType() {
        return ContentType.zip;
    }
}
