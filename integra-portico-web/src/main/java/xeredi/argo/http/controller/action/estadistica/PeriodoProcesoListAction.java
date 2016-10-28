package xeredi.argo.http.controller.action.estadistica;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.estadistica.bo.PeriodoProcesoBO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoListAction.
 */
@Data
public final class PeriodoProcesoListAction extends GridListAction<PeriodoProcesoCriterioVO, PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1113088797514470782L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.pepr;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final PeriodoProcesoBO peprBO = new PeriodoProcesoBO();

        resultList = peprBO.selectList(model, getOffset(), limit);
    }
}
