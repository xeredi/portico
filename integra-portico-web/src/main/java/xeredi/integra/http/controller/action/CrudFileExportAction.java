package xeredi.integra.http.controller.action;

import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudFileExportAction.
 *
 * @param <M>
 *            the generic type
 */
@Result(name = "success", type = "stream", params = { "contentType", "${contentType.mimeType}", "inputName", "stream",
        "contentDisposition", "filename=${filename}.${contentType.fileExtension}" })
public abstract class CrudFileExportAction<M> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8850677829805815139L;

    /**
     * The Enum ContentType.
     */
    public static enum ContentType {
        /** The pdf. */
        pdf("application/pdf", "pdf"),
        /** The xls. */
        xls("application/xls", "xls"),
        /** The zip. */
        zip("application/zip", "zip");

        /** The mime type. */
        private final String mimeType;

        /** The file extension. */
        private final String fileExtension;

        /**
         * Instantiates a new content type.
         *
         * @param amimeType
         *            the amime type
         * @param afileExtension
         *            the afile extension
         */
        private ContentType(final String amimeType, final String afileExtension) {
            mimeType = amimeType;
            fileExtension = afileExtension;
        }

        /**
         * Gets the mime type.
         *
         * @return the mime type
         */
        public String getMimeType() {
            return mimeType;
        }

        /**
         * Gets the file extension.
         *
         * @return the file extension
         */
        public String getFileExtension() {
            return fileExtension;
        }
    };

    /** The model. */
    protected M model;

    /** The stream. */
    protected InputStream stream;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        try {
            doExport();
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * Do export.
     *
     * @throws ApplicationException
     *             the application exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public abstract void doExport() throws ApplicationException, IOException;

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public abstract String getFilename();

    /**
     * Gets the content type.
     *
     * @return the content type
     */
    public abstract ContentType getContentType();

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public final InputStream getStream() {
        return stream;
    }

    /**
     * Sets the model.
     *
     * @param value
     *            the new model
     */
    public final void setModel(final M value) {
        this.model = value;
    }
}
