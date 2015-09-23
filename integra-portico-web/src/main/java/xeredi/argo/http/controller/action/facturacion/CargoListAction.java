package xeredi.argo.http.controller.action.facturacion;

import java.util.Calendar;

import xeredi.argo.http.controller.action.comun.GridListAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.bo.CargoBO;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.facturacion.vo.CargoVO;
import xeredi.argo.model.seguridad.vo.AccionPrefix;

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
        if (model.getFechaVigencia() == null) {
            model.setFechaVigencia(Calendar.getInstance().getTime());
        }

        final CargoBO crgoBO = new CargoBO();

        resultList = crgoBO.selectList(model, getOffset(), limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.crgo;
    }
}
