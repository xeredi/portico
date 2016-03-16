package xeredi.argo.http.controller.action.comun;

import java.io.IOException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudLoadFileSaveAction.
 *
 * @param <T>
 *            the generic type
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class CrudLoadAction<T> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7224167551778868909L;

    /** The model. */
    protected T model;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(model);

        try {
            doLoad();
        } catch (final ApplicationException ex) {
            throw ex;
        } catch (final IOException ex) {
            throw new InternalErrorException(ex);
        }
    }

    /**
     * doLoad.
     *
     * @throws ApplicationException
     *             the application exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    protected abstract void doLoad() throws ApplicationException, IOException;

}