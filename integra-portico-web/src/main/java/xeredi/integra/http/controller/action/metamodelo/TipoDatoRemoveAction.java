package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.http.controller.action.CrudRemoveAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoDatoBO;
import xeredi.integra.model.metamodelo.vo.TipoDatoVO;

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
}
