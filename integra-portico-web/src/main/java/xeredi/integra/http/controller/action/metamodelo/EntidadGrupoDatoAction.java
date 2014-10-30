package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadGrupoDatoBO;
import xeredi.integra.model.metamodelo.vo.EntidadGrupoDatoVO;
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

    /** The i18n map. */
    private Map<String, I18nVO> i18nMap;

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
            engd = engdBO.select(engd.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.engd, engd.getId());
        } catch (final InstanceNotFoundException ex) {
            addActionError(MessageI18nKey.E00008, getText(MessageI18nKey.engd), String.valueOf(engd));
        }

        return SUCCESS;
    }

    /**
     * Guardar.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("engd-save")
    public String save() throws InstanceNotFoundException {
        final EntidadGrupoDatoBO engdBO = new EntidadGrupoDatoBO();

        FieldValidator.validateRequired(this, MessageI18nKey.engd_enti, engd.getEntiId());
        FieldValidator.validateRequired(this, MessageI18nKey.engd_numero, engd.getNumero());
        FieldValidator.validateRequired(this, MessageI18nKey.engd_etiqueta, engd.getEtiqueta());

        FieldValidator.validateI18n(this, i18nMap);

        if (hasErrors()) {
            return SUCCESS;
        }

        if (accion == ACCION_EDICION.create) {
            engdBO.insert(engd, i18nMap);
        } else {
            try {
                engdBO.update(engd, i18nMap);
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
            engd = engdBO.select(engd.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.engd, engd.getId());
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

    /**
     * Gets the i18n map.
     *
     * @return the i18n map
     */
    public Map<String, I18nVO> getI18nMap() {
        return i18nMap;
    }

    /**
     * Sets the i18n map.
     *
     * @param value
     *            the value
     */
    public void setI18nMap(final Map<String, I18nVO> value) {
        i18nMap = value;
    }

}
