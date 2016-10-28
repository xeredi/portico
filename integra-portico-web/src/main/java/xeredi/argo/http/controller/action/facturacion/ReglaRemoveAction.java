package xeredi.argo.http.controller.action.facturacion;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.ReglaBO;
import xeredi.argo.model.facturacion.vo.ReglaVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaRemoveAction.
 */
public final class ReglaRemoveAction extends CrudRemoveAction<ReglaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5160365319372545490L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final ReglaBO rglaBO = new ReglaBO();

        rglaBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.rgla;
    }
}
