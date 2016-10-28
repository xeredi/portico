package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.vo.TipoParametroCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoParametroFilterAction.
 */
@Data
public final class TipoParametroFilterAction extends GridFilterAction<TipoParametroCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8019963453091790625L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tppr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doPrepareFilter() throws ApplicationException {
        // noop
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        // noop
    }
}
