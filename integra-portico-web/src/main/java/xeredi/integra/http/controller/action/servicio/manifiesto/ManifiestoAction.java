package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mani-bloquear")
    public String bloquear() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.bloquear(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mani-completar")
    public String completar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.completar(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mani-iniciar")
    public String iniciar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.iniciar(item.getId());

        item = srvcBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mani-anular")
    public String anular() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final ManifiestoBO srvcBO = new ManifiestoBO();

        srvcBO.anular(item.getId());

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
