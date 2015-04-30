package xeredi.integra.http.controller.action.servicio;

import java.io.IOException;

import xeredi.integra.http.controller.action.comun.CrudFileExportAction;
import xeredi.integra.model.comun.bo.ArchivoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ArchivoInfoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ServicioArchivoExportAction.
 */
public final class ServicioArchivoExportAction extends CrudFileExportAction<ArchivoInfoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5307490519714600140L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getId());

        final ArchivoBO archBO = new ArchivoBO();

        model = archBO.select(model.getId());
        stream = archBO.selectStream(model.getId());
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
