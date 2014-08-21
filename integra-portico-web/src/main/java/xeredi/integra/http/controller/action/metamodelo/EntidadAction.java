package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.metamodelo.Entidad;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.metamodelo.vo.EntidadVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAction.
 */
public final class EntidadAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5675312476405724624L;

    /** The id. */
    private EntidadVO enti;

    // Acciones Web
    /**
     * Detalle.
     * 
     * @return the string
     */
    @Action(value = "enti-detalle", results = {
            @Result(name = "P", location = "tppr-detalle", type = "redirect", params = { "tppr.id", "%{enti.id}" }),
            @Result(name = "T", location = "tpsr-detalle", type = "redirect", params = { "tpsr.id", "%{enti.id}" }),
            @Result(name = "S", location = "tpss-detalle", type = "redirect", params = { "tpss.id", "%{enti.id}" }),
            @Result(name = "B", location = "tpsp-detalle", type = "redirect", params = { "tpsp.id", "%{enti.id}" }) })
    public String detalle() {
        final Entidad entiBO = BOFactory.getInjector().getInstance(Entidad.class);

        return entiBO.selectTipoEntidad(enti.getId()).name();
    }

    // get/set
    /**
     * Gets the enti.
     * 
     * @return the enti
     */
    public EntidadVO getEnti() {
        return enti;
    }

    /**
     * Sets the enti.
     * 
     * @param value
     *            the new enti
     */
    public void setEnti(final EntidadVO value) {
        enti = value;
    }

}
