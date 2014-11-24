package xeredi.integra.http.controller.action.proceso;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.exception.ApplicationException;
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

    // Acciones web

    /**
     * Detalle.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prbt-detail")
    public String detalle() throws ApplicationException {
        Preconditions.checkNotNull(prbt);
        Preconditions.checkNotNull(prbt.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbt = prbtBO.select(prbt.getId());

        return SUCCESS;
    }

    /**
     * Borrar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("prbt-cancel")
    public String borrar() throws ApplicationException {
        Preconditions.checkNotNull(prbt);
        Preconditions.checkNotNull(prbt.getId());

        final ProcesoBO prbtBO = new ProcesoBO();

        prbtBO.cancelar(prbt.getId());

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
