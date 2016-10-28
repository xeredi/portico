package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.vo.TipoServicioCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoServicioFilterAction.
 */
@Data
public final class TipoServicioFilterAction extends GridFilterAction<TipoServicioCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7142046528816411938L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.tpsr;

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
