package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

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

        entiBO.delete(model.getId());
    }

}
