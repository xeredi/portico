package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TipoEstadisticaListadoAction.
 */
public final class TipoEstadisticaListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2739529063689281983L;

    /** The mensajes. */
    private List<LabelValueVO> tpess;

    // Acciones web
    /**
     * Listado.
     *
     * @return the string
     */
    @Action(value = "tpes-listado")
    public String listado() {
        tpess = TipoEstadisticaProxy.selectLabelValues();

        return SUCCESS;
    }

    /**
     * Gets the tpess.
     *
     * @return the tpess
     */
    public List<LabelValueVO> getTpess() {
        return tpess;
    }

}
