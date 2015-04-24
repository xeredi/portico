package xeredi.integra.http.controller.action.maestro;

import xeredi.integra.http.controller.action.item.ItemDetailAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.maestro.bo.SubparametroBO;
import xeredi.integra.model.maestro.vo.SubparametroVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroDetailVO;
import xeredi.integra.model.metamodelo.proxy.TipoSubparametroProxy;

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
        final SubparametroBO itemBO = new SubparametroBO();

        model = itemBO.selectObject(model.getId(), idioma, fechaVigencia);
        enti = TipoSubparametroProxy.select(model.getEntiId());
    }
}
