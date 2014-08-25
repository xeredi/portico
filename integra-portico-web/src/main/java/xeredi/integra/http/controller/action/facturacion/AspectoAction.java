package xeredi.integra.http.controller.action.facturacion;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.facturacion.bo.Aspecto;
import xeredi.integra.model.facturacion.bo.AspectoBO;
import xeredi.integra.model.facturacion.vo.AspectoCriterioVO;
import xeredi.integra.model.facturacion.vo.AspectoVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class AspectoAction.
 */
public final class AspectoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 4939833753699919759L;

    /** The aspc. */
    private AspectoVO aspc;

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
    @Actions({ @Action(value = "aspc-detalle") })
    public String detalle() {
        Preconditions.checkNotNull(aspc);
        Preconditions.checkNotNull(aspc.getAspv());
        Preconditions.checkNotNull(aspc.getAspv().getId());

        final Aspecto aspcBO = BOFactory.getInjector().getInstance(AspectoBO.class);
        final AspectoCriterioVO aspcCriterioVO = new AspectoCriterioVO();

        if (hasErrors()) {
            return INPUT;
        }

        aspcCriterioVO.setAspvId(aspc.getAspv().getId());

        aspc = aspcBO.select(aspcCriterioVO);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the aspc.
     *
     * @return the aspc
     */
    public AspectoVO getAspc() {
        return aspc;
    }

    /**
     * Sets the aspc.
     *
     * @param value
     *            the aspc
     */
    public void setAspc(final AspectoVO value) {
        aspc = value;
    }

}
