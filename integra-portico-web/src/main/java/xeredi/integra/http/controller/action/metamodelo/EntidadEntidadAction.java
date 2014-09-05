package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.EntidadEntidad;
import xeredi.integra.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadEntidadAction.
 */
public final class EntidadEntidadAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7902127201717597996L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The enen. */
    private EntidadEntidadVO enen;

    /**
     * Alta.
     *
     * @return the string
     */
    @Action("enen-create")
    public String alta() {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("enen-edit")
    public String modificar() {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHijaId());

        accion = ACCION_EDICION.edit;

        final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);

        // FIXME Busqueda

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("enen-save")
    public String guardar() throws DuplicateInstanceException {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());

        if (enen.getEntiPadreId() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enen_entiPadreId") }));
        }

        if (enen.getOrden() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enen_orden") }));
        }

        if (!hasErrors()) {
            final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);

            enenBO.insert(enen);
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("enen-delete")
    public String eliminar() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHijaId());

        final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);

        enenBO.delete(enen);

        return SUCCESS;
    }

    // get / set

    /**
     * Gets the accion.
     *
     * @return the accion
     */
    public ACCION_EDICION getAccion() {
        return accion;
    }

    /**
     * Sets the accion.
     *
     * @param value
     *            the accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the enen.
     *
     * @return the enen
     */
    public EntidadEntidadVO getEnen() {
        return enen;
    }

    /**
     * Sets the enen.
     *
     * @param value
     *            the new enen
     */
    public void setEnen(final EntidadEntidadVO value) {
        enen = value;
    }
}
