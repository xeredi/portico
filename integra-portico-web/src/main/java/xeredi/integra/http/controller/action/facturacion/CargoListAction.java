package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.comun.GridListAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoListAction.
 */
public final class CargoListAction extends GridListAction<CargoCriterioVO, CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6203976676780090103L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() throws ApplicationException {
        final CargoBO crgoBO = new CargoBO();

        resultList = crgoBO.selectList(model, getOffset(), limit);
    }
}
