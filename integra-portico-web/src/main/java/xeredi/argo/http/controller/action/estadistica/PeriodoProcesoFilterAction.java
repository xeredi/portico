package xeredi.argo.http.controller.action.estadistica;

import java.util.List;

import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;
import xeredi.argo.model.estadistica.vo.PeriodoProcesoCriterioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoFilterAction.
 */
public final class PeriodoProcesoFilterAction extends GridFilterAction<PeriodoProcesoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4100651934689033353L;

    /** The subps. */
    private List<SuperpuertoVO> sprtList;

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
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterio = new SuperpuertoCriterioVO();

        sprtCriterio.setIdioma(idioma);

        sprtList = sprtBO.selectList(sprtCriterio);
    }

    /**
     * Gets the sprt list.
     *
     * @return the sprt list
     */
    public List<SuperpuertoVO> getSprtList() {
        return sprtList;
    }

}
