package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroRemoveAction.
 */
public final class TipoSubparametroRemoveAction extends CrudRemoveAction<TipoSubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2112505129384431410L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TipoSubparametroBO entiBO = new TipoSubparametroBO();

        entiBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpsp;
    }

}
