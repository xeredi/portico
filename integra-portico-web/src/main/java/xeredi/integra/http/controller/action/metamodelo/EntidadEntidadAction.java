package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.EntidadEntidad;
import xeredi.integra.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
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
    public String create() {
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
    public String edit() {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHija());
        Preconditions.checkNotNull(enen.getEntiHija().getId());

        accion = ACCION_EDICION.edit;

        final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);
        final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

        enenCriterioVO.setEntiPadreId(enen.getEntiPadreId());
        enenCriterioVO.setEntiHijaId(enen.getEntiHija().getId());

        enen = enenBO.selectObject(enenCriterioVO);

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("enen-save")
    public String save() {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());

        if (accion == ACCION_EDICION.create) {
            if (enen.getEntiHija() == null || enen.getEntiHija().getId() == null) {
                addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enen_entiHija") }));
            }
        } else {
            Preconditions.checkNotNull(enen.getEntiHija());
            Preconditions.checkNotNull(enen.getEntiHija().getId());
        }

        if (enen.getOrden() == null) {
            addActionError(getText(ErrorCode.E00001.name(), new String[] { getText("enen_orden") }));
        }

        if (hasErrors()) {
            return SUCCESS;
        }

        final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);

        if (accion == ACCION_EDICION.create) {
            try {
                enenBO.insert(enen);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("enen") }));
            }
        } else {
            try {
                enenBO.update(enen);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("enen"), String.valueOf(enen) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     */
    @Action("enen-remove")
    public String remove() {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHija());
        Preconditions.checkNotNull(enen.getEntiHija().getId());

        final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);

        try {
            enenBO.delete(enen);
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("enen"), String.valueOf(enen) }));
        }

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     */
    @Action("enen-detail")
    public String detail() {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHija());
        Preconditions.checkNotNull(enen.getEntiHija().getId());

        accion = ACCION_EDICION.edit;

        final EntidadEntidad enenBO = BOFactory.getInjector().getInstance(EntidadEntidadBO.class);
        final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

        enenCriterioVO.setEntiPadreId(enen.getEntiPadreId());
        enenCriterioVO.setEntiHijaId(enen.getEntiHija().getId());

        enen = enenBO.selectObject(enenCriterioVO);

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
