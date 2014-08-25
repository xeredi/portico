package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Cargo;
import xeredi.integra.model.facturacion.bo.CargoBO;
import xeredi.integra.model.facturacion.vo.CargoCriterioVO;
import xeredi.integra.model.facturacion.vo.CargoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class CargoAction.
 */
public final class CargoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5711768506965624584L;

    /** The crgo. */
    private CargoVO crgo;

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
    @Actions({ @Action(value = "crgo-detalle") })
    public String detalle() {
        Preconditions.checkNotNull(crgo);
        Preconditions.checkNotNull(crgo.getCrgv());
        Preconditions.checkNotNull(crgo.getCrgv().getId());

        final Cargo crgoBO = BOFactory.getInjector().getInstance(CargoBO.class);
        final CargoCriterioVO crgoCriterioVO = new CargoCriterioVO();

        if (hasErrors()) {
            return INPUT;
        }

        crgoCriterioVO.setCrgvId(crgo.getCrgv().getId());

        crgo = crgoBO.select(crgoCriterioVO);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the crgo.
     *
     * @return the crgo
     */
    public CargoVO getCrgo() {
        return crgo;
    }

    /**
     * Sets the crgo.
     *
     * @param value
     *            the new crgo
     */
    public void setCrgo(final CargoVO value) {
        crgo = value;
    }

}
