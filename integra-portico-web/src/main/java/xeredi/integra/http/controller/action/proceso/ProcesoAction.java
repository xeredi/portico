package xeredi.integra.http.controller.action.proceso;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.proceso.bo.OperacionNoPermitidaException;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoVO;
import xeredi.util.exception.InstanceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcesoAction.
 */
public final class ProcesoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 899256989833948070L;

    /** The prbt. */
    private ProcesoVO prbt;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("prbt-detail")
    public String detalle() throws InstanceNotFoundException {
        final ProcesoBO prbtBO = new ProcesoBO();

        prbt = prbtBO.select(prbt.getId());

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("prbt-cancel")
    public String borrar() throws InstanceNotFoundException {
        if (prbt.getId() == null) {
            throw new Error("No se ha especificado un proceso");
        }

        try {
            final ProcesoBO prbtBO = new ProcesoBO();

            prbtBO.cancelar(prbt.getId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError("El proceso seleccionado no se puede cancelar");
        }

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the prbt.
     *
     * @return the prbt
     */
    public ProcesoVO getPrbt() {
        return prbt;
    }

    /**
     * Sets the prbt.
     *
     * @param value
     *            the new prbt
     */
    public void setPrbt(final ProcesoVO value) {
        prbt = value;
    }

}
