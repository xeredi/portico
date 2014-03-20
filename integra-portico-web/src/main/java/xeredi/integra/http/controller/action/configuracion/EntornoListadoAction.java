package xeredi.integra.http.controller.action.configuracion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.configuracion.Entorno;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.configuracion.EntornoVO;

// TODO: Auto-generated Javadoc
/**
 * The Class EntornoListadoAction.
 */
public final class EntornoListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3982419406288444570L;

    /** The cnen list. */
    private List<EntornoVO> cnens;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web
    /**
     * Listado.
     * 
     * @return the string
     */
    @Action(value = "cnen-listado")
    public String listado() {
        final Entorno cnenBO = BOFactory.getInjector().getInstance(Entorno.class);

        cnens = cnenBO.selectAll();

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the cnen list.
     * 
     * @return the cnen list
     */
    public List<EntornoVO> getCnens() {
        return cnens;
    }

}
