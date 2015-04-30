package xeredi.integra.http.controller.action;

import java.util.Date;

import xeredi.integra.http.controller.action.comun.BaseAction;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemAction.
 */
public abstract class ItemAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8360824965530095464L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The fecha vigencia. */
    private Date fechaVigencia;

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public final ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the new accion
     */
    public final void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the fecha vigencia.
     *
     * @return the fecha vigencia
     */
    public final Date getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Sets the fecha vigencia.
     *
     * @param value
     *            the new fecha vigencia
     */
    public final void setFechaVigencia(final Date value) {
        fechaVigencia = value;
    }

}
