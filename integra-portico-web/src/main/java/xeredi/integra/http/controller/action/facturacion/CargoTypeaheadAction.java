package xeredi.integra.http.controller.action.facturacion;

import xeredi.integra.http.controller.action.TypeaheadAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoLupaAction.
 */
public final class CargoTypeaheadAction extends TypeaheadAction<CargoCriterioVO, CargoVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 367706797413439221L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void doTypeahead() throws ApplicationException {
        final CargoBO crgoBO = new CargoBO();

        resultList = crgoBO.selectList(model, limit);
    }
}
