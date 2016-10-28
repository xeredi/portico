package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.bo.TipoSubparametroBO;
import xeredi.argo.model.metamodelo.vo.TipoSubparametroVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoSubparametroDetailAction.
 */
@Data
public final class TipoSubparametroDetailAction extends EntidadDetailAction<TipoSubparametroVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8144616675066501877L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpsp;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSpecificDetail() throws ApplicationException {
        final TipoSubparametroBO tpspBO = new TipoSubparametroBO();

        model = tpspBO.select(model.getId(), idioma);
    }
}
