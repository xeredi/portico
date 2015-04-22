package xeredi.integra.http.controller.action;

import java.io.IOException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.exception.InternalErrorException;
import xeredi.integra.model.comun.vo.BaseCriterioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class XlsExportAction.
 *
 * @param <C>
 *            the generic type
 */
public abstract class XlsExportAction<C extends BaseCriterioVO> extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2203318775060986047L;

    /** The criterio. */
    protected C criterio;

    /** The stream. */
    protected InputStream stream;

    /**
     * {@inheritDoc}
     */
    @Override
    @Action(results = { @Result(name = "success", type = "stream", params = { "contentType", "application/xls",
            "inputName", "stream", "contentDisposition", "filename=${filename}.xls" }) })
    public final String execute() throws ApplicationException {
        Preconditions.checkNotNull(criterio);

        criterio.setIdioma(getIdioma());

        try {
            doXlsExport();
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
    public abstract void doXlsExport() throws ApplicationException, IOException;

    /**
     * Gets the filename.
     *
     * @return the filename
     */
    public abstract String getFilename();

    /**
     * Sets the criterio.
     *
     * @param value
     *            the new criterio
     */
    public final void setCriterio(final C value) {
        this.criterio = value;
    }

    /**
     * Gets the stream.
     *
     * @return the stream
     */
    public final InputStream getStream() {
        return stream;
    }

}
