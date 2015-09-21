package xeredi.argo.http.controller.action.facturacion;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.FacturaBO;
import xeredi.argo.model.facturacion.vo.FacturaLineaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FacturaLineaDetailAction.
 */
public final class FacturaLineaDetailAction extends CrudDetailAction<FacturaLineaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 958295274244836693L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final FacturaBO fctrBO = new FacturaBO();

        model = fctrBO.selectFctl(model.getId(), getIdioma());
    }
}
