package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mabl-bloquear")
    public String bloquear() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final BlBO mablBO = new BlBO();

        mablBO.bloquear(item.getId());

        item = mablBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mabl-completar")
    public String completar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final BlBO mablBO = new BlBO();

        mablBO.completar(item.getId());

        item = mablBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mabl-iniciar")
    public String iniciar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final BlBO mablBO = new BlBO();

        mablBO.iniciar(item.getId());

        item = mablBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("mabl-anular")
    public String anular() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final BlBO mablBO = new BlBO();

        mablBO.anular(item.getId());

        item = mablBO.select(item.getId(), getIdioma());

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
