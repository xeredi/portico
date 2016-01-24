package xeredi.argo.http.controller.action.comun;

import java.io.IOException;
import java.io.InputStream;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts2.convention.annotation.Result;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.exception.InternalErrorException;
import xeredi.argo.model.comun.vo.BaseCriterioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class XlsExportAction.
 *
 * @param <C>
 *            the generic type
 */
@Result(name = "success", type = "stream", params = { "contentType", "application/xls", "inputName", "stream",
        "contentDisposition", "filename=${filename}.xls" })
public abstract class GridXlsExportAction<C extends BaseCriterioVO> extends BaseAction implements ProtectedAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2203318775060986047L;

    /** The criterio. */
    @Setter
    protected C criterio;

    /** The stream. */
    @Getter
    protected InputStream stream;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExecute() throws ApplicationException {
        Preconditions.checkNotNull(criterio);

        criterio.setIdioma(getIdioma());

        try {
            doXlsExport();
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
    public abstract void doXlsExport() throws ApplicationException, IOException;

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public abstract String getFilename();

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getAccnCodigo() {
        return "list";
    }

}
