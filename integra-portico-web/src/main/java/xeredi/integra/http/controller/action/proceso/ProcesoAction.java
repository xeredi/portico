package xeredi.integra.http.controller.action.proceso;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.exception.OperacionNoPermitidaException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.proceso.bo.ProcesoBO;
import xeredi.integra.model.proceso.vo.ProcesoVO;

import com.google.common.base.Preconditions;

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
     */
    @Action("prbt-detail")
    public String detalle() {
        Preconditions.checkNotNull(prbt);
        Preconditions.checkNotNull(prbt.getId());

        try {
            final ProcesoBO prbtBO = new ProcesoBO();

            prbt = prbtBO.select(prbt.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        }

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     */
    @Action("prbt-cancel")
    public String borrar() {
        Preconditions.checkNotNull(prbt);
        Preconditions.checkNotNull(prbt.getId());

        try {
            final ProcesoBO prbtBO = new ProcesoBO();

            prbtBO.cancelar(prbt.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(ex.getClassName()), ex.getObjId());
        } catch (final OperacionNoPermitidaException ex) {
            addActionError(MessageI18nKey.E00013, getText(ex.getClassName()), ex.getObjId());
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
