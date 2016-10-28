package xeredi.argo.http.controller.action.estadistica;

import xeredi.argo.http.controller.action.comun.CrudRemoveAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoRemoveAction.
 */
public final class PeriodoProcesoRemoveAction extends CrudRemoveAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5932718578821008471L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRemove() throws ApplicationException {
        Preconditions.checkNotNull(model.getId());

        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        peprBO.delete(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.pepr;
    }
}
