package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.http.controller.action.comun.CrudDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.CampoAgregacionBO;
import xeredi.argo.model.metamodelo.vo.CampoAgregacionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoAgregacionDetailAction.
 */
public final class CampoAgregacionDetailAction extends CrudDetailAction<CampoAgregacionVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7449645197472409959L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doDetail() throws ApplicationException {
        Preconditions.checkNotNull(model.getTpesId());
        Preconditions.checkNotNull(model.getEntd());
        Preconditions.checkNotNull(model.getEntd().getId());

        final CampoAgregacionBO cmagBO = new CampoAgregacionBO();

        model = cmagBO.select(model.getTpesId(), model.getEntd().getId(), idioma);
    }

}
