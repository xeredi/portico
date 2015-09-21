package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaEditAction.
 */
public final class FacturaEditAction extends CrudEditAction<FacturaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1122946174457133287L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();

        model = fctrBO.select(model.getId(), getIdioma());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
