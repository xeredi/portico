package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ManifiestoAction.
 */
public final class ManifiestoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6347595712376492068L;

    /** The srvc. */
    private ServicioVO item;

    // Acciones web
    /**
     * Bloquear.
     *
     * @return the string
     */
    @Action("mani-bloquear")
    public String bloquear() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        maniBO.bloquear(item.getId());

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     */
    @Action("mani-completar")
    public String completar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        maniBO.completar(item.getId());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     */
    @Action("mani-iniciar")
    public String iniciar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        maniBO.iniciar(item.getId());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     */
    @Action("mani-anular")
    public String anular() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final ManifiestoBO maniBO = new ManifiestoBO();

        maniBO.anular(item.getId());

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

}
