package xeredi.argo.http.controller.action.estadistica;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoListAction.
 */
public final class PeriodoProcesoListAction extends GridListAction<PeriodoProcesoCriterioVO, PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1113088797514470782L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        resultList = peprBO.selectList(model, getOffset(), limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.pepr;
    }
}
