package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import xeredi.integra.http.controller.action.comun.GridFilterAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoFilterAction.
 */
public final class CargoFilterAction extends GridFilterAction<CargoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4024940532231620563L;

    /** The tpsr list. */
    private List<LabelValueVO> tpsrList;

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
        tpsrList = TipoServicioProxy.selectLabelValues();
    }

    /**
     * Gets the tpsr list.
     *
     * @return the tpsr list
     */
    public List<LabelValueVO> getTpsrList() {
        return tpsrList;
    }
}
