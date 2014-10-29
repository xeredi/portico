package xeredi.integra.http.controller.action.metamodelo;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
import xeredi.integra.model.util.GlobalNames.ACCION_EDICION;
import xeredi.util.exception.DuplicateInstanceException;
import xeredi.util.exception.InstanceNotFoundException;

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

        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        try {
            engd = engdBO.select(engd.getEntiId(), engd.getNumero());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.engd), String.valueOf(engd));
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
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        FieldValidator.validateRequired(this, MessageI18nKey.engd_enti, engd.getEntiId());
        FieldValidator.validateRequired(this, MessageI18nKey.engd_numero, engd.getNumero());
        FieldValidator.validateRequired(this, MessageI18nKey.engd_etiqueta, engd.getEtiqueta());

        if (hasErrors()) {
            return SUCCESS;
        }

        if (accion == ACCION_EDICION.create) {
            try {
                engdBO.insert(engd);
            } catch (final DuplicateInstanceException ex) {
                addActionError(MessageI18nKey.E00005, getText(MessageI18nKey.engd));
            }
        } else {
            try {
                engdBO.update(engd);
            } catch (final InstanceNotFoundException ex) {
                addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.engd), String.valueOf(engd));
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
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        try {
            engd = engdBO.select(engd.getEntiId(), engd.getNumero());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.engd), String.valueOf(engd));
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
