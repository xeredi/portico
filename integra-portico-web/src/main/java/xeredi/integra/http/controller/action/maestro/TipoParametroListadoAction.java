package xeredi.integra.http.controller.action.maestro;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.metamodelo.proxy.TipoParametroProxy;
import xeredi.integra.model.metamodelo.vo.TipoParametroCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeListadoAction.
 */
public final class TipoParametroListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6957331552111084410L;

    /** The mensajes. */
    private List<LabelValueVO> tpprList;

    /** The tppr criterio. */
    private TipoParametroCriterioVO tpprCriterio;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Listado.
     *
     * @return the string
     */
    @Action("tppr-list")
    public String list() {
        tpprList = TipoParametroProxy.selectLabelValues();

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the mensajes.
     *
     * @return the mensajes
     */
    public final List<LabelValueVO> getTpprList() {
        return tpprList;
    }

    /**
     * Gets the tppr criterio.
     *
     * @return the tppr criterio
     */
    public TipoParametroCriterioVO getTpprCriterio() {
        return tpprCriterio;
    }

    /**
     * Sets the tppr criterio.
     *
     * @param value
     *            the new tppr criterio
     */
    public void setTpprCriterio(final TipoParametroCriterioVO value) {
        tpprCriterio = value;
    }

}
