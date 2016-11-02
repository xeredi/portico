package xeredi.argo.http.controller.action.estadistica;

import java.util.List;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.CrudEditAction;
import xeredi.argo.http.view.estadistica.ProcesoEstadisticaVO;
import xeredi.argo.model.comun.bo.SuperpuertoBO;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.SuperpuertoCriterioVO;
import xeredi.argo.model.comun.vo.SuperpuertoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoProcesoEditAction.
 */
@Data
public final class PeriodoProcesoEditAction extends CrudEditAction<ProcesoEstadisticaVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -505923029249050738L;

    /** The sprt list. */
    private List<SuperpuertoVO> sprtList;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doEdit() throws ApplicationException {
        model = new ProcesoEstadisticaVO();
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
}
