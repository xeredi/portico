package xeredi.integra.http.controller.action.estadistica;

import xeredi.integra.http.controller.action.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;

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
}
