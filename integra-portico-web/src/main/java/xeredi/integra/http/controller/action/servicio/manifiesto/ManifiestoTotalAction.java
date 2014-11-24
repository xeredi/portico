package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
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

    // Acciones web

    /**
     * Totales.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mani-totales")
    public String totales() throws ApplicationException {
        final ServicioBO srvcBO = new ServicioBO();
        final ManifiestoBO maniBO = new ManifiestoBO();

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
