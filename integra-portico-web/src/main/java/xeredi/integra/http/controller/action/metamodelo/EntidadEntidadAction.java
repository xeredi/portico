package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadEntidadBO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadCriterioVO;
import xeredi.integra.model.metamodelo.vo.EntidadEntidadVO;

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHija());
        Preconditions.checkNotNull(enen.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();
        final EntidadEntidadCriterioVO enenCriterioVO = new EntidadEntidadCriterioVO();

        enenCriterioVO.setEntiPadreId(enen.getEntiPadreId());
        enenCriterioVO.setEntiHijaId(enen.getEntiHija().getId());

        enen = enenBO.selectObject(enenCriterioVO);
        accion = ACCION_EDICION.edit;

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enen_entiHija, enen.getEntiHija());
        } else {
            Preconditions.checkNotNull(enen.getEntiHija());
            Preconditions.checkNotNull(enen.getEntiHija().getId());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.enen_orden, enen.getOrden());

        if (!hasErrors()) {
            final EntidadEntidadBO enenBO = new EntidadEntidadBO();

            if (accion == ACCION_EDICION.create) {
                enenBO.insert(enen);
            } else {
                enenBO.update(enen);
            }
        }

        return SUCCESS;
    }

    /**
     * Eliminar.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHija());
        Preconditions.checkNotNull(enen.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();

        enenBO.delete(enen);

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enen-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(enen);
        Preconditions.checkNotNull(enen.getEntiPadreId());
        Preconditions.checkNotNull(enen.getEntiHija());
        Preconditions.checkNotNull(enen.getEntiHija().getId());

        final EntidadEntidadBO enenBO = new EntidadEntidadBO();
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
