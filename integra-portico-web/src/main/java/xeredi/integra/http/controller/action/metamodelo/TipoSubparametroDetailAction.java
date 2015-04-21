package xeredi.integra.http.controller.action.metamodelo;

import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.integra.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroDetailAction.
 */
public final class TipoSubparametroDetailAction extends EntidadDetailAction<TipoSubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8144616675066501877L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        model = tpspBO.select(model.getId(), idioma);
    }
}
