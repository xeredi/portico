package xeredi.integra.http.controller.action.maestro;

import xeredi.integra.http.controller.action.ListAction;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeListadoAction.
 */
public final class IndexAction extends ListAction<LabelValueVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6957331552111084410L;

    // Acciones web
    /**
     * {@inheritDoc}
     */
    @Override
    public void doList() {
        resultList = TipoParametroProxy.selectLabelValues();
    }
}
