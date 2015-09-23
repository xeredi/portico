package xeredi.argo.http.controller.action.maestro;

import xeredi.argo.http.controller.action.comun.ListAction;
import xeredi.argo.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.argo.model.seguridad.vo.AccionPrefix;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeListadoAction.
 */
public final class MaestroIndexAction extends ListAction<LabelValueVO> {

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

    /**
     * {@inheritDoc}
     */
    @Override
    public AccionPrefix getAccnPrefix() {
        return AccionPrefix.item;
    }
}
