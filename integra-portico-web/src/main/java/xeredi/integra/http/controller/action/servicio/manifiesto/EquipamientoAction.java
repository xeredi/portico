package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.comun.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.servicio.bo.manifiesto.EquipamientoBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EquipamientoAction.
 */
public final class EquipamientoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 414576548039759307L;

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
    @Action("equi-bloquear")
    public String bloquear() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EquipamientoBO equiBO = new EquipamientoBO();

        equiBO.bloquear(item.getId());

        item = equiBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("equi-iniciar")
    public String iniciar() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EquipamientoBO equiBO = new EquipamientoBO();

        equiBO.iniciar(item.getId());

        item = equiBO.select(item.getId(), getIdioma());

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("equi-anular")
    public String anular() throws ApplicationException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EquipamientoBO equiBO = new EquipamientoBO();

        equiBO.anular(item.getId());

        item = equiBO.select(item.getId(), getIdioma());

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
