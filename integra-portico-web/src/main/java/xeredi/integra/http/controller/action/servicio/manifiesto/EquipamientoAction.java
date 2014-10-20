package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.integra.model.servicio.bo.manifiesto.EquipamientoBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.exception.InstanceNotFoundException;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web
    /**
     * Bloquear.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("equi-bloquear")
    public String bloquear() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EquipamientoBO equiBO = new EquipamientoBO();

        try {
            equiBO.bloquear(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
        }

        return SUCCESS;
    }

    /**
     * Iniciar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("equi-iniciar")
    public String iniciar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EquipamientoBO equiBO = new EquipamientoBO();

        try {
            equiBO.iniciar(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
        }

        return SUCCESS;
    }

    /**
     * Anular.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("equi-anular")
    public String anular() throws InstanceNotFoundException {
        Preconditions.checkNotNull(item);
        Preconditions.checkNotNull(item.getId());

        final EquipamientoBO equiBO = new EquipamientoBO();

        try {
            equiBO.anular(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
        }

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
