package xeredi.integra.http.controller.action.item;

import java.io.IOException;

import xeredi.integra.http.controller.action.CrudFileExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemPdfExportAction.
 *
 * @param <I>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemFileExportAction<I extends ItemVO> extends CrudFileExportAction<I> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5721322101881550614L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(model.getEntiId());
        Preconditions.checkNotNull(model.getId());

        doSpecificFileExport();
    }

    /**
     * Do specific pdf export.
     *
     * @throws ApplicationExceptionhttp
     *             ://marketplace.eclipse.org/content/clay-mark-ii the application exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public abstract void doSpecificFileExport() throws ApplicationException, IOException;
}