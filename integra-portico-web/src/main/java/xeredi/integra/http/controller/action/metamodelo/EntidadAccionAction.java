package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.DuplicateInstanceException;
import xeredi.integra.model.comun.exception.InstanceNotFoundException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionVO;

import com.google.common.base.Preconditions;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionAction.
 */
public final class EntidadAccionAction extends BaseAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8430223895677320578L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The entd form. */
    private EntidadAccionVO enac;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    // Acciones Web
    /**
     * Creates the.
     *
     * @return the string
     */
    @Action("enac-create")
    public String create() {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());

        accion = ACCION_EDICION.create;

        return SUCCESS;
    }

    /**
     * Edits the.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("enac-edit")
    public String edit() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getId());

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enac = enacBO.select(enac.getEntiId(), enac.getPath());
        i18nMap = I18nBO.selectMap(I18nPrefix.enac, enac.getId());
        accion = ACCION_EDICION.edit;

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     * @throws DuplicateInstanceException
     *             the duplicate instance exception
     */
    @Action("enac-save")
    public String save() throws InstanceNotFoundException, DuplicateInstanceException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getEntiId());
        Preconditions.checkNotNull(i18nMap);

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enac_path, enac.getPath());
        } else {
            Preconditions.checkNotNull(enac.getPath());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.enac_etiqueta, enac.getEtiqueta());
        FieldValidator.validateRequired(this, MessageI18nKey.enac_orden, enac.getOrden());
        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final EntidadAccionBO enacBO = new EntidadAccionBO();

            switch (accion) {
            case create:
                enacBO.insert(enac, i18nMap);

                break;
            case edit:
                enacBO.update(enac, i18nMap);

                break;
            default:
                throw new Error("Accion " + accion + " no implementada");
            }
        }

        return SUCCESS;
    }

    /**
     * Removes the.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("enac-remove")
    public String remove() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getId());

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enacBO.delete(enac.getId());

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     * @throws InstanceNotFoundException
     *             the instance not found exception
     */
    @Action("enac-detail")
    public String detail() throws InstanceNotFoundException {
        Preconditions.checkNotNull(enac);
        Preconditions.checkNotNull(enac.getId());

        final EntidadAccionBO enacBO = new EntidadAccionBO();

        enac = enacBO.select(enac.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enac, enac.getId());

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
     *            the new accion
     */
    public void setAccion(final ACCION_EDICION value) {
        accion = value;
    }

    /**
     * Gets the enac.
     *
     * @return the enac
     */
    public EntidadAccionVO getEnac() {
        return enac;
    }

    /**
     * Sets the enac.
     *
     * @param value
     *            the new enac
     */
    public void setEnac(final EntidadAccionVO value) {
        enac = value;
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
