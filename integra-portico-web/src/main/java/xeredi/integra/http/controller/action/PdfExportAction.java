package xeredi.integra.http.controller.action;

import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfExportAction.
 */
public abstract class PdfExportAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8506495302704421492L;

    /** The stream. */
    protected InputStream stream;

    /**
     * {@inheritDoc}
     */
    @Override
    @Action(results = { @Result(name = "success", type = "stream", params = { "contentType", "application/pdf",
            "inputName", "stream", "contentDisposition", "filename=${filename}.pdf" }) })
    public final String execute() throws ApplicationException {
        try {
            doPdfExport();
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }

        return SUCCESS;
    }

    /**
     * Do export.
     *
     * @throws ApplicationException
     *             the application exception
     */
    public abstract void doPdfExport() throws ApplicationException, IOException;

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public abstract String getFilename();

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public final InputStream getStream() {
        return stream;
    }

}
