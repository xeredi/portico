package xeredi.argo.http.controller.action.metamodelo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.metamodelo.vo.TipoEstadisticaCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaFilterAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class TipoEstadisticaFilterAction extends GridFilterAction<TipoEstadisticaCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3827129512834686253L;

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
