package xeredi.integra.http.controller.action.maestro;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.proxy.metamodelo.TipoParametroProxy;
import xeredi.integra.model.vo.metamodelo.TipoParametroCriterioVO;
import xeredi.util.applicationobjects.LabelValueVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MensajeListadoAction.
 */
@ParentPackage("json-default")
public final class TipoParametroListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6957331552111084410L;

    /** The mensajes. */
    private List<LabelValueVO> tpprs;

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
    @Actions({
        @Action(value = "tppr-listado"),
        @Action(value = "tppr-listado-json", results = { @Result(name = "success", type = "json") }),
        @Action(value = "tppr-listado-ftl", results = { @Result(name = "success", type = "freemarker", location = "tppr-listado.ftl") }) })
    public String listado() {
        tpprs = TipoParametroProxy.selectLabelValues();

        return SUCCESS;
    }

    // get / set
    /**
     * Gets the mensajes.
     * 
     * @return the mensajes
     */
    public final List<LabelValueVO> getTpprs() {
        return tpprs;
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
