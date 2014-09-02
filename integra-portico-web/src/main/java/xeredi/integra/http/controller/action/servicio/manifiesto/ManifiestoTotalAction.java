package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.servicio.bo.Servicio;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.manifiesto.Manifiesto;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoTotalAction.
 */
public final class ManifiestoTotalAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7801170979950579286L;

    /** The srvc. */
    private ServicioVO item;

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
    @Action(value = "mani-totales-popup", results = { @Result(name = "success", location = "manifiesto/mani-totales.jsp") })
    public String totales() throws InstanceNotFoundException {
        final Servicio srvcBO = BOFactory.getInjector().getInstance(ServicioBO.class);
        final Manifiesto maniBO = BOFactory.getInjector().getInstance(ManifiestoBO.class);

        item = srvcBO.select(item.getId(), getIdioma());
        resumen = maniBO.selectResumen(item.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the srvc.
     *
     * @return the srvc
     */
    public ServicioVO getItem() {
        return item;
    }

    /**
     * Sets the srvc.
     *
     * @param value
     *            the new srvc
     */
    public void setItem(final ServicioVO value) {
        item = value;
    }

    /**
     * Gets the total vo.
     *
     * @return the total vo
     */
    public ResumenTotalesVO getResumen() {
        return resumen;
    }

}
