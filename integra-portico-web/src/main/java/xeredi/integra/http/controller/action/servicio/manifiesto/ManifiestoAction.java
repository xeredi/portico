package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.servicio.bo.ServicioBO;
import xeredi.integra.model.servicio.bo.manifiesto.ManifiestoBO;
import xeredi.integra.model.servicio.vo.ServicioVO;

import com.google.common.base.Preconditions;

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
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action("mani-bloquear")
    public String bloquear() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO maniBO = new ManifiestoBO();
        final ServicioBO srvcBO = new ServicioBO();

        maniBO.bloquear(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action("mani-completar")
    public String completar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO maniBO = new ManifiestoBO();
        final ServicioBO srvcBO = new ServicioBO();

        maniBO.completar(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action("mani-iniciar")
    public String iniciar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO maniBO = new ManifiestoBO();
        final ServicioBO srvcBO = new ServicioBO();

        maniBO.iniciar(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws OperacionNoPermitidaException
     *             the operacion no permitida exception
     */
    @Action("mani-anular")
    public String anular() throws InstanceNotFoundException, OperacionNoPermitidaException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO maniBO = new ManifiestoBO();
        final ServicioBO srvcBO = new ServicioBO();

        maniBO.anular(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

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
