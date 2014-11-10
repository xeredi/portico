package xeredi.integra.http.controller.action.estadistica;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoEstadisticaProxy;
import xeredi.integra.model.metamodelo.vo.TipoEstadisticaCriterioVO;
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

    /** The tppr criterio. */
    private TipoEstadisticaCriterioVO tpesCriterio;

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

    // get / set
    /**
     * Gets the tpes criterio.
     *
     * @return the tpes criterio
     */
    public TipoEstadisticaCriterioVO getTpesCriterio() {
        return tpesCriterio;
    }

    /**
     * Sets the tpes criterio.
     *
     * @param value
     *            the new tpes criterio
     */
    public void setTpesCriterio(final TipoEstadisticaCriterioVO value) {
        tpesCriterio = value;
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
