package xeredi.argo.http.controller.action.proceso;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListAction.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ProcesoListAction extends GridListAction<ProcesoCriterioVO, ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4892003930947515760L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ProcesoBO prbtBO = new ProcesoBO();

        resultList = prbtBO.selectList(model, getOffset(), limit);
    }
}
