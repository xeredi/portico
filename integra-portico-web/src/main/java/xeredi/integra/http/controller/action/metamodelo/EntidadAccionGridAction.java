package xeredi.integra.http.controller.action.metamodelo;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;

import xeredi.integra.http.controller.action.BaseAction;
import xeredi.integra.http.util.FieldValidator;
import xeredi.integra.model.comun.bo.I18nBO;
import xeredi.integra.model.comun.exception.ApplicationException;
import xeredi.integra.model.comun.vo.I18nPrefix;
import xeredi.integra.model.comun.vo.I18nVO;
import xeredi.integra.model.comun.vo.MessageI18nKey;
import xeredi.integra.model.metamodelo.bo.EntidadAccionGridBO;
import xeredi.integra.model.metamodelo.vo.EntidadAccionGridVO;

import com.google.common.base.Preconditions;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class EntidadAccionGridAction.
 */
public final class EntidadAccionGridAction extends BaseAction implements ModelDriven<EntidadAccionGridVO> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5575767026166039789L;

    /** The accion. */
    private ACCION_EDICION accion;

    /** The enag. */
    private EntidadAccionGridVO model;

    /** The cdri map. */
    private Map<String, I18nVO> i18nMap;

    // Acciones Web
    /**
     * Edits the.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enag-edit")
    public String edit() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (accion == ACCION_EDICION.edit) {
            Preconditions.checkNotNull(model.getId());

            final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

            model = enagBO.select(model.getId(), getIdioma());
            i18nMap = I18nBO.selectMap(I18nPrefix.enag, model.getId());
        }

        return SUCCESS;
    }

    /**
     * Save.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enag-save")
    public String save() throws ApplicationException {
        Preconditions.checkNotNull(accion);
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getEntiId());

        if (accion == ACCION_EDICION.create) {
            FieldValidator.validateRequired(this, MessageI18nKey.enag_path, model.getPath());
        } else {
            Preconditions.checkNotNull(model.getPath());
        }

        FieldValidator.validateRequired(this, MessageI18nKey.enag_orden, model.getOrden());
        FieldValidator.validateI18n(this, i18nMap);

        if (!hasErrors()) {
            final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

            switch (accion) {
            case create:
                enagBO.insert(model, i18nMap);

                break;
            case edit:
                enagBO.update(model, i18nMap);

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
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enag-remove")
    public String remove() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

        enagBO.delete(model.getId());

        return SUCCESS;
    }

    /**
     * Detail.
     *
     * @return the string
     * @throws ApplicationException
     *             the application exception
     */
    @Action("enag-detail")
    public String detail() throws ApplicationException {
        Preconditions.checkNotNull(model);
        Preconditions.checkNotNull(model.getId());

        final EntidadAccionGridBO enagBO = new EntidadAccionGridBO();

        model = enagBO.select(model.getId(), getIdioma());
        i18nMap = I18nBO.selectMap(I18nPrefix.enag, model.getId());

        return SUCCESS;
    }

    // get / set
    /**
     * {@inheritDoc}
     */
    @Override
    public EntidadAccionGridVO getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the new model
     */
    public void setModel(final EntidadAccionGridVO value) {
        model = value;
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
