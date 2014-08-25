package xeredi.integra.http.controller.action.facturacion;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Regla;
import xeredi.integra.model.facturacion.bo.ReglaBO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleCriterioVO;
import xeredi.integra.model.facturacion.vo.ReglaIncompatibleVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaIncompatibleListadoAction.
 */
public final class ReglaIncompatibleListadoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4688936303299393980L;

    /** The rgin list. */
    private List<ReglaIncompatibleVO> rginList;

    /** The rgin criterio. */
    private ReglaIncompatibleCriterioVO rginCriterio;

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
    @Actions({ @Action(value = "rgin-listado") })
    public String listado() {
        Preconditions.checkNotNull(rginCriterio);

        final Regla rglaBO = BOFactory.getInjector().getInstance(ReglaBO.class);

        if (hasErrors()) {
            return INPUT;
        }

        rginList = rglaBO.selectRginList(rginCriterio);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the rgin criterio.
     *
     * @return the rgin criterio
     */
    public ReglaIncompatibleCriterioVO getRginCriterio() {
        return rginCriterio;
    }

    /**
     * Sets the rgin criterio.
     *
     * @param value
     *            the new rgin criterio
     */
    public void setRginCriterio(final ReglaIncompatibleCriterioVO value) {
        rginCriterio = value;
    }

    /**
     * Gets the rgin list.
     *
     * @return the rgin list
     */
    public List<ReglaIncompatibleVO> getRginList() {
        return rginList;
    }

}
