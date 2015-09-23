package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TipoDatoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

import com.google.common.base.Preconditions;

/**
 * The Class TipoDatoRemoveAction.
 */
public final class TipoDatoRemoveAction extends CrudRemoveAction<TipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8293109920924616036L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final TipoDatoBO tpdtBO = new TipoDatoBO();

        tpdtBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpdt;
    }
}
