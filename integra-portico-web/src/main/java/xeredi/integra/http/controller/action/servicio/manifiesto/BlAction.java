package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.servicio.bo.SubservicioBO;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

// TODO: Auto-generated Javadoc
/**
 * The Class BlAction.
 */
public final class BlAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3751908708490319574L;

    /** The item. */
    private SubservicioVO item;

    // Acciones web
    /**
     * Bloquear.
     *
     * @return the string
     */
    @Action("mabl-bloquear")
    public String bloquear() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final BlBO mablBO = new BlBO();
        final SubservicioBO ssrvBO = new SubservicioBO();

        mablBO.bloquear(item.getId());

        item = ssrvBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     */
    @Action("mabl-completar")
    public String completar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final BlBO mablBO = new BlBO();

        mablBO.completar(item.getId());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     */
    @Action("mabl-iniciar")
    public String iniciar() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final BlBO mablBO = new BlBO();

        mablBO.iniciar(item.getId());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     */
    @Action("mabl-anular")
    public String anular() throws InstanceNotFoundException, OperacionNoPermitidaException {
        final BlBO mablBO = new BlBO();

        mablBO.anular(item.getId());

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the item.
     *
     * @return the item
     */
    public final SubservicioVO getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param value
     *            the new item
     */
    public final void setItem(final SubservicioVO value) {
        item = value;
    }

}
