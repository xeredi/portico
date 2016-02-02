package xeredi.argo.http.controller.action.maestro;

import java.util.List;

import lombok.Getter;
import xeredi.argo.http.controller.action.comun.BaseAction;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeListadoAction.
 */
public final class MaestroIndexAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6957331552111084410L;

    @Getter
    private List<LabelValueVO> resultList;

    // Acciones web
    /**
     * {@inheritDoc}
     */
    @Override
    public void doExecute() {
        resultList = TipoParametroProxy.selectLabelValues();
    }
}
