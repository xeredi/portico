package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.argo.model.metamodelo.service.EntidadEntidadService;
import xeredi.argo.model.metamodelo.vo.EntidadEntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadDetailAction.
 */
public final class EntidadEntidadDetailAction extends CrudDetailAction<EntidadEntidadVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6250400972687447880L;

    @Inject
    private EntidadEntidadService enenService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getEntiPadreId());
        Preconditions.checkNotNull(model.getEntiHija());
        Preconditions.checkNotNull(model.getEntiHija().getId());

        model = enenService.select(model.getEntiPadreId(), model.getEntiHija().getId());
    }
}
