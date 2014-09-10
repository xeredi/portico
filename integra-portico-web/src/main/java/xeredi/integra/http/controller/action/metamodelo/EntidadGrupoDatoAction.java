package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.model.comun.bo.BOFactory;
import xeredi.integra.model.comun.exception.ErrorCode;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDato;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;
import xeredi.util.struts.PropertyValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadGrupoDatoAction.
 */
public final class EntidadGrupoDatoAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3556845527608258423L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The entd form. */
    private EntidadGrupoDatoVO engd;

    /**
     * Instantiates a new entidad grupo dato action.
     */
    public EntidadGrupoDatoAction() {
        super();

        engd = new EntidadGrupoDatoVO();
    }

    // Acciones Web
    /**
     * Alta.
     *
     * @return the string
     */
    @Action("engd-create")
    public String create() {
        if (engd.getEntiId() == null) {
            throw new Error("No se ha seleccionado una entidad");
        }

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    @Action("engd-edit")
    public String edit() {
        accion = ACCION_EDICION.edit;

        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDatoBO.class);

        try {
            engd = engdBO.select(engd.getEntiId(), engd.getNumero());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("engd"), String.valueOf(engd) }));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     */
    @Action("engd-save")
    public String save() throws InstanceNotFoundException {
        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDatoBO.class);

        PropertyValidator.validateRequired(this, "engd.entiId", engd.getEntiId());
        PropertyValidator.validateRequired(this, "engd.numero", engd.getNumero());
        PropertyValidator.validateRequired(this, "engd.etiqueta", engd.getEtiqueta());

        if (hasErrors()) {
            return SUCCESS;
        }

        if (accion == ACCION_EDICION.create) {
            try {
                engdBO.insert(engd);
            } catch (final DuplicateInstanceException ex) {
                addActionError(getText(ErrorCode.E00005.name(), new String[] { getText("engd") }));
            }
        } else {
            try {
                engdBO.update(engd);
            } catch (final InstanceNotFoundException ex) {
                addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("engd"), String.valueOf(engd) }));
            }
        }

        return SUCCESS;
    }

    /**
     * Detalle.
     *
     * @return the string
     */
    @Action("engd-detail")
    public String detail() {
        final EntidadGrupoDato engdBO = BOFactory.getInjector().getInstance(EntidadGrupoDatoBO.class);

        try {
            engd = engdBO.select(engd.getEntiId(), engd.getNumero());
        } catch (final InstanceNotFoundException ex) {
            addActionError(getText(ErrorCode.E00008.name(), new String[] { getText("engd"), String.valueOf(engd) }));
        }

        return SUCCESS;
    }

    // get/set
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
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the engd.
     *
     * @return the engd
     */
    public EntidadGrupoDatoVO getEngd() {
        return engd;
    }

    /**
     * Sets the engd.
     *
     * @param value
     *            the new engd
     */
    public void setEngd(final EntidadGrupoDatoVO value) {
        engd = value;
    }

}
