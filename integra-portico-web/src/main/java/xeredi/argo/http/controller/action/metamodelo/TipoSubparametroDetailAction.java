package xeredi.argo.http.controller.action.metamodelo;

import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.tpsp;
    }
}
