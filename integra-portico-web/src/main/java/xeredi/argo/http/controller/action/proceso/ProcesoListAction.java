package xeredi.argo.http.controller.action.proceso;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.comun.vo.ClassPrefix;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListAction.
 */
@Data
public final class ProcesoListAction extends GridListAction<ProcesoCriterioVO, ProcesoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4892003930947515760L;

    /** The prefix. */
    private final ClassPrefix prefix = ClassPrefix.prbt;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final ProcesoBO prbtBO = new ProcesoBO();

        resultList = prbtBO.selectList(model, getOffset(), limit);
    }
}
