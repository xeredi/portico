package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoParametroBO;
import xeredi.integra.model.metamodelo.vo.TipoParametroVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroRemoveAction.
 */
public final class TipoParametroRemoveAction extends CrudRemoveAction<TipoParametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5117314548397691124L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TipoParametroBO entiBO = new TipoParametroBO();

        entiBO.delete(model.getId());
    }
}
