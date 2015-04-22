package xeredi.integra.http.controller.action.item;

import java.io.IOException;

import xeredi.integra.http.controller.action.CrudPdfExportAction;
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
public abstract class ItemPdfExportAction<I extends ItemVO> extends CrudPdfExportAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5721322101881550614L;

    /** The item. */
    protected I item;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doPdfExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getEntiId());
        Preconditions.checkNotNull(item.getId());

        doSpecificPdfExport();
    }

    /**
     * Do specific pdf export.
     *
     * @throws ApplicationException
     *             the application exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public abstract void doSpecificPdfExport() throws ApplicationException, IOException;

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final I value) {
        this.item = value;
    }

}
