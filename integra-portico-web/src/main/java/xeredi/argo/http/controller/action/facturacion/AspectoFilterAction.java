package xeredi.argo.http.controller.action.facturacion;

import java.util.List;

import lombok.Data;
import xeredi.argo.http.controller.action.comun.GridFilterAction;
import xeredi.argo.model.comun.exception.ApplicationException;
import xeredi.argo.model.facturacion.vo.AspectoCriterioVO;
import xeredi.argo.model.metamodelo.proxy.TipoServicioProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoFilterAction.
 */
@Data
public final class AspectoFilterAction extends GridFilterAction<AspectoCriterioVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7354700770368605863L;

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
}
