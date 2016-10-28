package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.metamodelo.vo.ModuloCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModuloFilterAction.
 */
@Data
public final class ModuloFilterAction extends GridFilterAction<ModuloCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1763268076473491380L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.mdlo;

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
