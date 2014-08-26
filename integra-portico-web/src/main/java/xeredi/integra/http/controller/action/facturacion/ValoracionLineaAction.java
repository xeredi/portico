package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Valoracion;
import xeredi.integra.model.facturacion.bo.ValoracionBO;
import xeredi.integra.model.facturacion.vo.ValoracionLineaVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionLineaAction.
 */
public final class ValoracionLineaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3876356981308567280L;

    /** The vlrl. */
    private ValoracionLineaVO vlrl;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // acciones web

    /**
     * Detalle.
     *
     * @return the string
     */
    @Actions({ @Action(value = "vlrl-detalle") })
    public String detalle() {
        Preconditions.checkNotNull(vlrl);
        Preconditions.checkNotNull(vlrl.getId());

        final Valoracion vlrcBO = BOFactory.getInjector().getInstance(ValoracionBO.class);

        if (hasErrors()) {
            return INPUT;
        }

        vlrl = vlrcBO.selectVlrl(vlrl.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the vlrl.
     *
     * @return the vlrl
     */
    public ValoracionLineaVO getVlrl() {
        return vlrl;
    }

    /**
     * Sets the vlrl.
     *
     * @param value
     *            the vlrl
     */
    public void setVlrl(ValoracionLineaVO value) {
        this.vlrl = value;
    }

}
