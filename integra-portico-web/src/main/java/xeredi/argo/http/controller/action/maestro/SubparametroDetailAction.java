package xeredi.argo.http.controller.action.maestro;

import xeredi.argo.http.controller.action.item.ItemDetailAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.maestro.bo.SubparametroBO;
import xeredi.argo.model.maestro.bo.SubparametroBOFactory;
import xeredi.argo.model.maestro.vo.SubparametroVO;
import xeredi.argo.model.metamodelo.proxy.TipoSubparametroProxy;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroDetailVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SubparametroDetailAction.
 */
public final class SubparametroDetailAction extends ItemDetailAction<SubparametroVO, TipoSubparametroDetailVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4494947768754537198L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final SubparametroBO itemBO = SubparametroBOFactory.newInstance(model.getEntiId());

        model = itemBO.selectObject(model.getId(), getIdioma(), model.getFref());
        enti = TipoSubparametroProxy.select(model.getEntiId());
    }
}
