package xeredi.argo.http.controller.action.proceso;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.proceso.bo.ProcesoBO;
import xeredi.argo.model.proceso.vo.ProcesoCriterioVO;
import xeredi.argo.model.proceso.vo.ProcesoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoListAction.
 */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.prbt;
    }
}
