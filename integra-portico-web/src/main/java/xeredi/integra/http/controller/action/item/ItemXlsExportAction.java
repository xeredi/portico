package xeredi.integra.http.controller.action.item;

import java.io.IOException;

import xeredi.integra.http.controller.action.XlsExportAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.ItemCriterioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemXlsExportAction.
 *
 * @param <C>
 *            the generic type
 * @param <E>
 *            the element type
 */
public abstract class ItemXlsExportAction<C extends ItemCriterioVO> extends XlsExportAction<C> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1760701788741847611L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doXlsExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(criterio.getEntiId());

        criterio.setIdioma(idioma);
        criterio.setSoloDatosGrid(false);

        doSpecificXlsExport();
    }

    /**
     * Do specific xls export.
     *
     * @throws ApplicationException
     *             the application exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public abstract void doSpecificXlsExport() throws ApplicationException, IOException;

}
