package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;
import xeredi.integra.model.servicio.vo.manifiesto.ResumenTotalesVO;

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
     */
    @Action("mani-totales")
    public String totales() {
        final ServicioBO srvcBO = new ServicioBO();
        final ManifiestoBO maniBO = new ManifiestoBO();

        try {
            item = srvcBO.select(item.getId(), getIdioma());
            resumen = maniBO.selectResumen(item.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

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
