package xeredi.argo.http.controller.action.item;

import java.io.IOException;

import com.google.common.base.Preconditions;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemXlsExportAction.
 *
 * @param <C>
 *            the generic type
 */
@Data
public abstract class ItemXlsExportAction<C extends ItemCriterioVO> extends GridXlsExportAction<C> implements ProtectedItemAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1760701788741847611L;

    /**
     * {@inheritDoc}
     */
    @Override
    public final void doXlsExport() throws ApplicationException, IOException {
        Preconditions.checkNotNull(criterio.getEntiId());

        criterio.setIdioma(getIdioma());
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

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        return criterio.getEntiId();
    }
}
