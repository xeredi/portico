package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.vo.CargoCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.argo.model.metamodelo.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoFilterAction.
 */
public final class CargoFilterAction extends GridFilterAction<CargoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4024940532231620563L;

    /** The tpsr list. */
    @Getter
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
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.crgo;
    }
}
