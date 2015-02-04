package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.PartidaBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidaAction.
 */
public final class PartidaAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6389372066711184329L;

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
    @Action("part-bloquear")
    public String bloquear() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final PartidaBO partBO = new PartidaBO();

        partBO.bloquear(item.getId());

        item = partBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("part-iniciar")
    public String iniciar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final PartidaBO partBO = new PartidaBO();

        partBO.iniciar(item.getId());

        item = partBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("part-anular")
    public String anular() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final PartidaBO partBO = new PartidaBO();

        partBO.anular(item.getId());

        item = partBO.select(item.getId(), getIdioma());

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
