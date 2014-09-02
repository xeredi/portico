package xeredi.integra.http.controller.action.configuracion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.configuracion.bo.Idioma;
import xeredi.integra.model.configuracion.bo.IdiomaBO;
import xeredi.integra.model.configuracion.vo.IdiomaVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IdiomaListadoAction.
 */
public final class IdiomaListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3046800950522897945L;

    /** The cnid list. */
    private List<IdiomaVO> cnids;

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
    @Action(value = "cnid-listado")
    public String listado() {
        final Idioma cnidBO = BOFactory.getInjector().getInstance(IdiomaBO.class);

        cnids = cnidBO.selectAll();

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the cnid list.
     *
     * @return the cnid list
     */
    public List<IdiomaVO> getCnids() {
        return cnids;
    }

}
