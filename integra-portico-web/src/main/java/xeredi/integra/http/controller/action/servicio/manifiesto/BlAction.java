package xeredi.integra.http.controller.action.servicio.manifiesto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.servicio.bo.EstadoInvalidoException;
import xeredi.integra.model.servicio.bo.manifiesto.BlBO;
import xeredi.integra.model.servicio.vo.SubservicioVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class BlAction.
 */
public final class BlAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3751908708490319574L;

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
    @Action("mabl-bloquear")
    public String bloquear() throws InstanceNotFoundException {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.bloquear(item.getId());
        } catch (final EstadoInvalidoException ex) {
            addActionError(getText("ssrv.error.estadoInvalido", new String[] { ex.getEstado(), ex.getItem() }));
        }

        return SUCCESS;
    }

    /**
     * Completar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("mabl-completar")
    public String completar() throws InstanceNotFoundException {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.completar(item.getId());
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
    @Action("mabl-iniciar")
    public String iniciar() throws InstanceNotFoundException {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.iniciar(item.getId());
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
    @Action("mabl-anular")
    public String anular() throws InstanceNotFoundException {
        final BlBO mablBO = new BlBO();

        try {
            mablBO.anular(item.getId());
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
