package xeredi.argo.http.controller.action.metamodelo;

import com.google.common.base.Preconditions;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TramiteTipoDatoBO;
import xeredi.argo.model.metamodelo.vo.TramiteTipoDatoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TramiteTipoDatoDetailAction.
 */
public final class TramiteTipoDatoDetailAction extends CrudDetailAction<TramiteTipoDatoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4066766450469953829L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getTrmtId());
        Preconditions.checkNotNull(model.getEntd());
        Preconditions.checkNotNull(model.getEntd().getTpdt().getId());

        final TramiteTipoDatoBO trtdBO = new TramiteTipoDatoBO();

        model = trtdBO.select(model.getTrmtId(), model.getEntd().getTpdt().getId(), getIdioma());
    }
}
