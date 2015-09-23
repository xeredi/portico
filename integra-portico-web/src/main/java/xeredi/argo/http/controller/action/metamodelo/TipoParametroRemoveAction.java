package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoParametroBO;
import xeredi.argo.model.metamodelo.vo.TipoParametroVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

        entiBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tppr;
    }
}
