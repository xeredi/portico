package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.bo.servicio.Subservicio;
import xeredi.integra.model.bo.servicio.manifiesto.Bl;
import xeredi.integra.model.bo.util.BOFactory;
import xeredi.integra.model.vo.servicio.SubservicioVO;
import xeredi.integra.model.vo.servicio.manifiesto.ResumenTotalesVO;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class BlTotalAction.
 */
public final class BlTotalAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7524630519110057937L;

    /** The ssrv. */
    private SubservicioVO item;

    /** The total vo. */
    private ResumenTotalesVO resumen;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web

    /**
     * Totales.
     * 
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action(value = "mabl-totales-popup", results = { @Result(name = "success", location = "manifiesto/mabl-totales.jsp") })
    public String totales() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());
        Preconditions.checkNotNull(item.getSrvc());
        Preconditions.checkNotNull(item.getSrvc().getId());

        final Subservicio ssrvBO = BOFactory.getInjector().getInstance(Subservicio.class);
        final Bl mablBO = BOFactory.getInjector().getInstance(Bl.class);

        item = ssrvBO.select(item.getId(), getIdioma());
        resumen = mablBO.selectResumen(item.getSrvc().getId(), item.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the total vo.
     * 
     * @return the total vo
     */
    public ResumenTotalesVO getResumen() {
        return resumen;
    }

    /**
     * Gets the ssrv.
     * 
     * @return the ssrv
     */
    public SubservicioVO getItem() {
        return item;
    }

    /**
     * Sets the ssrv.
     * 
     * @param value
     *            the new ssrv
     */
    public void setItem(final SubservicioVO value) {
        item = value;
    }

}
