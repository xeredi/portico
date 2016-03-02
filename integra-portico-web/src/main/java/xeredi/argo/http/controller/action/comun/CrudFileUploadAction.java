package xeredi.argo.http.controller.action.comun;

import java.io.File;
import java.io.IOException;

import lombok.Setter;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudFileUploadAction.
 *
 * @param <M>
 *            the generic type
 */
public abstract class CrudFileUploadAction<M> extends BaseAction {

    /** serialVersionUID. */
    private static final long serialVersionUID = -8802007256009670945L;

    /** The model. */
    @Setter
    protected M model;

    /** The file. */
    @Setter
    protected File file;

    /** The contentType. */
    @Setter
    protected String contentType;

    /** filename. */
    @Setter
    protected String filename;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        try {
            doImport();
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * Do Import.
     *
     * @throws ApplicationException
     *             the application exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public abstract void doImport() throws ApplicationException, IOException;

}
