package xeredi.argo.http.controller.action.item;

import java.io.IOException;

import xeredi.argo.http.controller.action.comun.GridXlsExportAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.item.vo.ItemCriterioVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemXlsExportAction.
 *
 * @param <C>
 *            the generic type
 */
public abstract class ItemXlsExportAction<C extends ItemCriterioVO> extends GridXlsExportAction<C> implements ProtectedItemAction {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getEntiId() {
        return criterio.getEntiId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
