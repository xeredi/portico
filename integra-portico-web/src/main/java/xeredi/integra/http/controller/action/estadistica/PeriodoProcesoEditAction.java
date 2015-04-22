package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import xeredi.integra.http.controller.action.CrudEditAction;
import xeredi.integra.model.comun.bo.SuperpuertoBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.integra.model.comun.vo.SuperpuertoVO;
import xeredi.integra.model.estadistica.vo.PeriodoProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoEditAction.
 */
public final class PeriodoProcesoEditAction extends CrudEditAction<PeriodoProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -505923029249050738L;

    /** The sprt list. */
    private List<SuperpuertoVO> sprtList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        model = new PeriodoProcesoVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLoadDependencies() throws ApplicationException {
        final SuperpuertoBO sprtBO = new SuperpuertoBO();
        final SuperpuertoCriterioVO sprtCriterioVO = new SuperpuertoCriterioVO();

        sprtCriterioVO.setIdioma(getIdioma());

        sprtList = sprtBO.selectList(sprtCriterioVO);
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
